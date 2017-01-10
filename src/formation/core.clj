(comment
  Formation, Copyright 2012 Ronen Narkis, narkisr.com
  Licensed under the Apache License,
  Version 2.0  (the "License") you may not use this file except in compliance with the License.
  You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.)

(ns formation.core
  (:require
    [taoensso.timbre.appenders.core :as appenders]
    [clojure.tools.reader.edn :as edn]
    [clojure.pprint :refer (pprint)]
    [taoensso.timbre :as  timbre]
    [clojure.core.strint :refer (<<)]
    [clojure.java.io :refer (file)]))

(timbre/refer-timbre)

(defn config-paths [project]
  [(<<"/etc/~{project}/~{project}.edn") (<< "~(System/getProperty \"user.home\")/.~{project}.edn")])

(defn path-of [project]
  (first (filter #(.exists (file %)) (config-paths project))))

(defn pretty-error
  "A pretty print error log"
  [m c project]
  (let [st (java.io.StringWriter.)]
    (binding [*out* st]
      (clojure.pprint/pprint m))
    (timbre/merge-config!
     {:appenders
       {:spit (appenders/spit-appender
         {:fname (get-in c [(keyword project) :log :path] (<< "~{project}.log"))})}})
    (error (str "Following configuration errors found:\n" (.toString st)))))

(defn read-and-validate [path validate-conf project]
  (let [c (edn/read-string (slurp path)) es (validate-conf c)]
    (when-not (empty? es)
      (pretty-error es c project)
      (System/exit 1))
    c))


(defn config
  "main configuation"
  [project validate-conf]
  (if-let [path (path-of project)]
    (read-and-validate path validate-conf project)
    (when-not (System/getProperty "disable-conf") ; enables repl/testing
      (error
        (<< "Missing configuration file, you should configure ~{project} in either ~(config-paths project)"))
      (System/exit 1))))


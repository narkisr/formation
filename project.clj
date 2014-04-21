(defproject formation "0.0.1"
  :description "A configuration library for Clojure"
  :url "https://github.com/narkisr/fomration"
  :license  {:name "Apache License, Version 2.0" :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [
     [org.clojure/clojure "1.5.1"]
     [com.taoensso/timbre "2.6.3"]
     [org.clojure/core.incubator "0.1.3"]
     [org.clojure/tools.reader "0.8.4"] ]

   :profiles { :dev {
     :dependencies [[midje "1.6.3"]]
     :set-version {
         :updates [{:path "project.clj" :search-regex #"\"target\/celestial-\d+\.\d+\.\d+\.jar"} ]
     }
    }}
  :plugins [[lein-tag "0.1.0"] [lein-set-version "0.3.0"] [lein-midje "3.1.1"]]
)

(defproject formation "0.1.1"
  :description "A configuration library for Clojure"
  :url "https://github.com/narkisr/fomration"
  :license  {:name "Apache License, Version 2.0" :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [
     [org.clojure/clojure "1.8.0"]
     [com.taoensso/timbre "4.10.0"]
     [com.fzakaria/slf4j-timbre "0.3.5"]
     [org.clojure/core.incubator "0.1.4"]
     [com.fzakaria/slf4j-timbre "0.2"]
     [org.clojure/tools.reader "1.0.0-beta4"]]

   :plugins [
        [lein-tag "0.1.0"]  [lein-set-version "0.4.1"]
        [lein-ancient "0.6.10"] [lein-midje "3.2.1"]]


   :profiles {
     :dev {
     :dependencies [[midje "1.8.3"]]
    }}
)

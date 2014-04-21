(ns formation.test.core
  (:use midje.sweet) 
  (:require [formation.core :as form])
 )

(fact "desc" filters
   (get-in (form/config "example" {}) [:example :foo]) => 1
   (provided (form/path-of "example") => "data/example.edn")
  )

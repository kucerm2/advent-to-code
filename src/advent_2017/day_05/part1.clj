(ns advent-2017.day-05.part1
  (:require [clojure.string :as str]
            [advent-2017.day-05.shared :refer [step]]))

(defn solve
  [states]
  ((step inc) states 0 0))

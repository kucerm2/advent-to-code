(ns advent-2017.day-02.part1
  (:require [advent-2017.day-02.shared :as sh]))

(defn min-max-decoder [coll]
  (let [max (apply max coll)
        min (apply min coll)]
    (- max min)))

(defn solve [str]
  (sh/checksum str min-max-decoder))



(ns advent-2017.day-04.part1
  (:require [advent-2017.day-04.shared :as sh]))

(defn solve
  "return count of valid phrases"
  [phrases]
  (->> phrases
    (filter (sh/check-phrase identity))
    (count)))


(ns advent-2017.day-09.part2
  (:require [advent-2017.day-09.shared :as sh]))

(defn solve
  [seq]
  (get (sh/group-score seq) 4))

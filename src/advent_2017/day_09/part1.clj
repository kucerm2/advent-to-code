(ns advent-2017.day-09.part1
  (:require [advent-2017.day-09.shared :as sh]))

(defn solve
  [seq]
  (reduce + (first (sh/group-score seq))))

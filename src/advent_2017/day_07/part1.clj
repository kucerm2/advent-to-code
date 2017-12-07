(ns advent-2017.day-07.part1
  (:require [advent-2017.day-07.shared :as sh]))


(defn solution
  [towers]
  (first (sh/build-tree towers)))
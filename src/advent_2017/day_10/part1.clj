(ns advent-2017.day-10.part1
  (:require [advent-2017.day-10.shared :as sh]))

(defn solve
  [shifts]
  (let [[x y & _] (sh/hash (into [] (range 256)) shifts)]
    (* x y)))

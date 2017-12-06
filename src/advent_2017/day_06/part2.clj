(ns advent-2017.day-06.part2
  (:require [advent-2017.day-06.shared :as sh]))

(defn solve
  [next-fn coll]
  (->> (iterate (partial sh/reallocate next-fn) coll)
       (reduce (fn [[res cnt] x]
                 (let [i (.indexOf res x)]
                   (if (> i -1)
                     (reduced (- (count res) i))
                     [(conj res x) (inc cnt)])))
               [[] 0])))


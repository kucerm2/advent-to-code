(ns advent-2017.day-06.part1
  (require [advent-2017.day-06.shared :as sh]))

(defn solve
  [next-fn coll]
  (count (->> (iterate (partial sh/reallocate next-fn) coll)
              (reduce (fn [res x]
                        (if (contains? res x)
                          (reduced res)
                          (conj res x)))
                      #{}))))
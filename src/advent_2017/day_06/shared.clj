(ns advent-2017.day-06.shared
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input [10 3 15 10 5 15 5 15 9 2 5 8 5 2 3 6])

(defn rotate
  [max n]
  (if (= n max) 0 (inc n)))

(defn reallocate
  [next-fn v]
  (let [val (apply max v)
        idx (.indexOf v val)]
    (reduce
      (fn [xs i] (update xs i inc))
      (assoc v idx 0)
      (->> (iterate next-fn idx)
           (drop 1)
           (take val)))))







(ns advent-2017.day4.part2
  (:require [advent-2017.day4.data1 :as data]
            [clojure.string :as str]))

(defn check-phrase [str]
  (some? (->>
          (str/split str #" ")
          (map sort)
          (reduce
            (fn [used-set key]
              (if-not (contains? used-set key)
                (conj used-set key)
                (reduced nil)))
            #{}))))


(defn solve
  "return count of valid phrases"
  [phrases]
  (->>
    (str/split phrases #"\n")
    (filter check-phrase)
    (count)))


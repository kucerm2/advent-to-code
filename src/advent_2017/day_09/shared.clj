(ns advent-2017.day-09.shared
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn parse-input
  [file]
  (->> file
       io/reader
       slurp))

(defn reducer
  [[acc ignore? score garbage? garbage-count :as state] c]
  (if ignore?
    [acc false score garbage? garbage-count]
    (if (= c \!)
      [acc true score garbage? garbage-count]
      (if (and garbage? (= c \>))
        [acc false score false garbage-count]
        (if garbage?
          [acc false score true (inc garbage-count)]
          (if (= c \<)
            [acc false score true garbage-count]
            (if (= c \{)
              [acc false (inc score) false garbage-count]
              (if (= c \})
                [(conj acc score) false (dec score) false garbage-count]
                state))))))))

(defn group-score
  [seq]
  (reduce reducer
          [[] false 0 false 0]
          seq))

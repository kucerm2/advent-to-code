(ns advent-2017.day-10
  (:require [clojure.test :refer :all]
            [advent-2017.day-10.shared :as sh]
            [advent-2017.day-10.part1 :as part1]))


(deftest test-sublist
  (are [x y] (= x (sh/sublist y 2 [0 1 2 3]))
             [0 1] 0
             [1 2] 1
             [2 3] 2
             [3 0] 3
             [0 1] 4))

(deftest test-merge
  (are [x y] (= x (sh/merge y [8 9] [0 1 2 3]))
             [8 9 2 3] 0
             [0 8 9 3] 1
             [0 1 8 9] 2
             [9 1 2 8] 3
             [8 9 2 3] 4))

(deftest test-reverse-sublist
  (are [x y] (= x (sh/reverse-sublist y 2 [0 1 2 3]))
             [1 0 2 3] 0
             [0 2 1 3] 1
             [0 1 3 2] 2
             [3 1 2 0] 3
             [1 0 2 3] 4))

(deftest test-hash1
  (are [x y] (= x (sh/hash [0 1 2 3] [y]))
             [0 1 2 3] 0
             [0 1 2 3] 1
             [1 0 2 3] 2
             [2 1 0 3] 3
             [3 2 1 0] 4))

(deftest test-hash1
  (are [x y] (= x (sh/hash [0 1 2 3 4] y))
             [3 4 2 1 0] [3 4 1 5]))

(deftest test-solution-part1
  (is (= 4480 (part1/solve [63 144 180 149 1 255 167 84 125 65 188 0 2 254 229 24]))))





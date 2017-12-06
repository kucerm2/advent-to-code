(ns advent-2017.day-06
  (:require [clojure.test :refer :all]
            [advent-2017.day-06.shared :as sh]
            [advent-2017.day-06.part1 :as part1]
            [advent-2017.day-06.part2 :as part2]))

(def banks4 (partial sh/rotate 3))
(def banks16 (partial sh/rotate 15))

(deftest test-realloc-bank-4
  (are [x y] (= x (sh/reallocate banks4 y))
             [2 4 1 2] [0 2 7 0]
             [3 1 2 3] [2 4 1 2]
             [0 2 3 4] [3 1 2 3]
             [1 3 4 1] [0 2 3 4]
             [2 4 1 2] [1 3 4 1]))

(deftest test-realloc-bank-16
  (are [x y] (= x (sh/reallocate banks16 y))
             [11 4 0 11 6 16 6 16 10 3 6 9 6 3 4 7] [10 3 15 10 5 15 5 15 9 2 5 8 5 2 3 6]
             [12 5 1 12 7 1 7 17 11 4 7 10 7 4 5 8] [11 4 0 11 6 16 6 16 10 3 6 9 6 3 4 7]))

(deftest part2-assignment-test
  (is (= 4 (part2/solve banks4 [0 2 7 0]))))



;; long time execution task
;(deftest part1-solve-assignment
;  (is (= 14029 (part1/solve banks16 sh/input))))
;
;(def solver-bank-16 (partial part2/solve banks16))
;(deftest part2-solve-my
;  (is (= 2765 (solver-bank-16 [10 3 15 10 5 15 5 15 9 2 5 8 5 2 3 6]))))
;(deftest part2-solve2
;  (is (= 2392 (solver-bank-16 [0 14 13 12 11 10 8 8 6 6 5 3 3 2 1 10]))))
;(deftest part2-solve3
;  (is (= 2793 (solver-bank-16 [11 11 13 7 0 15 5 5 4 4 1 1 7 1 15 11]))))

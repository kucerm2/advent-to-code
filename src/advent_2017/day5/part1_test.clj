(ns advent-2017.day5.part1-test
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day5.part1 :refer [solve]]))


(deftest test-easy-states
  (is (= 5 (solve "0\n3\n0\n1\n-3"))))


(deftest test-solution
  (is (= 388611 (solve advent-2017.day5.data1/input))))
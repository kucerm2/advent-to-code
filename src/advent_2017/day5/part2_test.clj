(ns advent-2017.day5.part2-test
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day5.part2 :refer [solve]]))


(deftest test-easy-states
  (is (= 10 (solve "0\n3\n0\n1\n-3"))))


(deftest test-solution
  (is (= 27763113 (solve advent-2017.day5.data1/input))))
(ns advent-2017.day4.part1-test
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day4.part1 :refer [check-phrase solve]]))


(deftest test-phrase
  (are [x y] (= x (check-phrase y))
             true "aa bb cc dd ee"
             false "aa bb cc dd aa"
             true "aa bb cc dd aaa"))

(deftest test-solution
  (is (= 337 (solve advent-2017.day4.data1/input))))

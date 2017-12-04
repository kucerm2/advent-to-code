(ns advent-2017.day4.part2-test
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day4.part2 :refer [check-phrase solve]]))


(deftest test-phrase
  (are [x y] (= x (check-phrase y))
             true "abcde fghij"
             false "abcde xyz ecdab"
             true "a ab abc abd abf abj"
             true "iiii oiii ooii oooi oooo"
             false "oiii ioii iioi iiio"))

(deftest test-solution
  (is (= 231 (solve advent-2017.day4.data1/input))))

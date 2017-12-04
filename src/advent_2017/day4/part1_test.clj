(ns advent-2017.day4.part1-test
  (:require [clojure.test :refer [deftest are]]
            [advent-2017.day4.part1 :refer [check-phrase solve]]))


(deftest test-phrase
  (are [x y] (= x (check-phrase y))
             true "aa bb cc dd ee"
             false "aa bb cc dd aa"
             true "aa bb cc dd aaa"))

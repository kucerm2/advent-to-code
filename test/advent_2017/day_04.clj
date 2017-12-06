(ns advent-2017.day-04
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day-04.part1 :as p1]
            [advent-2017.day-04.part2 :as p2]
            [advent-2017.day-04.shared :as sh]))


(deftest test-phrase-p1
  (are [x y] (= x ((sh/check-phrase identity) y))
             true "aa bb cc dd ee"
             false "aa bb cc dd aa"
             true "aa bb cc dd aaa"))



(deftest test-phrase-p2
  (are [x y] (= x ((sh/check-phrase sort)y))
             true "abcde fghij"
             false "abcde xyz ecdab"
             true "a ab abc abd abf abj"
             true "iiii oiii ooii oooi oooo"
             false "oiii ioii iioi iiio"))

;; long time execution task
;(deftest test-solution-p1
;  (is (= 337 (p1/solve sh/input))))
;(deftest test-solution-p2
;  (is (= 231 (p2/solve sh/input))))


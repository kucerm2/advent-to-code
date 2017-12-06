(ns advent-2017.day-05
  (:require [clojure.test :refer [deftest are is]]
            [advent-2017.day-05.part1 :as p1]
            [advent-2017.day-05.part2 :as p2]))

(deftest test-part1-assignment
  (is (= 5 (p1/solve [0 3 0 1 -3]))))

(deftest test-part2-assignment
  (is (= 10 (p2/solve [0 3 0 1 -3]))))


;; long time execution task
;(deftest test-solution-part-1
;  (is (= 388611 (p1/solve advent-2017.day-05.shared/input))))
;(deftest test-solution-part2
;  (is (= 27763113 (p2/solve advent-2017.day-05.shared/input))))
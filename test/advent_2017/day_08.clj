(ns advent-2017.day-08
  (:require [clojure.test :refer :all]
            [advent-2017.day-08.shared :as sh]
            [advent-2017.day-08.part1 :as part1]
            [advent-2017.day-08.part2 :as part2]))

(deftest test-assignment-regs
  (is (= {'a 1, 'c -10} (first (sh/evaluate (sh/parse-input "resource/advent_2017/day_08/assignment_input.txt") {})))))

(deftest test-s1
  (is (= 450 (part1/solve (sh/parse-input "resource/advent_2017/day_08/input_1.txt")))))

(deftest test-s1-obj
  (is (= {'gjr -698 'jyg 378 'k -994 'qen 450}
         (first (sh/evaluate (sh/parse-input "resource/advent_2017/day_08/input_1.txt") {})))))

(deftest test-assignment-solve
  (is (= 1 (part1/solve (sh/parse-input "resource/advent_2017/day_08/assignment_input.txt")))))

(deftest test-solve-part1
  (is (= 3612 (part1/solve (sh/parse-input "resource/advent_2017/day_08/input.txt")))))

(deftest test-solve-part2
  (is (= 3818 (part2/solve (sh/parse-input "resource/advent_2017/day_08/input.txt")))))

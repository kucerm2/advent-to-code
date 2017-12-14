(ns advent-2017.day-09
  (:require [clojure.test :refer :all]
            [advent-2017.day-09.shared :as sh]
            [advent-2017.day-09.part1 :as part1]
            [advent-2017.day-09.part2 :as part2]))

(deftest test-group-score
  (are [x y] (= x (-> (sh/group-score y) first))
             [1] "{}"
             [3 2 1] "{{{}}}"
             [2 2 1] "{{},{}}"
             [3 3 4 3 2 1] "{{{},{},{{}}}}"
             [1] "{<a>,<a>,<a>,<a>}"
             [2 2 2 2 1] "{{<ab>},{<ab>},{<ab>},{<ab>}}"
             [2 2 2 2 1] "{{<!!>},{<!!>},{<!!>},{<!!>}}"
             [2 1] "{{<a!>},{<a!>},{<a!>},{<ab>}}"))

(deftest test-part1-assignment
  (are [x y] (= x (part1/solve y))
             1 "{}"
             6 "{{{}}}"
             5 "{{},{}}"
             16 "{{{},{},{{}}}}"
             1 "{<a>,<a>,<a>,<a>}"
             9 "{{<ab>},{<ab>},{<ab>},{<ab>}}"
             9 "{{<!!>},{<!!>},{<!!>},{<!!>}}"
             3 "{{<a!>},{<a!>},{<a!>},{<ab>}}"))

(deftest test-part1-solution
  (is (= 15922 (part1/solve (sh/parse-input "resource/advent_2017/day_09/input.txt")))))

(deftest test-part2-assignment
  (are [x y] (= x (get (sh/group-score y) 4))
             0 "<>"
             17 "<random characters>"
             3 "<<<<>"
             2 "<{!>}>"
             0 "<!!>"
             0 "<!!!>>"
             10 "<{o\"i!a,<{i<a>"))

(deftest test-part1-solution
  (is (= 7314 (part2/solve (sh/parse-input "resource/advent_2017/day_09/input.txt")))))

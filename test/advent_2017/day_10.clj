(ns advent-2017.day-10
  (:require [clojure.test :refer :all]
            [advent-2017.day-10.shared :as sh]
            [advent-2017.day-10.part1 :as part1]
            [advent-2017.day-10.part2 :as part2]))


(deftest test-sublist
  (are [x y] (= x (sh/sublist y 2 [0 1 2 3]))
             [0 1] 0
             [1 2] 1
             [2 3] 2
             [3 0] 3
             [0 1] 4))

(deftest test-merge
  (are [x y] (= x (sh/merge-sublist y [8 9] [0 1 2 3]))
             [8 9 2 3] 0
             [0 8 9 3] 1
             [0 1 8 9] 2
             [9 1 2 8] 3
             [8 9 2 3] 4))

(deftest test-reverse-sublist
  (are [x y] (= x (sh/reverse-sublist y 2 [0 1 2 3]))
             [1 0 2 3] 0
             [0 2 1 3] 1
             [0 1 3 2] 2
             [3 1 2 0] 3
             [1 0 2 3] 4))

(deftest test-hash1
  (are [x y] (= x (sh/knot-hash [0 1 2 3] [y]))
             [0 1 2 3] 0
             [0 1 2 3] 1
             [1 0 2 3] 2
             [2 1 0 3] 3
             [3 2 1 0] 4))

(deftest test-hash1
  (are [x y] (= x (sh/knot-hash [0 1 2 3 4] y))
             [3 4 2 1 0] [3 4 1 5]))

(deftest test-solution-part1
  (is (= 4480 (part1/solve [63 144 180 149 1 255 167 84 125 65 188 0 2 254 229 24]))))

(deftest test-dense
  (are [x y] (= x (part2/dense y))
             64 [65 27 9 1 4 3 40 50 91 7 6 0 2 5 68 22]))

(deftest test-finalize-str
  (is (= [49 44 50 44 51 17 31 73 47 23] (part2/finalize-str "1,2,3"))))

(deftest test-solution-part2
  (are [x y] (= x (part2/solve y))
             "c500ffe015c83b60fad2e4b7d59dabc4" "63,144,180,149,1,255,167,84,125,65,188,0,2,254,229,24"
             "a2582a3a0e66e6e86e3812dcb672a272" ""
             "33efeb34ea91902bb2f59c9920caa6cd" "AoC 2017"
             "3efbe78a8d82f29979031a4aa0b16a9d" "1,2,3"
             "63960835bcdc130f0b66d7ff4f6a5a8e" "1,2,4"))





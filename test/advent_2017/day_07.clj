(ns advent-2017.day-07
  (:require [clojure.test :refer :all]
            [advent-2017.day-07.shared :as sh]
            [advent-2017.day-07.part1 :as part1]
            [advent-2017.day-07.part2 :as part2]))


(deftest read-tower-line-test
  (are [x y] (= x (sh/read-tower-line y))
             '("pbga" "66" nil)  "pbga (66)"
             '("fwft" "72" " -> ktlj, cntj, xhth") "fwft (72) -> ktlj, cntj, xhth"))

(deftest parse-tower-test
  (are [x y] (= x (sh/parse-tower y))
             ["pbga" {:weight 66 :child-names nil}] '("pbga" "66" nil)

             ["fwft" {:weight 72 :child-names ["ktlj" "cntj" "xhth"]}] '("fwft" "72" " -> ktlj, cntj, xhth")))

(deftest parse-input
  (is (= {
          "pbga" {:weight 66 :child-names nil}
          "fwft" {:weight 72 :child-names ["ktlj" "cntj" "xhth"]}}
         (sh/parse-input "resource/advent_2017/day_07/test_input.txt"))))

(deftest find-root-name
  (is (= "tknk" (first (sh/build-tree (sh/parse-input "resource/advent_2017/day_07/assignment_input.txt"))))))

(deftest solution1
  (is (= "vgzejbd" (part1/solution (sh/parse-input "resource/advent_2017/day_07/input.txt")))))

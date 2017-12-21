(ns advent-2017.day-11.shared
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn str->dirs [s]
  (clojure.edn/read-string (str "(" s ")")))

(defn move [[x y z] dir]
  (case dir
    n [x (inc y) (dec z)]
    s [x (dec y) (inc z)]
    nw [(dec x) (inc y) z]
    sw [(dec x) y (inc z)]
    se [(inc x) (dec y) z]
    ne [(inc x) y (dec z)]))

(defn dist [coords]
  (/ (apply + (map #(Math/abs ^long %) coords)) 2))
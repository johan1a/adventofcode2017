(ns day2.core
  (:require [clojure.string :as str]))

(defn to-ints
  [line]
  (map #(Integer/parseInt %) line))

(defn get-input
  []
  (let [input (slurp "input.txt")
        lines (str/split input #"\n")
        split-lines (map #(str/split % #"\t") lines)]
    (map to-ints split-lines)))

(defn line-score
  [line]
  (let [max-val (apply max line)
        min-val (apply min line)]
    (- max-val min-val)))

(defn part1
  []
  (reduce + (map line-score (get-input))))

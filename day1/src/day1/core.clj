(ns day1.core
  (:require [clojure.string :as str]))

(defn read-input
  []
  (let [input (str/trim-newline (slurp "input.txt"))
        full-input (str input (last input))]
  (map #(Integer/parseInt (str %)) full-input)))

(defn calc-score
  [a b]
  (if (= a b) a 0))

(defn calc-scores
  [input acc]
  (if (= 1 (count input)) acc
      (let [a (first input)
            b (second input)
            score (calc-score a b)]
        (recur (rest input) (+ acc score)))))

(defn part1
  []
  (let [input (read-input)]
      (calc-scores input 0)))

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

(defn get-other
  [input index]
  (let [size (count input)
        offset (mod (+ (/ size 2) index) size)]
    (nth input offset)))

(defn calc-scores2
  [input index acc]
  (if (= index (count input)) acc
      (let [a (nth input index)
            b (get-other input index)
            score (calc-score a b)]
        (recur input (inc index) (+ acc score)))))

(defn read-input2
  []
  (let [input (str/trim-newline (slurp "input.txt"))]
  (map #(Integer/parseInt (str %)) input)))

(defn part2
  []
  (let [input (read-input2)]
      (calc-scores2 input 0 0)))

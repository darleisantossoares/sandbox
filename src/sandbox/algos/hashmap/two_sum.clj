(ns sandbox.algos.hashmap.two-sum
  (:require [clojure.test :refer [deftest is]]))


(defn two-sum
  [nums target]
  (loop [num-map {}
         [x & xs] nums
         idx 0]
    (let [diff (- target x)
          match (num-map diff)]
      (if match
        [match idx]
        (recur (assoc num-map x idx) xs (inc idx))))))


(deftest two-sum-test
  (is (= (two-sum [2 7 11 15] 9) [0 1]))
  (is (= (two-sum [3 2 4] 6) [1 2])))

(ns sandbox.algos.graphs.dfs
  (:require [clojure.test :refer [deftest is are]]))

(defn dfs
  [graph start]
  (loop [stack [start]
         visited #{}
         path []]
    (if (empty? stack)
      visited
      (let [node (peek stack)
            neighbours (graph node)
            new-path (conj path node)]
        (if (visited node)
          (recur (pop stack) visited new-path)
          (recur (into stack (remove visited neighbours)) (conj visited node) new-path))))))

(def graph {:a [:b :c]
            :b [:a :d :e]
            :c [:a :f]
            :d [:b]
            :e [:b :f]
            :f [:c :e]
            :g []})

(deftest traverse-test
  (are [g start] (= (dfs g start) #{:a :b :c :d :e :f})
    graph :a
    graph :b
    graph :c)
  (is (dfs graph :g) #{:g}))


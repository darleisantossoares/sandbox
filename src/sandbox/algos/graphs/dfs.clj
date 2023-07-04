(ns sandbox.algos.graphs.dfs)

(def graph {:a [:b :c]
            :b [:a :d :e]
            :c [:a :f]
            :d [:b]
            :e [:b :f]
            :f [:c :e]})

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
          (do
            (println node "->" path "->" neighbours)
            (recur (into stack (remove visited neighbours)) (conj visited node) new-path)))))))


(println (dfs graph :a))

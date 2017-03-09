(ns martian-robots-clojure.core)

(defn move
  [robot]
  (cond
    (= (:orientation robot) :N) (update-in robot [:y] inc)
    (= (:orientation robot) :S) (update-in robot [:y] dec)
    (= (:orientation robot) :E) (update-in robot [:x] inc)
    (= (:orientation robot) :W) (update-in robot [:x] dec)))

(defn -main
  []
  (println (move {:x 1 :y 2 :orientation :W})))

(ns martian-robots-clojure.core)

(defn go-forward
  [robot]
  (cond
    (= (:orientation robot) :N) (update robot :y inc)
    (= (:orientation robot) :S) (update robot :y dec)
    (= (:orientation robot) :E) (update robot :x inc)
    (= (:orientation robot) :W) (update robot :x dec)))

(defn rotate-right
  [robot]
  (cond
    (= (:orientation robot) :N) (assoc robot :orientation :E)
    (= (:orientation robot) :E) (assoc robot :orientation :S)
    (= (:orientation robot) :S) (assoc robot :orientation :W)
    (= (:orientation robot) :W) (assoc robot :orientation :N)))

(defn rotate-left
  [robot]
  (cond
    (= (:orientation robot) :N) (assoc robot :orientation :W)
    (= (:orientation robot) :W) (assoc robot :orientation :S)
    (= (:orientation robot) :S) (assoc robot :orientation :E)
    (= (:orientation robot) :E) (assoc robot :orientation :N)))

(defn move
  [robot direction]
  (cond
    (= direction :L) (rotate-left robot)
    (= direction :R) (rotate-right robot)
    (= direction :F) (go-forward robot)))

(defn go
  [robot instructions]
  (reduce (fn [robot instruction] (move robot instruction)) robot instructions))

(defn -main
  []
  (go {:x 1 :y 1 :orientation :E} [:R :F :R :F :R :F :R :F]))

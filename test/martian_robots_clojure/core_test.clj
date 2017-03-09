(ns martian-robots-clojure.core-test
  (:require [clojure.test :refer :all]
            [martian-robots-clojure.core :refer :all]))

(deftest move-test
  (testing "Robot moves correctly when oriented North"
    (is (= (move {:x 1 :y 2 :orientation :N }) {:x 1 :y 3 :orientation :N})))
  (testing "Robot moves correctly when oriented South"
    (is (= (move {:x 1 :y 2 :orientation :S }) {:x 1 :y 1 :orientation :S})))
  (testing "Robot moves correctly when oriented East"
    (is (= (move {:x 1 :y 2 :orientation :E }) {:x 2 :y 2 :orientation :E})))
  (testing "Robot moves correctly when oriented West"
    (is (= (move {:x 1 :y 2 :orientation :W }) {:x 0 :y 2 :orientation :W}))))

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

(deftest rotate-test
  (testing "Robot turns right correctly when facing north"
    (is (= (rotate {:x 1 :y 2 :orientation :N } :R) {:x 1 :y 2 :orientation :E})))
  (testing "Robot turns left correctly when facing north"
    (is (= (rotate {:x 1 :y 2 :orientation :N } :L) {:x 1 :y 2 :orientation :W})))
  (testing "Robot turns right correctly when facing south"
    (is (= (rotate {:x 1 :y 2 :orientation :S } :R) {:x 1 :y 2 :orientation :W})))
  (testing "Robot turns left correctly when facing south"
    (is (= (rotate {:x 1 :y 2 :orientation :S } :L) {:x 1 :y 2 :orientation :E})))
  (testing "Robot turns right correctly when facing east"
    (is (= (rotate {:x 1 :y 2 :orientation :E } :R) {:x 1 :y 2 :orientation :S})))
  (testing "Robot turns left correctly when facing east"
    (is (= (rotate {:x 1 :y 2 :orientation :E } :L) {:x 1 :y 2 :orientation :N})))
  (testing "Robot turns right correctly when facing west"
    (is (= (rotate {:x 1 :y 2 :orientation :W } :R) {:x 1 :y 2 :orientation :N})))
  (testing "Robot turns left correctly when facing west"
    (is (= (rotate {:x 1 :y 2 :orientation :W } :L) {:x 1 :y 2 :orientation :S}))))

(ns martian-robots-clojure.core-test
  (:require [clojure.test :refer :all]
            [martian-robots-clojure.core :refer :all]))

(deftest go-forward-test
  (testing "Robot moves correctly when oriented North"
    (is (= (go-forward {:x 1 :y 2 :orientation :N }) {:x 1 :y 3 :orientation :N})))
  (testing "Robot moves correctly when oriented South"
    (is (= (go-forward {:x 1 :y 2 :orientation :S }) {:x 1 :y 1 :orientation :S})))
  (testing "Robot moves correctly when oriented East"
    (is (= (go-forward {:x 1 :y 2 :orientation :E }) {:x 2 :y 2 :orientation :E})))
  (testing "Robot moves correctly when oriented West"
    (is (= (go-forward {:x 1 :y 2 :orientation :W }) {:x 0 :y 2 :orientation :W}))))

(deftest rotate-right-test
  (testing "Robot turns right correctly when facing north"
    (is (= (rotate-right {:x 1 :y 2 :orientation :N }) {:x 1 :y 2 :orientation :E})))
  (testing "Robot turns right correctly when facing south"
    (is (= (rotate-right {:x 1 :y 2 :orientation :S }) {:x 1 :y 2 :orientation :W})))
  (testing "Robot turns right correctly when facing east"
    (is (= (rotate-right {:x 1 :y 2 :orientation :E }) {:x 1 :y 2 :orientation :S})))
  (testing "Robot turns right correctly when facing west"
    (is (= (rotate-right {:x 1 :y 2 :orientation :W }) {:x 1 :y 2 :orientation :N}))))

(deftest rotate-left-test
  (testing "Robot turns right correctly when facing north"
    (is (= (rotate-left {:x 1 :y 2 :orientation :N }) {:x 1 :y 2 :orientation :W})))
  (testing "Robot turns right correctly when facing south"
    (is (= (rotate-left {:x 1 :y 2 :orientation :S }) {:x 1 :y 2 :orientation :E})))
  (testing "Robot turns right correctly when facing east"
    (is (= (rotate-left {:x 1 :y 2 :orientation :E }) {:x 1 :y 2 :orientation :N})))
  (testing "Robot turns right correctly when facing west"
    (is (= (rotate-left {:x 1 :y 2 :orientation :W }) {:x 1 :y 2 :orientation :S}))))

(deftest go-test
  (testing "Robot is moved correctly based on instructions"
    (is (= (go {:x 1 :y 1 :orientation :E} [:R :F :R :F :R :F :R :F]) {:x 1 :y 1 :orientation :E}))))

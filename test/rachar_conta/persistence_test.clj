(ns rachar-conta.persistence-test
  (:require [clojure.test :refer :all]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.core :refer :all]))

(deftest make-order-test
  (testing "Make Order Test"
    (is (= [] @bill-card))

    (let [new-order
          {:id (rand-int 9999999)
           :food "Simple Burger"
           :customer "TK"
           :price 22.00}]
      (persistence/make-order bill-card new-order))

    (let [last-order (last @bill-card)]
      (is (= "Simple Burger" (:food last-order)))
      (is (= "TK" (:customer last-order)))
      (is (= 22.00 (:price last-order))))

    (reset! bill-card [])))

(ns rachar-conta.calculation-test
  (:require [clojure.test :refer :all]
            [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.core :refer :all]))

(deftest total-bill-test
  (testing "Test the calculation for total bill"
    (persistence/make-order bill-card {:id 1 :food "Simple Burger" :customer "Kaio"   :price 22.00})
    (persistence/make-order bill-card {:id 2 :food "X-Bacon"       :customer "TK"     :price 29.00})
    (persistence/make-order bill-card {:id 3 :food "Veggie Burger" :customer "Kazumi" :price 30.00})
    (persistence/make-order bill-card {:id 4 :food "X-Burger"      :customer "Monica" :price 24.00})
    (persistence/make-order bill-card {:id 5 :food "Coke"          :customer "Kaio"   :price 5.00})
    (persistence/make-order bill-card {:id 6 :food "Heineken"      :customer "Kazumi" :price 7.00})
    (persistence/make-order bill-card {:id 7 :food "Coke"          :customer "TK"     :price 5.00})
    (persistence/make-order bill-card {:id 8 :food "Coke"          :customer "Monica" :price 5.00})
    (is (= 139.7 (calculation/total-bill @bill-card)))
    (reset! bill-card [])))

(deftest calculate-10%-tip-test
  (testing "Test the 10% tip calculation"
    (is (= 1.0 (calculation/calculate-10%-tip 10)))
    (is (= 10.0 (calculation/calculate-10%-tip 100)))
    (is (= 4.0 (calculation/calculate-10%-tip 40)))
    (is (= 5.5 (calculation/calculate-10%-tip 55)))))

(deftest bill-for-each-test
  (testing "Test the bill for each"
    (is (= 10.0 (calculation/bill-for-each 100 10)))))

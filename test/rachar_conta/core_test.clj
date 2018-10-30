(ns rachar-conta.core-test
  (:require [clojure.test :refer :all]
            [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.core :refer :all]))

(deftest initialized-bill-test
  (testing "Test the value of the initialized bill"
    (is (= 0 @total-bill))
    (reset! total-bill 0)))

(deftest integration-test
  (testing "Simulates a `real` restaurant bill"
    (persistence/update-total-bill total-bill 22) ;; simple burger
    (persistence/update-total-bill total-bill 29) ;; x-bacon
    (persistence/update-total-bill total-bill 30) ;; veggie burger
    (persistence/update-total-bill total-bill 24) ;; x-burger
    (persistence/update-total-bill total-bill 5)  ;; coke
    (persistence/update-total-bill total-bill 7)  ;; heineken
    (persistence/update-total-bill total-bill 5)  ;; coke
    (persistence/update-total-bill total-bill 5)  ;; coke
    (persistence/update-total-bill total-bill (calculation/calculate-10%-tip @total-bill))
    (is (= 34.925 (calculation/bill-for-each @total-bill 4)))
    (reset! total-bill 0)))

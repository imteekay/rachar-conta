(ns rachar-conta.core-test
  (:require [clojure.test :refer :all]
            [rachar-conta.calculation :refer :all]
            [rachar-conta.persistence :refer :all]
            [rachar-conta.core :refer :all]))

(deftest initialized-bill-test
  (testing "Test the value of the initialized bill"
    (is (= 0 @total-bill))
    (reset! total-bill 0)))

(deftest integration-test
  (testing "Simulates a `real` restaurant bill"
    (update-total-bill total-bill 22) ;; simple burger
    (update-total-bill total-bill 29) ;; x-bacon
    (update-total-bill total-bill 30) ;; veggie burger
    (update-total-bill total-bill 24) ;; x-burger
    (update-total-bill total-bill 5)  ;; coke
    (update-total-bill total-bill 7)  ;; heineken
    (update-total-bill total-bill 5)  ;; coke
    (update-total-bill total-bill 5)  ;; coke
    (update-total-bill total-bill (calculate-10%-tip @total-bill))
    (is (= 34.925 (bill-for-each @total-bill 4)))
    (reset! total-bill 0)))

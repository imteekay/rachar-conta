(ns rachar-conta.calculation-test
  (:require [clojure.test :refer :all]
            [rachar-conta.calculation :refer :all]
            [rachar-conta.core :refer :all]))

(deftest calculate-10%-tip-test
  (testing "Test the 10% tip calculation"
    (is (= 1.0 (calculate-10%-tip 10)))
    (is (= 10.0 (calculate-10%-tip 100)))
    (is (= 4.0 (calculate-10%-tip 40)))
    (is (= 5.5 (calculate-10%-tip 55)))
    (reset! total-bill 0)))

(deftest bill-for-each-test
  (testing "Test the bill for each"
    (is (= 10.0 (bill-for-each 100 10)))))

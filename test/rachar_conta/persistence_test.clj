(ns rachar-conta.persistence-test
  (:require [clojure.test :refer :all]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.core :refer :all]))

(deftest update-total-bill-test
  (testing "Test the total bill update"
    (is (= 0 @total-bill))
    (persistence/update-total-bill total-bill 10)
    (is (= 10 @total-bill))
    (persistence/update-total-bill total-bill 10)
    (is (= 20 @total-bill))
    (reset! total-bill 0)))

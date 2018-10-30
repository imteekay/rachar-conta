(ns rachar-conta.builders-test
  (:require [clojure.test :refer :all]
            [rachar-conta.builders :as builders]
            [rachar-conta.core :refer :all]))

(deftest build-order-test
  (testing "Build Order Test"
    (let [new-order (builders/build-order "Simple Burger" 22.00)]
      (is (= "Simple Burger" (:food new-order)))
      (is (= 22.00 (:price new-order))))))

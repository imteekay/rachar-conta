(ns rachar-conta.builders
  (:require [rachar-conta.calculation :as calculation]))

(defn build-order [food customer price]
  {:id       (rand-int 9999999)
   :food     food
   :customer customer
   :price    price})

(defn build-price-per-customer
  [customers bill-card]
  (map
    (fn [customer]
      {:customer    customer
       :total-price (calculation/calculate-total-price-for customer bill-card)})
    customers))

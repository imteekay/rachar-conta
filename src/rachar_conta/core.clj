(ns rachar-conta.core
  (:require [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]))

(def total-bill (atom 0))

(def bill-card (atom []))

(defn build-order [id food price]
  {:id    id
   :food  food
   :price price})

(defn make-order
  [order]
  (swap!
    bill-card
    conj
    order))

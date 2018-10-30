(ns rachar-conta.core
  (:require [rachar-conta.calculation :refer :all]))

(def total-bill (atom 0))

(defn update-total-bill
  [total-bill consumption]
  (swap! total-bill (partial + consumption)))

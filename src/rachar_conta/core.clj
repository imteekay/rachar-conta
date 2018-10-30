(ns rachar-conta.core
  (:require [rachar-conta.calculation :refer :all])
  (:require [rachar-conta.persistence :refer :all]))

(def total-bill (atom 0))

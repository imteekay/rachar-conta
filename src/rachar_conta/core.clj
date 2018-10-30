(ns rachar-conta.core
  (:require [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.builders :as builders]))

(def bill-card (atom []))

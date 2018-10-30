(ns rachar-conta.core
  (:require [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]))

(def bill-card (atom []))

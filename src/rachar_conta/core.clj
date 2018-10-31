(ns rachar-conta.core
  (:require [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.visualization :as visualization]
            [rachar-conta.builders :as builders]))

(def bill-card (atom []))

(defn order
  [bill-card food customer price]
  (persistence/make-order
    bill-card
    (builders/build-order food customer price)))

(defn -main [& args]
  (order bill-card "Simple Burger" "Kaio"   22.00)
  (order bill-card "X-Bacon"       "TK"     29.00)
  (order bill-card "Veggie Burger" "Kazumi" 30.00)
  (order bill-card "X-Burger"      "Monica" 24.00)
  (order bill-card "Coke"          "Kaio"   5.00)
  (order bill-card "Heineken"      "Kazumi" 7.00)
  (order bill-card "Coke"          "Kaio"   5.00)
  (order bill-card "Coke"          "Monica" 5.00)

  (visualization/print-show-total-bill (calculation/total-bill @bill-card))

  (visualization/print-show-equally-divided-bill
    (calculation/bill-for-each
      (calculation/total-bill @bill-card) 4))

  (visualization/print-show-separated-bills
    (let [customers ["Kaio" "TK" "Kazumi" "Monica"]]
      (builders/build-price-per-customer
        customers
        @bill-card))))

(ns rachar-conta.core
  (:require [rachar-conta.calculation :as calculation]
            [rachar-conta.persistence :as persistence]
            [rachar-conta.builders :as builders]))

(def bill-card (atom []))

(persistence/make-order
  bill-card
  (builders/build-order "Simple Burger" "Kaio" 22.00))

(persistence/make-order
  bill-card
  (builders/build-order "X-Bacon" "TK" 29.00))

(persistence/make-order
  bill-card
  (builders/build-order "Veggie Burger" "Kazumi" 30.00))

(persistence/make-order
  bill-card
  (builders/build-order "X-Burger" "Monica" 24.00))

(persistence/make-order
  bill-card
  (builders/build-order "Coke" "Kaio" 5.00))

(persistence/make-order
  bill-card
  (builders/build-order "Heineken" "Kazumi" 7.00))

(persistence/make-order
  bill-card
  (builders/build-order "Coke" "TK" 5.00))

(persistence/make-order
  bill-card
  (builders/build-order "Coke" "Monica" 5.00))

(print
  (str
    "Total Bill: "
    (calculation/total-bill @bill-card)))

(print
  (str
    "Equally Divided Bill: "
    (format "%.2f"
      (calculation/bill-for-each
        (calculation/total-bill @bill-card)
        4))))

(loop
  [customers ["Kaio" "TK" "Kazumi" "Monica"]]
  (when (not-empty customers)
    (let [customer (first customers)]
      (println
        (str "Total Bill for " customer ": R$"
          (format
            "%.2f"
            (calculation/total-bill
              (filter
                #(= customer (:customer %))
                @bill-card))))))
    (recur (rest customers))))

(ns rachar-conta.calculation)

(defn calculate-10%-tip
  [total-bill]
  (/ total-bill 10.0))

(defn bill-for-each
  [total-bill number-of-people]
  (let [total-bill (* 1.0 total-bill)]
    (/ total-bill number-of-people)))

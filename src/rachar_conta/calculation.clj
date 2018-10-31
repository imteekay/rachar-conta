(ns rachar-conta.calculation)

(defn calculate-total-price
  [card-bill]
  (reduce
    +
    (map
      #(:price %)
      card-bill)))

(defn calculate-10%-tip
  [total-price]
  (/ total-price 10.0))

(defn total-bill
  [card-bill]
  (let [total-price (calculate-total-price card-bill)]
    (+
      total-price
      (calculate-10%-tip total-price))))

(defn bill-for-each
  [total-bill number-of-people]
  (let [total-bill (* 1.0 total-bill)]
    (/ total-bill number-of-people)))

(defn calculate-total-price-for
  [customer bill-card]
  (total-bill
    (filter
      #(= customer (:customer %))
      bill-card)))

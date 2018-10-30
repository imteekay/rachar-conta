(ns rachar-conta.core)

(def total-bill (atom 0))

(defn update-total-bill
  [total-bill consumption]
  (swap! total-bill (partial + consumption)))

(defn calculate-10%-tip
  [total-bill]
  (/ total-bill 10.0))

(defn bill-for-each
  [total-bill number-of-people]
  (let [total-bill (* 1.0 total-bill)]
    (format "%.2f"
      (/ total-bill number-of-people))))

(ns rachar-conta.persistence)

(defn make-order
  [bill-card order]
  (swap!
    bill-card
    conj
    order))

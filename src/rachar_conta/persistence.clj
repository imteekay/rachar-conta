(ns rachar-conta.persistence)

(defn update-total-bill
  [total-bill consumption]
  (swap! total-bill (partial + consumption)))

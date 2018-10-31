(ns rachar-conta.visualization)

(defn show-total-bill
  [total]
  (str
    "Total Bill: R$"
    (format "%.2f" total)))

(defn show-equally-divided-bill
  [bill-price]
  (str
    "Equally Divided Bill: R$"
    (format "%.2f" bill-price)))

(defn show-separated-bills
  [price-per-customer]
  (map
    (fn [ppc]
      (str
        "Total Bill for " (:customer ppc) ": R$"
        (format "%.2f" (:total-price ppc))))
    price-per-customer))

(defn print-show-total-bill
  [total]
  (println
    (show-total-bill total)))

(defn print-show-equally-divided-bill
  [bill-price]
  (println
    (show-equally-divided-bill bill-price)))

(defn print-show-separated-bills
  [price-per-customer]
  (doseq [bill (show-separated-bills price-per-customer)]
    (println bill)))

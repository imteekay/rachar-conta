(ns rachar-conta.builders)

(defn build-order [food customer price]
  {:id       (rand-int 9999999)
   :food     food
   :customer customer
   :price    price})

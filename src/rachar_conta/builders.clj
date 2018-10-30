(ns rachar-conta.builders)

(defn build-order [food price]
  {:id    (rand-int 9999999)
   :food  food
   :price price})

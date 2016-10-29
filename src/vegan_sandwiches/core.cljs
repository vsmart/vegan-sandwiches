(ns vegan-sandwiches.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def screens
  {:intro "images/intro.png"
   :instructions "images/start-screen.png" })

(defn setup []
  (q/frame-rate 1)
  {:current-screen :intro})

(def load-image (memoize q/load-image))

(defn is-between [num min max]
  (and (>= num min) (<= num max)))

(defn update-screen [state]
  (let [frame-count (q/frame-count)]
    (cond
     (is-between frame-count 0 5) (assoc state :current-screen :intro)
     (is-between frame-count 5 10) (assoc state :current-screen :intro)
     :else (assoc state :current-screen :instructions))))

(defn update-state [state]
  (-> state
    (update-screen)))

(defn draw-screen [screen]
  (q/image (load-image (screen screens)) 0 0 (q/width) (q/height)))

(defn draw-state [state]
  (draw-screen (:current-screen state)))

(q/defsketch vegan-sandwiches
  :host "vegan-sandwiches"
  :size [600 400]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])

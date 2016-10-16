(ns vegan-sandwiches.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def screens
  {:intro "images/intro.png"
   :instructions "images/start-screen.png" })

(defn setup []
  ; Set frame rate to 30 frames per second.
  (q/frame-rate 1)
  {:current-screen :intro})

(def load-image (memoize q/load-image))

(defn update-state [state]
  (if (= (mod (q/frame-count) 2) 0)
    (assoc state :current-screen :intro)
    (assoc state :current-screen :instructions)))

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

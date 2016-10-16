(ns vegan-sandwiches.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def screens
  {:intro "images/intro.jpg"
   :instructions "images/start-screen.jpg" })

(defn setup []
  ; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  {:current-screen (:intro screens)})

(defn update-state [state]
  state)

(defn draw-screen [screen]
  (q/image (q/load-image screen) 0 0))

(defn draw-state [state]
  (draw-screen (:current-screen state)))

(q/defsketch vegan-sandwiches
  :host "vegan-sandwiches"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])

(ns re-frame-mobile-test.views
  (:require [re-frame.core :as rf]
            [re-frame-mobile-test.subs :as subs]))

(defn main-panel []
  [:div.container
   [:h1 "Web Speech Demo"]
   [:div "This button uses rf/dispatch and doesn't work on mobile Safari, unless you click the bottom button first"]
   [:button.btn.btn-danger {:on-click #(rf/dispatch [:say-something])}
    "Speak using dispatch"]
   [:div "This button always works because it calls speechSynthesis.speak() directly"]
   [:button.btn.btn-primary {:on-click #(.speak js/speechSynthesis (js/SpeechSynthesisUtterance. "Speak now or hold your peace"))}
    "Speak immediately"]])

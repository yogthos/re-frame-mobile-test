(ns re-frame-mobile-test.events
  (:require [re-frame.core :as rf]
            [re-frame-mobile-test.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

#_(rf/reg-fx
  :speak
  (fn [_]
    (.speak js/speechSynthesis
            (js/SpeechSynthesisUtterance. "This won't come out on mobile"))))

#_(rf/reg-event-fx
 :say-something
 (fn [_ _]
   {:speak true}))

(reg-event-db
 :say-something
 (fn [db _]
   (.speak js/speechSynthesis
           (js/SpeechSynthesisUtterance. "This won't come out on mobile"))
   db))

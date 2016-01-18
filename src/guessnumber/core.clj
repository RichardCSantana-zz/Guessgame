(ns guessnumber.core (:gen-class))

(defn get-input[]
  (print "> ")
  (flush)
  (try
  (Integer/parseInt (read-line))
  (catch Exception e (str "caught exception: " (.getMessage e)))))

(defn pc-guess []
  (println "Think of a number between 0 to 99 and I'll try to guess it! ")
  (loop [minimum 0
        maximum 99]
        (let [guess (int (+ minimum (/ (- maximum minimum) 2)))]
            (println "My guess is:" guess)
            (print "1. Bigger ")
            (print "2. Smaller ")
            (print "3. That's correct!")
            (condp = (get-input)
              1 (recur guess maximum)
              2 (recur minimum guess)
              3 (println "All right!!!")
              (do (println "I didn't understand your answer...")
                (recur minimum maximum))))))

(defn player-guess []
  (let [answer (rand-int 100)]
    (println "I've tought of a number between 0 to 99... can you guess it?")
    (loop [guess (get-input)]
      (cond
        (< answer guess) (do (println "Smaller!") (recur (get-input)))
        (> answer guess) (do (println "Bigger!") (recur (get-input)))
        (= answer guess) (println "You got it!")))))

(defn menu []
  (println "Let's play Guess the Number!")
  (println "1. PC will decide the number")
  (println "2. You will decide the number")
  (println "3. Quit")
  (condp = (get-input)
    1 (player-guess)
    2 (pc-guess)
    3 (System/exit 0)
    (println "That's not a valid choice, sorry")))

(defn -main []
  (while true
    (menu)))

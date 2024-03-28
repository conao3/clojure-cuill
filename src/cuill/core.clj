(ns cuill.core
  (:import
   [com.googlecode.lanterna TextColor]
   [com.googlecode.lanterna.terminal Terminal DefaultTerminalFactory]))

(defn -main [& args]
  ;; (println "Hello, World!")
  (let* [default-terminal-factory (new DefaultTerminalFactory)
         terminal (.createTerminal default-terminal-factory)]

    (do
     (.putCharacter terminal \H)
     (.putCharacter terminal \e)
     (.putCharacter terminal \l)
     (.putCharacter terminal \l)
     (.putCharacter terminal \o)
     (.putCharacter terminal \newline)
     (.flush terminal))

    (Thread/sleep 2000)

    (let [start-position (.getCursorPosition terminal)]
      (.setCursorPosition terminal (-> start-position
                                       (.withRelativeColumn 3)
                                       (.withRelativeRow 2)))
      (.flush terminal))

    (Thread/sleep 2000)

    (.setBackgroundColor terminal
                        (.ANSI com.googlecode.lanterna.TextColor)
                         ;; (.BLUE (.ANSI TextColor))
                         ;; (-> TextColor (.ANSI) (.BLUE))
                         )
    ;; (.setForegroundColor terminal
    ;;                      (.YELLOW (.ANSI TextColor))
    ;;                      ;; (-> TextColor (.ANSI) (.WHITE))
    ;;                      )
    (.putString terminal "Hello, World!")
    (.flush terminal)

    (Thread/sleep 2000)
    (.close terminal)))

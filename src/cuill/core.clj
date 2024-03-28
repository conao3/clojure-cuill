(ns cuill.core)

(defn -main [& args]
  ;; (println "Hello, World!")
  (let* [default-terminal-factory (new com.googlecode.lanterna.terminal.DefaultTerminalFactory)
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

    (.setBackgroundColor terminal com.googlecode.lanterna.TextColor$ANSI/BLUE)
    (.setForegroundColor terminal com.googlecode.lanterna.TextColor$ANSI/YELLOW)
    (.putCharacter terminal \Y)
    (.putCharacter terminal \e)
    (.putCharacter terminal \l)
    (.putCharacter terminal \l)
    (.putCharacter terminal \o)
    (.putCharacter terminal \newline)
    (.resetColorAndSGR terminal)
    (.flush terminal)

    (Thread/sleep 2000)
    (.close terminal)))

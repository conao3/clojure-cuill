(ns cuill.core
  (:import [com.googlecode.lanterna.terminal Terminal DefaultTerminalFactory]))

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

    (.readInput terminal)
    (.close terminal)))

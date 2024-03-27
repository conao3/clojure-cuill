(ns cuill.core
  (:import [com.googlecode.lanterna.terminal Terminal DefaultTerminalFactory]))

(defn -main [& args]
  (println "Hello, World!")
  (let* [default-terminal-factory (DefaultTerminalFactory.)
         terminal (.createTerminal default-terminal-factory)]

    (do
     (.putCharacter terminal \H)
     (.putCharacter terminal \e)
     (.putCharacter terminal \l)
     (.putCharacter terminal \l)
     (.putCharacter terminal \o)
     (.putCharacter terminal \!)
     (.flush terminal))

    (.readInput terminal)
    (.close terminal)))

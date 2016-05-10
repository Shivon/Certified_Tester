# CTP-03
## Aufgabe 1
### Aufgabe 1.1: Analyse der Ausgangssituation
* Analyse Klassen _processing_ und _storage_ uf Codecoverage
* Coverage Report mit EclEmma erstellen und erläutern

* Erläuterungen:
  * "Branches" = jede Verzweigung für alle `if` und `switch` Statements zB
  ``` ruby
  def blubb
    if x
      y
    else
      z
    if a
      b
    else
      c
  end
  ```    
  => 2 Verzweigungen mit 4 Branches
  * "Cxty" = Cyclomatic Complexity = die minimale Anzahl an Pfaden durch den Code, mit denen alle Branches abgedeckt werden
    * beim Beispiel oben reichen 2 Pfade

##### SoSe-16    WP Certified Tester	  Prof. Dr. Bettina Buth

## Projekt Calculator – Problemreports Intuitiver Test

Team: Jana Wengenroth, Malte Scheller, Marjan Bachtiari    
Datum: 22.03.2016    

### Gefundene Probleme
#### Eingabewerte

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-1                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | 7 angeklickt                            |
| Beschreibung des Fehlerverhaltens   | Button „7“ geht nicht in GUI            |
| Vermutete Fehlerursache             | Bei Klick GUI keine Funktion aufgerufen |
| Vorschlag zur Fehlerbehebung        | Funktion hinterlegen                    |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-2                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | √ angeklickt                            |
| Beschreibung des Fehlerverhaltens   | Button geht nicht                       |
| Vermutete Fehlerursache             | Keine Funktion hinterlegt |
| Vorschlag zur Fehlerbehebung        | Funktion hinterlegen                    |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-3                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | C angeklickt                            |
| Beschreibung des Fehlerverhaltens   | Button „C“ (Clear) geht nicht, stürzt ab mit NullPointerException |
| Vermutete Fehlerursache             |                                         |
| Vorschlag zur Fehlerbehebung        |                                         |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-4                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | <- angeklickt                           |
| Beschreibung des Fehlerverhaltens   | Button „<-“ geht nicht in GUI           |
| Vermutete Fehlerursache             | Bei Klick GUI keine Funktion aufgerufen |
| Vorschlag zur Fehlerbehebung        | Funktion hinterlegen                    |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-5                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Eingabe über Tastatur gelöscht                            |
| Beschreibung des Fehlerverhaltens   | Wenn man negative Zahlen löscht, wirft es NumberFormatException: For input string, sobald man beim Minus ankommt, kein Absturz |
| Vermutete Fehlerursache             |                                         |
| Vorschlag zur Fehlerbehebung        |                                         |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-6                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Große Zahlen verrechnet                 |
| Beschreibung des Fehlerverhaltens   | Wenn Ergebnis große Zahl ist, stürzt TR mit NumberFormatException ab |
| Vermutete Fehlerursache             | Nur Eingabewerte gecheckt, aber keine Rückgabewerte |
| Vorschlag zur Fehlerbehebung        | Auch Rückgabewerte checken              |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-7                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Versucht, mehrere Punkte nacheinander einzugeben |
| Beschreibung des Fehlerverhaltens   | Mehrere Punkte direkt nacheinander geht nicht, dafür aber mehrere Punkte innerhalb einer Zahl |
| Vermutete Fehlerursache             | Anzahl Punkte nur direkt nacheinander und nicht im Kontext der ganzen Zahl geprüft |
| Vorschlag zur Fehlerbehebung        | Checks anpassen                         |
| Status                              | Offen                                   |

| Mangel                              |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-8                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Lange Berechnungen eingegeben           |
| Beschreibung des Fehlerverhaltens   | Bei zu langer Equationline verschiebt sich der CT-Calc innerhalb Fenster (Spalte 9, 6, 3 wird größer) |
| Vermutete Fehlerursache             |                                         |
| Vorschlag zur Fehlerbehebung        |                                         |
| Status                              | Offen                                   |

#### Unäre Operanden

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-9                               |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | ² (mehrfach) verwendet                  |
| Beschreibung des Fehlerverhaltens   | Wenn man bereits eine Berechnung gemacht hat & eine neue Zahl eingeben möchte, wird diese immer auf 0.0 gesetzt |
| Vermutete Fehlerursache             |                                         |
| Vorschlag zur Fehlerbehebung        |                                         |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-10                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | ² (mehrfach) verwendet                  |
| Beschreibung des Fehlerverhaltens   | Quadrieren von 2er-Potenzen geht nicht, ab 2. Mal wird Ergebnis immer negativ |
| Vermutete Fehlerursache             | Zahlen irgendwo negativ interpretiert   |
| Vorschlag zur Fehlerbehebung        | Stelle finden und korrigieren           |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-11                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | √ versucht zu verwenden                 |
| Beschreibung des Fehlerverhaltens   | Wurzelfunktion gar nicht verfügbar      |
| Vermutete Fehlerursache             | Zahlen irgendwo negativ interpretiert   |
| Vorschlag zur Fehlerbehebung        | Stelle finden und korrigieren           |
| Status                              | Offen                                   |

#### Binäre Operanden

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-11                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | √ versucht zu verwenden                 |
| Beschreibung des Fehlerverhaltens   | Wurzelfunktion gar nicht verfügbar      |
| Vermutete Fehlerursache             | Zahlen irgendwo negativ interpretiert   |
| Vorschlag zur Fehlerbehebung        | Stelle finden und korrigieren           |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-12                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Versucht, Berechnungen zu verketten     |
| Beschreibung des Fehlerverhaltens   | Verkettung von Berechnungen geht nicht, maximal 1 Binäroperator |
| Vermutete Fehlerursache             | Matching via Regex sieht nur 1 Operator jeweils vor |
| Vorschlag zur Fehlerbehebung        | Regex anpassen                          |
| Status                              | Offen                                   |

| Mangel                              |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-13                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Berechnung mit Binäroperator eingegeben |
| Beschreibung des Fehlerverhaltens   | Die erste eingegebene Zahl bleibt immer gemäß Eingabe, die zweite Zahl wird _immer_ zu einer Kommazahl umgewandelt |
| Vermutete Fehlerursache             | Umwandlung von letzter Zahl im Code     |
| Vorschlag zur Fehlerbehebung        | Umwandlung entfernen                    |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-14                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Additionen eingegeben                   |
| Beschreibung des Fehlerverhaltens   | Statt einer Addition wird immer eine Subtraktion durchgeführt |
| Vermutete Fehlerursache             | Falsche Implementierung/ falsche Funktion hinterlegt |
| Vorschlag zur Fehlerbehebung        | Implementieren/ richtig hinterlegen     |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-15                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Additionen eingegeben                   |
| Beschreibung des Fehlerverhaltens   | 1 und 4 scheinen negativ gewertet zu werden, wenn sie am Anfang stehen bei Berechnungen |
| Vermutete Fehlerursache             | Umwandlung im Negativzahlen             |
| Vorschlag zur Fehlerbehebung        | Negierung entfernen                     |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-16                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Division von 0 durch andere Zahl eingegeben |
| Beschreibung des Fehlerverhaltens   | 0 : x ergibt immer Infinity             |
| Vermutete Fehlerursache             | Statt 0 wird Infinity zurückgegeben (mathematisch inkorrekt und in Spezifikation dies als gewünschtes Verhalten nicht ersichtlich) |
| Vorschlag zur Fehlerbehebung        | Klären, was gewünscht und entsprechend dokumentieren/ abändern |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-17                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Division eingegeben                     |
| Beschreibung des Fehlerverhaltens   | Es wird immer ArithmeticException: Divided by 0 geworfen (außer gm PR-Calc-16) |
| Vermutete Fehlerursache             | Divisor wird immer als 0 interpretiert statt aus der Eingabe gelesen |
| Vorschlag zur Fehlerbehebung        | Tatsächliche Eingabe verwenden          |
| Status                              | Offen                                   |

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-18                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Multiplikation eingegeben               |
| Beschreibung des Fehlerverhaltens   | Ergebnisse, die eigentlich Nachkommastellen haben, werden immer auf ganze Zahlen abgerundet |
| Vermutete Fehlerursache             | Produkt wird immer abgeschnitten/ gecastet |
| Vorschlag zur Fehlerbehebung        | Tatsächliches Produkt zurückgeben       |
| Status                              | Offen                                   |

#### Utilities

| Fehlerfund                          |                                         |
|-------------------------------------|-----------------------------------------|
| Problemreport                       | PR-Calc-19                              |
| Datum                               | 2016-03-22                              |
| Gefunden durch wen                  | Team                                    |
| Gefunden durch Test                 | Nach Berechnung neue Zahl eingegeben    |
| Beschreibung des Fehlerverhaltens   | Wenn eine Berechnung durchgeführt wurde und man eine neue Zahl eintippt, wird der Screen nicht geleert und dann die neue Zahl geschrieben. Stattdessen wird die neue Zahl an das Ergebnis angehängt |
| Vermutete Fehlerursache             | Ggf ist nicht der C-Button in der GUI defekt, sondern die Clearfunktion selber ist nicht (richtig) implementiert oder wird nicht nach Ergebnis und bei neuer Eingabe automatisch aufgerufen |
| Vorschlag zur Fehlerbehebung        | Clearfunktion implementieren/ nutzen    |
| Status                              | Offen                                   |

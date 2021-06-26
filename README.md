# htwcalenderproject
Online-Kalender von Marie Jager (Einzelarbeit) \
https://github.com/MarieJager/htwcalenderproject \
Modul Webtechnologien, SoSe 2021, Prof. Dr. Arif Wider \
HTW-Berlin 

Funktionalität: \
Die Startseite zeigt eine Willkommensnachricht und eine Vorschau des Kalenders. Es gibt zwei Buttons: Login und Register
Um den Kalender nutzen zu können muss sich der Nutzer mit einem individuellen Nutzernamen und seiner E-Mail-Adresse anmelden. \
Der Kalender stellt eine Wochenübersicht der vom Nutzer erstellten Termine dar. Über ein Feld kann der Nutzer weitere Termine speichern, die dann im Kalender sichtbar werden. \
Die Nutzerdaten werden gespeichert und beim erneuten Anmelden über den Login abgerufen.

Anforderungen im Überblick: 
- die Anwendung ist nach Heroku deployed und öffentlich ansprechbar 
- Termine und Nutzer-Daten und Einstellungen werden in einer Datenbank gespeichert 
- es gibt einen User-Login, mehrere User werden unterstützt 
- Passwörter werden verschlüsselt gespeichert, Credentials gehen nicht als Klartext nach Github 
- Frontend- und Backend-Tests werden automatisiert von Github ausgeführt (CI/CD) 
- es gibt eine REST-Schnittstelle (GET, POST) 
- Funktionalitäten sind dynamisch im Frontend umgesetzt, VUE.js (keine Kommunikation mit Server nötig)

Zeitrahmen:

April: Github-Repo mit Themenbeschreibung in README.md, "Hello World" Spring Boot App, Link zum Repo per Mail an Dozenten\
Mai: REST-Schnittstelle, zu Heroku deployed, Daten werden in Datenbank gespeichert\
Mai: statische, server-seitig mit Thymeleaf ersteltte, grafische Oberfläche\
Juni: dynamische, mit Vue.js erstellte grafische Oberfläche\
Juni: finale Abgabe

Java
HTML
Heroku deployed, Nutzung der Heroku Postgres Datenbank
Datenbankanbindung mit Spring Boot
Datenschutz mit Spring Web Security
grafische Oberfläche mit Thymeleaf, CSS und Vue.js
automatisierte Frontend- und Backend-Tests
Programmieroberfläche IntelliJ IDEA Edu
Git und Github


# htwcalenderproject
Im Rahmen des Moduls Webtechnologien an der HTW-Berlin wird ein Online-Kalender realisiert von Marie Jager (Einzelarbeit). Ein Nutzer kann sich für diesen Kalender anmelden und seine Termine speichern. Beim nächsten Zugriff werden alle bereits gespeicherten Termine angezeigt. Eventuelle Features: Der Nutzer kann die Farbe der Kalendereinträge bestimmen. Der Nutzer kann Termine mit anderen Nutzern teilen. Es wird eine Web Application gebaut, eine Datenbank realisiert und eine Nutzer-Interaktion eingerichtet. Das Projekt wird in Java programmiert und mit Tests versehen.

Anforderungen im Überblick: 
- die Anwendung ist nach Heroku deployed und öffentlich ansprechbar 
- Termine und Nutzer-Daten und Einstellungen werden in einer Datenbank gespeichert 
- es gibt einen User-Login, mehrere User werden unterstützt 
- Passwörter werden verschlüsselt gespeichert, Credentials gehen nicht als Klartext nach Github 
- Frontend- und Backend-Tests werden automatisiert von Github ausgeführt (CI/CD) 
- es gibt eine REST-Schnittstelle (GET, POST) 
- Funktionalitäten sind dynamisch im Frontend umgesetzt, VUE.js (keine Kommunikation mit Server nötig)

Das Projekt ist auf Github öffentlich zugänglich: https://github.com/MarieJager/htwcalenderproject

Zeitrahmen:

April: Github-Repo mit Themenbeschreibung in README.md, "Hello World" Spring Boot App, Link zum Repo per Mail an Dozenten
Mai: REST-Schnittstelle, zu Heroku deployed, Daten werden in Datenbank gespeichert
Mai: statische, server-seitig mit Thymeleaf ersteltte, grafische Oberfläche
Juni: dynamische, mit Vue.js erstellte grafische Oberfläche
Juni: finale Abgabe

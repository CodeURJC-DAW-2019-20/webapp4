# webapp4

# Fase 0

## Web name
URJC.share

## Description
URJC.share is a platform for students of URJC with the purpose of allowing them to share all kind of notes and exams.
They will be able to upload their own notes and download notes from other students and rate them.
Guest users will be able to search notes but the wouldn't be able to downloading them.
Registered users may upload and download all the available files and rate them.
Admin users will manage the different degrees and subjects in order to avoid duplications.

## Dev team
| Name | Email | Github user |
| -- | -- | -- |
| David Tejero Bravo | d.tejero.2017@alumnos.urjc.es | davidtb10 |
| Alejandro Domingo Cornás | a.domingoc.2017@alumnos.urjc.es | AlexDC8 |
| Miguel Rodríguez Álvarez | m.rodriguezalva@alumnos.urjc.es | miguelrod21 |
| Diego Almansa Cantero| d.almansa.2017@alumnos.urjc.es | almansad |
| Álvaro García Velasco| a.garciav.2017@alumnos.urjc.es | Alvarogv96 |

## Entities
The data base will contain 4 different entities:
- Notes
- Users
- Degrees
- Subjects

## User permissions
There will be three types of users with different permissions over the content of the platform.
- Guests users: They will be able to search notes but they wouldn't be able to upload or download them.
- Logged users: They are capable of upload and download all the available files and rate them.
- Admin users: They will manage the fidderent degrees and subjects in order to avoid duplications.

## Entities with images
Two of the four entities previously mentioned will have images.
- Notes
- Users

## Plots
Each note page will contain a graphic that shows the downloads of a note within a period of time.

## Technology
Users will receive a welcome mail with their nickname.

## Algorithm
The users will be able to rate each note in a range of 1 to 5. 
Users will obtain a score obtained from the average of the scores of their notes.


# Fase 1

## Capturas de pantalla

### Home page
![Home page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/inicio.jpeg)
A first look of our web where the guests users can search in order to look if a note from a specific subject is available.
Users can search for a specific degree, which will show all subjects of that degree, or a specific subject.

### Register page
![Sign up page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/sign%20up.jpeg)
Page for the sign up of the new users.

### Login page
![Login page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/login.jpeg)
Page for the sign in of previously registered users.

### Subject list page
![Subject list](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/lista%20asignaturas.jpeg)
This page will show a list with the subjects resulting from the search. Selecting a subject will show all the existing notes of that subject.

### Notes List page
![Notes list](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/lista%20apuntes.jpeg)
In this page, after a search, topic relative notes will be shown in a list. Selecting a note will show the info about that note.

### Note selected page
![Note selected page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/apuntes%20seleccionado.jpeg)
This page will show all the info about the selected note, and loged users will be capable of downloading it.

### Profile page
![Profile page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/perfil.jpeg)
This page will show all the info about a loged user, including the notes he has uploaded, and there will be a button to allow him to modify that info.

### Edit profile page
![Edit profile page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/editar%20perfil.jpeg)
This page will alow the users to modify their profiles.

### Upload notes page
![Upload notes page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/subir%20apuntes.jpeg)
At this page loged users will be able to select a file and fill the form in order to upload the note to the platform.

### Admin page
![Admin page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/admin.jpg)
Admin users will use this page with the purpose of creating new degrees and subjects for the platform, that will be available for the users of the platform.

### Ranking page
![Ranking page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/ranking.png)
This page will show a sorted list of the users with the highest scores of the platform.

## Navigation diagram
![Navigation diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/master/src/images/Diagramanavegacion.jpg)

#Fase 2
##Navigation

##Development instructions
#Code repository
All the code will be able in this repo: 
[DAW/webapp4](https://github.com/CodeURJC-DAW-2019-20/webapp4)

#Development tools
In this application we used technologies as Moustache templates, Springboot and a mySQL database.

To run this app, at first you will need to clone this repository on your computer.
Then you will need to import the project as Maven Project into your favorite IDE that supports maven and springboot  (as Springtool or IntelliJ).
Next you will need to run the database, we did it in mySQL, creating a schema named "urjc_share". The credentials used are user:"root" and pass: "pass"
Once you did all those steps, you can run the project with springboot running configuration.
The port used to run this app is 8443, so to have access you will need to type on your explorer the route "https://localhost:8443".
##Database diagrams

##Class diagrams and templates

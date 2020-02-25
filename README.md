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

# Fase 2
## Navigation

## Development instructions
# Code repository
All the code will be able in this repo: 
[DAW/webapp4](https://github.com/CodeURJC-DAW-2019-20/webapp4)

# Development tools
In this application we used technologies as Moustache templates, Springboot and a mySQL database.

To run this app, at first you will need to clone this repository on your computer.
Then you will need to import the project as Maven Project into your favorite IDE that supports maven and springboot  (as Springtool or IntelliJ).
Next you will need to run the database, we did it in mySQL, creating a schema named "urjc_share". The credentials used are user:"root" and pass: "pass"
Once you did all those steps, you can run the project with springboot running configuration.
The port used to run this app is 8443, so to have access you will need to type on your explorer the route "https://localhost:8443".
## Database diagrams

## Class diagrams and templates

## Five Commits
### Alvaro Garcia
Control de errores                1d87a0993ef9cbb44910190774d67efe1203e300.
pagina de error en la URL         b26192d4a82fa1758d06f5b8dfa93f82eaa922f2.
Subir grado a BBDD hecho          d09481277acf0f5a99b654d3c24d0a50f31872fa.
Creacion de Roles en los usuarios 2c21b3758f64162516ee363737bd9dbb720265a9.
BBDD definitiva                   914e9d7e6780740aee10807b56491481a1ac6dfa.

#### Tasks:
  -He creado la BBDD tanto en un principio en H2 como mas adelante en MySQL.
  -Me he encargado del control de errores.
  -He organizado las tablas de la BBDD.
  -He hecho los Roles de los usuarios.
  -He realizado la subida de registros a las bases de datos.
#### Files:
  -DataBaseController.
  -error y loginerror.
  -SecurityConfiguration.
  -DegreeController.
  -SubjectController.
  
  
 ### Miguel Rodriguez
 Descargar archivo fbd28795c7651da8215c10920023a50013ae2086
 subir apunte funciona 58cefd69ca8b7dbbecf20a882f76b1e2834edc9f
 insert notes 3b8ee668a2cb67745bfa015a5abafdccdb89e999
 springdata repositories 3ee77a96909a862a5f98d28d9ebb14d9dc7191ea
 Lista de apuntes con Controller 03cb79515305a80fd45c171cd03cc66577d11f2d
 
 ### Tasks:
 -I implemented  the NoteController class which allows upload notes to the WebApp
 -I implemented the ImageService class to permit the user select a photo
 -I implemented the UploadFileService class to upload files to the WebApp
 -I implemented the file myprofile.html in which the users can see their data
 -I implemented the Modal files like UploadModalFile with the forms for de user.

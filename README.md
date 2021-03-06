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
![Home page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/inicio.jpeg)
A first look of our web where the guests users can search in order to look if a note from a specific subject is available.
Users can search for a specific degree, which will show all subjects of that degree, or a specific subject.

### Register page
![Sign up page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/sign%20up.jpeg)
Page for the sign up of the new users.

### Login page
![Login page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/login.jpeg)
Page for the sign in of previously registered users.

### Subject list page
![Subject list](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/lista%20asignaturas.jpeg)
This page will show a list with the subjects resulting from the search. Selecting a subject will show all the existing notes of that subject.

### Notes List page
![Notes list](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/lista%20apuntes.jpeg)
In this page, after a search, topic relative notes will be shown in a list. Selecting a note will show the info about that note.

### Note selected page
![Note selected page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/apuntes%20seleccionado.jpeg)
This page will show all the info about the selected note, and loged users will be capable of downloading it.

### Profile page
![Profile page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/perfil.jpeg)
This page will show all the info about a loged user, including the notes he has uploaded, and there will be a button to allow him to modify that info.

### Edit profile page
![Edit profile page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/editar%20perfil.jpeg)
This page will alow the users to modify their profiles.

### Upload notes page
![Upload notes page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/subir%20apuntes.jpeg)
At this page loged users will be able to select a file and fill the form in order to upload the note to the platform.

### Admin page
![Admin page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/admin.jpg)
Admin users will use this page with the purpose of creating new degrees and subjects for the platform, that will be available for the users of the platform.

### Ranking page
![Ranking page](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/ranking.png)
This page will show a sorted list of the users with the highest scores of the platform.

## Navigation diagram
![Navigation diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/Diagramanavegacion.jpg)

# Fase 2

## Navigation diagram
![Navigation diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/DiagramadeNavegacionFase2.jpg)

## Development instructions
### Code repository
All the code will be able in this repo: 
[DAW/webapp4](https://github.com/CodeURJC-DAW-2019-20/webapp4)

### Development tools
In this application we used technologies as Moustache templates, Springboot and a mySQL database.

To run this app, at first you will need to clone this repository on your computer.
Then you will need to import the project as Maven Project into your favorite IDE that supports maven and springboot  (as Springtool or IntelliJ).
Next you will need to run the database, we did it in mySQL, creating a schema named "urjc_share". The credentials used are user:"root" and pass: "pass"
Once you did all those steps, you can run the project with springboot running configuration.
The port used to run this app is 8443, so to have access you will need to type on your explorer the route "https://localhost:8443".

## Database diagrams
![Database diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/model1.png)

## Class diagrams and templates
![Class diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/diagramaClasesDAW.jpg)
![Model diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/diagramModel.png)

We've decided to put the model relations in a separated diagram to make it more clear

## Participation

### Alvaro García

#### Commits
- Control de errores                1d87a0993ef9cbb44910190774d67efe1203e300.
- pagina de error en la URL         b26192d4a82fa1758d06f5b8dfa93f82eaa922f2.
- Subir grado a BBDD hecho          d09481277acf0f5a99b654d3c24d0a50f31872fa.
- Creacion de Roles en los usuarios 2c21b3758f64162516ee363737bd9dbb720265a9.
- BBDD definitiva                   914e9d7e6780740aee10807b56491481a1ac6dfa.

#### Tasks:
- I implemented the H2 DDBB and MySQL DDBB.
- I implemented the error control.
- I have organized the DDBB tables.
- I implemented the user roles.
- I implemented the record upload in DDBB.

#### Files:
- DataBaseController.
- error y loginerror.
- SecurityConfiguration.
- DegreeController.
- SubjectController.
  
  
 ### Miguel Rodriguez
 
 #### Commits
 - Descargar archivo                fbd28795c7651da8215c10920023a50013ae2086
 - subir apunte funciona            58cefd69ca8b7dbbecf20a882f76b1e2834edc9f
 - insert notes                     3b8ee668a2cb67745bfa015a5abafdccdb89e999
 - springdata repositories          3ee77a96909a862a5f98d28d9ebb14d9dc7191ea
 - Lista de apuntes con Controller  03cb79515305a80fd45c171cd03cc66577d11f2d
 
 #### Tasks
 - I implemented  the NoteController class which allows upload notes to the WebApp
 - I implemented the ImageService class to permit the user select a photo
 - I implemented the UploadFileService class to upload files to the WebApp
 - I implemented the file myprofile.html in which the users can see their data
 - I implemented the Modal files like UploadModalFile with the forms for de user.
 
 #### Files
 - NoteController
 - ImageService
 - UploadFileService
 - myprofile.html
 - UploadModalFile
 
 ### David Tejero Bravo
 
 #### Commits
 
 - Ventana de admin                                3ded72dbf26c81a8b478735a0730c5097e98d486
 - Registro con base de datos                      0b7491933b6a15667beeaae0f73f0374714c1388
 - Login implementado                              65f3cf40121d7f051d984d2934e8456dce59d08f
 - Implementada funcionalidad básica de búsqueda   c55ccb48e7dffd86a08a800aa99dbfae8381d560
 - Funciona crear asignatura                       f2890184045b56fcf2305aa2064ae2b312492b09
 
 #### Tasks
 
 - Create admin modal that allows the admin to manage degrees y subjects.
 - Implement sign up with date base.
 - Implement login with data base.
 - Implement searh feature that allows the user to searh notes.
 - Implement creation of subjects in the admin modal.
 
 #### Files
 
 - NavController
 - modalAdmin.html
 - listDegrees.html
 - listsubjects.html
 - login.html
 - register.html 
 ### Diego Almansa Cantero
 
 #### Commits
 
 - Servidor Spring                                2f51b8886f0ea9721a637fe7317fc04518af0fde
 - Componentes html globales nav,modal            daf4d8599ac01410ef6b48723e8439f0421c7b5b
 - HTPPS                                          6dbf42a8f0b6d029e39e9c5e3fb6034a612c8990
 - Configuration nav and userSesion               24b084bac42a0984aaa10ba3e129c483102f2378
 - Page ranking and vote note                     717fd0f64ab874eee57ac10ec040f1f6258c73c2
 #### Tasks
 
 - Server creation with spring.
 - CSS style arrangements.
 - Created html global components for all the pages
 - Differentiation by roles according to user in session.
 - Algorithm of classification according to punctuation of notes.
 
 #### Files
 
 - NavController.java
 - nav.html
 - ranking.html
 - Score.java
 - selectNote.html
 - UserComponent.java
 
 ### Alejandro Domingo Cornás   
  
  #### Commits
  
  - Mail dependencies and service added            f92ccd664f31e0ebc9470cf1c65d07684b874cf1
  - Welcome mail                                   bf91322f737cf34e13414411873907e23e3ebc62
  - Update readme                                  fd21d7345320b938caf1ff5c6384ca8a81d2b50b
  - Login bugfix                                   7b3f0bea502bc13441675d080709da1f242e59ec
  - Readme diagrams and doc.                       9f6b5d28e7e438089d2ded763c5897ea077fdb52
  #### Tasks
  
  - Mail sending    
  - Readme
  - E/R and class diagrams
  - Documentation
  - Bugfixing
  
  #### Files
  
  - sendMailService.java
  - application.properties 
  - UserController.java
  - README.md
  - User.java 

# Fase 3

## API REST Documentation

The API REST documentation is at [API REST DOCUMENTATION](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/API.md)

## Updated class diagrams
![Class diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/diagramFase3.png)

## Instructions for executing the dockerized application

- Create the app image if it is not already uploaded to Docker Hub
```
sudo sh create_image.sh
```

- Create the network
```
docker network create urjcShare-network
```

- Create de database container
```
docker container run --name mysqldb --network urjcShare-network -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=urjc_share -d mysql:8
```

- Create the app container
```
docker container run --network urjcShare-network --name urjcShare -p 8443:8443 -d crusasul/urjcshare
```

- Run the app with docker-compose:
```
docker-compose up
```

## Participation

### Álvaro García Velasco


#### Commits
- LoginController                   9934d9151045b216fb66c5a58cb422f75e776e74.
- restsecurity y websecurity        075df8525ef995a26c67e0c77ae65ee3b3a2a935
- Login arreglado                   889db88a944fc26d09edbb386418171c88e1afaa.
- Autentificacion a la hora de crear y borrar grados 58d84f3ed085ca302d89d603b5634a5f9305cd4a.
- .jar                              dd2c60a3d69a51025aff76dd30c9e7b737995145.

#### Tasks:
- I implemented the login controller.
- I implemented the restsecurity and the websecurity.
- I have controlled the authorization of the functionalities of the different users.
- I have helped create the dockerfile.
- I have created the database images for docker.

#### Files:
- LoginController.
- RestSecurityConfiguration.
- UserRepositoryAuthenticationProvider.
- DockerFile.
- docker-compose.yalm.

### Miguel Rodriguez Alvarez
#### Commits
- Crear usuario e imagen API-REST  463466d0d7b6f8ec858a5ebe17565a4fde94528e
- usuario acabado con API-REST     d7fcc296a9e49f007dde3ca61c9a670b957dfb58
- User Service API                 3ca5d358175e1e7ff45a77310bb2d11fa580b4d5
- docker-compose                   cb294d11e2516f7a1a86cec1849f2bb62e97cd47

#### Tasks:
- I implemented the API User controller
- I refactored the UserController class creating UserServices
- I have created the dockerfile
- I have created the docker-compose
- I helped with Security.

#### Files:
- APIUserController
- UserController
- UserService
- Dockerfile
- docker-compose.yml

### David Tejero Bravo

#### Commits
- Funcionalidad API REST para Degrees f2656a7a7f243a1b616e917cece4261031cdda0a
- Paginación implementada en la búsqueda de degress 51eb15cd753420c253680904645e13e420dab243
- Paginación implementada en la búsqueda de users f097fa27bb441e55ed043d72dccd750c6b317c10
- Paginación y API REST de Subjects abc574c72e97e82cceb0078018d2a164c34c1d50
- Documentación sobre las operaciones de Degree y User df218f8ecd3328750bccf13ed383f82015ef9445

#### Tasks
- Implement API REST for Degrees.
- Implement API REST for Subjects.
- Implement pagination for entities.
- Create services.
- Create API.md.

#### Files
- APIDegreeController
- DegreeService
- APISubjectController
- SubjectService
- API.md

### Alejandro Domingo Cornás
#### Commits
- APISubjectController and SubjectService added (WIP)  c7cade4a71f2f7b13ed3099cce82c4617163be7c
- APISubject referencias circulares en el get          d7fcc296a9e49f007dde3ca61c9a670b957dfb58
- Update API.md                                        d3a4239b583a1713b3bf91e2def98d8bbb66faa3
- Corrijo error en apidegree                           8afa2bc32066faef3b5b38cab7047b664b8b7cca

#### Tasks:
- I have created the APISubjectController
- I have created the SubjectService
- Documentation and diagrams


#### Files:
- APISubjectController
- SubjectService
- Note
- API.md

### Diego Almansa Cantero
#### Commits
 
 - Api notes controller                           c15bc878387b482687c27421d0555952664aef9a
 - Service notes                                  6d9339af6cb84e37b82ade831642a6cf841ef7c0
 - Collection                                     4e18b7fdb42c38916e53f0d3ab4974dfb616bb11
 - Config security rute path                      670533f9908513163224396eb540fa9bfb4a2061
 - Config JsonView notes                          23e237f5f5b9ac70ed5a9c5d1a6b268672b994d0
 #### Tasks
 
 - Create api notes controller
 - Create service notes.
 - Created collection postman.
 - Config auth path rute for role.
 - Config jsonview notes.
 
 #### Files
 
 - APINoteController.java
 - NoteService.java
 - NoteController.java
 - DAW.postman_collection.json
 - RestSecurityConfiguration.java

# Fase 4

## Instructions for executing the dockerized application

The instructions are the same as in the previous **phase 3**.
The unique change is that the script create_image will use a container with **nodejs** for the **Angular frontend**.

## Updated class diagrams

![Class diagram](https://github.com/CodeURJC-DAW-2019-20/webapp4/blob/Fusion/images/diagrama%20fase%204.jpeg)

## Participation

### David Tejero Bravo

#### Commits
- Registro completo con imágenes de usuario 47848c126d4537d0bcc9d26833064d4cf5379975
- Funcionamiento del listado de grados 6db306ae142554afff24e8c02e58c06195bfe3da
- Implementación del modal de administración cc9739e265928888a6f145b65f98c91b8b586229
- Paginación de asignaturas en front con angular 6368a6bf3e25f903a707a449acfcb1e11bf62f8d
- Frontend dockerizado f0e29b1481b839a1bfcfbee98537521a405138b2


#### Tasks
- Implement sign up with Angular.
- Implement degrees list with Angular.
- Implement admin modal with Angular.
- Implement pagination in subjects and notes.
- Change docker to add Angular frontend.

#### Files
- signUp.component.ts
- degree-list.component.ts
- modalAdmin.component.ts
- subjects.component.ts
- create_image.sh

### Álvaro García Velasco

#### Commits
- Correccion de HTML y creacion de páginas de asignaturas 56cd16ae9b4982ce331e41972192a8c179695b99
- Subject Service 3c1f2367a5b76eda1ab48db83c9429d2d0071e65
- Modal de subir apuntes sin funcionalidad 915a68673bae1c5fdc32b608b9b29929d1b900a6
- Funcionalidad de subir apunte hecha f3340f2047058945aa81992907f938761b006502
- Listado de asignaturas hecho. 75f74494d2fdbd42bc9343d7fe9b255b26505c2e                           

#### Tasks:
- I have designed the login and the subject page
- I have done in front the function of upload point
- I have done in front the function of listing the subjects
- I have participated in the creation of the login

#### Files:
- Subjecs.service
- approuting
- subjects.component
- modal-upload-note
- note.service

### Miguel Rdoríguez Álvarez

#### Commits
- grafico 89180690ee5c5823b2bd1e93250dd6951ff89659
- Modificar usuario 
- logout casi casi 360300fc45df810917bb0e245ff72c60a4b0afe8
- modificar usuario funciona 108f66039ee710da6c7770d8f74dec8837afc0eb
- login finito b3707cde988ce8cb66654b42addd0b45d917ae25

#### Tasks:
- I have created the user profile page with angular
- I have done the angular graphic in frontend
- I have participated in the creatin of login
- I have done the logout function
- I have implemented the Edit Profile User function

#### Files:
- EditModalComponent
- user.service
- signin.component
- graph.component
- profile.component

### Alejandro Domingo Cornás

#### Commits
- index component c847a993d5f7b5e95684439cb37ef5ac45dc0225
- ranking component 5ae176abe4005ec0bd242884b3d56a5db29c61df
- index working e0560f7246daa1eefbe0107d231dbb2d5ecbb79d
- ranking working f0786daa219a8e4a25f892b3ef934030bd2e1224

#### Tasks:
- I have made the index page using angular
- I have made the ranking page using angular
- I have created a user service to provide data to the ranking
- I have made the angular components diagram
- I have recorded the video sample

#### Files:
- index.component.ts
- ranking.component.ts
- index.component.html
- ranking.component.html
- user.service.ts
### Diego Almansa Cantero

#### Commits
- List notes components - services notes list - note rate, download and img extension 65b5f3e6f329b523e8c9f9e047d212079385769a
- nav component 2c8db282bb6fb25fbd2c4b8b2925446284351c87
- note component b0370c23684b096da2af1eb0961d06b19a94db92
- use register in config nav 240d3dba4c0e0baf52ecaca0e780ad393e1d3ae8
- service grafic c0d6a8eac0d922d2b5ad29646574e9f1f9c584a7

#### Tasks:
- I have made the nav component and add in app component
- I have made the list of notes and their services
- I have made note component and their services
- I have configurate register in nav component
- Create controller on back for chart

#### Files:
- notes.component.ts
- nav.component.ts
- list-notes.component.html
- notes.service.html
- UserService.java
## Video demo
You can take a look at the features of our applcation working on Angular in this video!: [![Video demo](https://img.youtube.com/vi/tD7f_ZxotBY/0.jpg)](https://www.youtube.com/watch?v=tD7f_ZxotBY)

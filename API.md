# URJC.share - API REST Documentation

## About our API

This API REST will allow you to obtain information about degrees, subjects, notes and users from URJC.share web application. This document will help you to use the four principal kind of requests (GET, POST, PUT, DELETE) as well as understanding status codes and responses.

## How to use our API

1. Download Postman.
2. You can only send GET, POST, PUT and DELETE requests.

## API requests

The API REST will be available at **https://localhost:8443** followed by the containt request URL.
All API queries must be preceded by **/api** .

## Authentication

### Login

### Logout

## DEGREES operations

The following operations will be preceded by **/degrees**.

### GET

#### Show all degrees

* URL:

  `</>`
  
* Success response:

  ```
  [
    {
        "id": 32,
        "name": "Ingeniería del Software",
        "subjects": [
            {
                "id": 34,
                "name": "Calidad"
            }
        ]
    },
    {
        "id": 35,
        "name": "Filosofía",
        "subjects": []
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 204 NO CONTENT

#### Show degrees filtered by name

* URL:

  `</?name=*>`
  
  **Example**: */api/degrees?name=Ingeniería+del+Sofware*
  
  Name words must be concatenated by **+**.
  
* Success response:

  ```
  [
    {
        "id": 36,
        "name": "Ingeniería del Sofware",
        "subjects": [
            {
                "id": 37,
                "name": "Calidad"
            }
        ]
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND

#### Show a specific degree by ID

* URL:

  `</id>`
  
  **Example**: */api/degrees/36*
  
* Success response:

  ```
  [
    {
        "id": 36,
        "name": "Ingeniería del Sofware",
        "subjects": [
            {
                "id": 37,
                "name": "Calidad"
            }
        ]
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND

### POST

#### Create a degree without subjects

* URL:

  `</>`
  
* Body:

  A JSON degree.
  
  Example:
  
  ```
  {
    "name": "Filosofía",
    "subjects": []
  }
  ```
  
  
* Success response:

  ```
  {
    "id": 39,
    "name": "Filosofía",
    "subjects": []
  }
  ```
  Code: 200 OK
  

### PUT

#### Update an existing degree

* URL:

  `</id>`
  
  **Example**: */api/degrees/39*
  
* Body:

  An existing JSON degree with the new values.
  
  Example:
  
  ```
  {
    "name": "Ingeniería de Materiales",
    "subjects": []
  }
  ```
  
  
* Success response:

  ```
  {
    "id": 39,
    "name": "Ingeniería de Materiales",
    "subjects": []
  }
  ```
  Code: 200 OK
 
* Error response:

  Code: 404 NOT FOUND
  
  When the id of the degree doesn't exist.

### DELETE

#### Delete an existing degree

* URL:

  `</id>`
  
  **Example**: */api/degrees/39*  
  
* Success response:

  ```
  {
    "id": 39,
    "name": "Ingeniería de Materiales",
    "subjects": []
  }
  ```
  Code: 200 OK
 
* Error response:

  Code: 404 NOT FOUND
  
  When the id of the degree doesn't exist.

## SUBJECTS operations

### GET

### POST

### PUT

### DELETE

## NOTES operations

### GET

### POST

### PUT

### DELETE

## USERS operations

The following operations will be preceded by **/users**.

### GET

#### Show all degrees

* URL:

  `</>`
  
* Success response:

  ```
  [
    {
        "id": 2,
        "name": "Marcos",
        "passwordHash": "$2a$10$1zTx781KCk7s0ROcKlhgHOwbHP/CFG5MUZmEtkAr1uf8RKEyFlCKC",
        "degree": "Software",
        "nickname": "MArcos01",
        "email": "marcosos@gmail.com",
        "number": 4567,
        "image": false,
        "media": 0.0,
        "notes": [],
        "roles": [
            "ROLE_USER"
        ]
    },
    {
        "id": 3,
        "name": "David",
        "passwordHash": "$2a$10$oGjljIZJbjVRbdtfP.GTiuWisaXu.vX1CjqN.hc26JP4EW6INQNx6",
        "degree": "Ingenieria del Software",
        "nickname": "DavidDaw",
        "email": "d.tejero.207@alumnos.urjc.es",
        "number": 0,
        "image": false,
        "media": 0.0,
        "notes": [],
        "roles": [
            "ROLE_ADMIN"
        ]
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 204 NO CONTENT
  
#### Show a specific user by ID

* URL:

  `</id>`
  
  **Example**: */api/users/3*
  
* Success response:

  ```
  {
    "id": 3,
    "name": "David",
    "passwordHash": "$2a$10$oGjljIZJbjVRbdtfP.GTiuWisaXu.vX1CjqN.hc26JP4EW6INQNx6",
    "degree": "Ingenieria del Software",
    "nickname": "DavidDaw",
    "email": "d.tejero.207@alumnos.urjc.es",
    "number": 0,
    "image": false,
    "media": 0.0,
    "notes": [],
    "roles": [
        "ROLE_ADMIN"
    ]
  }
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND
 
#### Search the image of a user

* URL:

  `</id/image>`
  
  **Example**: */api/users/40/image*
  
* Success response:

  **Imagen**
 
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND

### POST

#### Create a new user without image

* URL:

  `</>`
  
* Body:

  A JSON user.
  
  Example:
  
  ```
  {
    "name": "Juan Lopez",
    "passwordHash": "juanpass",
    "degree": "Matemáticas",
    "nickname": "juanito",
    "email": "juan@juan.com",
    "number": 123456,
    "image": false,
    "roles": [
        "ROLE_USER"
    ]
  }
  ```
  
  
* Success response:

  ```
  {
    "id": 41,
    "name": "Juan Lopez",
    "passwordHash": "$2a$10$QD86jCv2QFzb4FlwzUgsi.UChMGYAwHWTASvhkoW2bFGxWuS3KE56",
    "degree": "Matemáticas",
    "nickname": "juanito",
    "email": "juan@juan.com",
    "number": 123456,
    "image": true,
    "media": 0.0,
    "notes": [],
    "roles": [
        "ROLE_USER"
    ]
  }
  ```
  Code: 200 OK
  
* Error response:

  Code: 500 INTERNAL SERVER ERROR

### PUT

#### Assign the image to a user

* URL:

  `<id/image>`

  **Example**: */api/users/40/image*

* Body:

  Users of the API must follow the following steps:
  
  1. Change the **Content-Type** of Postman to **multipart/form-data**.
  2. Select **form-data** in the body.
  3. Type **imageFile** int the **Key** field, select **File** type and select the image in the **Value** field.

* Success response:

  Code: 200 OK

* Error response:

  Code: 404 NOT FOUND

#### Update an existing user

**You can change the password of the user just by sending it as a string, and the server will encrypt it.**

* URL:

  `</id>`

  **Example**: */api/users/3*

* Body:

  ```
  {
      "name": "Juanjo Martínez",
      "passwordHash": "juanjopass",
      "degree": "Ingeniería de Materiales",
      "nickname": "antonio",
      "email": "antoniogonzalez@gmail",
      "number": 111111111,
      "image": true,
      "media": 0.0,
      "notes": [],
      "roles": [
          "ROLE_USER"
    ]
  }
  ```

* Success response:

  ```
  {
      "id": 40,
      "name": "Juanjo Martínez",
      "passwordHash": "$2a$10$7J6CeK.zAtIOcEEh4nc/e.QjEHObZJ4wq0FE0rrKcqIF681lQDELW",
      "degree": "Ingeniería de Materiales",
      "nickname": "antonio",
      "email": "antoniogonzalez@gmail",
      "number": 111111111,
      "image": true,
      "media": 0.0,
      "notes": [],
      "roles": [
          "ROLE_USER"
      ]
  }
  ```
  Code: 200 OK

* Error response:

  Code: 404 NOT FOUND

### DELETE

#### Delete an existing user

* URL:
  '</id>' 

  **Example**: */api/users/40*

* Success response:

  ```
  {
      "id": 40,
      "name": "Juanjo Martínez",
      "passwordHash": "$2a$10$7J6CeK.zAtIOcEEh4nc/e.QjEHObZJ4wq0FE0rrKcqIF681lQDELW",
      "degree": "Ingeniería de Materiales",
      "nickname": "antonio",
      "email": "antoniogonzalez@gmail",
      "number": 111111111,
      "image": true,
      "media": 0.0,
      "notes": [],
      "roles": [
          "ROLE_USER"
      ]
  }
  ```

  Code: 200 OK

* Error response:

  Code: 404 NOT FOUND


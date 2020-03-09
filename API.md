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
        "id": 8,
        "name": "Ingeniería del Software",
        "subjects": [
            {
                "id": 10,
                "name": "Calidad"
            },
            {
                "id": 11,
                "name": "Seguridad informática"
            }
        ]
    },
    {
        "id": 9,
        "name": "Magisterio",
        "subjects": []
    },
    {
        "id": 17,
        "name": "Física",
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
        "id": 8,
        "name": "Ingeniería del Software",
        "subjects": [
            {
                "id": 10,
                "name": "Calidad"
            },
            {
                "id": 11,
                "name": "Seguridad informática"
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
    "id": 8,
    "name": "Ingenieríaa del Software",
    "subjects": [
        {
            "id": 10,
            "name": "Calidad"
        },
        {
            "id": 11,
            "name": "Seguridad informática"
        }
    ]
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
	"name": "Medicina",
	"subjects": []
  }
  ```
  
  
* Success response:

  ```
  {
    "id": 19,
    "name": "Medicina",
    "subjects": []
  }
  ```
  Code: 201 Created
  

### PUT

#### Update an existing degree

* URL:

  `</id>`
  
  **Example**: */api/degrees/39*
  
* Body:

  An existing JSON degree with the new values.
  
  Example:
  Existing degree:
  ```
  {
	"id": 17,
	"name": "Física",
	"subjects": []
  }
  ```
  We want to modify the name as shown below 
  ```
  {
    "name": "Quimica",
    "subjects": []
  }
  ```
  
  
* Success response:

  ```
  {
    "id": 17,
    "name": "Quimica",
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
The following operations will be preceded by **/subjects**, in other case will be  specified.
#### Show all subjects

* URL:

  `</>`
  
* Success response:

  ```
  [
    {
        "id": 10,
        "name": "Calidad",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": [
            {
                "id": 12,
                "name": "Tema 1",
                "scores": [
                    {}
                ]
            }
        ]
    },
    {
        "id": 11,
        "name": "Seguridad informática",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": []
    },
    {
        "id": 21,
        "name": "Anatomia",
        "degree": {
            "name": "Medicina"
        },
        "notes": []
    },
    {
        "id": 22,
        "name": "Quimica organica",
        "degree": {
            "name": "Quimica"
        },
        "notes": []
    }
]
  ```
  Code: 200 OK
  
* Error response:

  Code: 204 NO CONTENT

#### Show subjects filtered by name

* URL:

  `</?name=*>`
  
  **Example**: */api/subjects?name=Calidad*
  
  Name words must be concatenated by **+**.
  
* Success response:

  ```
  [
    {
        "id": 10,
        "name": "Calidad",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": [
            {
                "id": 12,
                "name": "Tema 1",
                "scores": [
                    {}
                ]
            }
        ]
    }
]
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND

#### Show a specific subject by ID

* URL:

  `</id>`
  
  **Example**: */api/subjects/11*
  
* Success response:

  ```
{
    "id": 11,
    "name": "Seguridad informática",
    "degree": {
        "name": "Ingeniería del Software"
    },
    "notes": []
}
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND

####Show all the subjects from a specific degree
* URL:
	This URL will be different than the others in the subject controller, not starting with `/subjects`
	`<degrees/{degreeId}/subjects`
	**Example**: */api/degrees/8/subjects
	
* Success response:
```
[
    {
        "id": 10,
        "name": "Calidad",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": [
            {
                "id": 12,
                "name": "Tema 1",
                "scores": [
                    {}
                ]
            }
        ]
    },
    {
        "id": 11,
        "name": "Seguridad informática",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": []
    }
]
```
	Code: 200 OK
* Error response
	If the specified degree has no subjects on it:
	Code: 204 No content 
	
	If the degree id does not exist:
	Code:404 Not found

### POST

#### Create a subject without notes

* URL:

  `</>`
  
* Body:

  A JSON subject.
  
  Example:
  
  ```
  {
    "name": "Procesos",
    "degree": {
        "name": "Ingeniería del Software"
    }
}
  ```
  
  
* Success response:

  ```
  {
    "id": 23,
    "name": "Procesos",
    "degree": {
        "name": "IngenierÃ­a del Software"
    },
    "notes": []
}
  ```
  Code: 200 OK
  
  If the specified degree  does not exist
  Code: 500 Internal Server Error
  
  

### PUT

#### Update an existing degree

* URL:

  `</id>`
  
  **Example**: */api/degrees/23*
  
* Body:

  An existing JSON subject with the new values.
  Before
  
  Existing subject:
    ```
	{
        "id": 23,
        "name": "Procesos",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": []
    }
  ```
  We want to modify it as shown below:
  
  ```
    {
        "name": "Procesos software",
        "degree": {
            "name": "Ingeniería del Software"
        },
        "notes": []
    }
  ```
  
  
* Success response:
```
	{
		"id": 23,
		"name": "Procesos software",
		"degree": {
			"name": "Ingeniería del Software"
		},
		"notes": []
	}
```
  Code: 200 OK
 
* Error response:

  Code: 404 NOT FOUND
  
  When the id of the degree doesn't exist.
  
  Code: 500 Internal server error
  When the body follow an incorrect pattern

### DELETE

#### Delete an existing degree

* URL:

  `</id>`
  
  **Example**: */api/degrees/24*  
  
* Success response:

  ```
 {
    "id": 24,
    "name": "Algoritmos",
    "degree": {
        "name": "Ingeniería del Software"
    },
    "notes": []
}
  ```
  Code: 200 OK
 
* Error response:

  Code: 404 NOT FOUND
  
  When the id of the degree doesn't exist.


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
        "degree": "Software",
        "nickname": "MArcos01",
        "email": "marcosos@gmail.com",
        "number": 4567,
        "image": false,
        "notes": []
    },
    {
        "id": 3,
        "name": "David",
        "degree": "Ingenieria del Software",
        "nickname": "DavidDaw",
        "email": "d.tejero.207@alumnos.urjc.es",
        "number": 0,
        "image": false,
        "notes": []
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
    "degree": "Ingenieria del Software",
    "nickname": "DavidDaw",
    "email": "d.tejero.207@alumnos.urjc.es",
    "number": 0,
    "image": false,
    "notes": []
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
    "id": 26,
    "name": "Juan Lopez",
    "degree": "Matemáticas",
    "nickname": "juanitoLopez",
    "email": "juan@juan.com",
    "number": 123456,
    "image": true,
    "notes": []
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

  **Example**: */api/users/40*

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
      "degree": "Ingeniería de Materiales",
      "nickname": "antonio",
      "email": "antoniogonzalez@gmail",
      "number": 111111111,
      "image": true,
      "notes": [],
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

  **Example**: */api/users/29*

* Success response:

  ```
  {
    "id": 29,
    "name": "Francisco",
    "degree": "Ingeniería del Software",
    "nickname": null,
    "email": "paco@paco.com",
    "number": 123456,
    "image": true,
    "notes": []
   
  }
  ```

  Code: 200 OK

* Error response:

  Code: 404 NOT FOUND



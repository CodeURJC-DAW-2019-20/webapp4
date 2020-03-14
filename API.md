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

You must follow this steps:
1. Select Authorization tab in Postman.
2. Choose Bacis Auth in TYPE.
3. Enter the user and the password in the fields.
4. Use the API REST.

## Pagination

Some GET queries implements pagination. By default they will return the first page with a size of 20 elements. If you want to change these values you can do it by including in the URL the following query: 
**?page=`*&size=`***

## DEGREES operations

The following operations will be preceded by **/degrees**.

### GET

#### Show all degrees
This operation is **pageable**.

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
This operation is **pageable**.

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
  Code: 200 OK
  
  * Error response:

  Code: 409 Conflict
  
  If already exists a degree with the specified name
  

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
This operation is **pageable**.

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
This operation is **pageable**.

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

#### Show all the subjects from a specific degree
This operation is **pageable**.

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
* Error response:
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
    	"id": 36,
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
        "name": "Ingeniería del Software"
    },
    "notes": []
  }
  ```
  Code: 200 OK
  
* Error response: 
  Code: 500 Internal Server Error.
  If the specified degree  does not exist.
  
  Code: 409 Conflict.
  If already exists a degree with the specified name.
    
### PUT

#### Update an existing subject

* URL:

  `</id>`
  
  **Example**: */api/subject/23*
  
* Body:

  An existing JSON subject with the new values.
  Before
  
  Existing subject:
    ```
	{
        "id": 23,
        "name": "Procesos",
        "degree": {
	    "id": 36,
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
	    "id": 36,
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
			"id": 36,
			"name": "Ingeniería del Software"
		},
		"notes": []
	}
```
  Code: 200 OK
 
* Error response:

  Code: 404 NOT FOUND
  
  When the id of the subject doesn't exist.
  
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

The following operations will be preceded by **/notes**, in other case will be  specified.

### GET

#### Show all notes
This operation is **pageable**.

* URL:

  `</>`
  
* Success response:

  ```
  [
    {
        "id": 52,
        "name": "Tema 1",
        "professor": "Garzás",
        "subject": {
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "scores": [],
        "user": null,
        "extension": "txt"
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 204 NO CONTENT


#### Show notes filtered by name
This operation is **pageable**.

* URL:

  `</?name=*>`
  
  **Example**: */api/notes?name=Tema+1*
  
  Name words must be concatenated by **+**.
  
* Success response:

  ```
  [
    {
        "id": 52,
        "name": "Tema 1",
        "professor": "Garzás",
        "subject": {
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "scores": [],
        "user": null,
        "extension": "txt"
    }
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND
  
#### Show a specific note by ID

* URL:

  `</id>`
  
  **Example**: */api/notes/52*
  
* Success response:

  ```
  {
    "id": 52,
    "name": "Tema 1",
    "professor": "Garzás",
    "subject": {
        "name": "Calidad",
        "degree": {
            "id": 36,
            "name": "Ingeniería del Sofware"
        }
    },
    "scores": [],
    "user": null,
    "extension": "txt"
  }
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND
  
#### Show all the notes from a subject
This operation is **pageable**.

* URL:

  This URL will be different than the others in the note controller, not starting with `/notes`
  
	`<subjects/{subjectId}/notes`
	**Example**: */api/subjects/37/notes
  
* Success response:

  ```
  [
    {
        "id": 52,
        "name": "Tema 1",
        "professor": "Garzás",
        "subject": {
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "scores": [],
        "user": null,
        "extension": "txt"
    }		
  ]
  ```
  Code: 200 OK
  
* Error response:

  Code: 404 NOT FOUND if the subject doesn't exist or 204 NO CONTENT if there are not notes.

### POST

#### Create a note without the note file

* URL:

  `</>`
  
* Body:

  A JSON note.
  
  Example:
  
  ```
  {
        "name": "Tema 1",
        "professor": "Garzás",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
  ```
  
  
* Success response:

  ```
  {
        "name": "Tema 1",
        "professor": "Garzás",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
  ```
  Code: 200 OK
  
* Error response:

  If the specified subject  does not exist
  Code: 404 NOT FOUND

### PUT

#### Update an existing note

* URL:

  `</id>`
  
  **Example**: */api/notes/52*
  
* Body:

  An existing JSON note with the new values.
  Before
  
  Existing note:
    ```
    {
	"name": "Tema 1",
        "professor": "Garzás",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
  ```
  We want to modify it as shown below:
  
  ```
     {
	"name": "Tema 2",
        "professor": "Antonio",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
  ```
  
  
* Success response:
```
	{
	"name": "Tema 2",
        "professor": "Antonio",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
```
  Code: 200 OK
 
* Error response:

  Code: 
  	* **403 FORBIDDEN** if the user is not the owner of the note.
	* **404 NOT FOUND** if the subject or the note does not exist.

#### Update a note with a image

* URL:

  `</noteId/file>`
  
  **Example**: */api/notes/52/file*
  
* Body:

   Users of the API must follow the following steps:
  
  1. Change the **Content-Type** of Postman to **multipart/form-data**.
  2. Select **form-data** in the body.
  3. Type **file** int the **Key** field, select **File** type and select the image in the **Value** field
  
* Success response:
```
	{
	"name": "Tema 2",
        "professor": "Antonio",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
```
  Code: 200 OK
 
* Error response:

  Code: 
  	* **304 NOT MODIFIED** if the file of note has not been modified
  	* **401 UNAUTHORIZED** if the user is not the owner of the note.
	* **404 NOT FOUND** if the note does not exist.

### DELETE

#### Delete an existing note

* URL:

`</noteId>`

**Example**: */api/notes/50

* Success response:
```
	{
	"name": "Tema 2",
        "professor": "Antonio",
        "subject": {
        	"id": 37,
            "name": "Calidad",
            "degree": {
                "id": 36,
                "name": "Ingeniería del Sofware"
            }
        },
        "extension": "txt"
    }
```
  Code: 200 OK

* Error response:

Code: 
* **403 FORBIDDEN** if the user is not the owner of the note.
* **404 NOT FOUND** if the note does not exist.

## USERS operations

The following operations will be preceded by **/users**.

### GET

#### Show all degrees
This operation is **pageable**.

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
  
#### Show ranking of users

*URL:

`</ranking>`

* Success response:

```
[
    {
        "id": 1,
        "name": "paco",
        "degree": "Matematicas",
        "nickname": "pacomer",
        "email": "pacopacon@gmail.com",
        "number": 56789,
        "image": true,
        "notes": [
            {
                "id": 51,
                "name": "prueba",
                "subject": {},
                "scores": []
            }
        ]
    },
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
    },
    {
        "id": 4,
        "name": "Miguel",
        "degree": "Ingenieria del Software",
        "nickname": "MiguelDaw",
        "email": "m.rodrigez@alumnos.urjc.es",
        "number": 0,
        "image": false,
        "notes": []
    },
    {
        "id": 5,
        "name": "Alex",
        "degree": "Ingenieria del Software",
        "nickname": "AlexDaw",
        "email": "a.domingoc.2017@alumnos.urjc.es",
        "number": 0,
        "image": false,
        "notes": []
    },
    {
        "id": 6,
        "name": "Diego",
        "degree": "Ingenieria del Software",
        "nickname": "DiegoDaw",
        "email": "d.almansa.2017@alumnos.urjc.es",
        "number": 0,
        "image": false,
        "notes": []
    }
]
```
Code: 200 OK

* Error response:

Code: 204 NO CONTENT

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



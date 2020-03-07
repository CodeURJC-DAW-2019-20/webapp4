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

  </>
  
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
  Code: 


### POST

### PUT

### DELETE

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

### GET

### POST

### PUT

### DELETE

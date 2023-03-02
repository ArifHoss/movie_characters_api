# Movie Characters API(Hibernate, Postgres, Spring)

API which can create, read, update and delete from a Postgres database using Hibernate.

## Participants ##

Arif Hossain, Zakhida Ruslanova

## Technologies ##

  - IntelliJ IDEA 
  - Java
  - Spring Web, Spring DataJPA, Spring DataJPA, PostgreSQL
  - Maven
  - Hibernate
  - Rest API
  - Postman
  - Docker

## API requirement ##

_When **adding new resources**, related data is not added  at the same time, this is deferred to an
update._

_When **retrieving or inserting data**, related data is not shown._

_When **deleting data**, related data is not deleted – the foreign keys set to null._


## Link to Swagger

http://localhost:8080/api/swagger-ui/index.html

## Endpoints for characters

| Endpoints                                     | TypeMethod |        Description |
|-----------------------------------------------|:----------:|-------------------:|
| "http://localhost:8080/api/actor"             |    GET     |     get all actors |
| "http://localhost:8080/api/actor/{id}"        |    GET     | get an actor by id |
| "http://localhost:8080/api/actor/create"      |    POST    |       create actor |
| "http://localhost:8080/api/actor/update/{id}" |   PATCH    |       update actor |
| "http://localhost:8080/api/actor/delete/{id}" |   DELETE   |       delete actor |

## Endpoints for movies

| Endpoints                                             | TypeMethod |               Description |
|-------------------------------------------------------|:----------:|--------------------------:|
| "http://localhost:8080/api/movie"                     |    GET     |            get all movies |
| "http://localhost:8080/api/movie/{Id}"                |    GET     |         get a movie by id |
| "http://localhost:8080/api/movie/actors/movieId/{id}" |    GET     | get characters in a movie |
| "http://localhost:8080/api/movie/create"              |    POST    |              create movie |
| "http://localhost:8080/api/movie/update/{id}"         |   PATCH    |              update movie |
| "http://localhost:8080/api/movie/update/actors/{id}"  |   PATCH    |  update actors in a movie |
| "http://localhost:8080/api/movie/delete/{id}"         |   DELETE   |              delete movie |

## Endpoints for franchises

| Endpoints                                                     | TypeMethod |                           Description |
|---------------------------------------------------------------|:----------:|--------------------------------------:|
| "http://localhost:8080/api/franchise"                         |    GET     |                    get all franchises |
| "http://localhost:8080/api/franchise/{Id}"                    |    GET     |                 get a franchise by id |
| "http://localhost:8080/api/franchise/movies/franchiseid/{id}" |    GET     |     Get all the movies in a franchise |
| "http://localhost:8080/api/franchise/actors/franchiseid/{id}" |    GET     | Get all the characters in a franchise |
| "http://localhost:8080/api/franchise/create"                  |    POST    |                      create franchise |
| "http://localhost:8080/api/franchise/update/{id}"             |   PATCH    |                      update franchise |
| "http://localhost:8080/api/franchise/update/movies/{id}"      |   PATCH    |          update movies in a franchise |
| "http://localhost:8080/api/franchise/delete/{id}"             |   DELETE   |                      delete franchise |



## Project tree ##
```bash
├───.idea                                                                   
│   ├───dataSources                                                         
│   │   └───fef78ae1-a728-4c39-b149-d37918a65b63                            
│   │       └───storage_v2                                                  
│   │           └───_src_                                                   
│   │               └───database                                            
│   │                   └───movie_characters_api.tPcE6w                     
│   │                       └───schema                                      
│   └───shelf                                                               
│       ├───Uncommitted_changes_before_Update_at_2_28_2023_1_00_PM_[Changes]
│       └───Uncommitted_changes_before_Update_at_3_2_2023_8_15_AM_[Changes] 
├───.mvn
│   └───wrapper
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───experis
│   │   │           └───movie_characters_api
│   │   │               ├───controller
│   │   │               ├───enums
│   │   │               ├───exception
│   │   │               ├───model
│   │   │               │   ├───dto
│   │   │               │   └───entity
│   │   │               ├───repositories
│   │   │               └───services
│   │   │                   ├───implementation
│   │   │                   └───service_view
│   │   └───resources
│   └───test
│       └───java
│           └───com
│               └───experis
│                   └───movie_characters_api
└───target
    ├───classes
    │   └───com
    │       └───experis
    │           └───movie_characters_api
    │               ├───controller
    │               ├───enums
    │               ├───exception
    │               ├───model
    │               │   ├───dto
    │               │   └───entity
    │               ├───repositories
    │               └───services
    │                   ├───implementation
    │                   └───service_view
    └───generated-sources
        └───annotations

```


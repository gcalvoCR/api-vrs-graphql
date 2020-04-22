Esta es una aplicación simple de Spring Boot donde se explora:

- La creación de un API, usando un RestController para un CRUD completo.
- La misma implementacion utilizando GraphQL
- Manejo de Excepciones de Spring Boot
- Consumo de servicios (en este caso se consume un servicio para generar GUIDS)
- Utilizacion de MongoDB (en este caso es local por lo que tendría que estar instalado y corriendo en su computadora)

## Requisitos

- Tener Mongo instalado y corriendo. [Cliquee aquí para descargar](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)
- STS. [Cliquee aquí para descargar](https://spring.io/tools)

## Funcionalidad

- Expone un API Restful en el endpoint  ```localhost:8080/especies``` donde se puede hacer el CRUD de una especie
- Expone un API Restful en el endpoint ```localhost:8081/guid``` el cual genera GUIDs cuando se crean especies nuevas
- Para consumir GraphQL ir a ```http://localhost:8080/graphiql```


## Pasos de ejecución

1. Levante MongoDB:
.. Dirigase a una consola y digite ```cd C:\Program Files\MongoDB\Server\4.2\bin``` 
.. Una vez en la carpeta digite ``` mongod``` 
.. El servicio de Mongo debería de estar corriendo.


2. Levante los dos servicios de SpringBoot:
.. *especies* correra en ```localhost:8080/especies```
.. *guid* correra en ```localhost:8081/guid```


## Ejemplos de Request para la API Rest

1. POST  ```localhost:8080/especies```

```json
    {
        "nombre": "Pequevirus",
        "autor": "Gabriel Calvo",
        "tipo": "Virus"
    }
```

2. GET (by id) ```localhost:8080/especies/{id}```

3. GET (by guid) ```localhost:8080/especies/guid/{guid}```

4. GET (all) ```localhost:8080/especies/```

5. PUT  ```localhost:8080/especies/{id}```

```json
    {
        "id": "5e9f9198128e5443f2f69464",
        "nombre": "Coronavirus 4",
        "autor": "Gabriel Calvo Vargas",
        "fecha": "01/03/2020",
        "tipo": "Virus",
        "guid": ""
    }
```

6. DELETE  ```localhost:8080/especies/{id}```

## Ejemplos de Request para GraphQL

1. GET ALL
```graphql
    query{
    getEspecies {
        id
        nombre
        guid
    }
    }
```

2. GET BY ID
```graphql
query{
  getEspecieId(id:"5e9f9198128e5443f2f69464") {
    id
    nombre
    guid
  }
}
```

3. GET BY GUID
```graphql
query{
  getEspecieGuid(guid:"07f3ece9-254c-4de9-b3ec-e9254c5de944") {
    id
    nombre
    guid
  }
}
```

4. CREATE ESPECIE
```graphql
mutation {
  createEspecie(nombre: "minivirus", autor: "Gabriel Calvo", tipo: "virus") {
    id
    nombre
    guid
  }
}
```

5. DELETE ESPECIE
```graphql
mutation {
  deleteEspecie(id: "5e9fb3ad5ec2c749b54e56ac")
}
```


6. UPDATE ESPECIE
```graphql
mutation {
  updateEspecie(id: "5e9fa92bf087b97939765ba5", nombre: "Bichirin", autor: "Juan Pablo II", fecha: "01/01/2020", tipo: "MiniVirus") {
    id
    nombre
    guid
  }
}
```

___

### Realizado por: Gabriel Calvo Vargas

¿Quiere conversar? Contacteme [aquí](https://www.linkedin.com/in/gabriel-calvo-vargas-932b3357/). 

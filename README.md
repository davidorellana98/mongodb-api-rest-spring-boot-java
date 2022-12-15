<h1 align="center">Conexión con MongoDB</h1>

## Conexión Local ‍💻

Utilizar la siguiente propiedad, permitira hacer pruebas en local a las interacciones CRUD.

```xml
spring.data.mongodb.uri=mongodb://localhost:27017/${NOMBRE_BD_LOCAL}
```

## Conexión Cluster 🚀

Esta propiedad permitira, guardar la información en un Cluster. La URI la obtendrás una vez creado el Cluster y a ver utilizado el Driver de Java con la versión más reciente.

```xml
spring.data.mongodb.uri=${MONGODB_URI_CLUSTER}
```

Adicionalmente, colocar la siguiente propiedad para crear la base de datos inicialmente vacía, para permitir la inserción de las colecciones (puedes ignorar esta propiedad, si creas la colección en el cluster de MongoDB).

```xml
spring.data.mongodb.database=${NOMBRE_BD}
```

## Propiedades Opcionales

Esta propiedad, permite visualizar las interacciones que se han hecho con los metodos CRUD en la consola de tu IDE.

```xml
logging.level.org.springframework.data.mongodb.core.MongoTemplate=DEBUG
```
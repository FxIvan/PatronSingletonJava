# Patrón Singleton en Java

El **Patrón Singleton** es un patrón de diseño creacional que garantiza que una clase tenga una única instancia y proporciona un punto de acceso global a dicha instancia.

## ¿Cuándo utilizar Singleton?
El patrón Singleton es útil en los siguientes casos:
- Cuando se necesita una única instancia de una clase en toda la aplicación.
- Para gestionar conexiones a bases de datos.
- Para manejar registros de logs.
- Para gestionar configuraciones globales.
- Para manejar instancias compartidas en memoria.

## Implementación en Java
A continuación, se muestra un ejemplo de implementación del patrón Singleton en Java con una clase de conexión a base de datos (`ConexionDB`).

### **Clase Singleton: ConexionDB.java**
```java
public class ConexionDB {
    private static ConexionDB instancia;

    // Constructor privado para evitar la instanciación directa
    private ConexionDB() {}

    // Método estático para obtener la única instancia
    public static ConexionDB obtenerConexion() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }
}
```

### **Uso del Singleton en la clase principal: App.java**
```java
public class App {
    public static void main(String[] args) {
        ConexionDB conexion1 = ConexionDB.obtenerConexion();
        ConexionDB conexion2 = ConexionDB.obtenerConexion();
        
        // Comprobamos que ambas referencias apuntan a la misma instancia
        System.out.println(conexion1.hashCode());
        System.out.println(conexion2.hashCode());
        // Ambos imprimirán el mismo hashcode, lo que confirma que es una única instancia
    }
}
```

## Ventajas del Patrón Singleton
- **Control de acceso a recursos compartidos**: Evita la creación innecesaria de múltiples instancias de una clase.
- **Optimización de memoria**: Se usa una única instancia en lugar de múltiples objetos.
- **Facilita el acceso global**: Se puede acceder desde cualquier parte del código.

## Consideraciones al usar Singleton
- No es adecuado cuando la aplicación requiere múltiples instancias independientes de una clase.
- Puede generar problemas en aplicaciones multihilo si no se implementa correctamente (se puede usar `synchronized` o el patrón Singleton con doble verificación para hilos seguros).
- Puede dificultar la prueba unitaria debido a su acceso global.

---

Con este enfoque, el patrón Singleton asegura que `ConexionDB` solo tenga una única instancia en toda la ejecución del programa, lo cual es útil para gestionar una conexión única a una base de datos, evitando múltiples conexiones innecesarias.


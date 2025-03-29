public class App {
    // Singleton nos asegura que una clase solo seria instanciada una vez
    // Nos proporciona un punto de acceso global a la instancia
    // Vamos a implementar Singleton siempre que necesitemos solo una instancia en nuestra aplicacion
    // Por ejemplo, una clase de configuracion, una clase de log, 1 sola conexion a la base de datos, etc.
    public static void main(String[] args) throws Exception {
        // si es static no usamos new
        ConexionDB conexion = ConexionDB.obtenerConexion();
        System.out.println(conexion.hashCode()); // Imprimimos el hashcode de la conexion. RETORNA: 366712642, y es el mismo para todas las conexiones

        ConexionDB conexion2 = ConexionDB.obtenerConexion();
        System.out.println(conexion2.hashCode()); // Imprimimos el hashcode de la conexion. RETORNA: 366712642, es decir que utiliza siempre la misma instancia de la clase ConexionDB
        // En NodeJS si llamamos a un modulo, siempre nos retorna la misma instancia, por eso es que se dice que es un singleton. En Java no es asi, por eso tenemos que implementarlo nosotros.
        // En este caso, la clase ConexionDB es un singleton, ya que solo se puede instanciar una vez y siempre retorna la misma instancia.


        conexion.host = "localhost"; // Cambiamos el host de la conexion
        System.out.println(conexion.host); // Imprimimos el host de la conexion. RETORNA: localhost
        System.out.println(conexion2.host); // Imprimimos el host de la conexion2. RETORNA: localhost, es decir que ambas conexiones apuntan al mismo objeto y por lo tanto tienen el mismo valor en el atributo host
    }
}

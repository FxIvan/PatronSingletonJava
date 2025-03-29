public class ConexionDB {

    private static ConexionDB conexion;

    public String host;

    // Private porque no queremos que se pueda instanciar desde fuera
    private ConexionDB() {
        // Constructor de la clase
    }

    // Usamos este metodo para obtener la instancia de la clase
    // Retorne un objeto de la misma clase
    public static ConexionDB obtenerConexion() {
        // Metodo para obtener la conexion
        // Aqui se implementaria la logica para conectarse a la base de datos
        // Validamos un atributo privado y statico
        if(conexion == null) { // No se ah instanciado la clase
            // Si la conexion es nula, creamos una nueva instancia
            conexion = new ConexionDB();
        }
        return conexion;
    }
}

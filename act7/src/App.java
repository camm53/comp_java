public class App {

    public static void main(String[] args) {
        String nombre = "Juan Pérez";
        double[] calificaciones = {85, 90, 75, 80, 95};
        Alumno alumno = new Alumno(nombre, calificaciones);
        alumno.imprimirResultados();
    }
}

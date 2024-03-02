


public class App {
    public static class Operaciones {

        private int x;
        private int y;

        public Operaciones(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void Resultados() {
            int suma = suma();
            int resta = resta();
            int multiplicacion = multiplicacion();
            double division = division();
            int modulo = modulo();

            System.out.println("X = " + x);
            System.out.println("Y = " + y);
            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("División: " + division);
            System.out.println("Módulo: " + modulo);
        }

        private int suma() {
            return x + y;
        }

        private int resta() {
            return x - y;
        }

        private int multiplicacion() {
            return x * y;
        }

        private double division() {
            return (double) x / y;
        }

        private int modulo() {
            return x % y;
        }
    }
    public static void main(String[] args) {
        //se crea la instancia de la clase operaciones
        //Operaciones operaciones = new Operaciones(10, 5);

        // se llama al metodo para imprimir los resultadis
        //operaciones.Resultados();
    String numero="01";
    System.err.println(Integer.parseInt(numero));
    
    }
}

public class Algoritmos {

    private int n;

    public Algoritmos(int n) {
        this.n = n;
    }

    public int[] calcularNumerosPrimos() {
        int[] numerosPrimos = new int[n];
        int count = 0;
        int candidato = 2;

        while (count < n) {
            if (esPrimo(candidato)) {
                numerosPrimos[count++] = candidato;
            }
            candidato++;
        }

        return numerosPrimos;
    }

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int[] calcularSucesionFibonacci() {
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public void imprimirResultados() {
        System.out.println("Números primos:");
        for (int numeroPrimo : calcularNumerosPrimos()) {
            System.out.print(numeroPrimo + " ");
        }

        System.out.println("\n\nSucesión de Fibonacci:");
        for (int numeroFibonacci : calcularSucesionFibonacci()) {
            System.out.print(numeroFibonacci + " ");
        }
    }

}

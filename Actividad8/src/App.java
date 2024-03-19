import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();
        int opcion;

        do {
            opcion = showMenu();
            switch (opcion) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static int showMenu() {
        int opcion;
        do {
            System.out.println("\nBienvenido a Poker!");
            System.out.println("Selecciona una opción:");
            System.out.println("1 Mezclar deck");
            System.out.println("2 Sacar una carta");
            System.out.println("3 Carta al azar");
            System.out.println("4 Generar una mano de 5 cartas");
            System.out.println("0 Salir");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no válida. Ingresa un número del 0 al 4.");
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }
}

class Deck {

    private ArrayList<Card> cartas;
    private ArrayList<Card> descartes;

    public Deck() {
        cartas = new ArrayList<>();
        descartes = new ArrayList<>();
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Card(palo, palo.getColor(), valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cartas.isEmpty()) {
            System.out.println("No hay más cartas en el Deck.");
            return;
        }
        Card carta = cartas.remove(0);
        descartes.add(carta);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
    }

    public void pick() {
        if (cartas.isEmpty()) {
            System.out.println("No hay más cartas en el Deck.");
            return;
        }
        int indice = (int) (Math.random() * cartas.size());
        Card carta = cartas.remove(indice);
        descartes.add(carta);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
    }

    public void hand() {
        if (cartas.size() < 5) {
            System.out.println("No hay suficientes cartas en el Deck para una mano.");
            return;
        }
        ArrayList<Card> mano = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card carta = cartas.remove(0);
            descartes.add(carta);
            mano.add(carta);
        }
        System.out.println("Mano generada: " + mano);
        System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
    }
}

enum Palo {
    TREBOLES(Color.NEGRO), CORAZONES(Color.ROJO), PICAS(Color.NEGRO), DIAMANTES(Color.ROJO);

    private final Color color;

    private Palo(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

enum Color {
    NEGRO, ROJO
}

enum Valor {
    AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, J, Q, K
}

class Card {

    private final Palo palo;
    private final Color color;
    private final Valor valor;

    public Card(Palo palo, Color color, Valor valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
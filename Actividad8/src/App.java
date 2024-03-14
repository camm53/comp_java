import java.util.ArrayList;
import java.util.Collections;
public class App {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // Show the first card
        System.out.println("Primera carta:");
        deck.head();

        // Pick a random card
        System.out.println("\nCarta al azar:");
        deck.pick();

        // Get a hand of five cards
        System.out.println("\nMano de cinco cartas:");
        String[] mano = deck.hand();
        for (String carta : mano) {
            System.out.println(carta);
        }
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

    public String[] hand() {
        if (cartas.size() < 5) {
            System.out.println("No hay suficientes cartas en el Deck para una mano.");
            return new String[0];
        }
        String[] mano = new String[5];
        for (int i = 0; i < 5; i++) {
            Card carta = cartas.remove(0);
            descartes.add(carta);
            mano[i] = carta.toString();
        }
        System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
        return mano;
    }
}

enum Palo {
    TREBOLES(Color.NEGRO), CORAZONES(Color.ROJO), PICAS(Color.NEGRO), DIAMANTES(Color.ROJO);

    private Color color;

    private Palo(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

enum Color {
    ROJO, NEGRO
}

enum Valor {
    DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, JOTA, REINA, REY, AS
}

class Card {

    private Palo palo;
    private Color color;
    private Valor valor;

    public Card(Palo palo, Color color, Valor valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
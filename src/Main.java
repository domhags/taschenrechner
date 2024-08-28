import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Eingabe der ersten Zahl
        System.out.println("Geben Sie die erste Zahl ein:");
        String ersteZahlInput = scanner.nextLine();

        // Eingabe des Operators
        System.out.println("Geben Sie den Operator (+, -, *, /) ein:");
        char operator = scanner.nextLine().trim().charAt(0);

        // Eingabe der zweiten Zahl
        System.out.println("Geben Sie die zweite Zahl ein:");
        String zweiteZahlInput = scanner.nextLine();

        // Überprüfung, ob die Eingabe int oder double ist
        if (isInteger(ersteZahlInput) && isInteger(zweiteZahlInput)) {
            int ersteZahl = Integer.parseInt(ersteZahlInput);
            int zweiteZahl = Integer.parseInt(zweiteZahlInput);
            int ergebnis = berechne(ersteZahl, zweiteZahl, operator);
            System.out.println("Ergebnis: " + ergebnis);
        } else if (isDouble(ersteZahlInput) && isDouble(zweiteZahlInput)){
            double ersteZahl = Double.parseDouble(ersteZahlInput);
            double zweiteZahl = Double.parseDouble(zweiteZahlInput);
            double ergebnis = berechne(ersteZahl, zweiteZahl, operator);
            System.out.printf("Ergebnis: %.2f%n", ergebnis);
        } else {
            System.out.println("Ungültige Eingabe. Stellen Sie sicher, dass beide Zahlen entweder ganze Zahlen oder Dezimalzahlen sind.");
        }
    }

    private static boolean isInteger(String eingabe) {
        return eingabe.matches("-?\\d+"); //-? Minuszeichen, muss nicht vorhanden sein, \\d für Ziffern
    }

    private static boolean isDouble(String eingabe) {
        return eingabe.matches("-?\\d*\\.?\\d+"); // \\. für Dezimalpunkt
    }

    // Überladene berechnen Methode für int
    private static int berechne(int ersteZahl, int zweiteZahl, char operator) {
        switch (operator) {
            case '+':
                return ersteZahl + zweiteZahl;
            case '-':
                return ersteZahl - zweiteZahl;
            case '*':
                return ersteZahl * zweiteZahl;
            case '/':
                if (zweiteZahl == 0) {
                    throw new ArithmeticException("Division durch Null ist nicht erlaubt.");
                }
                return ersteZahl / zweiteZahl;
            default:
                System.out.println("Ungültiger Operator.");
                return 0;
        }
    }

    // Überladene berechnen Methode für double
    private static double berechne(double ersteZahl, double zweiteZahl, char operator) {
        switch (operator) {
            case '+':
                return ersteZahl + zweiteZahl;
            case '-':
                return ersteZahl - zweiteZahl;
            case '*':
                return ersteZahl * zweiteZahl;
            case '/':
                if (zweiteZahl == 0.0) {
                    throw new ArithmeticException("Division durch Null ist nicht erlaubt.");
                }
                return ersteZahl / zweiteZahl;
            default:
                System.out.println("Ungültiger Operator.");
                return 0.0;
        }
    }
}

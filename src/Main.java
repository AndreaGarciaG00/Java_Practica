import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        while (true) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpia buffer

            if (option == 2) {
                System.out.println("¡Hasta luego!");
                break;
            }

            try {
                System.out.print("Moneda de origen (ej. USD): ");
                String from = scanner.nextLine().toUpperCase();
                System.out.print("Moneda destino (ej. MXN): ");
                String to = scanner.nextLine().toUpperCase();
                System.out.print("Cantidad a convertir: ");
                double amount = scanner.nextDouble();

                double converted = converter.convert(from, to, amount);
                System.out.printf("Resultado: %.2f %s = %.2f %s\n", amount, from, converted, to);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

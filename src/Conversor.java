import java.util.Scanner;

public class Conversor {
    public static void exibirMenu() {
        System.out.println("""
        ******************************************************
        Sea bienvenido/a al Conversor de Moneda =]

        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileño
        4) Real brasileño =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Salir

        Elija una opción válida:
        ******************************************************
        """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcion = scanner.nextInt();

            String from = "";
            String to = "";

            switch (opcion) {
                case 1 -> {
                    from = "USD";
                    to = "ARS";
                }
                case 2 -> {
                    from = "ARS";
                    to = "USD";
                }
                case 3 -> {
                    from = "USD";
                    to = "BRL";
                }
                case 4 -> {
                    from = "BRL";
                    to = "USD";
                }
                case 5 -> {
                    from = "USD";
                    to = "COP";
                }
                case 6 -> {
                    from = "COP";
                    to = "USD";
                }
                case 7 -> {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    continuar = false;
                    continue;
                }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            try {
                System.out.print("Ingrese el monto a convertir: ");
                double cantidad = scanner.nextDouble();

                double resultado = converter.convert(from, to, cantidad);
                System.out.printf("Resultado: %.2f %s = %.2f %s\n\n", cantidad, from, resultado, to);
            } catch (Exception e) {
                System.out.println("Error durante la conversión: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

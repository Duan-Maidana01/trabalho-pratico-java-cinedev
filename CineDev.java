import java.util.Scanner;

public class CineDev {

    // Matriz que representa a sala de cinema
    static char[][] salaDeCinema = new char[10][20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarSala();

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMapa();
                    break;
                case 2:
                    comprarIngresso(scanner);
                    break;
                case 3:
                    cancelarIngresso(scanner);
                    break;
                case 4:
                    exibirRelatorio();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    // Inicializa todos os assentos como livres "L"
    public static void inicializarSala() {
        for (int i = 0; i < salaDeCinema.length; i++) {
            for (int j = 0; j < salaDeCinema[i].length; j++) {
                salaDeCinema[i][j] = 'L';
            }
        }
    }

    // Exibe o menu principal
    public static void exibirMenu() {
        System.out.println("\n===== Menu Principal =====");
        System.out.println("1. Exibir Mapa de Assentos");
        System.out.println("2. Comprar Ingresso");
        System.out.println("3. Cancelar Compra de Ingresso");
        System.out.println("4. Exibir Relatório de Ocupação");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Exibe o mapa da sala com os assentos
    public static void exibirMapa() {
        System.out.println("\nAssentos: ");
        System.out.print("         ");
        for (int j = 0; j < salaDeCinema[0].length; j++) {
            System.out.printf("%2d ", j + 1);
        }
        System.out.println();

        for (int i = 0; i < salaDeCinema.length; i++) {
            System.out.printf("Fileira %2d: ", i + 1);
            for (int j = 0; j < salaDeCinema[i].length; j++) {
                System.out.print("[" + salaDeCinema[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Lógica para comprar um ingresso
    public static void comprarIngresso(Scanner scanner) {
        System.out.print("\nDigite o número da fileira (1-10): ");
        int fileira = scanner.nextInt();
        System.out.print("Digite o número do assento (1-20): ");
        int assento = scanner.nextInt();

        if (validarPosicao(fileira, assento)) {
            int f = fileira - 1;
            int a = assento - 1;

            if (salaDeCinema[f][a] == 'L') {
                salaDeCinema[f][a] = 'X';
                System.out.println("Ingresso comprado com sucesso! (Fileira " + fileira + ", Assento " + assento + ")");
            } else {
                System.out.println("Esse assento já está ocupado!");
            }
        } else {
            System.out.println("Posição inválida! Digite fileira entre 1-10 e assento entre 1-20.");
        }
    }

    // Lógica para cancelar um ingresso
    public static void cancelarIngresso(Scanner scanner) {
        System.out.print("\nDigite o número da fileira (1-10): ");
        int fileira = scanner.nextInt();
        System.out.print("Digite o número do assento (1-20): ");
        int assento = scanner.nextInt();

        if (validarPosicao(fileira, assento)) {
            int f = fileira - 1;
            int a = assento - 1;

            if (salaDeCinema[f][a] == 'X') {
                salaDeCinema[f][a] = 'L';
                System.out.println("Compra cancelada com sucesso!");
            } else {
                System.out.println(" Esse assento já está livre.");
            }
        } else {
            System.out.println(" Posição inválida! Digite fileira entre 1-10 e assento entre 1-20.");
        }
    }

    
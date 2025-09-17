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
}

// Inicializa todos os assentos como livres "L"
    public static void inicializarSala() {
        for (int i = 0; i < salaDeCinema.length; i++) {
            for (int j = 0; j < salaDeCinema[i].length; j++) {
                salaDeCinema[i][j] = 'L';
            }
        }
    }



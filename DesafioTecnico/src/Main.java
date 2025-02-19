import java.util.Scanner;


 //Classe principal que contém o método main e apresenta um menu de interação com o usuário.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleGastos controle = new ControleGastos();
        int opcao = 0;

        do {
            System.out.println("\n=== Sistema de Controle de Gastos Residenciais ===");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Deletar Pessoa");
            System.out.println("3 - Listar Pessoas");
            System.out.println("4 - Cadastrar Transação");
            System.out.println("5 - Listar Transações");
            System.out.println("6 - Consultar Totais");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade da pessoa: ");
                    int idade;
                    try {
                        idade = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Idade inválida.");
                        break;
                    }
                    controle.cadastrarPessoa(nome, idade);
                    break;
                case 2:
                    System.out.print("Digite o id da pessoa a ser deletada: ");
                    int idDel;
                    try {
                        idDel = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Id inválido.");
                        break;
                    }
                    controle.deletarPessoa(idDel);
                    break;
                case 3:
                    controle.listarPessoas();
                    break;
                case 4:
                    System.out.print("Digite a descrição da transação: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o valor da transação: ");
                    double valor;
                    try {
                        valor = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido.");
                        break;
                    }

                    System.out.print("Digite o tipo da transação (1 - Receita, 2 - Despesa): ");
                    int tipoInput;
                    try {
                        tipoInput = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    Transacao.TipoTransacao tipo;
                    if (tipoInput == 1) {
                        tipo = Transacao.TipoTransacao.RECEITA;
                    } else if (tipoInput == 2) {
                        tipo = Transacao.TipoTransacao.DESPESA;
                    } else {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    // Exibir menu com pessoas cadastradas antes de pedir o ID
                    controle.listarPessoas();
                    System.out.print("\nDigite o ID da pessoa associada à transação: ");
                    int idPessoa;
                    try {
                        idPessoa = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }

                    controle.cadastrarTransacao(descricao, valor, tipo, idPessoa);
                    break;
                case 5:
                    controle.listarTransacoes();
                    break;
                case 6:
                    controle.consultarTotais();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

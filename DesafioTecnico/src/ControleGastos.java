import java.util.*;

/**
 * ControleGastos.java
 *
 * Classe que gerencia os cadastros de pessoas e transações,
 * além de fornecer a funcionalidade de consulta dos totais.
 *
 * Implementa as interfaces ICadastroPessoa e ICadastroTransacao.
 */
public class ControleGastos implements ICadastroPessoa, ICadastroTransacao {
    private List<Pessoa> pessoas;
    private List<Transacao> transacoes;

    public ControleGastos() {
        pessoas = new ArrayList<>();
        transacoes = new ArrayList<>();
    }

    // Métodos da interface ICadastroPessoa
    @Override
    public void cadastrarPessoa(String nome, int idade) {
        Pessoa novaPessoa = new Pessoa(nome, idade);
        pessoas.add(novaPessoa);
        System.out.println("Pessoa cadastrada: " + novaPessoa);
    }

    @Override
    public void deletarPessoa(int idPessoa) {
        Pessoa pessoaRemover = null;
        for (Pessoa p : pessoas) {
            if (p.getId() == idPessoa) {
                pessoaRemover = p;
                break;
            }
        }
        if (pessoaRemover != null) {
            pessoas.remove(pessoaRemover);
            // Remove todas as transações associadas à pessoa removida
            transacoes.removeIf(t -> t.getPessoa().getId() == idPessoa);
            System.out.println("Pessoa removida: " + pessoaRemover);
        } else {
            System.out.println("Pessoa com id " + idPessoa + " não encontrada.");
        }
    }

    @Override
    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("=== Pessoas Cadastradas ===");
            for (Pessoa p : pessoas) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Idade: " + p.getIdade());
            }
        }
    }

    // Métodos da interface ICadastroTransacao
    @Override
    public void cadastrarTransacao(String descricao, double valor, Transacao.TipoTransacao tipo, int idPessoa) {
        // Se não houver pessoas cadastradas, impede o cadastro de transações
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada. Cadastre uma pessoa antes de adicionar uma transação.");
            return;
        }

        // Procura a pessoa pelo ID informado
        Pessoa pessoaEncontrada = null;
        for (Pessoa p : pessoas) {
            if (p.getId() == idPessoa) {
                pessoaEncontrada = p;
                break;
            }
        }

        if (pessoaEncontrada == null) {
            System.out.println("Pessoa com id " + idPessoa + " não encontrada. Transação não cadastrada.");
            return;
        }

        // Se a pessoa for menor de 18 anos, apenas transações do tipo DESPESA são permitidas
        if (pessoaEncontrada.getIdade() < 18 && tipo == Transacao.TipoTransacao.RECEITA) {
            System.out.println("Pessoa menor de idade não pode ter transações do tipo receita. Transação não cadastrada.");
            return;
        }

        // Verifica se o valor é positivo
        if (valor <= 0) {
            System.out.println("O valor da transação deve ser positivo. Transação não cadastrada.");
            return;
        }

        // Cria e adiciona a transação
        Transacao novaTransacao = new Transacao(descricao, valor, tipo, pessoaEncontrada);
        transacoes.add(novaTransacao);
        System.out.println("Transação cadastrada: " + novaTransacao);
    }

    @Override
    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada.");
        } else {
            System.out.println("=== Transações Cadastradas ===");
            for (Transacao t : transacoes) {
                System.out.println(t);
            }
        }
    }

    /**
     * Consulta os totais de receitas, despesas e saldo (receitas - despesas)
     * para cada pessoa e exibe também os totais gerais.
     */
    public void consultarTotais() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        // Map para armazenar os totais por pessoa: ID -> {Receitas, Despesas}
        Map<Integer, double[]> totaisPorPessoa = new HashMap<>();
        for (Pessoa p : pessoas) {
            totaisPorPessoa.put(p.getId(), new double[]{0.0, 0.0});
        }

        // Processa cada transação e acumula os valores
        for (Transacao t : transacoes) {
            int idPessoa = t.getPessoa().getId();
            double[] totais = totaisPorPessoa.get(idPessoa);
            if (t.getTipo() == Transacao.TipoTransacao.RECEITA) {
                totais[0] += t.getValor();
            } else {
                totais[1] += t.getValor();
            }
        }

        double totalReceitasGeral = 0;
        double totalDespesasGeral = 0;

        System.out.println("\n=== Consulta de Totais por Pessoa ===");
        for (Pessoa p : pessoas) {
            double[] totais = totaisPorPessoa.get(p.getId());
            double saldo = totais[0] - totais[1];
            totalReceitasGeral += totais[0];
            totalDespesasGeral += totais[1];

            System.out.println("\nPessoa: " + p.getNome() + " (ID: " + p.getId() + ")");
            System.out.println("  Total Receitas: " + totais[0]);
            System.out.println("  Total Despesas: " + totais[1]);
            System.out.println("  Saldo: " + saldo);
        }

        double saldoGeral = totalReceitasGeral - totalDespesasGeral;
        System.out.println("\n=== Totais Gerais ===");
        System.out.println("  Total Receitas: " + totalReceitasGeral);
        System.out.println("  Total Despesas: " + totalDespesasGeral);
        System.out.println("  Saldo Geral: " + saldoGeral);
    }
}

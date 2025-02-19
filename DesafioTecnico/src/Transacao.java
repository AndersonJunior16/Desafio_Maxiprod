/**
 * Classe que representa uma transação financeira no sistema.
 */
public class Transacao {

    /**
     * Enum para representar os tipos de transação: RECEITA ou DESPESA.
     */
    public enum TipoTransacao {
        RECEITA,
        DESPESA
    }

    private static int contadorId = 1; // Gera IDs únicos automaticamente
    private int id;
    private String descricao;
    private double valor;
    private TipoTransacao tipo;
    private Pessoa pessoa; // Pessoa associada à transação

    /**
     * Construtor para criar uma nova transação.
     * @param descricao Descrição da transação.
     * @param valor Valor (deve ser positivo).
     * @param tipo Tipo da transação (RECEITA ou DESPESA).
     * @param pessoa Pessoa associada.
     */
    public Transacao(String descricao, double valor, TipoTransacao tipo, Pessoa pessoa) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Transacao{id=" + id + ", descricao='" + descricao + "', valor=" + valor +
                ", tipo=" + tipo + ", pessoa=" + pessoa.getNome() + " (id=" + pessoa.getId() + ")}";
    }
}

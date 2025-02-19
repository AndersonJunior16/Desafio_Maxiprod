/**
 * Classe que representa uma pessoa cadastrada no sistema.
 */
public class Pessoa {
    private static int contadorId = 1; // Gera IDs únicos automaticamente
    private int id;
    private String nome;
    private int idade;

    /**
     * Construtor para criar uma nova pessoa.
     * @param nome Nome da pessoa.
     * @param idade Idade da pessoa.
     */
    public Pessoa(String nome, int idade) {
        this.id = contadorId++;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "', idade=" + idade + "}";
    }
}

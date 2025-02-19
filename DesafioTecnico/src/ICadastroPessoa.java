/**
 * Interface que define os métodos para o cadastro, deleção e listagem de pessoas.
 */
public interface ICadastroPessoa {
    void cadastrarPessoa(String nome, int idade);
    void deletarPessoa(int idPessoa);
    void listarPessoas();
}

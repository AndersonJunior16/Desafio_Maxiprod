/**
 * Interface que define os métodos para o cadastro e listagem de transações.
 */
public interface ICadastroTransacao {
    void cadastrarTransacao(String descricao, double valor, Transacao.TipoTransacao tipo, int idPessoa);
    void listarTransacoes();
}


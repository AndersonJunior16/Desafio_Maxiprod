# 📘 Documentação do Sistema de Controle de Gastos Residenciais

## 📌 Introdução
Este sistema foi desenvolvido em **Java** e permite cadastrar pessoas, registrar transações financeiras e consultar os totais de receitas e despesas. A interação ocorre através do **terminal (CLI)**.

## 📌 Funcionalidades
**Cadastro de pessoas** (nome, idade, ID gerado automaticamente).  
**Cadastro de transações** (descrição, valor, tipo - Receita ou Despesa).  
**Consulta de totais** para visualizar receitas, despesas e saldo de cada pessoa.  
**Restrição para menores de 18 anos**: apenas despesas são permitidas.  

## 📌 Estrutura do Código
O projeto contém os seguintes arquivos:

```
📂 SistemaGastosResidenciais
 ┣  Main.java  → Ponto de entrada do sistema (menu interativo).
 ┣  Pessoa.java  → Representa uma pessoa cadastrada.
 ┣  Transacao.java  → Representa uma transação financeira.
 ┣  TipoTransacao.java  → Enum que define os tipos de transação.
 ┣  ICadastroPessoa.java  → Interface para operações com pessoas.
 ┣  ICadastroTransacao.java  → Interface para operações com transações.
 ┗  ControleGastos.java  → Gerencia cadastros e consultas do sistema.
```

## 📌 Como Executar
1 **Instale o Java (versão 8 ou superior).**  
2 **Execute o programa:**  
   ```sh
   java Main
   ```  
3 **Interaja com o menu para cadastrar e consultar dados.**  

## 📌 Melhorias Futuras
🔹 Armazenar dados em arquivo ou banco de dados.  
🔹 Criar uma interface gráfica (JavaFX ou angular).  
🔹 Implementar relatórios em PDF.  

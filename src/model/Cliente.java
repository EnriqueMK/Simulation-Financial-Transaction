package model;

import validation.client.CpfValidar;
import validation.client.EnderecoValidar;
import validation.client.NomeValidar;
import validation.client.TelefoneValidar;
import validation.credit.CartaoCreditoValidar;

public class Cliente {

    // Atributos do Cliente
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private Cartao cartao;

    // Método Construtor do Cliente
    public Cliente(String nome, String cpf, String telefone, String endereco) {
        this.nome = NomeValidar.validar(nome);
        this.cpf = CpfValidar.validar(cpf);
        this.telefone = TelefoneValidar.validar(telefone);
        this.endereco = EnderecoValidar.validar(endereco);
    }

    // Getters do Cliente
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEndereco() {
        return endereco;
    }

    // Setters do Cliente
    public void setNome(String nome) {
        this.nome = NomeValidar.validar(nome);
    }
    public void setTelefone(String telefone) {
        this.telefone = TelefoneValidar.validar(telefone);
    }
    public void setEndereco(String endereco) {
        this.endereco = EnderecoValidar.validar(endereco);
    }

    // Getters ou/e Setters do Cartão
    public void adicionarCartao(Credito cartao) {
        CartaoCreditoValidar.validar(this, cartao);
        this.cartao = cartao;
    }
    public Cartao getCartao() {
        return cartao;
    }

    // Exibe o cadastro do Cliente
    public void informacoesCliente() {
        System.out.println("\nOlá " + getNome() + " Sejá Bem-vindo ao seu Banco!");
        System.out.println("=================================");
        System.out.println("SEU CADASTRO");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
    }
}
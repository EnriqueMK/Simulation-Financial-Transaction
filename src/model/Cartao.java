package model;

// Interface onde são implementados os métodos obrigatórios para classe Cartão
public interface Cartao {
    String getTipo();
    void informacoesCartao();
    boolean autorizarPagamento(double valor);
}
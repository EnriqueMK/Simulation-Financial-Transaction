package model;

import javax.swing.JOptionPane;
import java.time.YearMonth;
import java.util.concurrent.ThreadLocalRandom;

import service.ProcessarTransacao;
import validation.credit.LimiteCreditoValidar;

public class Credito implements Cartao {

    // Atributos do Crédito 
    private Cliente cliente;
    private final String numero;
    private final YearMonth vencimento;
    private final int cvv;
    private double limite;
    private double limiteDisponivel;
    
    // Método construtor do Cartão
    public Credito(Cliente cliente, double limite) {
        this.cliente = cliente;

        this.numero = (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000));
        
        YearMonth venc = YearMonth.now().plusYears(3);

        this.vencimento = venc;
        this.cvv = ThreadLocalRandom.current().nextInt(100, 1000);
        this.limite = LimiteCreditoValidar.validar(limite);
        this.limiteDisponivel = limite;
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }
    public String getNumero() {
        return numero;
    }
    public YearMonth getVencimento() {
        return vencimento;
    }
    public int getCvv() {
        return cvv;
    }
    public double getLimite() {
        return limite;
    }
    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    // Setters 
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    // Tipo do Cartão
    @Override
    public String getTipo() {
        return "Crédito";
    }

    // Método para exibir informações do Cartão do cliente selecionado
    @Override
    public void informacoesCartao() {
        String menu = "\nINFORMAÇÕES DO SEU CARTÃO DE CRÉDITO\n" +
        "Número do Cartão: " + getNumero() + "\n" +
        "CVV: " + getCvv() + "\n" +
        "Vencimento: " + getVencimento() + "\n" +
        "Limite Liberado: R$" + String.format("%.2f\n", getLimite()) +
        "Limite Disponível: R$" + String.format("%.2f\n", getLimiteDisponivel());

        JOptionPane.showMessageDialog(null, menu);
    }

    // Validador para autorizar pagamento do Cliente selecionado
    @Override
    public boolean autorizarPagamento(double valor) {
        return ProcessarTransacao.processamento(this, valor);
    }
}

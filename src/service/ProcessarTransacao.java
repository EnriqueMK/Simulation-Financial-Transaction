package service;

import java.time.YearMonth;
import model.Credito;

public final class ProcessarTransacao {
    
    private ProcessarTransacao() {}

    public static boolean processamento(Credito credito, double valor) {
        YearMonth venc = credito.getVencimento();
        YearMonth dataAtual = YearMonth.now();

        if (valor <= 0) {
            throw new IllegalArgumentException("Transferência do valor R$ " + String.format("%.2f", valor) + " NEGADA!");
        }
        if (venc.isBefore(dataAtual)) {
            throw new IllegalArgumentException("Cartão vencido!");
        }
        if (valor > credito.getLimiteDisponivel()) {
            throw new IllegalArgumentException("Transferência recusada! Limite indisponível.");
        }

        double limiteAtual = credito.getLimiteDisponivel() - valor;
        credito.setLimiteDisponivel(limiteAtual);
        return true;
    }
}

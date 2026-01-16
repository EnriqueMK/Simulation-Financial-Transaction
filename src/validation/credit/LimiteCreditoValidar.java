package validation.credit;

import model.Credito;

// Classe não herdável
public final class LimiteCreditoValidar {
    
    // Construtor não instanciável
    private LimiteCreditoValidar() {}

    // Método que valida a entrada de dado Limite
    public static double validar(Credito credito, double limite) {
        if (limite < 200.0 || limite > 100000.0) {
            throw new IllegalArgumentException("O limite deve conter entre R$ 200 a R$ 100.000.");
        }

        if (limite > credito.getLimite()) {
            credito.setLimiteDisponivel(credito.getLimiteDisponivel() + (limite - credito.getLimite()));
        } 
        
        if (limite == credito.getLimiteDisponivel()) {
            credito.setLimiteDisponivel(limite);
        }

        if (limite < credito.getLimite()) {
            credito.setLimite(limite);
            if (credito.getLimite() < credito.getLimiteDisponivel()) {
                credito.setLimiteDisponivel(limite);
            }
        }

        credito.setLimite(limite);
        return limite;
    }
}

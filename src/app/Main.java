import model.Cliente;
import model.Credito;

public class Main {
    public static void main(String[] args) {
    

        try {
            Cliente cliente = new Cliente("Enrique", "50690239858", "11968746930", "Rua Vulnarária, 58");
            Credito credito = new Credito(cliente, 1000);
            cliente.adicionarCartao(credito);

            credito.informacoesCartao();

            credito.autorizarPagamento(200);
            credito.informacoesCartao();

            credito.atualizarLimite(400);
            credito.informacoesCartao();


            
        } catch (IllegalArgumentException erro) {
            System.err.println("Erro: " + erro.getMessage());
        } catch (Exception erroInesperado) {
            System.err.println("Erro: " + erroInesperado.getMessage());
        } finally {
            System.out.println("Programa finalizado!");
        }
    }
}
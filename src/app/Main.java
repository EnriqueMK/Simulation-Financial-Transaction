import model.Cliente;
import model.Credito;

public class Main {
    public static void main(String[] args) throws Exception {
        // Testar código nesta área
        Cliente cliente = new Cliente("Enrique", "50690239858", "11968746930", "Rua Vulnerária, 58");
        Credito credito = new Credito(cliente, 1000);

        cliente.informacoesCliente();
        credito.informacoesCartao();
    }
}
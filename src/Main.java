public class Main {

	public static void main(String[] args) {
		
		Banco banco1 = new Banco();
		banco1.setNome("Você Pode");
		
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Marianne");
		cliente1.setCpf("01163772089");
		
		Conta conta1 = new ContaCorrente(cliente1);
		conta1.setNumeroConta(753190789);
		conta1.setSaldo(200);
		conta1.criarConta(banco1);
		
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Josué");
		cliente2.setCpf("91875405097");
		
		Conta conta2 = new ContaCorrente(cliente2);
		conta2.setNumeroConta(466402271);
		conta2.setSaldo(0);
		conta2.criarConta(banco1);
		
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Maria");
		cliente3.setCpf("96691881052");
		
		Conta conta3 = new ContaCorrente(cliente3);
		conta3.setNumeroConta(853892120);
		conta3.setSaldo(20.50);
		conta3.criarConta(banco1);
		
		conta3.opcao(banco1);

	}

}

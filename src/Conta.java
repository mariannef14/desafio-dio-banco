import java.util.Scanner;

public abstract class Conta implements IConta {

	private static int AGENCIA_PADRAO = 1407;

	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	

	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = AGENCIA_PADRAO;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	public void criarConta(Banco banco) {
		banco.getContas().add(this);
	}
	
	public void opcao(Banco banco) {
		int numero = 0;
		
		System.out.printf("Ol�, %s!", cliente.getNome());
		
		while(numero != 6) {
			System.out.println("\nO que voc� deseja fazer?\n"
					+ "[1] Consultar saldo \n"
					+ "[2] Sacar \n"
					+ "[3] Depositar \n"
					+ "[4] Transferir \n"
					+ "[5] Imprimir extrato \n"
					+ "[6] Sair");
	
			Scanner teclado = new Scanner(System.in);
			numero = teclado.nextInt();
			
			if(numero == 1) 
				consultarSaldo();
			else if(numero == 2)
				sacar();
			else if(numero == 3)
				depositar();
			else if(numero == 4)
				transferir(banco);
			else if(numero == 5)
				imprimirExtrato();
			else if(numero == 6)
				System.out.println("Obrigado por utilizar os nossos servi�os!!");
			else
				System.out.println("Op��o inv�lida!! Selecione uma das op��es abaixo:");
		}
	}
	
	@Override
	public void consultarSaldo() {
		System.out.printf("Seu saldo: R$%.2f\n", saldo);
	}

	@Override
	public void sacar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o valor(R$) que deseja sacar: ");
		double valor = teclado.nextDouble();
		
		if(valor > saldo) {
			System.out.println("N�o � poss�vel realizar o saque!!");
		} else {
			saldo -= valor;
		}

		consultarSaldo();
	}

	@Override
	public void depositar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o valor(R$) que deseja depositar: ");
		double valor = teclado.nextDouble();
		
		saldo += valor;
		System.out.println("Dep�sito realizado com sucesso!");
		
		consultarSaldo();
	}

	@Override
	public void transferir(Banco banco) {
		String nome = "";
		boolean contaExiste = false;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o valor(R$) que deseja transferir: ");
		double valor = teclado.nextDouble();
		System.out.println("Digite o n�mero da conta: ");
		int numeroContaDestino = teclado.nextInt();
		
		for(Conta c: banco.getContas()) {
			if(c.getNumeroConta() == numeroContaDestino) {
				contaExiste = true;
				
				if(valor > saldo) {
					System.out.printf("N�o � poss�vel realizar a tranfer�ncia! Seu saldo � de R$ %.2f \n", saldo);
				}else {
					nome = c.getCliente().getNome();
					double saldoContaDestino = c.getSaldo();
					c.setSaldo(saldoContaDestino += valor) ;
					saldo -= valor;
					
					System.out.printf("Tranfer�ncia no valor de R$ %.2f realizada para %s \n", valor, nome);			
				}
			}
		}
		
		if(!contaExiste)
			System.out.println("N�o � poss�vel realizar a tranfer�ncia porque a conta n�o existe");		

	}

	protected void imprimirInfoConta() {
		System.out.printf("Cliente: %s \n", cliente.getNome());
		System.out.printf("Ag�ncia: %d \n", agencia);
		System.out.printf("N�mero: %d \n" , numeroConta);
		System.out.printf("Seu saldo: %.2f \n", saldo);
	}

	@Override
	public String toString() {
		return "Conta - ag�ncia:" + agencia + ", numeroConta: " + numeroConta + ", saldo: " + saldo + ", cliente: "
				+ cliente;
	}

}

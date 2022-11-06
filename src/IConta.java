public interface IConta {

	void sacar();
	
	void depositar();
	
	void transferir(Banco banco);
	
	void imprimirExtrato();
	
	void consultarSaldo();
}

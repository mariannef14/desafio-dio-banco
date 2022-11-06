import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Banco {

	private String nome;
	private Set<Conta> contas = new LinkedHashSet<Conta>();
	
	
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Conta> getContas() {
		return contas;
	}
	
	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contas, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(contas, other.contas) && Objects.equals(nome, other.nome);
	}
	
	
	public Set<Cliente> listaCliente() {
		Set<Cliente> clientes = new LinkedHashSet<Cliente>(); 
		
		for(Conta c: contas) {
			clientes.add(c.getCliente());
		}
		
		return clientes;
	}
	
}

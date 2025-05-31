package modelo;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	
	public Usuario(String nome, String cpf, String email) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		String relatorio = "Nome: " + this.nome;
		relatorio += "CPF: " + this.cpf;
		relatorio += "Email: " + this.email;
		// TODO Auto-generated method stub
		return relatorio;
	}
}


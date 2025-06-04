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
	
	//gets()
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	//sets()
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		String relatorio = "\n\t===Usuário==="; 
		relatorio += "\n\nNome: " + this.nome;
		relatorio += "\nCPF: " + this.cpf;
		relatorio += "\nEmail: " + this.email;
		relatorio += "\n\n================================";
		// TODO Auto-generated method stub
		return relatorio;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Usuario usuario = (Usuario) obj;
		return this.cpf.equals(usuario.cpf);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return cpf.hashCode();
	}
}


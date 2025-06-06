package modelo;

import java.util.Objects;

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
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Usuario)) {
        	return false;
        }
        Usuario other = (Usuario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return cpf.hashCode();
	}
}


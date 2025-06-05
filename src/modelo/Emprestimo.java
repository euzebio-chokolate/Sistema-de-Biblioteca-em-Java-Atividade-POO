package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucaoPrevista;
	private LocalDate dataDevolucaoReal;
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
		// TODO Auto-generated constructor stub
		this.livro = Objects.requireNonNull(livro, "Livro não pode ser nulo.");
		this.usuario = Objects.requireNonNull(usuario, "Usuário não pode ser nulo.");
		this.dataEmprestimo = (dataEmprestimo);
		this.dataDevolucaoPrevista = (dataDevolucaoPrevista);
		this.dataDevolucaoReal = null;
	}
	
	//gets()
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public LocalDate getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	
	public LocalDate getDataDevoluaoReal() {
		return dataDevolucaoReal;
	}
	
	//set()
	public void setDataDevolucaoReal(LocalDate dataDevoluaoReal) {
		this.dataDevolucaoReal = dataDevoluaoReal;
	}
	
	public boolean isDevolvido() {
		return this.dataDevolucaoReal != null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String dataDevolucaoRealStr;
		if (dataDevolucaoReal != null) {
		    dataDevolucaoRealStr = dataDevolucaoReal.format(formatter);
		}
		else {
		    dataDevolucaoRealStr = "Não devolvido";
		}
		String relatorio = "\n\t===Emprestimo===";
		relatorio += "\n\nLivro: " + livro.getTitulo();
		relatorio += "\nUsuário: " + usuario.getNome();
		relatorio += "\nData de Empréstimo: " + dataEmprestimo.format(formatter);
		relatorio += "\nData de Devolução Prevista: " + dataDevolucaoPrevista.format(formatter);
		relatorio += "\nData de Devolução Real: " + dataDevolucaoRealStr;
		relatorio += "\n\n====================================";
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
		Emprestimo emprestimo = (Emprestimo) obj;
		return Objects.equals(this.livro, emprestimo.livro) && Objects.equals(this.usuario, emprestimo.usuario) && Objects.equals(this.dataEmprestimo, emprestimo.dataEmprestimo);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(livro, usuario, dataEmprestimo);
	}
}

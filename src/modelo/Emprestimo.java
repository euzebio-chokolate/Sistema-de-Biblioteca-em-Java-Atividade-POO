package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		// TODO Auto-generated constructor stub
		this.livro = Objects.requireNonNull(livro, "Livro não pode ser nulo.");
		this.usuario = Objects.requireNonNull(usuario, "Usuário não pode ser nulo.");
		this.dataEmprestimo = Objects.requireNonNull(dataEmprestimo, "Data de Emprestimo não pode nulo.");
		this.dataDevolucao = Objects.requireNonNull(dataDevolucao, "Data de Devolução não pode nulo.");
	}
	
	//gets()
	public Usuario getUsario() {
		return usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	//set()
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public boolean devolvido() {
		if(this.dataDevolucao != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String relatorio = "\tEmprestimo";
		relatorio += "\n\nLivro: " + livro.getTitulo();
		relatorio += "\nUsuário: " + usuario.getNome();
		relatorio += "\nData de Empréstimo: " + dataEmprestimo.format(formatter);
		relatorio += "\nData de Devolução: " + dataDevolucao.format(formatter);
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

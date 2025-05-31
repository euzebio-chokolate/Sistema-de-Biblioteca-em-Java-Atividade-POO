package modelo;

public class Emprestimo {
	private Usuario usario;
	private Livro livro;
	private String dataEmprestimo;
	private String dataDevolucao;
	
	public Emprestimo(Usuario usuario, Livro livro) {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario getUsario() {
		return usario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}
}

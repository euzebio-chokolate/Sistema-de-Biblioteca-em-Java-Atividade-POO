package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	private int quantidadeExemplares;
	private int ISBN;
	
	
	//construtor
	public Livro (String titulo, String autor, String editora, int anoPublicacao, int quantidadeExemplares, int ISBN) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.quantidadeExemplares = quantidadeExemplares;
		this.ISBN = ISBN;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}
	
	public int getISBN() {
		return ISBN;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
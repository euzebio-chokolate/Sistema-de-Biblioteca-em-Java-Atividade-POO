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
	
	//gets()
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
	
	//sets()
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public void setQuantidadeExemplares(int quantidadeExemplares) {
		if(quantidadeExemplares >= 0) {
			this.quantidadeExemplares = quantidadeExemplares;
		}
		else {
			System.err.println("Quantidade de Exemplares não pode ser negativa!!!");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String relatorio = "\tLivro";
		relatorio += "\n\nTitulo: " + this.titulo;
		relatorio += "\nAutor:  " + this.autor;
		relatorio += "\nEditora: " + this.editora;
		relatorio += "\nISBN: " + this.ISBN;
		relatorio += "\nAno de Publicação: " + this.anoPublicacao;
		relatorio += "\nQuantidade de Exemplares: " + this.quantidadeExemplares;
		relatorio += "\n\n================================";
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
		Livro livro = (Livro) obj;
		return this.ISBN == livro.ISBN;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.hashCode(ISBN);
	}
}
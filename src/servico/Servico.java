package servico;

import java.util.List;

import modelo.Livro;
import modelo.Usuario;
import repositorio.BDsimulado;

public class Servico {
	private static int totalExemplares = 0;
	private static int totalUsuarios = 0;
	
	public static void contador() {
		totalExemplaresAtualizado();
		if(BDsimulado.listarUsuarios() != null) {
			totalUsuarios = BDsimulado.listarUsuarios().size();
		}
		else {
			totalUsuarios = 0;
		}
	}
	
	//Livros
	public static Livro cadastrarLivros(String titulo, String autor, String editora, String ISBN, int ano, int quantidadeExemplares) {
		if(ISBN == null || ISBN.trim().isEmpty()) {
			System.err.println("ISBN inválido");
			return null;
		}
		
		if(BDsimulado.buscarLivroISBN(ISBN) != null) {
			System.err.println("Livro com ISBN " + ISBN + "já cadastrado");
			return null;
		}
		
		if(quantidadeExemplares <= 0) {
			System.err.println("Quantidade de Exemplares inválida");
			return null;
		}
		
		Livro novoLivro = new Livro(titulo, autor, editora, ISBN, ano, quantidadeExemplares);
		BDsimulado.addLivro(novoLivro);
		totalExemplares += quantidadeExemplares;
		System.out.println("Livro '" + novoLivro.getTitulo() + "' cadastrado na biblioteca!!");
		return novoLivro;
	}
	
	public static Livro consultarLivroISBN(String ISBN) {
		return BDsimulado.buscarLivroISBN(ISBN);
	}
	
	public static List<Livro> listarLivros(){
		return BDsimulado.listarLivros();
	}
	
	public static boolean removerLivro(String ISBN) {
		Livro livroRemove = BDsimulado.buscarLivroISBN(ISBN);
		if(livroRemove == null) {
			System.err.println("Livro com ISBN " + ISBN + " não encontrado");
			return false;
		}
		
		boolean removido = BDsimulado.removerLivro(ISBN);
		
		if(removido) {
			totalExemplares -= livroRemove.getQuantidadeExemplares();
			System.out.println("Livro '" + livroRemove.getTitulo() + "' removido com sucessor");
		}
		return removido;
	}
	
	public static List<Livro> buscarLivroAutor(String autor){
		return BDsimulado.buscarLivrosAutor(autor);
	}
	
	public static int getTotalExemplares() {
		return totalExemplares;
	}
	
	public static void totalExemplaresAtualizado() {
		totalExemplares = 0; 
		List<Livro> livros = BDsimulado.listarLivros();
		if(livros != null) {
			for(Livro livro: livros) {
				totalExemplares += livro.getQuantidadeExemplares();
			}
		}
	}
	
	//Usuarios
	public static Usuario cadastrarUsuario(String nome, String CPF, String email) {
		if(CPF == null || CPF.trim().isEmpty()) {
			System.err.println("Campo CPF não pode ser vazio!");
			return null;
		}
		
		if(BDsimulado.buscarUsuarioCPF(CPF) != null) {
			System.err.println("Usuário com CPF " + CPF + " já cadastrado!!");
			return null;
		}
		
		Usuario novoUsuario = new Usuario(nome, CPF, email);
		BDsimulado.addUsuario(novoUsuario);
		totalUsuarios++;
		System.out.println("Usuário '" + novoUsuario.getNome() + "' cadastrado com sucesso!!");
		return novoUsuario;
	}
	
	public static Usuario consultarUsuarioCPF(String CPF) {
		return BDsimulado.buscarUsuarioCPF(CPF);
	}
	
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return BDsimulado.listarUsuarios();
	}
	
	
}

package servico;

import java.time.LocalDate;
import java.util.List;

import modelo.Emprestimo;
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
	
	public static List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return BDsimulado.listarUsuarios();
	}
	
	public static boolean removerUsuario(String CPF) {
		Usuario usuarioRemove = BDsimulado.buscarUsuarioCPF(CPF);
		if(usuarioRemove == null) {
			System.err.println("Usuário com o CPF: " + CPF + " não encontrado!!");
			return false;
		}
		
		boolean removido = BDsimulado.removerUsuario(CPF);
		
		if (removido) {
			totalUsuarios--;
			System.out.println("Usuário '" + usuarioRemove.getNome() + "' removido com sucesso!!");
		}
		return removido;
	}
	
	public static int getTotalUsuarios() {
		return totalUsuarios;
	}
	
	
	//Emprestimos
	public static Emprestimo realizarEmprestimo(String ISBNlivro, String CPFusuario) {
		Livro livro = BDsimulado.buscarLivroISBN(ISBNlivro);
		Usuario usuario = BDsimulado.buscarUsuarioCPF(CPFusuario);
		
		if (livro == null) {
			System.err.println("Livro com o ISBN " + ISBNlivro +" não encontrado!!");
			return null;
		}
		if (usuario == null) {
			System.err.println("Usuário com o CPF " + CPFusuario + " não encontrado!!" );
			return null;
		}
		
		if(livro.getQuantidadeExemplares() <= 1) {
			System.err.println("Quantidade de exemplares do livro '" + livro.getTitulo() + "' insuficiente!");
			return null;
		}
		
		livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() - 1);
		
		LocalDate dataEmprestimo = LocalDate.now();
		
		Emprestimo novoEmprestimo = new Emprestimo(usuario, livro, dataEmprestimo, dataEmprestimo);
		BDsimulado.addEmprestimo(novoEmprestimo);
		return novoEmprestimo;
	}
	
	public static boolean registrarDevolucao(String ISBNlivro, String CPFusuario) {
		Livro livro = BDsimulado.buscarLivroISBN(ISBNlivro);
		Usuario usuario = BDsimulado.buscarUsuarioCPF(CPFusuario);
		
		if (livro == null) {
			System.err.println("Livro com o ISBN " + ISBNlivro +" não encontrado para devolução!!");
			return false;
		}
		
		if (usuario == null) {
			System.err.println("Usuário com o CPF " + CPFusuario + " não encontrado para devolução!!" );
			return false;
		}
		
		LocalDate dataDevolucao = LocalDate.now();
		livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() + 1);
		
		System.out.println("Devolução registrada com sucesso!");
		return true;
	}
}


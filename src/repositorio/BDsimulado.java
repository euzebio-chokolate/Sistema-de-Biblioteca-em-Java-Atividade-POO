package repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Livro;
import modelo.Usuario;
import modelo.Emprestimo;

public class BDsimulado {
	private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	private static List<Emprestimo> emprestimos =  new ArrayList<Emprestimo>();
	
	//Metodos de Livro
	public static boolean addLivro(Livro livro) {
		String ISBNstr = String.valueOf(livro.getISBN());
		if (!livros.containsKey(ISBNstr)) {
			livros.put(ISBNstr, livro);
			return true;
		}
		else {
			System.err.println("Livro já cadastrado com o ISBN: " + ISBNstr);
			return false;
		}
	}
	
	public static Livro buscarLivroISBN(String ISBN) {
		// TODO Auto-generated method stub
		return livros.get(ISBN);
	}
	
	public static List<Livro> listarLivros() {
		// TODO Auto-generated method stub
		return new ArrayList<Livro>(livros.values());
	}
	
	public static boolean removerLivro(String ISBN) {
		if(livros.remove(ISBN) != null) {
			return true;
		}
		return false;
	}
	
	public static List<Livro> buscarLivrosAutor(String autor) {
		// TODO Auto-generated method stub
		if (autor == null || autor.trim().isEmpty()) {
			return new ArrayList<Livro>();
		}
		return livros.values().stream().filter(livro -> livro.getAutor().equalsIgnoreCase(autor.trim())).collect(Collectors.toList());
	}
	
	//Metodos de Usuario
	public static boolean addUsuario(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getCpf())) {
			usuarios.put(usuario.getCpf(), usuario);
			return true;
		}
		return false;
	}
	
	public static Usuario buscarUsuarioCPF(String CPF) {
		// TODO Auto-generated method stub
		return usuarios.get(CPF);
	}
	
	public static List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return new ArrayList<Usuario>(usuarios.values());
	}
	
	public static void removerUsuario(String cpf) {
		usuarios.remove(cpf);
	}
	
	//Metodos de Emprestimo
	public static void addEmprestimo(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		emprestimos.add(emprestimo);
	}
	
	public static List<Emprestimo> listarEmprestimos(){
		return new ArrayList<Emprestimo>(emprestimos);
	}
}




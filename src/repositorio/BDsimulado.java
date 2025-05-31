package repositorio;

import java.util.HashMap;
import modelo.Livro;
import modelo.Usuario;
import modelo.Emprestimo;

public class BDsimulado {
	private static HashMap<String, Livro > livros = new HashMap<String, Livro>();
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();
	
	public static boolean addLivro(Livro l) {
		if (livros.containsKey(l.getISBN())) {
			return false;
		}
		return true;
	}
	
	public static void removerLivro(String ISBN) {
		livros.remove(ISBN);
	}
	
	public static boolean addUsuario(Usuario u) {
		if (usuarios.containsKey(u.getCpf())) {
			return false;
		}
		return true;
	}
	
	public static void removerUsuario(String cpf) {
		usuarios.remove(cpf);
	}
}




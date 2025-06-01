package aplicacao;

import modelo.Livro;
import modelo.Usuario;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Livro l = new Livro("Sapecagens", "João Monteiro", "SuaMae", 2000, 120, 123456);
		System.out.println(l.toString());
		
		Usuario u = new Usuario("Euzebio Nascimento", "088.123.896-23", "euzebioneto547@gmail.com");
		System.out.println(u.toString());
	}

}

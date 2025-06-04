package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.Livro;
import modelo.Usuario;
import servico.Servico;

public class Aplicacao {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte opcao;
		do {
			
			//exibirMenu();
			System.out.println("Escolha uma opção: ");
			opcao = Byte.parseByte(teclado.nextLine());
			switch (opcao) {
			case 1: {
				break;	
			}	
			
			case 2: {
				break;
			}		
			
			case 3: {
				break;
			}		
			
			case 4: {
				break;
			}	
			
			case 5: {
				break;
			}	
			
			case 6: {
				break;
			}	
			
			case 7: {
				break;
			}	
			
			case 8: {
				break;
			}	
			
			case 9: {
				break;
			}	
			
			case 10: {
				break;
			}	
			
			case 11: {
				break;
			}
			
			case 12: {
				break;
			}
			
			case 13: {
				break;
			}
			
			case 14: {
				break;
			}
			
			case 0:{
				break;
			}
		
			default:
				System.out.println("Opcão Inválida");
			}
			
		} while (opcao != 0);
		System.out.println("\nPrecione Enter para continuar...");
		teclado.close();
	}
	
	private static void cadastrarLivro() {
		System.out.println("\n\tCadastrar Novo Livro");
		System.out.println("Titulo: ");
		String titulo = teclado.nextLine();
		System.out.println("Autor: ");
		String autor = teclado.nextLine();
		System.out.println("Editora: ");
		String editora = teclado.nextLine();
		System.out.println("ISBN: ");
		String ISBN = teclado.nextLine();
		System.out.println("Ano de Publicacao: ");
		int anoPublicacao = Integer.parseInt(teclado.nextLine());
		System.out.println("Titulo: ");
		int quantidadeExemplares = Integer.parseInt(teclado.nextLine());
		Servico.cadastrarLivros(titulo, autor, editora, ISBN, anoPublicacao, quantidadeExemplares);
	}
		
	private static void consultarLivroISBN() {
		System.out.println("\n\tConsultar Livro por ISBN");
		System.out.println("Digite o ISBN do livro: ");
		String ISBN = teclado.nextLine();
		Livro livro = Servico.consultarLivroISBN(ISBN);
		if(livro == null) {
			System.out.println("Livro Encontrado: " + livro);
		}
		else {
			System.out.println("Livro com o ISBN " + " não encontrado!");
		}
	}
	
	private static void listarLivros() {
		System.out.println("\nLista de todos Livros Cadastrados");
		List<Livro> livros = Servico.listarLivros();
		if(livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado na biblioteca");
		}
		else {
			livros.forEach(System.out::println);
		}
	}
	
	private static void removerLivro() {
		System.out.println("\n\tRemover Livro");
        System.out.print("Digite o ISBN do livro a ser removido: "); 
        String isbn = teclado.nextLine();
        Servico.removerLivro(isbn);
	}
	
	private static void buscarLivrosAutor() {
		System.out.println("\n\tBuscar Livro por Autor");
		System.out.println("\nDigite o nome do Autor: ");
		String autor = teclado.nextLine();
		List<Livro> livros = Servico.buscarLivroAutor(autor);
		if(livros.isEmpty()) {
			System.out.println("Nenhum livro encontrado para o Autor '" + autor + "' para este livro");
		}
		else {
			System.out.println("Livros encontrados para '" + autor + "' :");
		}
		livros.forEach(System.out::println);
	}
	
	private static void cadastrarUsuario() {
		System.out.println("\n\tCadastrar Novo Usuário");
		System.out.println("Nome completo: ");
		String nome = teclado.nextLine();
		System.out.println("CPF");
	}
}

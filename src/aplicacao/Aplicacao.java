package aplicacao;

import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import servico.Servico;

public class Aplicacao {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte opcao;
		do {
			
			exibirMenu();
			System.out.println("\nEscolha uma opção: ");
			opcao = Byte.parseByte(teclado.nextLine());
			switch (opcao) {
			case 1: {
				System.out.println("\n\tCadastrar Novo Livro");
				System.out.println("\nTitulo: ");
				String titulo = teclado.nextLine();
				System.out.println("\nAutor: ");
				String autor = teclado.nextLine();
				System.out.println("\nEditora: ");
				String editora = teclado.nextLine();
				System.out.println("\nISBN: ");
				String ISBN = teclado.nextLine();
				System.out.println("\nAno de Publicacao: ");
				int anoPublicacao = Integer.parseInt(teclado.nextLine());
				System.out.println("\nQuantidade de Exemplares: ");
				int quantidadeExemplares = Integer.parseInt(teclado.nextLine());
				Servico.cadastrarLivros(titulo, autor, editora, ISBN, anoPublicacao, quantidadeExemplares);
				System.out.println("Livro cadastrado com sucesso!");
				break;	
			}	
			
			case 2: {
				System.out.println("\n\tConsultar Livro por ISBN");
				System.out.println("Digite o ISBN do livro: ");
				String ISBN = teclado.nextLine();
				Livro livro = Servico.consultarLivroISBN(ISBN);
				if(livro == null) {
					System.out.println("\nLivro Encontrado: " + livro);
				}
				else {
					System.out.println("\nLivro com o ISBN " + " não encontrado!");
				}
				break;
			}		
			
			case 3: {
				System.out.println("\n\tLista de todos Livros Cadastrados");
				List<Livro> livros = Servico.listarLivros();
				if(livros.isEmpty()) {
					System.out.println("\nNenhum livro cadastrado na biblioteca");
				}
				else {
					livros.forEach(System.out::println);
				}
				break;
			}		
			
			case 4: {
				System.out.println("\n\tRemover Livro");
		        System.out.print("\nDigite o ISBN do livro a ser removido: "); 
		        String isbn = teclado.nextLine();
		        Servico.removerLivro(isbn);
				break;
			}	
			
			case 5: {
				System.out.println("\n\tBuscar Livro por Autor");
				System.out.println("\nDigite o nome do Autor: ");
				String autor = teclado.nextLine();
				List<Livro> livros = Servico.buscarLivroAutor(autor);
				if(livros.isEmpty()) {
					System.out.println("\nNenhum livro encontrado para o Autor '" + autor + "' para este livro");
				}
				else {
					System.out.println("\nLivros encontrados para '" + autor + "' :");
				}
				livros.forEach(System.out::println);
				break;
			}	
			
			case 6: {
				System.out.println("\n\tCadastrar Novo Usuário");
				System.out.println("\nNome completo: ");
				String nome = teclado.nextLine();
				System.out.println("CPF");
				break;
			}	
			
			case 7: {
				System.out.println("\n\tConsultar Usuário por CPF");
				System.out.println("\nDigite o CPF do usuário que deseja encontrar: ");
				String CPF = teclado.nextLine();
				Usuario usuario = Servico.consultarUsuarioCPF(CPF);
				if(usuario != null) {
					System.out.println("Usuario encontrado: " + usuario);
				}
				else {
					System.err.println("Usuário com o CPF '" + CPF + "' não encontrado!");
				}
				break;
			}	
			
			case 8: {
				System.out.println("\n\tLista de todos os Usuários cadastrados");
				List<Usuario> usuarios = Servico.listarUsuarios();
				if(usuarios.isEmpty()) {
					System.err.println("Nenhum usuário cadastrado!");
				}
				else {
					usuarios.forEach(System.out::println);
				}
				break;
			}	
			
			case 9: {
				System.out.println("\n\tRemover Usuário");
				System.out.println("Digite o CPF do usuário a ser removido: ");
				String CPF = teclado.nextLine();
				Servico.removerUsuario(CPF);
				System.out.println("Usuario removido com sucesso!");
				break;
			}	
			
			case 10: {
				System.out.println("\n\tRealizar Empréstimo de Livro");
				System.out.println("Digite o ISBN do Livro: ");
				String ISBN = teclado.nextLine();
				System.out.println("Digite o CPF do Usuário");
				String CPF = teclado.nextLine();
				Servico.realizarEmprestimo(ISBN, CPF);
				System.out.println("Emprestimo realizado!");
				break;
			}	
			
			case 11: {
				System.out.println("\n\tRegistrar Devolução de Livro");
				System.out.println("Digite o ISBN do Livro devolvido: ");
				String ISBN = teclado.nextLine();
				System.out.println("Digite o CPF do Usuário que está devolvendo: ");
				String CPF = teclado.nextLine();
				Servico.registrarDevolucao(ISBN, CPF);
				System.out.println("Devolução Registrada");
				break;
			}
			
			case 12: {
				 System.out.println("\n\tLivros atualmente Emprestados");
				 List<Emprestimo> emprestimos = Servico.livrosEmprestados();
				 if(emprestimos.isEmpty()) {
					 System.out.println("Nenhum Livro Emprestado no momento!");
				 }
				 else {
					 emprestimos.forEach(System.out::println);
				 }
				break;
			}
			
			case 13: {
				System.out.println("\n\tLivros Disponíveis para Empréstimo");
				List<Livro> livros = Servico.listarLivrosDisponiveis();
				if(livros.isEmpty()) {
					System.out.println("Nenhum livro Disponível para empréstimo");
				}
				else {
					livros.forEach(l -> System.out.println("Exemplares na Biblioteca: " + l.getQuantidadeExemplares()));
				}
				break;
			}
			
			case 14: {
				System.out.println("\n\tHistórico de todos os Empréstimos");
				List<Emprestimo> historico = Servico.listarHistoricoEmprestimo();
				if (historico.isEmpty()) {
					System.out.println("Nenhum empréstimo registrado");
				}
				else {
					historico.forEach(System.out::println);
				}
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
		teclado.nextLine();
	}
	
	public static void exibirMenu() {
        System.out.println("\n\tMENU DA BIBLIOTECA");
        System.out.println("\n\tGerenciamento de Livros");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Consultar Livro por ISBN");
        System.out.println("3. Listar Todos os Livros");
        System.out.println("4. Remover Livro");
        System.out.println("5. Buscar Livros por Autor");
        System.out.println("\n\tGerenciamento de Usuários");
        System.out.println("6. Cadastrar Usuário");
        System.out.println("7. Consultar Usuário por CPF");
        System.out.println("8. Listar Todos os Usuários");
        System.out.println("9. Remover Usuário");
        System.out.println("\n\tEmpréstimos");
        System.out.println("10. Realizar Empréstimo");
        System.out.println("11. Registrar Devolução");
        System.out.println("12. Listar Livros Emprestados (Ativos)");
        System.out.println("13. Verificar Livros Disponíveis para Empréstimo"); 
        System.out.println("14. Listar Histórico Completo de Empréstimos"); 
        System.out.println("0. Sair do Sistema");
      }
}



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



public class Principal {

	public static void main(String[] args) {
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("automacaocomercial");
		
		EntityManager em = enf.createEntityManager();
		
		
		String opçao ="", opçao2 ="", opçao3="";
		String menuprincipal = "1 - Manuteçao de produtos \n"
				+ "2 - Manuteçao de clientes \n"
				+ "0 - Sair";
		
		while(!opçao.equals("0")) {
			opçao = JOptionPane.showInputDialog(menuprincipal);
			
			switch(opçao) {
			case "1":
				String menuproduto = "1- Listar todos \n"
						+ "2 - Adicionar \n"
						+ "3 - Editar \n"
						+ "4 - Excluir \n"
						+ "0 - Sair";
				while(!opçao2.equals("0")) {
					opçao2 = JOptionPane.showInputDialog(menuproduto);
					switch (opçao2) {
					case "1": //Listar Todos
						List<Produto> p2 = em.createQuery("Select * from produto", Produto.class).getResultList();
						JOptionPane.showInputDialog(null, "Todos os produtos:" +p2);
						break;
					case "2": //Cadastrando um novo produto
						Produto p1 = new Produto();
						p1.setDescricao(JOptionPane.showInputDialog("Descrição do produto:"));
						p1.setCodigobarra(JOptionPane.showInputDialog("Cod de barra do produto:"));
						p1.setValor(Double.valueOf(JOptionPane.showInputDialog("Valor de venda do produto:")));
						try {
							em.persist(p1);
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Produto cadastrado!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao cadastrar!");
						}
						break;
					case "3"://editando um novo produto
						Produto p3 = em.find(Produto.class, JOptionPane.showInputDialog("ID do produto:"));
						p3.setDescricao(JOptionPane.showInputDialog("Descrição do produto:"));
						p3.setCodigobarra(JOptionPane.showInputDialog("Cod de barra do produto:"));
						p3.setValor(Double.valueOf(JOptionPane.showInputDialog("Valor de venda do produto:")));
						try {
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Produto Editado!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao Editar!");
						}
						break;
					case "4":
						Produto p4 = em.find(Produto.class, JOptionPane.showInputDialog("ID do produto:"));
						em.remove(p4);
						try {
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Produto Removido!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao Remover!");
						}
						break;
					case "0":
						JOptionPane.showInputDialog(null, "Ir para o menuPrincipal");
						break;

					default:
						break;
					}
				}
				break;
				
			case "2":
				String menuCliente = "1- Listar todos \n"
						+ "2 - Adicionar \n"
						+ "3 - Editar \n"
						+ "4 - Excluir \n"
						+ "0 - Sair";
				while(!opçao3.equals("0")) {
					opçao3 = JOptionPane.showInputDialog(menuCliente);
					switch (opçao2) {
					case "1": //Listar Todos
						List<Cliente> c2 = em.createQuery("Select * from cliente", Cliente.class).getResultList();
						JOptionPane.showInputDialog(null, "Todos os produtos:" +c2);
						break;
					case "2": //Cadastrando um novo produto
						Cliente c1 = new Cliente();
						c1.setNome(JOptionPane.showInputDialog("Nome do clinete:"));
						c1.setCpf(JOptionPane.showInputDialog("Cpf do cliente:"));
						
						try {
							em.persist(c1);
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Cliente cadastrado!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao cadastrar!");
						}
						break;
					case "3"://editando um novo produto
						Cliente c3 = em.find(Cliente.class, JOptionPane.showInputDialog("ID do cliente:"));
						c3.setNome(JOptionPane.showInputDialog("Nome do clinete:"));
						c3.setCpf(JOptionPane.showInputDialog("Cpf do cliente:"));
						try {
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Cliente Editado!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao Editar!");
						}
						break;
					case "4":
						Cliente c4 = em.find(Cliente.class, JOptionPane.showInputDialog("ID do produto:"));
						em.remove(c4);
						try {
							em.getTransaction().begin();
							em.getTransaction().commit();
							JOptionPane.showInputDialog(null, "Cliente Removido!");
						} catch (Exception e) {
							JOptionPane.showInputDialog(null, "Error ao Remover!");
						}
						break;
					case "0":
						JOptionPane.showInputDialog(null, "Ir para o menuPrincipal");
						break;
					default:
						break;
					
				}
				break;}
				
			case "0":
				JOptionPane.showInputDialog(null, "Finalizado!!!");
				break;
				
			default:
				break;
			}
		}
		
		em.close();
	}

}

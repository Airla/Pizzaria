package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.PedidoDTO;

public class PedidoDAOPostgreSQL{
	
	private Connection con=null;
	private PreparedStatement pstm=null;
	private ResultSet rset=null;
	
	/** Metodo responsavel por salvar os pedidos no banco de dados
	*/
	public void adicionarPedido(PedidoDTO pdto) {
		 
		String sql = null;
		
		sql = "INSERT INTO pedido(quant_fatias,tamanho, status, valor, cpf_cliente, sabores)" +
					 " VALUES(?,?,?,?,?,?)"; 
		 
		 try {
			 
		con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		
		 pstm.setInt(1, pdto.getQuantFatias());
		 pstm.setString(2, pdto.getTamanho());
		 pstm.setString(3, "preparo");
		 pstm.setFloat(4, pdto.getValorDoPedido());
		 pstm.setString(5, pdto.getCpf());
		 pstm.setString(6, pdto.getSabores());
		 pstm.execute();
		 
		 } catch (Exception e) {
			 System.out.println("Erro ao adicionar pedido!");
		 e.printStackTrace();
		 }
	}
	
	/** Metodo responsavel por recuperar  os pedidos no banco de dados
	 * que o status e preparo
	*/
	public PedidoDTO pedidosPreparo() {
		
		String sql = "SELECT * FROM pedido WHERE status = ?";
		PedidoDTO dto = new PedidoDTO();
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 pstm.setString(1,"preparo");
		 rset = pstm.executeQuery();
		 ArrayList<String[]> pedidos = new ArrayList<>();
		 
		 while(rset.next()) {
			 String[] p = new String[4];			
			 p[0] =(rset.getString("tamanho"));
			 p[1] = Integer.toString(rset.getInt("num_pedido"));
			 p[2]=(rset.getString("sabores"));
			 p[3]=(rset.getString("cpf_cliente"));
			 pedidos.add(p);
			 
		 }
		 
		 dto.setPedidos(pedidos);
		 } catch (Exception e) {
			 
			 System.out.println("Erro!");
		 }
		 
		return dto;
		
	}
	
	/** Metodo responsavel por recuperar  os pedidos no banco de dados
	 * que o status e para entrega
	*/
	public PedidoDTO pedidosEntrega() {
		
		String sql = "SELECT pedido.valor, pedido.num_pedido, clientes.nome, clientes.bairro, clientes.rua, clientes.num_casa "
				+ "FROM clientes INNER JOIN pedido ON clientes.cpf = pedido.cpf_cliente AND pedido.status=? "
				+ "and pedido.cpf_cliente not in (select pedido.cpf_cliente from pedido where status = 'preparo')";
		
		 ArrayList<String[]> pedidos = new ArrayList<>();
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 pstm.setString(1, "Para entrega");		 
		 rset = pstm.executeQuery();
		
		 while(rset.next()) {
			 String[] p = new String[6];
			 p[0] = Float.toString(rset.getFloat("valor"));
			 p[1]=Integer.toString(rset.getInt("num_pedido"));
			 p[2] = rset.getString("nome");
			 p[3]=(rset.getString("bairro"));		 
			 p[4]=(rset.getString("rua"));
			 p[5]=Integer.toString(rset.getInt("num_casa"));
			 pedidos.add(p);
			 
		 }
		 
		 } catch (Exception e) {
			 
			 System.out.println("Erro no motoboy!");
		 }
		 
		 PedidoDTO dto = new PedidoDTO();
		 dto.setPedidos(pedidos); 
		return dto;
		
	}
	
	/**
	 * Metodo responsavel por recuperar os pedidos do banco
	 */
		public PedidoDTO getPedidos(){
			 
			 String sql = "SELECT * FROM pedido ";
			 
			 ArrayList<String[]> pedidos = new ArrayList<>();
			 
			 try {
				 con= ConectaBd.conectabd();
			 pstm = con.prepareStatement(sql);
			 
			 rset = pstm.executeQuery();
			 
			 while(rset.next()){
			 
			 String[] p =new String[3];
			 
			 p[0]=(Integer.toString(rset.getInt("num_pedido")));
			 p[1]=(rset.getString("status"));
			 p[2]=(rset.getString("cpf_cliente"))
					 ;
			 
			 pedidos.add(p);
			 }
			 } catch (Exception e) {
			 
				 System.out.println("Erro ao recuperar pedidos!");
			 }
			 
			 PedidoDTO dto = new PedidoDTO();
			 dto.setPedidos(pedidos);
			 return dto;
			 }

		/** Metodo responsavel por editar os dados do pedido no banco de dados
		*/
		public void mudarStatusDoPedido(PedidoDTO pdto){

			 String sql = "UPDATE pedido SET status ='Para entrega'" +
			 " WHERE num_pedido = ?";

			 try {
			 con = ConectaBd.conectabd();

			 pstm = con.prepareStatement(sql);		 
			 pstm.setInt(1, pdto.getnPedido());
			 pstm.execute();
			 
			 } catch (Exception e) {				 
			 System.out.println("Erro!");
			 e.printStackTrace();
			 }	
		}
		
		/** Metodo responsavel por finalizar o pedido (motoboy)
		*/
		public void atudalizarPedidoMotoboy(PedidoDTO pdto){

//			atualiza o status do pedido para "entregue"
			 String sql = "UPDATE pedido SET status = ?" +
					 " WHERE num_pedido = ?";

		try {
			 con = ConectaBd.conectabd();

			 pstm = con.prepareStatement(sql);

			 pstm.setString(1, "Entregue"); 
					 
			 pstm.setInt(2, pdto.getnPedido());
			 pstm.execute();
			 
//			 recupero os sabores da pizza desse pedido
			 sql= "SELECT sabores FROM pedido WHERE num_pedido = ?";
			 
			 pstm = con.prepareStatement(sql);
			 
			 pstm.setInt(1, pdto.getnPedido());		 
			 rset = pstm.executeQuery();
			 
			 String sabores=null;
			 
			 while(rset.next()) {				 
				sabores=rset.getString("sabores");				
				 break;
			 }
			 
			 String arraySabores[] = sabores.split(" ");
			 
//			incrementa a quantidade de vezes que a pizza foi pedida
//			de acordo com os sabores da pizza
			 for (int i = 0; i < arraySabores.length; i++) {
				String s = arraySabores[i];	
				sql = "UPDATE pizza SET quant_vezes_pedido = quant_vezes_pedido+1"+
						 "WHERE tipo = ?"
			 ;
				pstm = con.prepareStatement(sql);
				pstm.setString(1,s); 
				pstm.execute();			
		
			}
//			 atualiza a contabilidade
			 sql = "UPDATE contabilidade SET quant_pizzas_vendidas = quant_pizzas_vendidas+1, lucro_mes = lucro_mes+?";
			 pstm = con.prepareStatement(sql);
			 pstm.setFloat(1,pdto.getValorDoPedido()); 
			 pstm.execute();
			 
			 } catch (Exception e) {
				 
			 System.out.println("Erro!");
			 e.printStackTrace();
			 }
		}

}

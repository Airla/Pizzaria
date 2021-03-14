package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.ContabilidadeDTO;

public class ContabilidadeDAOPostgreSQL{
	
	private Connection con=null;
	private PreparedStatement pstm=null;
	private ResultSet rset=null;
	
	/** Metodo responsavel por recuperar a contabilidade
	*/
	public ContabilidadeDTO dadosContabilidade() {
		
		String sql = "SELECT * FROM pizza WHERE quant_vezes_pedido = (SELECT MAX(quant_vezes_pedido) FROM pizza)";
		
		ContabilidadeDTO cdto = new ContabilidadeDTO();
		
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 rset = pstm.executeQuery();
		 		
		 String[] dados = new String[3];
		 
		 while(rset.next()) {
			 dados[2] = (rset.getString("tipo"));
			 break;
		 }
		 
		 sql = "SELECT quant_pizzas_vendidas, lucro_mes FROM contabilidade";
		 
		 pstm = con.prepareStatement(sql);
		 rset = pstm.executeQuery();
		 
		 while(rset.next()) {
			 dados[0] = (rset.getString("quant_pizzas_vendidas"));
			 dados[1] = (rset.getString("lucro_mes"));
			 break;
		 }
		 
		 cdto.setDados(dados);
		 } catch (Exception e) {
			 
			 System.out.println("Erro!");
		 }
		 
		return cdto;
		
	}

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.IngredienteDTO;
import DTO.PizzaDTO;
import View.AdicionarComponentes;

public class PizzaDAOImplePostgreSQL{

	private Connection con=null;
	private PreparedStatement pstm=null;
	private ResultSet rset=null;
	
	/** Metodo responsavel por salvar as pizzas no banco de dados
	*/
	public void criarPizza(PizzaDTO pdto, IngredienteDTO idto) {
		 
		String sql = null;
		
		sql = "INSERT INTO pizza(tipo,tamanho,preparo, quant_fatias, custo, custo_fatia, quant_vezes_pedido, temperatura_forno, tempo_forno_minutos,"
				+ "tipo_caixa, sigla_estado)" +
					 " VALUES(?,?,?,?,?,?,?,?,?,?,?)"; 
		 
		 try {
			 
		con= ConectaBd.conectabd();
		
		 pstm = con.prepareStatement(sql);
		
		 pstm.setString(1, pdto.getTipo());
		 pstm.setString(2, pdto.getTamanho());
		 pstm.setString(3, pdto.getPreparo());
		 pstm.setInt(4, pdto.getQuantFatias());
		 pstm.setFloat(5, idto.getValor());
		 pstm.setFloat(6, pdto.getCustoFatia());
		 pstm.setInt(7, 0);
		 pstm.setInt(8, pdto.getTemperaturaForno());
		 pstm.setInt(9, pdto.getTempoNoFornoMinutos());
		 pstm.setString(10, pdto.getTipoDeCaixa());
		 pstm.setString(11, pdto.getSiglaEstado());
		 
		 pstm.execute();
		 int pizza=codigoPizza();
		
		 sql = "INSERT INTO ingrediente_pizza(pizza,ingrediente)" +
				 " VALUES(?,?)"; 
		 
		 pstm = con.prepareStatement(sql);
		
		 for (String i : idto.getNomeIngredientes()) {
			 pstm.setInt(1, pizza);
			 pstm.setString(2, i);
			 pstm.execute();
		}
		
		 } catch (Exception e) {
			 System.out.println("Erro ao adicionar pizza!");
		 e.printStackTrace();
		 }
	}
	
	
	/**
	 * Metodo responsavel por recuperar o numero da maior pizza
	 */
	public int codigoPizza(){
	 int num=0;
		 String sql = "SELECT * FROM pizza WHERE id = (SELECT MAX(id) FROM pizza)";
			
			 try {
				 con= ConectaBd.conectabd();
			 pstm = con.prepareStatement(sql);
			 rset = pstm.executeQuery();
			 		
			
			 while(rset.next()) {
				 num= (rset.getInt("id"));
				 break;
			 }
		 
			 }catch(Exception e) {
				 System.out.println("Erro ao recuperar numedo do pedido!");
				 e.printStackTrace();
			 }
			 return num;
	}
	
	/**
	 * Metodo responsavel por recuperar as pizzas do banco
	 */
	public ArrayList<PizzaDTO> getPizzas(){
			 
		String sql = "SELECT * FROM pizza";
			 
		ArrayList<PizzaDTO> pizzas = new ArrayList<>();
			 try {
				 con= ConectaBd.conectabd();
			 pstm = con.prepareStatement(sql);		 
			 
			 rset = pstm.executeQuery();
			 
			 while(rset.next()){
			 PizzaDTO p= new PizzaDTO();
			 p.setCodIdentificacao(rset.getInt("id"));
			 p.setTipo(rset.getString("tipo"));
			 p.setTamanho(rset.getString("tamanho"));
			 p.setCusto(rset.getFloat("custo"));
			 p.setCustoFatia(rset.getFloat("custo_fatia"));
			 p.setQuantVezesPedido(rset.getInt("quant_vezes_pedido"));
			 pizzas.add(p);
			 }
			 
			 } catch (Exception e) {
			 
				 System.out.println("Erro ao recuperar pizzas!");
			 }
						
			 PizzaDTO pdto = new PizzaDTO();
			 pdto.setPizzas(pizzas);
			 return pdto.getPizzas();
	}
		
	/**
	 * Metodo responsavel por recuperar os sabores das pizzas do banco
	*/
	public PizzaDTO getSaboresPizzas(){
				 
	String sql = "SELECT * FROM pizza";
				 
	ArrayList<String> pizzas = new ArrayList<>();
				 
		try {
			con= ConectaBd.conectabd();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
				 
			while(rset.next()){
			pizzas.add(rset.getString("tipo"));
			}
		} catch (Exception e) {
				 
			System.out.println("Erro ao recuperar sabores das pizzas!");
		}
		
		String[] saboresDePizzas = new String[pizzas.size()];
			for (int i=0; i<pizzas.size(); i++) {
				saboresDePizzas[i] = pizzas.get(i);
				}		 
			PizzaDTO pdto = new PizzaDTO();
				 
			pdto.setSaboresDePizzas(saboresDePizzas);
			return pdto;
		}
		
	/** Metodo responsavel por deletar as pizzas no banco de dados
	*/
	public void removerPizza(PizzaDTO pdto) {
			 
	String sql = "DELETE FROM pizza WHERE id = ?";
			 
		try {
			con = ConectaBd.conectabd();
			 
			pstm = con.prepareStatement(sql);
			 
			pstm.setInt(1, pdto.getCodIdentificacao());
			 
			pstm.execute();
			 
		} catch (Exception e) {
			 
		    e.printStackTrace();
		} 
	}
		
	/** Metodo responsavel por recuperar uma pizza do bd
	*/
	public PizzaDTO dadosPizza(PizzaDTO pdto) {
			
	String sql = "SELECT * FROM pizza WHERE id = ?";
	PizzaDTO p =null;
			 
		try {
			con= ConectaBd.conectabd();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, pdto.getCodIdentificacao());
			rset = pstm.executeQuery();			 

			 while(rset.next()) {
				 p = new PizzaDTO();
				 p.setTipo(rset.getString("tipo"));
				 p.setTamanho(rset.getString("tamanho"));
				 p.setCusto(rset.getFloat("custo"));
				 p.setPreparo(rset.getString("preparo"));
				 p.setCustoFatia(rset.getFloat("custo_fatia"));				 
				 p.setCodIdentificacao(rset.getInt("id"));
				 
				 break;
			 }
			
		} catch (Exception e) {
				 
			System.out.println("Erro!");
		}
		return p;
			
	}
		
//	public IngredienteDTO ingredientePizza(IngredienteDTO idto) {
//	String sql = "SELECT MAX(ID) FROM SUA_TABELA";
//	int numPedido = Integer.parseInt(sql);
//			 
//	sql = "INSERT INTO ingrediente_pedido(pedido,ingrediente)" +
//	" VALUES(?,?,?,?,?,?,?)"; 
//		 
//		 try {
//			 
//			 con= ConectaBd.conectabd();
//		
//			 pstm = con.prepareStatement(sql);
//		
//			 pstm.setInt(1, numPedido);
//			 pstm.setInt(2, 0);
//		
//			 pstm.execute();
//		
//		 } catch (Exception e) {
//			 System.out.println("Erro ao adicionar pizza!");
//		 e.printStackTrace();
//		 }
//	return null;
//	}		
}

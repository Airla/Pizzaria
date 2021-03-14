package DAO;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.PessoaDTO;
import DTO.IngredienteDTO;

public class GerenteDAOPostgreSQL{
	
	private Connection con=null;
	private PreparedStatement pstm=null;
	private ResultSet rset=null;
	private PessoaDTO g =null;
	
/** Metodo responsavel por salvar os funcionarios no banco de dados
	*/
	public void adicionarFuncionario(PessoaDTO gdto){/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */
		String sql = null;
		
		sql = "INSERT INTO funcionarios(cpf,email,nome, senha, cargo)" +
					 " VALUES(?,?,?,?,?)"; 
		 
		 try {
			 
		con= ConectaBd.conectabd();
		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = con.prepareStatement(sql);
		
		 pstm.setString(1, gdto.getCpf());
		 pstm.setString(2, gdto.getEmail());
		 pstm.setString(3, gdto.getNome());
		 pstm.setString(4, gdto.getSenha());
		 pstm.setString(5, gdto.getCargo());
		
		 //Executa a sql para inserção dos dados
		 pstm.execute();
		 } catch (Exception e) {
			 System.out.println("Erro ao cadastrar funcionario!");
		 e.printStackTrace();
		 }
	}
	
/**
 * Metodo responsavel por recuperar os funcionarios do banco
 */
	public PessoaDTO getFuncionarios(){
		 
		 String sql = "SELECT * FROM funcionarios ";
		 
		 ArrayList<String[]> funcionarios = new ArrayList<>();
		 
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 //Enquanto existir dados no banco de dados, faça
		 while(rset.next()){
		 
		 String[] f =new String[6];
		 
		 //Recupera os dados do banco e atribui ele ao objeto
		 f[0]=(Integer.toString(rset.getInt("id")));
		 f[1]=(rset.getString("nome"));
		 f[2]=(rset.getString("cargo"));
		 f[3]=(rset.getString("email"));
		 f[4]=(rset.getString("senha"));
		 f[5]=(rset.getString("cpf"));
		 
		 //Adiciono o funcionario recuperado, a lista de funcionarios
		 funcionarios.add(f);
		 }
		 } catch (Exception e) {
		 
			 System.out.println("Erro ao recuperar funcionarios!");
		 }
//			 finally{
//		 
//			ConectaBd.desconectabd(con, pstm, rset);
//		 }
		 
		 g = new PessoaDTO();
		 g.setArrayList(funcionarios);
		 return g;
		 }
	 
	/** Metodo responsavel por logar o funcionario no sistema
	*/
	public PessoaDTO recuperarFuncionario(PessoaDTO gdto) {
		
		String sql = "SELECT * FROM funcionarios WHERE email = ? and senha=?";
		 
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 pstm.setString(1, gdto.getEmail());
		 pstm.setString(2, gdto.getSenha());
		 rset = pstm.executeQuery();
		 
		 while(rset.next()) {
			 g = new PessoaDTO();
			 g.setCargo(rset.getString("cargo"));
			 g.setId(rset.getInt("id"));
			 break;
		 }
		 
		 } catch (Exception e) {
			 
			 System.out.println("Erro!");
		 }
		 
		return g;
		
	}
	
	/** Metodo responsavel por deletar os funcionarios no banco de dados
	*/
	public void removerFuncionario(PessoaDTO gdto){
		 
		 String sql = "DELETE FROM funcionarios WHERE id = ?";
		 
		 try {
		 con = ConectaBd.conectabd();
		 
		 pstm = con.prepareStatement(sql);
		 
		 pstm.setInt(1, gdto.getId());
		 
		 pstm.execute();
		 
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	}
	
	/** Metodo responsavel por editar os dados dos funcionarios no banco de dados
	*/
	public void editar(PessoaDTO gdto){

		 String sql = "UPDATE funcionarios SET nome = ?, email = ?, cargo = ?, senha = ?, cpf = ?" +
		 " WHERE id = ?";

		 try {
		 //Cria uma conexão com o banco
		 con = ConectaBd.conectabd();

		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = con.prepareStatement(sql);

		 pstm.setString(1, gdto.getNome()); 
		 pstm.setString(2, gdto.getEmail());
		 pstm.setString(3, gdto.getCargo());
		 pstm.setString(4, gdto.getSenha());
		 pstm.setString(5, gdto.getCpf());

		 pstm.setInt(6, gdto.getId());
		 
		 pstm.execute();
		 
		 } catch (Exception e) {
			 
		 System.out.println("Erro!");
		 e.printStackTrace();
		 }
	}
	
	/** Metodo responsavel por recuperar  os dados dos funcionarios no banco de dados
	 * utilizando o id
	*/
	public PessoaDTO recuperarDados(PessoaDTO gdto) {
		
		String sql = "SELECT * FROM funcionarios WHERE id = ?";
		 
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 pstm.setInt(1, gdto.getId());
		 rset = pstm.executeQuery();
		 
		 while(rset.next()) {
			 g = new PessoaDTO();
			 g.setNome(rset.getString("nome"));
			 g.setEmail(rset.getString("email"));
			 g.setCargo(rset.getString("cargo"));
			 g.setSenha(rset.getString("senha"));
			 g.setCpf(rset.getString("cpf"));
			 break;
		 }
		 
		 } catch (Exception e) {
			 
			 System.out.println("Erro!");
		 }
		 
		return g;
	}

		
	public void adicionarIngrediente(IngredienteDTO idto) {
		
		String sql = "INSERT INTO ingrediente(nome,preco)" +
					 " VALUES(?,?)"; 
		 try {
			 
		con= ConectaBd.conectabd();
		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = con.prepareStatement(sql);
		
		 pstm.setString(1, idto.getNome());
		 pstm.setFloat(2, idto.getValor());
		
		 //Executa a sql para inserção dos dados
		 pstm.execute();
		 } catch (Exception e) {
			 System.out.println("Erro ao adicionar ingrediente!");
		 e.printStackTrace();
		 }
	}

	/**
	 * Metodo responsavel por recuperar os ingredientes do banco
	 */	
	public IngredienteDTO recuperarIngredientes() {
		 
		 String sql = "SELECT * FROM ingrediente";
		 
		 ArrayList<String> sabores = new ArrayList<>();
		 
		 try {
			 con= ConectaBd.conectabd();
		 pstm = con.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 while(rset.next()){
		 
		 sabores.add(rset.getString("nome"));
		 }
		 } catch (Exception e) {
		 
			 System.out.println("Erro ao recuperar ingredientes!");
		 }
		 
		 String[] sab = new String[sabores.size()];
		 
		 for (int i = 0; i < sabores.size(); i++) {
			sab[i]=sabores.get(i);
		}
		 IngredienteDTO i = new IngredienteDTO();
		 i.setSabores(sab);
		 return i;
		 }

	/** Metodo responsavel recuperar dados do ingrediente
	*/
	public IngredienteDTO recuperarIngrediente(IngredienteDTO idto) {
		
			String sql = "SELECT * FROM ingrediente WHERE nome = ?";
			 
			IngredienteDTO i = new IngredienteDTO();
			
			 try {
				 con= ConectaBd.conectabd();
			 pstm = con.prepareStatement(sql);
			 pstm.setString(1, idto.getNome());
			 rset = pstm.executeQuery();
								
			 while(rset.next()) {				 
				 i.setNome(rset.getString("nome"));
				 i.setValor(rset.getFloat("preco"));
				 break;
			 }
			 
			 } catch (Exception e) {
				 
				 System.out.println("Erro!");
			 }
			return i;			
	}

}

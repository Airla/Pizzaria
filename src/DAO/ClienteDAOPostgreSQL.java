package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DTO.ClienteDTO;

public class ClienteDAOPostgreSQL{
	
	private Connection con=null;
	private PreparedStatement pstm=null;

	/** Metodo adicionarCliente contem os codigos de persistencia em PostgreSQL
	 * é responsavel por salvar os clientes
	*/
	
	public void adicionarCliente(ClienteDTO cdto){
		
		String sql = null;

		sql = "INSERT INTO clientes(cpf,nome,rua, bairro, num_casa, telefone, id_atendente)" +
					 " VALUES(?,?,?,?,?,?,?)"; 
		 try {
				con= ConectaBd.conectabd();
		
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1,cdto.getCPF());
		pstm.setString(2, cdto.getNome());
		pstm.setString(3, cdto.getRua());
		pstm.setString(4, cdto.getBairro());
		pstm.setInt(5, cdto.getnCasa());
		pstm.setString(6, cdto.getTelefone());
		pstm.setInt(7, cdto.getCodigoFuncionario());
		
		pstm.execute();
		} catch (Exception e) {
		System.out.println("Erro ao cadastrar cliente!");
		e.printStackTrace();
		}
	}
	
}

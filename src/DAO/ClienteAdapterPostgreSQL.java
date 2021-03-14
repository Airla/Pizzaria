package DAO;

import DTO.ClienteDTO;





public class ClienteAdapterPostgreSQL extends ClienteDAOPostgreSQL implements ClienteDAO{
	
	/**
	 * Método adicionarCliente salva clientes no banco de dados PostgreSQL
	 */
	
	@Override	
	public void adicionarCliente(ClienteDTO cdto) {		
		
		super.adicionarCliente(cdto);
	}
}

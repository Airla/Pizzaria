package DAO;

import DTO.ClienteDTO;

public class ClienteAdapterXML extends ClienteDAOXML implements ClienteDAO{

	/**
	 * Método adicionarCliente salva clientes em XML
	 */
	
	@Override
	public void adicionarCliente(ClienteDTO cdto) {
		super.salvarCliente(cdto);
		
	}
	
}

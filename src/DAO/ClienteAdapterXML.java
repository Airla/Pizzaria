package DAO;

import DTO.ClienteDTO;

public class ClienteAdapterXML extends ClienteDAOXML implements ClienteDAO{

	/**
	 * M�todo adicionarCliente salva clientes em XML
	 */
	
	@Override
	public void adicionarCliente(ClienteDTO cdto) {
		super.salvarCliente(cdto);
		
	}
	
}

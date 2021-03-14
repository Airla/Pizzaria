package DAO;

import DTO.ClienteDTO;

public interface ClienteDAO {
	
	/**
	 * Classe ClienteDAO fornece uma interface unificada para qualquer adapter que implementa-la
	 */
	
	void adicionarCliente(ClienteDTO cdto);

}

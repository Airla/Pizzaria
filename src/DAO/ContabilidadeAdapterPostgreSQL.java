package DAO;

import DTO.ContabilidadeDTO;

public class ContabilidadeAdapterPostgreSQL extends ContabilidadeDAOPostgreSQL implements ContabilidadeDAO{
	
	@Override
	public ContabilidadeDTO dadosContabilidade() {

		return super.dadosContabilidade();
	}

}

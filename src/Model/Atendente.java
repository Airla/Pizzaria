package Model;

import DAO.PedidoAdapterPostgreSQL;
import DTO.PedidoDTO;

public class Atendente extends Funcionario{
	
	private PedidoAdapterPostgreSQL pAdapter = new PedidoAdapterPostgreSQL();

	public void cadastrarNovoPedido(PedidoDTO pdto) {		
		pAdapter.adicionarPedido(pdto);
	}
	
	public PedidoDTO getPedidos() {
		return pAdapter.getPedidos();
	}
}

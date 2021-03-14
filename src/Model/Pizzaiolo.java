package Model;

import DAO.PedidoAdapterPostgreSQL;
import DTO.PedidoDTO;

public class Pizzaiolo extends Funcionario {
	
	private PedidoAdapterPostgreSQL pAdapter = new PedidoAdapterPostgreSQL();
	
	public Pizzaiolo(String nome, String email, String senha, String confirmeSenha, String codigo, String cargo) {
		super(nome,email,senha, confirmeSenha, codigo, cargo);
	}
	
	public Pizzaiolo() {
	}

	public PedidoDTO getPedidos(){	
		return pAdapter.getPedidos();	
	}

	public void mudarStatusDoPedido (PedidoDTO pdto) {
		pAdapter.mudarStatusDoPedido(pdto);
	}
	
	public PedidoDTO pedidosPreparo() {
	return pAdapter.pedidosPreparo();
	}
	
}

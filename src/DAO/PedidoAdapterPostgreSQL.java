package DAO;

import DTO.PedidoDTO;

public class PedidoAdapterPostgreSQL extends PedidoDAOPostgreSQL implements PedidoDAO{

	public void adicionarPedido(PedidoDTO pdto) {
		super.adicionarPedido(pdto);
	}

	public PedidoDTO getPedidos() {
		return super.getPedidos();
	}

	public PedidoDTO pedidosEntrega() {
		return super.pedidosEntrega();
	}
	 
	public void mudarStatusDoPedido(PedidoDTO pdto) {
		super.mudarStatusDoPedido(pdto);
	}

	public void atudalizarPedidoMotoboy(PedidoDTO pdto) {
		super.atudalizarPedidoMotoboy(pdto);
	}

	public PedidoDTO pedidosPreparo() {
		return super.pedidosPreparo();
	}
}

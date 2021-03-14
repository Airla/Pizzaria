package DAO;

import DTO.PedidoDTO;

public interface PedidoDAO  {

	void adicionarPedido(PedidoDTO pdto);

	PedidoDTO getPedidos();

	PedidoDTO pedidosEntrega();
	 
	void mudarStatusDoPedido(PedidoDTO pdto);

	void atudalizarPedidoMotoboy(PedidoDTO pdto);

	PedidoDTO pedidosPreparo();

}

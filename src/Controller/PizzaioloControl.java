package Controller;

import DTO.PedidoDTO;
import Model.Pizzaiolo;

public class PizzaioloControl {
	
	private Pizzaiolo pizzaiolo = new Pizzaiolo();
	
	public PedidoDTO getEntregas(){	
		
		return pizzaiolo.pedidosPreparo();		
	}
	
	public void mudarStatusDoPedido (PedidoDTO pdto) {
		
		pizzaiolo.mudarStatusDoPedido(pdto);
	}

}

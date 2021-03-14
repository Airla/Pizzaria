package Controller;

import DTO.PedidoDTO;
import Model.Motoboy;

public class MotoboyControl {
	
	private Motoboy motoboy = new Motoboy();
	
	public PedidoDTO getEntregas(){
		return motoboy.pedidosEntrega();		
	}
	
	public void atualizarPedido(PedidoDTO pdto) {	
		motoboy.atudalizarPedidoMotoboy(pdto);
				
	}

}

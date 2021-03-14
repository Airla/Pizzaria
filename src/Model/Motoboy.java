package Model;

import DAO.PedidoAdapterPostgreSQL;
import DTO.PedidoDTO;

public class Motoboy extends Funcionario {
	
	private PedidoAdapterPostgreSQL pAdapter = new PedidoAdapterPostgreSQL();
	
	public Motoboy(String nome, String email, String senha, String confirmeSenha, String codigo, String cargo) {
		super(nome,email,senha, confirmeSenha, codigo, cargo);
	}
	
	public Motoboy() {
	}

	public PedidoDTO getPedidos(){
		return pAdapter.getPedidos();		
	}
	
	public void atudalizarPedidoMotoboy(PedidoDTO pdto) {
		pAdapter.atudalizarPedidoMotoboy(pdto);
	}
	
	public PedidoDTO pedidosEntrega() {
		return pAdapter.pedidosEntrega();
	}
	
}

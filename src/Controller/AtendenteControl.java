package Controller;

import DTO.ClienteDTO;
import DTO.PedidoDTO;
import DTO.PizzaDTO;
import Model.Atendente;
import Model.Cliente;
import Model.Gerente;
import Model.Pizza;

public class AtendenteControl {
	
	private Cliente cliente = new Cliente();
	private Atendente atendente = new Atendente();
	private Pizza pizza = new Pizza();
	
	public void adicionarPedido(PedidoDTO pdto) {
		atendente.cadastrarNovoPedido(pdto);
		pdto.setStatus("Preparo");
	} 
	
	public void adicionarCliente(ClienteDTO cdto) {		
		cliente.adicionarCliente(cdto);
	}
	
	public PedidoDTO total(PizzaDTO pdto) {

		float total=0;
		for (PizzaDTO p : pizza.getPizzas()) {
			for (String s : pdto.getSaboresDePizzas()) {
				if(p.getTipo().equalsIgnoreCase(s)) {
					total=total+p.getCustoFatia();
				}
			}
		}
		
		PedidoDTO pedidodto = new PedidoDTO();
		pedidodto.setTotal(total);
		
		return pedidodto;
	}
	
	public PedidoDTO getStatus(){	
		
		return atendente.getPedidos();		
	}
}

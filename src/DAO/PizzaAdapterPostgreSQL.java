package DAO;

import java.util.ArrayList;

import DTO.IngredienteDTO;
import DTO.PizzaDTO;

public class PizzaAdapterPostgreSQL extends PizzaDAOImplePostgreSQL implements PizzaDAO{

	public void criarPizza(PizzaDTO pdto, IngredienteDTO idto) {
		super.criarPizza(pdto, idto);
		
	}

	public void removerPizza(PizzaDTO pdto) {
		super.removerPizza(pdto);
		
	}

	public PizzaDTO dadosPizza(PizzaDTO pdto) {		
		return super.dadosPizza(pdto);
	}

	public ArrayList<PizzaDTO> getPizzas() {		
		return super.getPizzas();
	}

	public PizzaDTO getSaboresPizzas() {	
		return super.getSaboresPizzas();
	}

//	public IngredienteDTO ingredientePizza(IngredienteDTO idto) {		
//		return super.ingredientePizza(idto);
//	}

}

package DAO;

import java.util.ArrayList;

import DTO.IngredienteDTO;
import DTO.PizzaDTO;

public interface PizzaDAO {

	void criarPizza(PizzaDTO pdto, IngredienteDTO idto);

	void removerPizza(PizzaDTO pdto);

	PizzaDTO dadosPizza(PizzaDTO pdto);

	ArrayList<PizzaDTO> getPizzas();

	PizzaDTO getSaboresPizzas();
	
//	IngredienteDTO ingredientePizza(IngredienteDTO idto);

}

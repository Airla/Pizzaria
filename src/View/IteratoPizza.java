package View;

import java.util.ArrayList;

import DTO.PizzaDTO;

public class IteratoPizza implements Iterator{

	private ArrayList<PizzaDTO> pizzas;
	private int posicao=0;
	
	public IteratoPizza(ArrayList<PizzaDTO> pizzas) {
		this.pizzas = pizzas;
	}

	/**
	 * O método hasNext() determina se existem mais elementos para serem iterados
	 */
	@Override
	public boolean hasNext() {
		if(pizzas.size()<=posicao || pizzas.get(posicao)==null) {
			return false;
		}
		return true;
	}

	/**
	 * O método next() retorna o próximo objeto da iteração.
	 */
	@Override
	public Object next() {
		Object pizza = pizzas.get(posicao);
		posicao++;
		return pizza;
	}

}

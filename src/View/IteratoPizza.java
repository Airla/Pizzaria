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
	 * O m�todo hasNext() determina se existem mais elementos para serem iterados
	 */
	@Override
	public boolean hasNext() {
		if(pizzas.size()<=posicao || pizzas.get(posicao)==null) {
			return false;
		}
		return true;
	}

	/**
	 * O m�todo next() retorna o pr�ximo objeto da itera��o.
	 */
	@Override
	public Object next() {
		Object pizza = pizzas.get(posicao);
		posicao++;
		return pizza;
	}

}

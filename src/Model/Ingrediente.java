package Model;

import java.util.ArrayList;

public abstract class Ingrediente {

	private ArrayList<String> nomes = new ArrayList<>();
	private float preco;	
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Ingrediente() {
		
	}

	public ArrayList<String> getNomes() {
		return nomes;
	}

	public void setNomes(String nome) {
		nomes.add(nome);
	}
}

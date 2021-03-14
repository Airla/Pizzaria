package DTO;

import java.util.ArrayList;

import Model.Ingrediente;

public class IngredienteDTO {
	
	private String nome;
	private float valor;
	private String sabores[];
	private Ingrediente ingrediente;
	private ArrayList<String[]> ingredientes = new ArrayList<>();
	private ArrayList<String> nomeIngredientes = new ArrayList<>();
	
	public IngredienteDTO(String nome, float valor) {
		super();
		this.setNome(nome);
		this.setValor(valor);
	}

	public IngredienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String[] getSabores() {
		return sabores;
	}

	public void setSabores(String sabores[]) {
		this.sabores = sabores;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public ArrayList<String[]> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String[]> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public ArrayList<String> getNomeIngredientes() {
		return nomeIngredientes;
	}

	public void setNomeIngredientes(ArrayList<String> nomeIngredientes) {
		this.nomeIngredientes = nomeIngredientes;
	}

}

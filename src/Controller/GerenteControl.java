package Controller;

import java.util.ArrayList;

import DTO.ContabilidadeDTO;
import DTO.PessoaDTO;
import DTO.IngredienteDTO;
import DTO.PizzaDTO;
import Model.Adicional;
import Model.Contabilidade;
import Model.Gerente;
import Model.Ingrediente;
import Model.Massa;
import Model.Pizza;

public class GerenteControl {
	
	private Gerente gerente = new Gerente();
	private Contabilidade contabilidade = new Contabilidade();
	private Pizza pizza = new Pizza();
	private float totalPizza=5;
	
	public void adicionarFuncionario(PessoaDTO gdto) {
		
		gerente.adicionarFuncionario(gdto);	
		
	}

	public PessoaDTO recuperarFuncionario(PessoaDTO gdto) {
		
		return gerente.recuperarFuncionario(gdto);
	}
	
	public void removerFuncionario(PessoaDTO gdto) {
		
		gerente.removerFuncionario(gdto);
	}
	
	public PessoaDTO  getFuncionarios(){
		return  gerente.getFuncionarios();	
	}
	
	public void editar(PessoaDTO gdto) {
		
		gerente.editar(gdto);
	}
	
//	public PizzaDTO getPizzas(){	
//		
//		return pizza.getPizzas();		
//	}
	
	public ArrayList<PizzaDTO> getPizzas(){	
		
		return pizza.getPizzas();		
	}

	public PizzaDTO getSaboresPizzas(){	
		return pizza.getSaboresPizzas();		
	}
	
	public PizzaDTO dadosDaPizza(PizzaDTO pdto) {
		
		return pizza.dados(pdto);
	}
	
	public void criarPizza(PizzaDTO pdto, IngredienteDTO idto) {
	
		pizza.criarPizza(pdto, idto);
	}
	
	public ContabilidadeDTO dadosContabilidade() {
		
		return contabilidade.dadosContabilidade();
	}
	
	public void removerPizza(PizzaDTO pdto) {
		
		pizza.removerPizza(pdto);	
	}
	
	public PessoaDTO recuperarDados(PessoaDTO gdto) {
		return gerente .recuperarDados(gdto);
	}

	public void adicionarIngrediente(IngredienteDTO idto) {
		
		gerente.adicionarIngrediente(idto);
	}
	
	public IngredienteDTO recuperarIngredientes() {
		return gerente.recuperarIngredientes();
	}
	
	public IngredienteDTO recuperarIngrediente(IngredienteDTO idto) {
		return gerente.recuperarIngrediente(idto);
	}
	
	
	public IngredienteDTO decorator(IngredienteDTO idto) {	
		Ingrediente ingredientes = new Massa();
		for (String[] i : idto.getIngredientes()) {
			ingredientes = new Adicional(ingredientes, i[0], Float.parseFloat(i[1]));
		}
		
		idto.setValor(ingredientes.getPreco());
		idto.setNomeIngredientes(ingredientes.getNomes());
		return idto;
	}
	
	
	public IngredienteDTO removendoIngrediente(IngredienteDTO idto) {
		totalPizza = totalPizza - idto.getValor();		
		idto.setValor(totalPizza);
		return idto;
	}
	
	public float adicionandoIngredientes(IngredienteDTO idto) {
		totalPizza = totalPizza+idto.getValor();
		return totalPizza;
	}

	
}

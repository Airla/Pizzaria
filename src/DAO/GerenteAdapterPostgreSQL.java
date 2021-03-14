package DAO;

import DTO.IngredienteDTO;
import DTO.PessoaDTO;
public class GerenteAdapterPostgreSQL extends GerenteDAOPostgreSQL implements GerenteDAO{

	public void adicionarFuncionario(PessoaDTO gdto) {
		super.adicionarFuncionario(gdto);
	}

	public PessoaDTO recuperarFuncionario(PessoaDTO gdto) {

		return super.recuperarFuncionario(gdto);
	}

	public void removerFuncionario(PessoaDTO gdto) {
		
		super.removerFuncionario(gdto);
	}

	public void editar(PessoaDTO gdto) {
		
		super.editar(gdto);
	}

	public PessoaDTO getFuncionarios() {

		return super.getFuncionarios();
	}

	public PessoaDTO recuperarDados(PessoaDTO gdto) {

		return super.recuperarDados(gdto);
	}

	public void adicionarIngrediente(IngredienteDTO idto) {

		super.adicionarIngrediente(idto);
	}

	public IngredienteDTO recuperarIngredientes() {

		return super.recuperarIngredientes();
	}

	public IngredienteDTO recuperarIngrediente(IngredienteDTO idto) {

		return super.recuperarIngrediente(idto);
	}

}

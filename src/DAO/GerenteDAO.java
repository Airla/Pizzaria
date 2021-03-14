package DAO;

import DTO.PessoaDTO;
import DTO.IngredienteDTO;

public interface GerenteDAO {

	void adicionarFuncionario(PessoaDTO gdto);

	PessoaDTO recuperarFuncionario(PessoaDTO gdto);

	void removerFuncionario(PessoaDTO gdto);

	void editar(PessoaDTO gdto);

	PessoaDTO getFuncionarios();

	PessoaDTO recuperarDados(PessoaDTO gdto);

	void adicionarIngrediente(IngredienteDTO idto);
	
	IngredienteDTO recuperarIngredientes();
	
	IngredienteDTO recuperarIngrediente(IngredienteDTO idto);

}

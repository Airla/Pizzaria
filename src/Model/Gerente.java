package Model;


import DAO.GerenteAdapterPostgreSQL;
import DTO.PessoaDTO;
import DTO.IngredienteDTO;

public class Gerente extends Funcionario{
	
	/**
	 *  @param gAdapter recebe um adapter de gerente PostgreSQL
	 */
	private GerenteAdapterPostgreSQL gAdapter = new GerenteAdapterPostgreSQL();
	
	public Gerente(String nome, String email, String senha, String confirmeSenha, String codigo, String cargo) {
		super(nome,email,senha, confirmeSenha, codigo, cargo);
	}

	public Gerente() {
		
	}
	
	/**
	 * Métodos que enviam e recebem dados para um adapter
	 */
	
	public void adicionarFuncionario(PessoaDTO gdto) {
		gAdapter.adicionarFuncionario(gdto);			
	}
			
	public PessoaDTO recuperarFuncionario(PessoaDTO gdto) {
		
		return gAdapter.recuperarFuncionario(gdto);
	}
	
	public void removerFuncionario(PessoaDTO gdto) {
		gAdapter.removerFuncionario(gdto);
	}
	
	public PessoaDTO getFuncionarios(){
		return gAdapter.getFuncionarios();	
	}
	
	public void editar(PessoaDTO gdto) {
		gAdapter.editar(gdto);			
	}
	
	public PessoaDTO recuperarDados(PessoaDTO gdto) {
		return gAdapter.recuperarDados(gdto);
	}

	public void adicionarIngrediente(IngredienteDTO idto) {
		gAdapter.adicionarIngrediente(idto);
	}
	
	public IngredienteDTO recuperarIngredientes() {
		return gAdapter.recuperarIngredientes();
	}
	
	public IngredienteDTO recuperarIngrediente(IngredienteDTO idto) {
		return gAdapter.recuperarIngrediente(idto);
	}
	
}

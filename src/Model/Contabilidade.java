package Model;

import DAO.ContabilidadeAdapterPostgreSQL;
import DTO.ContabilidadeDTO;

public class Contabilidade {
	
	private int quantPizzasVendidasNoMes=0;
	private float lucroDoMes=0;
	private String saborMaisVendidoNoMes="";
	private ContabilidadeAdapterPostgreSQL cAdapter = new ContabilidadeAdapterPostgreSQL();
	
	public int getQuantPizzasVendidasNoMes() {
		return quantPizzasVendidasNoMes;
	}
	
	public void setQuantPizzasVendidasNoMes(int quantPizzasVendidasNoMes) {
		this.quantPizzasVendidasNoMes = quantPizzasVendidasNoMes;
	}
	
	public float getLucroDoMes() {
		return lucroDoMes;
	}
	
	public void setLucroDoMes(float lucroDoMes) {
		this.lucroDoMes = lucroDoMes;
	}
	
	public String getSaborMaisVendidoNoMes() {
		return saborMaisVendidoNoMes;
	}
	
	public void setSaborMaisVendidoNoMes(String saborMaisVendidoNoMes) {
		this.saborMaisVendidoNoMes = saborMaisVendidoNoMes;
	}
	
//	metodos pro controller
	
	public ContabilidadeDTO dadosContabilidade() {
		return cAdapter.dadosContabilidade();
		
	}

}

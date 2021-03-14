package Model;

import java.util.ArrayList;

import DAO.PizzaAdapterPostgreSQL;
import DTO.IngredienteDTO;
import DTO.PizzaDTO;

public class Pizza {
	
	private String tipo, tamanho, preparo, codigoFuncionario;
	private int codIdentificacao, quantFatias, quantVezesPedido;
	private float custo, custoFatia;
	private String[] saboresDePizzas;
	private int temperaturaForno, tempoNoFornoMinutos;
	private String tipoDeCaixa;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public int getCodIdentificacao() {
		return codIdentificacao;
	}

	public void setCodIdentificacao(int codIdentificacao) {
		this.codIdentificacao = codIdentificacao;
	}

	public int getQuantFatias() {
		return quantFatias;
	}

	public void setQuantFatias(int quantFatias) {
		this.quantFatias = quantFatias;
	}

	public int getQuantVezesPedido() {
		return quantVezesPedido;
	}

	public void setQuantVezesPedido(int quantVezesPedido) {
		this.quantVezesPedido = quantVezesPedido;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public float getCustoFatia() {
		return custoFatia;
	}

	public void setCustoFatia(float custoFatia) {
		this.custoFatia = custoFatia;
	}

	public String[] getSaboresDePizzas() {
		return saboresDePizzas;
	}

	public void setSaboresDePizzas(String[] saboresDePizzas) {
		this.saboresDePizzas = saboresDePizzas;
	}
	
	public int getTemperaturaForno() {
		return temperaturaForno;
	}

	public void setTemperaturaForno(int temperaturaForno) {
		this.temperaturaForno = temperaturaForno;
	}

	public String getTipoDeCaixa() {
		return tipoDeCaixa;
	}

	public void setTipoDeCaixa(String tipoDeCaixa) {
		this.tipoDeCaixa = tipoDeCaixa;
	}

	public int getTempoNoFornoMinutos() {
		return tempoNoFornoMinutos;
	}

	public void setTempoNoFornoMinutos(int tempoNoFornoMinutos) {
		this.tempoNoFornoMinutos = tempoNoFornoMinutos;
	}
	
	/**
	 * @param pAdapter recebe um adapter de pizza PostgreSQL
	 */
	private PizzaAdapterPostgreSQL pAdapter = new PizzaAdapterPostgreSQL();
	
	/**
	 * Métodos que enviam e recebem dados para um adapter
	 */
	
	public ArrayList<PizzaDTO> getPizzas(){
		return pAdapter.getPizzas();		
	}
	
	public PizzaDTO dados(PizzaDTO pdto) {		
		return pAdapter.dadosPizza(pdto);		
	}
	
	public void criarPizza(PizzaDTO pdto, IngredienteDTO idto) {
		
		pAdapter.criarPizza(pdto, idto);
	}
	
	public void removerPizza(PizzaDTO pdto) {
		pAdapter.removerPizza(pdto);
	}

	public PizzaDTO getSaboresPizzas() {
		return pAdapter.getSaboresPizzas();
	}
}

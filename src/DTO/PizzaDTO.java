package DTO;

import java.util.ArrayList;

public class PizzaDTO {

	private String tipo, tamanho, preparo, siglaEstado;
	private int codIdentificacao;
	private int quantFatias;
	private float custo, custoFatia;
	private int quantVezesPedido=0;
	private String codigoFuncionario;
	private String[] pizza;
	private ArrayList<PizzaDTO> pizzas = new ArrayList<>();
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
	public int getQuantVezesPedido() {
		return quantVezesPedido;
	}
	public void setQuantVezesPedido(int quantVezesPedido) {
		this.quantVezesPedido = quantVezesPedido;
	}
	public PizzaDTO() {
		
	}	
	
	public PizzaDTO(String tipo, String tamanho, String preparo,
			int quantFatias,float custoFatia, String codigoFuncionario) {
		super();
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.preparo = preparo;
		this.quantFatias = quantFatias;
		this.custoFatia = custoFatia;
		this.codigoFuncionario = codigoFuncionario;
	}
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public String[] getPizza() {
		return pizza;
	}
	public void setPizza(String[] pizza) {
		this.pizza = pizza;
	}
	public ArrayList<PizzaDTO> getPizzas() {
		return pizzas;
	}
//	public void setPizzas(ArrayList<String[]> pizzas) {
//		this.pizzas = pizzas;
//	}
	public String[] getSaboresDePizzas() {
		return saboresDePizzas;
	}
	public void setSaboresDePizzas(String[] saboresDePizzas) {
		this.saboresDePizzas = saboresDePizzas;
	}
	public void setPizzas(ArrayList<PizzaDTO> pizzas) {
		this.pizzas = pizzas;
		
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
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
	
}

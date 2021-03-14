package DTO;

import java.util.ArrayList;

public class PedidoDTO {
	private int  nPedido, quantFatias, nCasa;
	private String tamanho, status, codigoFuncionario, cpf, rua, bairro, sabores;
	private float valorDoPedido, total;
	private ArrayList<String[]> pedidos = new ArrayList<>();
	
	public int getnPedido() {
		return nPedido;
	}
	public void setnPedido(int nPedido) {
		this.nPedido = nPedido;
	}
	public int getQuantFatias() {
		return quantFatias;
	}
	public void setQuantFatias(int quantFatias) {
		this.quantFatias = quantFatias;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getValorDoPedido() {
		return valorDoPedido;
	}
	public void setValorDoPedido(float valorDoPedido) {
		this.valorDoPedido = valorDoPedido;
	}
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public PedidoDTO(int nPedido, int quantFatias, String sabores, String tamanho, String codigoFuncionario, String cpf,
			float valorDoPedido) {
		super();
		this.nPedido = nPedido;
		this.quantFatias = quantFatias;
		this.setSabores(sabores);
		this.tamanho = tamanho;
		this.codigoFuncionario = codigoFuncionario;
		this.cpf = cpf;
		this.valorDoPedido = valorDoPedido;
	}
	public PedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String[]> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<String[]> pedidos) {
		this.pedidos = pedidos;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getSabores() {
		return sabores;
	}
	public void setSabores(String sabores) {
		this.sabores = sabores;
	}
	public int getnCasa() {
		return nCasa;
	}
	public void setnCasa(int nCasa) {
		this.nCasa = nCasa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}	
	
}

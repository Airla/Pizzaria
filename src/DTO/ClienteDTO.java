package DTO;

import java.util.ArrayList;

public class ClienteDTO {

	private String nome;
	private String CPF;
	private String rua;
	private String bairro;
	private int nCasa;
	private String telefone;
	private int codigoFuncionario;
	private ArrayList<String[]> clientes = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getnCasa() {
		return nCasa;
	}
	public void setnCasa(int nCasa) {
		this.nCasa = nCasa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ClienteDTO(String nome, String cPF, String rua, String bairro, int nCasa, 
		String telefone, int codigoFuncionario) {		
		this.nome = nome;
		this.CPF = cPF;
		this.rua = rua;
		this.bairro = bairro;
		this.nCasa = nCasa;
		this.telefone = telefone;
		this.codigoFuncionario = codigoFuncionario;
	}
	public ClienteDTO() {
	}
	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public ArrayList<String[]> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<String[]> clientes) {
		this.clientes = clientes;
	}
		
}

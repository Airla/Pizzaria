package Model;

import DAO.ClienteAdapterPostgreSQL;
import DTO.ClienteDTO;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String rua;
	private String bairro;
	private String nCasa;
	private String telefone;
	private ClienteAdapterPostgreSQL cAdapter = new ClienteAdapterPostgreSQL();
	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getnCasa() {
		return nCasa;
	}

	public void setnCasa(String nCasa) {
		this.nCasa = nCasa;
	}

	public Cliente(String nome, String cpf, String rua, String bairro, String nCasa, String telefone) {
		this.nome = nome;
		this.CPF = cpf;
		this.setRua(rua);
		this.setBairro(bairro);
		this.setnCasa(nCasa);
	}
	
	//metodos para dao
	
	public Cliente() {
		
	}

	public void adicionarCliente(ClienteDTO cdto) {
		cAdapter.adicionarCliente(cdto);
	}
	
}

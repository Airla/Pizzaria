
package DTO;

import java.util.ArrayList;

public class PessoaDTO {

	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String cargo;
	private int id;
	private ArrayList<String[]> arraylist = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public PessoaDTO(String nome, String email, String senha, String confimarSenha,
			String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = confimarSenha;
		this.cargo = cargo;
	}
	
	public PessoaDTO() {
		
	}
	public ArrayList<String[]> getArrayList() {
		return arraylist;
	}
	public void setArrayList(ArrayList<String[]> arraylist) {
		this.arraylist = arraylist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

package Model;

public abstract class Funcionario {

	private String nome;
	private String email;
	private String senha;
	private String confimarSenha;
	private String codIdentificacao;
	private String cargo;	
		
	public String getCodIdentificacao() {
		return codIdentificacao;
	}

	public void setCodIdentificacao(String codigo) {
		this.codIdentificacao = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

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

	public String getConfimarSenha() {
		return confimarSenha;
	}

	public void setConfimarSenha(String confimarSenha) {
		this.confimarSenha = confimarSenha;
	}
	
	public Funcionario(String nome, String email, String senha, String confimarSenha, String codIdentificacao,
			String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.confimarSenha = confimarSenha;
		this.codIdentificacao = codIdentificacao;
		this.cargo = cargo;
	}
	
	public Funcionario() {
	}

}

package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.GerenteControl;
import DTO.PessoaDTO;

public class TelaEditarDadosDoFuncionario extends TelaPadrao{

	private JTextField nome;
	private JTextField email;
	private JPasswordField senha;
	private JFormattedTextField cpf;
	private int id;
	private int codigo;	
	private JComboBox<String> cargo;
	
	public TelaEditarDadosDoFuncionario(int  id,int codigo) {
		this.id = id;
		this.codigo = codigo;
		super.setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarJL();
		adicionarCamposDeTexto();
		adicionarBotoes();
		adicionarJComboBox();
		setVisible(true);
	}	
	
	private void adicionarJL() {
		
		AdicionarComponentes.jLabel(this, "Editar Dados Do Funcionário", 180, 20, 200, 50);
		
		AdicionarComponentes.jLabel(this, "Nome", 100, 70, 100, 20);
	    
		AdicionarComponentes.jLabel(this, "E-mail", 100, 110, 100, 20);
	    
		AdicionarComponentes.jLabel(this, "Senha", 100, 150, 100, 20);
		
		AdicionarComponentes.jLabel(this, "CPF", 100, 190, 140, 20);
	    
		AdicionarComponentes.jLabel(this, "Cargo", 100, 230, 140, 20);
	}
	
	private void adicionarCamposDeTexto(){
		
		GerenteControl gerenteControl = new GerenteControl();		
		PessoaDTO gdto = new PessoaDTO();
		gdto.setId(codigo);
		PessoaDTO dto = gerenteControl.recuperarDados(gdto);
		
		nome = AdicionarComponentes.jTextField(this, 150, 70, 180, 30);
		nome.setText(dto.getNome());
	    
	    email = AdicionarComponentes.jTextField(this, 150, 110, 180, 30);
	    email.setText(dto.getEmail());
	    
	    senha = AdicionarComponentes.jPasswordField(this, 150, 150, 180, 30);
	    senha.setText(dto.getSenha());
	    
	    cpf = new JFormattedTextField(dto.getCpf());
	    cpf.setBounds(150, 190, 180, 30);
	    add(cpf);		
	}
	
	private void adicionarBotoes() {	
		JButton botaoSalvar = AdicionarComponentes.botao(this, "Salvar", 100, 300, 100, 35);
	    botaoSalvar.addActionListener(new Ouvinte(this));

	    JButton botaoCancelar = AdicionarComponentes.botao(this, "Cancelar", 300, 300, 100, 35);
	    botaoCancelar.addActionListener(new Ouvinte(this));		
	}
	
	private void adicionarJComboBox() {	
		String[] opcoesCargo = {"Atendente", "Motoboy", "Pizzaiolo", "Serviços gerais", "Gerente"};
		cargo = AdicionarComponentes.jComboBox(this, opcoesCargo, 150, 230, 150, 30);
	}
	
	public class Ouvinte implements ActionListener{
		private TelaEditarDadosDoFuncionario telaEditarDados;
		
		public Ouvinte(TelaEditarDadosDoFuncionario telaEditarDados) {
			this.telaEditarDados = telaEditarDados;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String botao = e.getActionCommand();
			if(botao.equals("Cancelar")) {
				TelaFuncionarios telaFuncionarios = new TelaFuncionarios(id, codigo);
				telaFuncionarios.setLocationRelativeTo(telaEditarDados);
				telaEditarDados.dispose();
			}else if(botao.equals("Salvar")) {
				
				String nome = telaEditarDados.nome.getText();
				String email = telaEditarDados.email.getText();
				String senha = telaEditarDados.senha.getText();
				String confirmeSenha = telaEditarDados.cpf.getText();
				String clique = (String) cargo.getSelectedItem();
				String cargo = "";
				if(clique.equals("Atendente")) {
					cargo = "Atendente";
				}else if(clique.equals("Motoboy")) {
					cargo = "Motoboy";
				}else if(clique.equals("Pizzaiolo")) {
					cargo = "Pizzaiolo";
				}else if(clique.equals("Serviços gerais")) {
					cargo = "Serviços gerais";
				}else {
					cargo = "Gerente";
				}											
					GerenteControl gerenteControl = new GerenteControl();
					PessoaDTO gdto = new PessoaDTO(nome, email, senha, confirmeSenha, cargo);
					gdto.setId(codigo);
					gerenteControl.editar(gdto);
					JOptionPane.showMessageDialog(telaEditarDados, "Dados Atualizados", null, JOptionPane.INFORMATION_MESSAGE);
					TelaFuncionarios telaFuncionarios = new TelaFuncionarios(id, codigo);
					telaFuncionarios.setLocationRelativeTo(telaEditarDados);					telaEditarDados.dispose();					
			}
		}		
	}

	@Override
	public void adicionarComponentes() {
		
	}
}
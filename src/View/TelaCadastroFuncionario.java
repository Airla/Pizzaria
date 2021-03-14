package View;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.GerenteControl;
import DTO.PessoaDTO;

public class TelaCadastroFuncionario extends TelaPadrao{
	
	private JTextField nome;
	private JTextField login;
	private JPasswordField senha;
	private JFormattedTextField cpf;
	private String tela="";
	private int  id=0;
	private int codigo; 
	private JLabel olho;
	private JComboBox<String> cargo;
	
	public TelaCadastroFuncionario() {
		super.setTitle("Cadastrar Gerente");
		adicionarJL();
		adicionarCamposDeTexto();
		adicionarBotoes();
		adicionarJComboBox();
		setVisible(true);
	}

	public TelaCadastroFuncionario(int id, String tela, int codigo) {
		this.codigo = codigo;
		this.id = id;
		this.tela = tela;
		super.setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarJL();
		adicionarCamposDeTexto();
		adicionarBotoes();
		adicionarJComboBox();
		setVisible(true);
	}
	
	private void adicionarJL() {
		
		AdicionarComponentes.jLabel(this, "Nome", 20, 50, 100, 20);	
		
	    AdicionarComponentes.jLabel(this, "Login", 20, 90, 100, 20);
	    
	    AdicionarComponentes.jLabel(this, "Senha", 20, 130, 100, 20);
	    
	    AdicionarComponentes.jLabel(this, "CPF", 20, 170, 140, 20);
	    
	    AdicionarComponentes.jLabel(this, "Cargo", 20, 210, 100, 30);
	    
	    olho = AdicionarComponentes.jLabelComIcone(this, "olhofechado.png", 350, 130, 30, 20);
	    olho.addMouseListener(new OuvinteOlho());
	}
	
	private void adicionarCamposDeTexto(){
		
		nome = AdicionarComponentes.jTextField(this, 130, 50, 200, 30);
	    
	    login = AdicionarComponentes.jTextField(this, 130, 90, 200, 30);
	    
	    senha = AdicionarComponentes.jPasswordField(this, 130, 130, 200, 30);
	    
	    cpf = AdicionarComponentes.jFormattedTextField(this, "###.###.###-##", 130, 170, 200, 30);
	    		
	}
	
	private void adicionarBotoes() {
		JButton botaoCadastrar = AdicionarComponentes.botao(this, "Cadastrar", 130, 300, 100, 35);
	    botaoCadastrar.addActionListener(new OuvinteTelaDeCadastro(this));

	    JButton botaoCancelar = AdicionarComponentes.botao(this, "Cancelar", 280, 300, 100, 35);
	    botaoCancelar.addActionListener(new OuvinteTelaDeCadastro(this));		
	}
	
	private void adicionarJComboBox() {
		if(id!=0) {
			String[] opcoesCargo = {"Atendente", "Motoboy", "Pizzaiolo", "Serviços gerais", "Gerente"};
			cargo =  AdicionarComponentes.jComboBox(this, opcoesCargo, 130, 210, 150, 30);
		}else {
			String[] cargoGerente = {"Gerente"};
			AdicionarComponentes.jComboBox(this, cargoGerente, 130, 210, 150, 30);
		}
	}

	private class OuvinteOlho implements MouseListener {

		public void mouseClicked(MouseEvent e) {			
			if(senha.getEchoChar() == '•'){
				olho.setIcon(Icones.olhoAberto);
				olho.setToolTipText("Ocultar Senha");
				senha.setEchoChar((char) 0);
		}else{
			olho.setIcon(Icones.olhoFechado);
			olho.setToolTipText("Mostrar Senha");
			senha.setEchoChar('•');
			}	
		}

		public void mouseEntered(MouseEvent e) {
			olho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent arg0) {
		}

		public void mouseReleased(MouseEvent arg0) {
		}
	}
	
	public class OuvinteTelaDeCadastro implements ActionListener{
		private TelaCadastroFuncionario telaDeCadastro;
		public OuvinteTelaDeCadastro(TelaCadastroFuncionario telaDeCadastro) {
			this.telaDeCadastro = telaDeCadastro;
		}
		
		public void actionPerformed(ActionEvent e) {			
			String botao = e.getActionCommand();
			
			if(botao.equals("Cancelar")) {
				if(tela.equals("telaFuncionarios")) {
					
					TelaFuncionarios telaFuncionarios = new TelaFuncionarios(id, codigo);
					telaFuncionarios.setLocationRelativeTo(telaDeCadastro);
					telaDeCadastro.dispose();
				}else {
					TelaLogin telaDeLogin = new TelaLogin();
					telaDeLogin.setLocationRelativeTo(telaDeCadastro);
					telaDeCadastro.dispose();
				}				
			}else {			
				String nome = telaDeCadastro.nome.getText();
				String email = telaDeCadastro.login.getText();
				String senha = telaDeCadastro.senha.getText();
				String confirmeSenha = telaDeCadastro.cpf.getText();			
				String cargo1 = "";
				
				if(id!=0) {
					String clique = (String) cargo.getSelectedItem();				
					if(clique.equals("Atendente")) {
						cargo1 = "Atendente";
					}else if(clique.equals("Motoboy")) {
						cargo1 = "Motoboy";
					}else if(clique.equals("Pizzaiolo")) {
						cargo1 = "Pizzaiolo";
					}else if(clique.equals("Serviços gerais")) {
						cargo1 = "Serviços gerais";
					}else {
						cargo1 = "Gerente";
					}
				}else {
					cargo1="Gerente";
				}
				
				 PessoaDTO gdto = new PessoaDTO(nome, email, senha, confirmeSenha, cargo1);
				 GerenteControl gerenteControl = new GerenteControl();
				 gerenteControl.adicionarFuncionario(gdto);
				 JOptionPane.showMessageDialog(telaDeCadastro, "Funcionario cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
					if(tela.equals("telaFuncionarios")) {						
						TelaFuncionarios telaFuncionarios = new TelaFuncionarios(id, codigo);
						telaFuncionarios.setLocationRelativeTo(telaDeCadastro);
					}else {
						TelaLogin telaDeLogin = new TelaLogin();
						telaDeLogin.getCampoLogin().setText(email);
						telaDeLogin.setLocationRelativeTo(telaDeCadastro);
				}
					telaDeCadastro.dispose();
			}						
		}		
	}

	@Override
	public void adicionarComponentes() {
		
	}
}
package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.GerenteControl;
import DTO.PessoaDTO;

public class TelaLogin extends TelaPadrao {
	
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JLabel cadastrar;
	private JLabel olho;
	private JComboBox<String> estados;
	public JTextField getCampoLogin() {
		return campoLogin;
	}

	public void setCampoLogin(JTextField campoLogin) {
		this.campoLogin = campoLogin;
	}

	private void adicionarComponentesGraficos() {
		
		JPanel painel = new JPanel(null);
		
		JLabel label = AdicionarComponentes.jLabelComIcone(this, "user.png", 100, 10, 100, 100);		
		painel.add(label);
	    
		AdicionarComponentes.jLabel(painel, "Login", 10, 130, 40, 20);

		AdicionarComponentes.jLabel(painel, "Senha", 10, 180, 50, 20);
		
		campoLogin = AdicionarComponentes.jTextFieldPainel(painel, 60, 130, 200, 30);
		painel.add(campoLogin);

		campoSenha = AdicionarComponentes.jPasswordField(this, 60, 180, 200, 30);
		painel.add(campoSenha);
		
		JButton botaoEntrar = AdicionarComponentes.botaoPainel(painel, "Entrar", 160, 250, 100, 35);
		botaoEntrar.addActionListener(new Ouvinte(this));
		
		cadastrar = AdicionarComponentes.jLabel(this, "Cadastrar Gerente", 160, 220, 130, 20);
		cadastrar.setForeground(Color.BLUE);
		painel.add(cadastrar);
		cadastrar.addMouseListener(new OuvinteMouseListener(this));
		
		olho = AdicionarComponentes.jLabelComIcone(this, "olhofechado.png", "Mostrar Senha", 265, 180, 30, 20);
	    painel.add(olho);
	    olho.addMouseListener(new OuvinteMouseListener(this));
	   	    
	    JLabel labelEstados = AdicionarComponentes.jLabel(this, "Estado", 10, 220, 130, 20);
	    painel.add(labelEstados);
	    
	    painel.setBounds(160, 40, 300, 300);
	    painel.setBackground(Color.WHITE);
	    painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	    add(painel);
	}
	
	private class OuvinteMouseListener implements MouseListener {

		private TelaLogin login;

		public OuvinteMouseListener(TelaLogin login) {
			this.login = login;
		}
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == olho) {
				
				
				if(campoSenha.getEchoChar() == '•'){
					olho.setIcon(Icones.olhoAberto);
					olho.setToolTipText("Ocultar Senha");
					campoSenha.setEchoChar((char) 0);
			}else{
				olho.setIcon(Icones.olhoFechado);
				olho.setToolTipText("Mostrar Senha");
				campoSenha.setEchoChar('•');
				}
			}else {
				
				String codigoDeAcesso = JOptionPane.showInputDialog("Digite o código de acesso");
				if (codigoDeAcesso.equals("pizza")) {
					TelaCadastroFuncionario telaDeCadastro = new TelaCadastroFuncionario();
					telaDeCadastro.setLocationRelativeTo(login);
					login.dispose();
				} 
				else {
					JOptionPane.showMessageDialog(login, "Código inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
				
		}

		public void mouseEntered(MouseEvent e) {
			
			if(e.getSource() == olho) {
				olho.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else {
				cadastrar.setText("<html><u>Cadastrar Gerente</u></html>");
				cadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
		}

		public void mouseExited(MouseEvent e) {
			if(e.getSource() == cadastrar) {
				cadastrar.setText("Cadastrar Gerente");
				cadastrar.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
		}

		public void mousePressed(MouseEvent arg0) {}

		public void mouseReleased(MouseEvent arg0) {}
		
	}

	public class Ouvinte implements ActionListener {

		private TelaLogin Login;

		public Ouvinte(TelaLogin Login) {
			this.Login = Login;
		}

		public void actionPerformed(ActionEvent e) {
			String botao = e.getActionCommand();

			if (botao.equals("Entrar")) {
				String email = Login.campoLogin.getText();
				String senha = Login.campoSenha.getText();

				GerenteControl gerenteControl = new GerenteControl();
				PessoaDTO gdto = new PessoaDTO();
				gdto.setEmail(email);
				gdto.setSenha(senha);
				PessoaDTO dto = gerenteControl.recuperarFuncionario(gdto);
				try {
					String cargo = dto.getCargo();
					
					int codigo = dto.getId();
					if (email == null || senha == null) {
						JOptionPane.showMessageDialog(Login, "Preencha todas as informações corretamente!", "Erro!",
								JOptionPane.ERROR_MESSAGE);
					} else{
//						if (cargo.equalsIgnoreCase("Gerente")) {
//							TelaGerente telaDeTotalAcesso = new TelaGerente(id, codigo);
//							telaDeTotalAcesso.setLocationRelativeTo(Login);
//						} else if (cargo.equals("Pizzaiolo")) {
//							TelaPizzaiolo telaPizzaiolo = new TelaPizzaiolo(codigo);
//							telaPizzaiolo.setLocationRelativeTo(Login);
//						} else if (cargo.equals("Atendente")) {
//							TelaAtendente telaCriarPedido = new TelaAtendente(codigo);
//							telaCriarPedido.setLocationRelativeTo(Login);
//						} else if (cargo.equals("Motoboy")) {
//							TelaMotoBoy telaMotoBoy = new TelaMotoBoy(codigo);
//							telaMotoBoy.setLocationRelativeTo(Login);
//						}
						LogarFuncionarioSimpleFactory factory = new LogarFuncionarioSimpleFactory();
						factory.logarFuncionario(cargo, codigo);
						Login.dispose();
					}
					
				}
			catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Usuario não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public static void main(String[] args) {
		new TelaLogin();
	}

	@Override
	public void adicionarComponentes() {
		super.setTitle("Login");
		setSize(640, 420);
        JLabel imagemFundo = new JLabel(Icones.logo);
        imagemFundo.setBounds(0,0, 640, 420);
        setContentPane(imagemFundo);
        adicionarComponentesGraficos();
        setVisible(true);	
	}
}
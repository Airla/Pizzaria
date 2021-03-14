package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaGerente extends TelaPadrao{
	
	private int id;
	private int codigo;
	private JPanel painel;
	
	public TelaGerente(int codigo) {	
		this.codigo = codigo;
		this.id = codigo;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarJMenu(this);	
		adicionarBotao();		
		setVisible(true);
	}

	public TelaGerente(int codigo, int id) {	
		this.codigo = codigo;
		this.id = id;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarJMenu(this);	
		adicionarBotao();		
		setVisible(true);
	}
	
	private void adicionarBotao(){	
		
		JLabel texto = AdicionarComponentes.jLabel(this, "Gerência", 210, 15, 200, 50);
		texto.setFont(new Font("Segoe Print", Font.BOLD, 25));
		
		painel = new JPanel(new GridLayout(2, 4));
		
		Ouvinte ouvinte = new Ouvinte(this);
		
		
		JButton funcionarios = AdicionarComponentes.botaoPersoalisado(painel, Icones.funcionarios, "Funcionarios");
		funcionarios.addActionListener(ouvinte);
		
		JButton contabilidade = AdicionarComponentes.botaoPersoalisado(painel, Icones.contabilidade, "Contabilidade");
		contabilidade.addActionListener(ouvinte);	
		
		
		JButton pizzas = AdicionarComponentes.botaoPersoalisado(painel, Icones.pizza, "Pizzas");
		pizzas.addActionListener(ouvinte);	
		
		JButton ingredientes = AdicionarComponentes.botaoPersoalisado(painel, Icones.ingredientes, "Ingredientes");
		ingredientes.addActionListener(ouvinte);	

		JButton atendente = AdicionarComponentes.botaoPersoalisado(painel, Icones.atendente, "Atendente");
		atendente.addActionListener(ouvinte);
		
		JButton pizzaiolo = AdicionarComponentes.botaoPersoalisado(painel, Icones.chef, "Pizzaiolo");
		pizzaiolo.addActionListener(ouvinte);
		
		JButton motoboy = AdicionarComponentes.botaoPersoalisado(painel, Icones.entregador, "Entregador");
		motoboy.addActionListener(ouvinte);
		
		painel.setBounds(0, 80, 540, 200);
		painel.setBackground(Color.WHITE);
	    painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		add(painel);
	}
	
	private void adicionarJMenu(JFrame frame) {	
		JMenuItem sair = AdicionarComponentes.jManuSair(this, Icones.configuracoes);
		
		sair.addActionListener(new Ouvinte(this));
	}

	public class Ouvinte implements ActionListener{
		private TelaGerente telaDeTotalAcesso;
		
		public Ouvinte(TelaGerente telaDeTotalAcesso) {
			this.telaDeTotalAcesso = telaDeTotalAcesso;
		}
				
		public void actionPerformed(ActionEvent e) {
			String botao = e.getActionCommand();
			
			if(botao.equals("Sair")) {
				TelaLogin telaDeLogin = new TelaLogin();
				telaDeLogin.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();	
			}else if(botao.equals("Funcionarios")) {				
				TelaFuncionarios telaFuncionarios = new TelaFuncionarios(id, codigo);					
				telaFuncionarios.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Contabilidade")){					
				TelaContabilidade telaContabilidade = new TelaContabilidade(id, codigo);
				telaContabilidade.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Atendente")){					
				TelaAtendente telaCriarPedido = new TelaAtendente(id, codigo);
				telaCriarPedido.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Pizzaiolo")){					
				TelaPizzaiolo telaPizzaiolo = new TelaPizzaiolo(id, codigo);
				telaPizzaiolo.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Entregador")){					
				TelaMotoBoy telaMotoBoy = new TelaMotoBoy(id, codigo);
				telaMotoBoy.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Pizzas")){					
				TelaPizza telaPizza = new TelaPizza(id, codigo);
				telaPizza.setLocationRelativeTo(telaDeTotalAcesso);
				telaDeTotalAcesso.dispose();
			}else if(botao.equals("Ingredientes")){					
				TelaNovoIngrediente telaNovoIngrediente = new TelaNovoIngrediente();
				telaNovoIngrediente.setLocationRelativeTo(telaDeTotalAcesso);					
			}
							
		}		
	}							

	public static void main(String[] args) {
		new TelaGerente(10, 10);
	}

	@Override
	public void adicionarComponentes() {
		setSize(540, 420);
		JLabel imagemFundo = new JLabel(Icones.fundoGerente);
	    imagemFundo.setBounds(0,0, 700, 500);
	    setContentPane(imagemFundo);
	}

}
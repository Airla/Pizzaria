package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.AtendenteControl;
import Controller.GerenteControl;
import DTO.ClienteDTO;
import DTO.PedidoDTO;
import DTO.PizzaDTO;

public class TelaAtendente extends TelaPadrao{
	
	private static JTextField total;	
	private JComboBox<String> tamanho;
	private static String saboresDasPizzas;
	private JFormattedTextField cpfDoCliente;
	private int id=0;
	private int codigo;
	private JTabbedPane abas;	
	private JTextField nome;
	private JFormattedTextField CPF;
	private JFormattedTextField telefone;
	private JTextField rua;
	private JTextField bairro;
	private JTextField nCasa;

	public TelaAtendente(int codigo) {
		this.codigo = codigo;
		setTitle("Código do Atendente: "+Integer.toString(codigo));
		AbaDeNovoPedido();
		abaNovoCliente();
		adicionarJMenu(this);		
		setVisible(true);
	}

	public TelaAtendente(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		AbaDeNovoPedido();
		abaNovoCliente();
		adicionarJMenu(this);		
		setVisible(true);
	}

	private void adicionarJMenu(JFrame frame) {		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu();
		menu.setIcon(Icones.configuracoes);
		menuBar.add(menu);	
		
		
		JMenuItem sair = new JMenuItem("Sair");
		menu.add(sair);
		sair.addActionListener(new Ouvinte(this));
		setJMenuBar(menuBar);
		
		JMenuItem statusPedidos = new JMenuItem("Status Pedidos");
		menu.add(statusPedidos);
		statusPedidos.addActionListener(new Ouvinte(this));
		setJMenuBar(menuBar);
	}

	private void AbaDeNovoPedido() {					
		
		JPanel painelNovoPedido = new JPanel(null);
		
		AdicionarComponentes.jLabelPainel(painelNovoPedido, "Cardapio", 310, 0, 150, 20);
		
		AdicionarComponentes.jLabelPainel(painelNovoPedido, "Valor do Pedido", 210, 360, 200, 20);

		AdicionarComponentes.jLabelPainel(painelNovoPedido, "Tamanho da Pizza", 20, 270, 150, 30);
	
		AdicionarComponentes.jLabelPainel(painelNovoPedido, "CPF do Cliente", 210, 310, 200, 30);
		
		total = AdicionarComponentes.jTextFieldPainel(painelNovoPedido, 310, 360, 100, 30);
		total.setEditable(false);
		   
		cpfDoCliente = AdicionarComponentes.jFormattedTextFieldPainel(painelNovoPedido, "###.###.###-##", 310, 310, 120, 30);
		
		String[] opcoesTamanho = {"P", "M", "G"};
		tamanho = AdicionarComponentes.jComboBoxPainel(painelNovoPedido, opcoesTamanho, 20, 310, 110, 30);
		
		JButton botaoAdicionar = AdicionarComponentes.botaoComIconePaiel(painelNovoPedido, Icones.adiciona, "Adicionar Pedido", 500, 360, 150, 30);
	    botaoAdicionar.addActionListener(new Ouvinte(this));
	    
	    JButton sabores = AdicionarComponentes.botaoComIconePaiel(painelNovoPedido, Icones.pizza2, "Sabores", 20, 360, 110, 30);
	    sabores.addActionListener(new Ouvinte(this));
	    
	    DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		modelo.addColumn("Sabores");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Preço Fatia");
		modelo.addColumn("Preço Completa");
		
		JTable tabela = new JTable(modelo);
		
		GerenteControl gerenteControl = new GerenteControl();
		
		ArrayList<PizzaDTO> pizzas = gerenteControl.getPizzas();
		Iterator iterator = new IteratoPizza(pizzas);
		
		while(iterator.hasNext()){
			PizzaDTO p = (PizzaDTO) iterator.next();
			Object[] linha = {p.getTipo(), p.getTamanho(), p.getCustoFatia(), p.getCusto()};
			modelo.addRow(linha);
		}
//		for (String[] pizzas: gerenteControl.getPizzas().getPizzas()) {
//			Object[] linha = new Object[]{
//					pizzas[1],			
//					pizzas[2],
//					pizzas[5],
//					pizzas[4]				
//			};
//			modelo.addRow(linha);
//		}																	
			
		try {
			tabela.addRowSelectionInterval(0, 0);
		}catch (Exception e) {			
		}
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0, 20, 700, 200);
		painelNovoPedido.add(scroll);
        
		abas.addTab("Novo Pedido", painelNovoPedido);		
		abas.setBounds(0, 0, 700, 500);		
		add(abas);
	}
	
	private void abaNovoCliente(){
		JPanel painelNovoCliente = new JPanel(null);
		
		AdicionarComponentes.jLabelPainel(painelNovoCliente, "Nome", 20, 20, 100, 20);
	    
		AdicionarComponentes.jLabelPainel(painelNovoCliente, "CPF", 20, 60, 200, 20);
	    
		AdicionarComponentes.jLabelPainel(painelNovoCliente, "Telefone", 20, 100, 100, 20);
	    
	    AdicionarComponentes.jLabelPainel(painelNovoCliente, "Rua", 20, 140, 100, 20);
	    
	    AdicionarComponentes.jLabelPainel(painelNovoCliente, "Bairro", 20, 180, 100, 20);
	    
	    AdicionarComponentes.jLabelPainel(painelNovoCliente, "Número da casa", 20, 220, 150, 20);
	    
	    JButton criar = AdicionarComponentes.botaoPainel(painelNovoCliente, "Adicionar", 350, 220, 100, 35);
		criar.addActionListener(new Ouvinte(this));
		
		nome = AdicionarComponentes.jTextFieldPainel(painelNovoCliente, 140, 20, 180, 30);
	    
	    CPF = AdicionarComponentes.jFormattedTextFieldPainel(painelNovoCliente, "###.###.###-##", 140, 60, 180, 30);
	    
	    telefone = AdicionarComponentes.jFormattedTextFieldPainel(painelNovoCliente, "(##)#####-####", 140, 100, 180, 30);
	    
	    rua = AdicionarComponentes.jTextFieldPainel(painelNovoCliente, 140, 140, 180, 30);
	    
	    bairro = AdicionarComponentes.jTextFieldPainel(painelNovoCliente, 140, 180, 180, 30);
	    
	    nCasa = AdicionarComponentes.jTextFieldPainel(painelNovoCliente, 140, 220, 50, 30);
	    
	    abas.addTab("Novo Cliente", painelNovoCliente);	
	}
	
	public class Ouvinte implements ActionListener{
		private TelaAtendente telaCriarPedido;
		
		public Ouvinte(TelaAtendente telaCriarPedido) {
			this.telaCriarPedido = telaCriarPedido;
		}
				
		public void actionPerformed(ActionEvent e) {
			
			String botao = e.getActionCommand();
			
			 if(botao.equals("Sabores")) {
				String clique = (String) tamanho.getSelectedItem();
				if(clique.equals("P")) {
						TelaPizzaPequena pP = new TelaPizzaPequena();
						pP.setLocationRelativeTo(telaCriarPedido);							
					
				}else if(clique.equals("M")) {
					
						TelaPizzaMedia pM = new TelaPizzaMedia();
						pM.setLocationRelativeTo(telaCriarPedido);
					
					
				}else if(clique.equals("G")) {
					
						TelaPizzaGrande pG = new  TelaPizzaGrande();
						pG.setLocationRelativeTo(telaCriarPedido);							
				}
			}if(botao.equals("Adicionar Pedido")) {
				int quantFatias=0;
				float valor = 0;
				int numPedido=0;
				try {
					valor = Float.parseFloat(total.getText());
				}catch(NumberFormatException erro) {
					
				}
				
				String clique = (String) tamanho.getSelectedItem();
				String tamanho = "";
				if(clique.equals("P")) {
					tamanho = "Pequena";
					quantFatias=3;
				}else if(clique.equals("M")) {
					tamanho = "Média";
					quantFatias=4;
				}else if(clique.equals("G")) {
					tamanho = "Grande";
					quantFatias=5;
				}
				
				String cpf = telaCriarPedido.cpfDoCliente.getText();
				AtendenteControl atendenteControl = new AtendenteControl();
				PedidoDTO ptdo = new PedidoDTO(numPedido, quantFatias, saboresDasPizzas, tamanho, Integer.toString(codigo), cpf, valor);
				atendenteControl.adicionarPedido(ptdo);
				JOptionPane.showMessageDialog(telaCriarPedido, "Pedido adicionado!", "", JOptionPane.INFORMATION_MESSAGE);
				total.setText("");
			}else if(botao.equals("Adicionar")) {
				String nome = telaCriarPedido.nome.getText();
				String cpf = telaCriarPedido.CPF.getText();
				String rua = telaCriarPedido.rua.getText();
				String bairro = telaCriarPedido.bairro.getText();
				int nCasa = Integer.parseInt(telaCriarPedido.nCasa.getText());
				String telefone = telaCriarPedido.telefone.getText();
				
				AtendenteControl atendenteControl = new AtendenteControl();
				ClienteDTO ctdo = new ClienteDTO(nome, cpf, rua, bairro, nCasa, telefone, codigo);
				atendenteControl.adicionarCliente(ctdo);
				JOptionPane.showMessageDialog(telaCriarPedido, "Novo Cliente Adicionado!", "", JOptionPane.INFORMATION_MESSAGE);
				telaCriarPedido.nome.setText("");
				telaCriarPedido.CPF.setText("");
				telaCriarPedido.rua.setText("");
				telaCriarPedido.bairro.setText("");
				telaCriarPedido.nCasa.setText("");
				telaCriarPedido.telefone.setText("");
			}else if(botao.equals("Status Pedidos")) {
				
				if(id!=0) {
					TelaStatusPedidos tela = new TelaStatusPedidos(id, codigo);
					tela.setLocationRelativeTo(telaCriarPedido);
				}else {
					TelaStatusPedidos tela = new TelaStatusPedidos(codigo);
					tela.setLocationRelativeTo(telaCriarPedido);
				}																		
				telaCriarPedido.dispose();	
			}else if(botao.equals("Sair")) {
				
				if(id!=0) {
					TelaGerente telaDeTotalAcesso = new TelaGerente(id, codigo);
					telaDeTotalAcesso.setLocationRelativeTo(telaCriarPedido);
				}else {
					TelaLogin telaDeLogin = new TelaLogin();
					telaDeLogin.setLocationRelativeTo(telaCriarPedido);
				}																		
				telaCriarPedido.dispose();
				
			}
		}
	}
	
	public static String getSaboresDasPizzas() {
		return saboresDasPizzas;
	}

	public static void setSaboresDasPizzas(String saboresDasPizzas) {
		TelaAtendente.saboresDasPizzas = saboresDasPizzas;
	}

	public static JTextField getTotal() {
		return total;
	}

	public static void setTotal(JTextField total) {
		TelaAtendente.total = total;
	}
	
	
	public static void main(String[] args) {
		new TelaAtendente(12);
	}

	@Override
	public void adicionarComponentes() {
		abas = new JTabbedPane();
		setSize(700, 500);
	}

}
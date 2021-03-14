package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.PizzaioloControl;
import DTO.PedidoDTO;

public class TelaPizzaiolo extends TelaPadrao{
	
	private DefaultTableModel modelo;
	private JTable tabela;
	private int id;
	private int codigo;
	
	public TelaPizzaiolo (int codigo) {
		this.codigo = codigo;
		setTitle("Código do Pizzaiolo: "+Integer.toString(codigo));
		adicionarComponentesGraficos();
		adicionarJMenu();
		setVisible(true);
	}

	public TelaPizzaiolo(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarComponentesGraficos();
		setVisible(true);
	}
	
	public void adicionarJMenu() {
		
		JMenuItem sair = AdicionarComponentes.jManuSair(this, Icones.configuracoes);
		sair.addActionListener(new Ouvinte(this));
	}
	
	public class Ouvinte implements ActionListener{

		private TelaPizzaiolo telaPizzaiolo;
		
		public Ouvinte(TelaPizzaiolo telaPizzaiolo) {
			this.telaPizzaiolo = telaPizzaiolo;
		}
				
		public void actionPerformed(ActionEvent e) {
			
			String botao = e.getActionCommand();
			if(botao.equals("Sair")) {
				TelaLogin telaDeLogin = new TelaLogin();
				telaDeLogin.setLocationRelativeTo(telaPizzaiolo);
				telaPizzaiolo.dispose();
			}else if(botao.equals("Voltar")) {
				TelaGerente teladeTotalAcesso = new TelaGerente(id, codigo);
				teladeTotalAcesso.setLocationRelativeTo(telaPizzaiolo);
				telaPizzaiolo.dispose();
			}else if(botao.equals("Concluir")) {
				int linhaSelecionada =tabela.getSelectedRow();
				if(tabela.getSelectedRow()!=-1) {
					Object obj = tabela.getValueAt(tabela.getSelectedRow(),
							2);
					String str=String.valueOf(obj);
					
					PizzaioloControl pizzaioloControl = new PizzaioloControl();
					PedidoDTO pdto = new PedidoDTO();
					pdto.setnPedido(Integer.parseInt(str));
					obj = tabela.getValueAt(tabela.getSelectedRow(),
							3);
					str=String.valueOf(obj);
					pdto.setCpf(str);
					pizzaioloControl.mudarStatusDoPedido(pdto);
					modelo.removeRow(linhaSelecionada);
				}	
			}
		}
	}
	
	private void adicionarComponentesGraficos(){
		
		JLabel texto = AdicionarComponentes.jLabel(this, "Pedidos para Preparo", 170, 15, 350, 50);
		texto.setFont(new Font("Segoe Print", Font.BOLD, 25));
		
		JButton concluir = AdicionarComponentes.botao(this, "Concluir", 50, 300, 100, 35);
		concluir.addActionListener(new Ouvinte(this));
		
		if(id!=0) {
			JButton botaoVoltar = AdicionarComponentes.botao(this, "Voltar", 400, 300, 100, 35);
			botaoVoltar.addActionListener(new Ouvinte(this));
		}
		
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		PizzaioloControl pizzaioloControl = new PizzaioloControl();
		
		modelo.addColumn("Sabores");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Número do pedido");
		modelo.addColumn("cpf");
		tabela = new JTable(modelo);
		for (String[] pedidos : pizzaioloControl.getEntregas().getPedidos()) {
			Object[] linha = new Object[]{
			pedidos[2],
			pedidos[0],
			pedidos[1],
			pedidos[3]
				};
			modelo.addRow(linha);										
		}	
		
		try {
			tabela.addRowSelectionInterval(0, 0);
		}catch (Exception e) {				
		}
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0, 80, 630, 200);
		add(scroll);     
	}

	@Override
	public void adicionarComponentes() {
		setSize(630, 420);
		JLabel imagemFundo = new JLabel(Icones.fundoP);
	    imagemFundo.setBounds(0,0, 630, 420);
	    setContentPane(imagemFundo);
	}	
}
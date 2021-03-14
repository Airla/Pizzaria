package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.MotoboyControl;
import DTO.PedidoDTO;

public class TelaMotoBoy extends TelaPadrao{

	private DefaultTableModel modelo;
	private JTable tabela;
	private int id;
	private int codigo;
	
	public TelaMotoBoy(int codigo) {
		this.codigo = codigo;
		setTitle("Entregas Codigo do Motoboy: "+Integer.toString(codigo));
		adicionarJB();
		adicionarTabela(this);
		adicionarMenu();
		setVisible(true);
	}

	public TelaMotoBoy(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		setTitle("Entregas Codigo do gerente: "+Integer.toString(codigo));
		adicionarJB();
		adicionarTabela(this);
		adicionarMenu();
		setVisible(true);
	}

	private void adicionarMenu() {

		JMenuItem sair = AdicionarComponentes.jManuSair(this, Icones.configuracoes);
		sair.addActionListener(new Ouvinte(this));
	}

	private void adicionarTabela(JFrame frame) {
		
		JLabel texto = AdicionarComponentes.jLabel(this, "Pedidos para Entrega", 170, 15, 350, 50);
		texto.setFont(new Font("Segoe Print", Font.BOLD, 25));
		
		  modelo = new DefaultTableModel() {
		    	public boolean isCellEditable(int row, int column) {
				       return false;
				    }
		    };
		    modelo.addColumn("N. do Pedido");
			modelo.addColumn("Valor");
			modelo.addColumn("Nome");
			modelo.addColumn("Bairro");
			modelo.addColumn("Rua");
			modelo.addColumn("N. da casa");
						
			tabela = new JTable(modelo);
			MotoboyControl motoboyControl = new MotoboyControl();
			for (String[] pedido : motoboyControl.getEntregas().getPedidos()) {
					Object[] linha = new Object[]{
						pedido[1],
						pedido[0],
						pedido[2],
						pedido[3],
						pedido[4],
						pedido[5],
							};
							modelo.addRow(linha);																							
			}
			
			try {
				tabela.addRowSelectionInterval(0, 0);
			}catch(Exception e) {
				
			}		
			
			JScrollPane scroll = new JScrollPane(tabela);
			scroll.setBounds(0, 80, 630, 200);
			frame.add(scroll);		
	}
	
	private void adicionarJB() {	
		
		 JButton entregue = AdicionarComponentes.botaoComIcone(this, Icones.entregue, "Entregue", 150, 300, 100, 35);
	     entregue.addActionListener(new Ouvinte(this));	
	     
	     if(id!=0) {
				JButton botaoVoltar = AdicionarComponentes.botao(this, "Voltar", 400, 300, 100, 35);
				botaoVoltar.addActionListener(new Ouvinte(this));
			}
	}
	
	public class Ouvinte implements ActionListener{
		private TelaMotoBoy telaMotoBoy;
		
		public Ouvinte(TelaMotoBoy telaMotoBoy) {
			this.telaMotoBoy = telaMotoBoy;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String botao = e.getActionCommand();
			
			if(botao.equals("Entregue")) {
				int linhaSelecionada =tabela.getSelectedRow();
				if(tabela.getSelectedRow()!=-1) {
					Object obj = tabela.getValueAt(tabela.getSelectedRow(),
							0);
					String str=String.valueOf(obj);
					MotoboyControl motoboyControl = new MotoboyControl();
					PedidoDTO pdto = new PedidoDTO();
					pdto.setnPedido(Integer.parseInt(str));
					obj = tabela.getValueAt(tabela.getSelectedRow(),
							1);
					str=String.valueOf(obj);
					pdto.setValorDoPedido(Float.parseFloat(str));
					motoboyControl.atualizarPedido(pdto);
					modelo.removeRow(linhaSelecionada);	
				}
			}else if(botao.equals("Voltar")) {
				TelaGerente tela = new TelaGerente(id, codigo);
				tela.setLocationRelativeTo(telaMotoBoy);
				telaMotoBoy.dispose();
			}else if(botao.equals("Sair")) {
				TelaLogin telaDeLogin = new TelaLogin();
				telaDeLogin.setLocationRelativeTo(telaMotoBoy);
				telaMotoBoy.dispose();
			}
		}		
	}

	@Override
	public void adicionarComponentes() {
		setSize(630, 420);
		JLabel imagemFundo = new JLabel(Icones.fundoP);
	    imagemFundo.setBounds(0,0, 630, 420);
	    setContentPane(imagemFundo);	
	}
}
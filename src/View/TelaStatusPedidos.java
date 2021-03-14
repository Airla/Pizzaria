package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.AtendenteControl;

public class TelaStatusPedidos extends TelaPadrao {

	private int codigo;
	private int id=0;
	
	public TelaStatusPedidos(int codigo) {
		this.codigo = codigo;
		setTitle("Código do Atendente: "+Integer.toString(codigo));
		adicionarComponentesGraficos();
		setVisible(true);	
	}
	
	public TelaStatusPedidos(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
	}

	private void adicionarComponentesGraficos() {
		
		JButton botaoVoltar = AdicionarComponentes.botao(this, "Voltar", 450, 400, 100, 35);
		botaoVoltar.addActionListener(new Ouvinte(this));
		
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		modelo.addColumn("CPF do Cliente");
		modelo.addColumn("Número do Pedido");
		modelo.addColumn("Status do Pedido");
	
		JTable tabela = new JTable(modelo);
		while (tabela.getModel().getRowCount() > 0)
			modelo.removeRow(0);
		AtendenteControl atendenteControl = new AtendenteControl();
		for (String[] c: atendenteControl.getStatus().getPedidos()) {
			Object[] linha = new Object[]{
			c[2],
			c[0],
			c[1],				
			};
			modelo.addRow(linha);									
		}
		try {
			tabela.addRowSelectionInterval(0, 0);
		}catch (Exception e) {			
		}
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0, 0, 700, 350);
		add(scroll);
		
	}
	
	public class Ouvinte implements ActionListener{

		private TelaStatusPedidos janela;
		
		public Ouvinte(TelaStatusPedidos janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String botao = e.getActionCommand();
			
			if(botao.equals("Voltar")) {
				if(id!=0) {
					TelaAtendente tela = new TelaAtendente(id, codigo);
					tela.setLocationRelativeTo(janela);
				}else {
					TelaAtendente tela = new TelaAtendente(codigo);
					tela.setLocationRelativeTo(janela);
				}																		
				janela.dispose();
			}
		}
		
	}

	@Override
	public void adicionarComponentes() {
		setSize(700, 500);	
	}
}

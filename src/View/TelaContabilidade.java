package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.GerenteControl;

public class TelaContabilidade extends TelaPadrao{

	private int id;
	private int codigo;
	
	public TelaContabilidade(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarComponentesGraficos();
		setVisible(true);
	}
	
	private void adicionarComponentesGraficos() {
		
		AdicionarComponentes.jLabel(this, "Contabilidade", 220, 20, 100, 50);
		
	    JButton voltar = AdicionarComponentes.botaoComIcone(this, Icones.voltar, "Voltar", 350, 300, 100, 35);
	    voltar.addActionListener(new Ouvinte(this));
	     
		DefaultTableModel modelo = new DefaultTableModel() {
		    	public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
		    };
		    modelo.addColumn("Quant. Pizzas Vendidas no mês");
			modelo.addColumn("Lucro do Mês");
			modelo.addColumn("Sabor Mais Vendido");
			
			GerenteControl gerenteControl = new GerenteControl();
			
			String[] dados = gerenteControl.dadosContabilidade().getDados();
			JTable tabela = new JTable(modelo);	
			try {				
			
				Object[] linha = new Object[]{
						dados[0],
						dados[1],
						dados[2]
					};
					modelo.addRow(linha);
			
			
				tabela.addRowSelectionInterval(0, 0);
			}catch(Exception e) {
				
			}		
			JScrollPane scroll = new JScrollPane(tabela);
			scroll.setBounds(0, 80, 540, 100);
			add(scroll);
		
	}
	
	public class Ouvinte implements ActionListener{

		private TelaContabilidade telaContabilidade;
		
		public Ouvinte(TelaContabilidade telaContabilidade) {
			this.telaContabilidade = telaContabilidade;
		}
		public void actionPerformed(ActionEvent e) {
			TelaGerente telaDeTotalAcesso = new TelaGerente(id, codigo);
			telaDeTotalAcesso.setLocationRelativeTo(telaContabilidade);
			telaContabilidade.dispose();		
		}		
	}

	@Override
	public void adicionarComponentes() {
				
	}
}

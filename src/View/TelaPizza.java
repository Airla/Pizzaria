package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.GerenteControl;
import Controller.PizzaioloControl;
import DTO.PizzaDTO;

public class TelaPizza extends TelaPadrao{
	
	private int id;
	private int codigo;
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaPizza(int id, int codigo) {
		this.id = id;
		this.codigo = codigo;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarComponentesGraficos();
		setVisible(true);
	}

	private void adicionarComponentesGraficos() {
		
		Ouvinte ouvinte = new Ouvinte(this);
		
		JButton botaoEditar = AdicionarComponentes.botaoComIcone(this, Icones.editar, "Editar", 20, 280, 100, 30);
		botaoEditar.addActionListener(ouvinte);
		JButton botaoDeletar = AdicionarComponentes.botaoComIcone(this, Icones.lixo, "Deletar", 20, 320, 100, 30);
		botaoDeletar.addActionListener(ouvinte);
		JButton botaoAdicionar = AdicionarComponentes.botaoComIcone(this, Icones.adiciona, "Adicionar", 20, 360, 100, 30);
		botaoAdicionar.addActionListener(ouvinte);
		JButton botaoVoltar = AdicionarComponentes.botaoComIcone(this, Icones.voltar, "Voltar", 400, 320, 100, 35);
		botaoVoltar.addActionListener(ouvinte);
		
		JLabel texto = AdicionarComponentes.jLabel(this, "Pizzas", 270, 5, 80, 50);
		texto.setFont(new Font("Segoe Print", Font.BOLD, 25));
		texto.setForeground(Color.WHITE);
		
		modelo = new DefaultTableModel() {
	    	public boolean isCellEditable(int row, int column) {
			       return false;
			    }
	    };
	    modelo.addColumn("Id");
		modelo.addColumn("Sabores");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Preço por fatia");
		modelo.addColumn("Preço da pizza");
		
		tabela = new JTable(modelo);
		
		GerenteControl gerenteControl = new GerenteControl();
		
		Iterator iterator = new IteratoPizza(gerenteControl.getPizzas());
		
		while(iterator.hasNext()){
			PizzaDTO p = (PizzaDTO) iterator.next();
			Object[] linha = {p.getCodIdentificacao(), p.getTipo(), p.getTamanho(), p.getCustoFatia(), p.getCusto()};
			modelo.addRow(linha);
		}
//		for (String[] pizza : gerenteControl.getPizzas().getPizzas()) {
//			Object[] linha = new Object[]{
//				pizza[0],
//				pizza[1],
//				pizza[2],
//				pizza[5],
//				pizza[4]
//			};
//			modelo.addRow(linha);
//		}
		try {
			tabela.addRowSelectionInterval(0, 0);
		}catch(Exception e) {				
		}		
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0, 50, 630, 200);
		add(scroll);
		
	}

	private class Ouvinte implements ActionListener{

		private TelaPizza telaPizza;
		
		public Ouvinte(TelaPizza telaPizza) {
			this.telaPizza = telaPizza;
		}

		public void actionPerformed(ActionEvent e) {

			String botao = e.getActionCommand();
			
			if (botao.equals("Editar")) {
				TelaNovaPizza tela = new TelaNovaPizza(id, codigo);
				tela.setLocationRelativeTo(telaPizza);
				
				if(tabela.getSelectedRow()!=-1) {
					Object obj = tabela.getValueAt(tabela.getSelectedRow(),
							1);
					int codigo =Integer.parseInt(String.valueOf(obj));
					
				}
				
			}else if(botao.equals("Deletar")) {
				int linhaSelecionada =tabela.getSelectedRow();
				if(tabela.getSelectedRow()!=-1) {
					int apagar = JOptionPane.showConfirmDialog(telaPizza, "Tem certeza que deseja excluir este sabor de pizza?", null, JOptionPane.YES_NO_OPTION);
					if(apagar==JOptionPane.YES_OPTION) {
						GerenteControl gerenteControl = new GerenteControl();
						PizzaDTO pdto = new PizzaDTO();
						Object obj = tabela.getValueAt(tabela.getSelectedRow(),
								0);
						String codigo =String.valueOf(obj);
						pdto.setCodIdentificacao(Integer.parseInt(codigo));											
						gerenteControl.removerPizza(pdto);
						modelo.removeRow(linhaSelecionada);
						JOptionPane.showMessageDialog(telaPizza, "Sabor excluido!", null, JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}else if(botao.equals("Adicionar")) {
				TelaNovaPizza telaNovaPizza = new TelaNovaPizza(id, codigo);
				telaNovaPizza.setLocationRelativeTo(telaPizza);
				telaPizza.dispose();
			}else if(botao.equals("Voltar")) {
				TelaGerente telaGerente = new TelaGerente(id, codigo);
				telaGerente.setLocationRelativeTo(telaPizza);
				telaPizza.dispose();
			}else if(botao.equals("Forma de Preparo")) {
				if(tabela.getSelectedRow()!=-1) {
					Object obj = tabela.getValueAt(tabela.getSelectedRow(),
							0);
					int id =Integer.parseInt(String.valueOf(obj));
					
					
				}
				
			}
			
		}
		
	}

	@Override
	public void adicionarComponentes() {
		setSize(630, 450);
		JLabel imagemFundo = new JLabel(Icones.fundoPizza);
	    imagemFundo.setBounds(0,0, 700, 500);
	    setContentPane(imagemFundo);
	}
	
}

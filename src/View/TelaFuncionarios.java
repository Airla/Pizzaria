package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Controller.GerenteControl;
import DTO.PessoaDTO;

public class TelaFuncionarios extends TelaPadrao{
	
	private DefaultTableModel modelo;
	private JTable tabela;
	private int id;
	private int codigo;
	
	public TelaFuncionarios(int id, int codigo) {
		this.codigo = codigo;
		this.id = id;
		setTitle("Código do Gerente: "+Integer.toString(codigo));
		adicionarComponentesGraficos();;
		adicionarTabela(this);
		setVisible(true);
	}

	private void adicionarComponentesGraficos(){
		
		AdicionarComponentes.jLabel(this, "Funcionários", 220, 0, 100, 50);
		
		Ouvinte ouvinte = new Ouvinte(this);
		
		JButton aditarDados = AdicionarComponentes.botaoComIcone(this, Icones.editar, "Editar", 20, 260, 100, 30);
		aditarDados.addActionListener(ouvinte);
		
		JButton excluir = AdicionarComponentes.botaoComIcone(this, Icones.lixo, "Excluir", 20, 300, 100, 30);
		excluir.addActionListener(ouvinte);
		
		JButton criar = AdicionarComponentes.botaoComIcone(this, Icones.nvUsuario, "Novo", 20, 340, 100, 30);
		criar.addActionListener(ouvinte);
		
		JButton voltar = AdicionarComponentes.botaoComIcone(this, Icones.voltar, "Voltar", 350, 300, 100, 30);
	    voltar.addActionListener(ouvinte);	    		
	}
	
	private void adicionarTabela(JFrame frame) {		
		modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		modelo.addColumn("Nome");
		modelo.addColumn("Código de Identificação");
		modelo.addColumn("Cargo");
		tabela = new JTable(modelo);
		GerenteControl gerenteControl = new GerenteControl();
		for (String[] g: gerenteControl.getFuncionarios().getArrayList()) {
			Object[] linha = new Object[]{
					g[1], /*nome */
					g[0], /*codigo*/
					g[2]/*cargo*/
			};
			modelo.addRow(linha);
		}																				
		try {
			tabela.addRowSelectionInterval(0, 0);
		}catch(Exception e) {			
		}
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0, 50, 540, 200);
		scroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		frame.add(scroll);
	}
	
	public class Ouvinte implements ActionListener {
		private TelaFuncionarios telaFuncionarios;
		
		public Ouvinte(TelaFuncionarios telaFuncionarios) {
			this.telaFuncionarios = telaFuncionarios;
		}
		public void actionPerformed(ActionEvent e) {
			String botao = e.getActionCommand();
			
			if(botao.equals("Voltar")) {
				TelaGerente telaDeTotalAcesso = new TelaGerente(id, codigo);
				telaDeTotalAcesso.setLocationRelativeTo(telaFuncionarios);
				telaFuncionarios.dispose();
			}else if(botao.equals("Novo")) {
				TelaCadastroFuncionario telaDeCadastro = new TelaCadastroFuncionario(id,"telaFuncionarios", codigo);
				telaDeCadastro.setLocationRelativeTo(telaFuncionarios);
				telaFuncionarios.dispose();
			}else if(botao.equals("Excluir")) {
				int linhaSelecionada =tabela.getSelectedRow();
				if(tabela.getSelectedRow()!=-1) {
					int apagar = JOptionPane.showConfirmDialog(telaFuncionarios, "Você tem certeza que deseja excluir este funcionario?", null, JOptionPane.YES_NO_OPTION);
					if(apagar==JOptionPane.YES_OPTION) {
						if(tabela.getSelectedRow()!=-1) {
							Object obj = tabela.getValueAt(tabela.getSelectedRow(),
									1);
							String codigo =String.valueOf(obj);			
						GerenteControl gerenteControl = new GerenteControl();
						PessoaDTO gdto = new PessoaDTO();
						gdto.setId(Integer.parseInt(codigo));
						gerenteControl.removerFuncionario(gdto);					
						modelo.removeRow(linhaSelecionada);
						JOptionPane.showMessageDialog(telaFuncionarios, "Funcionario excluido!", null, JOptionPane.INFORMATION_MESSAGE);					
						}					
					}
				}
			}else if(botao.equals("Editar")) {
				if(tabela.getSelectedRow()!=-1) {
					Object obj = tabela.getValueAt(tabela.getSelectedRow(),
							1);
					int codigo =Integer.parseInt(String.valueOf(obj));
					TelaEditarDadosDoFuncionario telaEditarDados = new TelaEditarDadosDoFuncionario(codigo, id);
					telaEditarDados.setLocationRelativeTo(telaFuncionarios);
					telaFuncionarios.dispose();
			}
		}		
	}
	
	}

	@Override
	public void adicionarComponentes() {
		
	}
}
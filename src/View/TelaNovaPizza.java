package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Controller.GerenteControl;
import DTO.IngredienteDTO;
import DTO.PizzaDTO;

public class TelaNovaPizza extends TelaPadrao{
	
	private DefaultTableModel modelo;
	private JTable tabela;
	private JTextField tipo;
	private JComboBox<String> tamanho;
	private JComboBox<String> nomeIngredientes;
	private JTextField custoF;
	private JTextField custoP;	
	private JTextArea preparo;
	private int id;
	private int cod;
	private IngredienteDTO idto = new IngredienteDTO();
	private GerenteControl gerenteControl = new GerenteControl();
	
	public TelaNovaPizza(int id, int codigo) {
		this.cod = codigo;
		this.id = id;
		adicionarJL();
		adicionarCamposDeTexto();
		adicionarJTA();
		adicionarBotoes();
		adicionarComboBox();
		adicionarTabela(this);
		setVisible(true);
	}

	private void adicionarJL() {
		
		JLabel tipo = AdicionarComponentes.jLabel(this, "Nome:", 10, 20, 100, 20);
		tipo.setForeground(Color.BLACK);
	    
		AdicionarComponentes.jLabel(this, "Tamanho:", 200, 20, 100, 20);
		
		AdicionarComponentes.jLabel(this, "Modo de Preparo:", 450, 20, 200, 20);
	    
	    AdicionarComponentes.jLabel(this, "Ingredientes:", 10, 100, 100, 20);
	    
	    AdicionarComponentes.jLabel(this, "Custo da Pizza:", 430, 300, 150, 20);
	    
	    AdicionarComponentes.jLabel(this, "Custo por Fatia:", 430, 350, 150, 20);	    
	}
	
	private void adicionarCamposDeTexto(){
		tipo = AdicionarComponentes.jTextField(this, 10, 50, 150, 30);
	    
	    custoP = AdicionarComponentes.jTextField(this, 550, 300, 100, 30);
	    
	    custoF = AdicionarComponentes.jTextField(this, 550, 350, 100, 30);
	}
	
	private void adicionarJTA() {
		preparo = new JTextArea();
		preparo.setLineWrap(true);
		preparo.setWrapStyleWord(true);
		preparo.setEditable(true);
		JScrollPane scroll = new JScrollPane(preparo);
		scroll.getVerticalScrollBarPolicy(); scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		scroll.setBounds(400, 50, 200, 150);
		add(scroll);
		
	}
	
		private void adicionarBotoes() {
		
		 JButton criar = AdicionarComponentes.botaoComIcone(this, Icones.pizza2, "Criar", 400, 400, 100, 30);
		 criar.addActionListener(new OuvinteCriar(this));
			
		 Ouvinte ouvinte = new Ouvinte(this);
		 
		 JButton voltar = AdicionarComponentes.botaoComIcone(this, Icones.voltar, "Voltar", 550, 400, 100, 30);
	     voltar.addActionListener(ouvinte);	
	     
	     JButton remover = AdicionarComponentes.botaoComIcone(this, Icones.lixo, "Excluir", 10, 400, 100, 30);
	     remover.addActionListener(ouvinte);	
	     
	     JButton adicionar = AdicionarComponentes.botaoComIcone(this, Icones.adiciona, "Adicionar", 200, 130, 120, 30);
	     adicionar.addActionListener(ouvinte);	
	}

		private void adicionarComboBox() {
			
			String[] opcoesTamanho = {"P (3)", "M (4)", "G (5)"};
			tamanho = AdicionarComponentes.jComboBox(this, opcoesTamanho, 200, 50, 120, 30);
		    
		    nomeIngredientes = AdicionarComponentes.jComboBox(this, gerenteControl.recuperarIngredientes().getSabores(), 10, 130, 150, 30);
		}
		 
		public class OuvinteCriar implements ActionListener{

			private TelaNovaPizza novaPizza;
			
			public OuvinteCriar(TelaNovaPizza novaPizza) {
				this.novaPizza = novaPizza;
			}
			
			public void actionPerformed(ActionEvent e) {
				String tipo = novaPizza.tipo.getText();
				String clique = (String) tamanho.getSelectedItem();
				String tamanho = "";
				int quantFatias = 0;
				
				if(clique.equals("P (3)")) {
					quantFatias = 3;
					tamanho = "Pequena";
				}else if(clique.equals("M (4)")) {
					quantFatias = 4;
					tamanho = "Média";
				}else if(clique.equals("G (5)")) {
					quantFatias = 5;
					tamanho = "Grande";
				}				
				String preparo = novaPizza.preparo.getText();		
				boolean valorN = false;
				float custoFatia = 0;			
					try {			
						custoFatia = Float.parseFloat(novaPizza.custoF.getText());
						valorN=true;
					}catch(NumberFormatException erro) {
						valorN=false;
					}
				
				PizzaDTO pdto = new PizzaDTO(tipo, tamanho, preparo,
				quantFatias, custoFatia, Integer.toString(cod));
				for(int i=0; i<tabela.getModel().getRowCount(); i++) {
					String[] ingrediente = new String[2];
					ingrediente[0]=String.valueOf(tabela.getValueAt(i, 0));
					ingrediente[1]=String.valueOf(tabela.getValueAt(i, 1));
					idto.getIngredientes().add(ingrediente);
				}
				/*
				 * aqui eu chamo o metodo q faz decorator, ele ta no controler, ele retorna um dto(no metodo eu explico) 
				 * 
				 */
				IngredienteDTO ingreDTO = gerenteControl.decorator(idto);
				//crio a pizza que tem a pizzadto e i ingredientedto(resultado do decorator)
				gerenteControl.criarPizza(pdto, ingreDTO);
				JOptionPane.showMessageDialog(novaPizza, "Novo sabor de pizza adicionado", null, JOptionPane.INFORMATION_MESSAGE);
				TelaPizza tela = new TelaPizza(id, cod);
				tela.setLocationRelativeTo(novaPizza);
				novaPizza.dispose();
			}		
			
		}
		
		private void adicionarTabela(JFrame frame) {
			
			modelo = new DefaultTableModel() {
				public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
			};
			modelo.addColumn("Nome");
			modelo.addColumn("Preço");
			
			tabela = new JTable(modelo);
		
			JScrollPane scroll = new JScrollPane(tabela);
			scroll.setBounds(10, 230, 320, 150);
			frame.add(scroll);
		}
		
		public class Ouvinte implements ActionListener{

			private TelaNovaPizza telaNovaPizza;
			
			public Ouvinte(TelaNovaPizza telaNovaPizza) {
				this.telaNovaPizza = telaNovaPizza;
			}


			public void actionPerformed(ActionEvent e) {
				String botao = e.getActionCommand();
				
				if(botao.equals("Adicionar")) {
					
					idto.setNome(nomeIngredientes.getSelectedItem().toString());
					IngredienteDTO i= gerenteControl.recuperarIngrediente(idto);
					modelo = (DefaultTableModel) tabela.getModel();	
					float valor= i.getValor();
					modelo.addRow(new String[] {i.getNome(), Float.toString(valor)});
					float valorPizza= gerenteControl.adicionandoIngredientes(i);
					custoP.setText(Float.toString(valorPizza));	
					
					
					String clique = (String) tamanho.getSelectedItem();					
					if(clique.equals("P (3)")) {
						custoF.setText(Float.toString(valorPizza/3));
					}else if(clique.equals("M (4)")) {
						custoF.setText(Float.toString(valorPizza/4));
					}else if(clique.equals("G (5)")) {
						custoF.setText(Float.toString(valorPizza/5));
					}
					
				}else if(botao.equals("Excluir")) {
					int linhaSelecionada =tabela.getSelectedRow();
					
					if(tabela.getSelectedRow()!=-1) {
						Object obj = tabela.getValueAt(tabela.getSelectedRow(), 0);
						Object obj2 = tabela.getValueAt(tabela.getSelectedRow(), 1);
						
						IngredienteDTO i= new IngredienteDTO();
						i.setNome(String.valueOf(obj));
						i.setValor(Float.parseFloat(String.valueOf(obj2))); 

						IngredienteDTO ing = gerenteControl.removendoIngrediente(i);

						custoP.setText(Float.toString(ing.getValor()));	
						
						modelo.removeRow(linhaSelecionada);
					}
				}else {
					TelaPizza telaDeTotalAcesso = new TelaPizza(id, cod);
					telaDeTotalAcesso.setLocationRelativeTo(telaNovaPizza);
					telaNovaPizza.dispose();
				}
			}	
		}

		@Override
		public void adicionarComponentes() {
			setTitle("Criar Novo Sabor De Pizza");
			setSize(700, 500);
			JLabel imagemFundo = new JLabel(Icones.fundoCriarPizza);
		    imagemFundo.setBounds(0,0, 700, 500);
		    setContentPane(imagemFundo);
		}
}

package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.GerenteControl;
import DTO.IngredienteDTO;

public class TelaNovoIngrediente extends JDialogo{
	
	private JTextField t1;
	private JTextField t2;
	
	public TelaNovoIngrediente() {
		setTitle("Cadastrar Ingrediente");		
		adicionarJLabel();
		adicionarCamposDeTexto();
		adicionarBotoes();
		setVisible(true);
	}
	
	public void adicionarJLabel() {	
		AdicionarComponentes.jLabel(this, "Nome", 10, 30, 40, 20);
	    
		AdicionarComponentes.jLabel(this, "Valor", 10, 80, 40, 20);
	}
	
	private void adicionarCamposDeTexto() {
		t1 = new JTextField();
	    t1.setBounds(50, 30, 150, 30);
	    add(t1);
	     
	    t2 = new JTextField();
	    t2.setBounds(50, 80, 150, 30);
	    add(t2);
	}
	
	private void adicionarBotoes() {
		
		JButton b1 = AdicionarComponentes.botao(this, "Adicionar", 20, 150, 100, 30);
	    b1.addActionListener(new Ouvinte(this));
	     
	    JButton b2 = AdicionarComponentes.botao(this, "Cancelar", 160, 150, 100, 30);
	    b2.addActionListener(new Ouvinte(this));	     
	}
	
	public class Ouvinte implements ActionListener{

		private TelaNovoIngrediente telaNovoIngrediente;

		public Ouvinte(TelaNovoIngrediente telaNovoIngrediente) {
				this.telaNovoIngrediente = telaNovoIngrediente;
			}
			 
			public void actionPerformed(ActionEvent e) {
			 String botao = e.getActionCommand();
				   
			 	if(botao.equals("Adicionar")) {
					String nome = telaNovoIngrediente.t1.getText();
					float valor = Float.parseFloat(telaNovoIngrediente.t2.getText());							
					
					GerenteControl gerenteControl = new GerenteControl();
					IngredienteDTO idto = new IngredienteDTO(nome, valor);				
					gerenteControl.adicionarIngrediente(idto);
					
					JOptionPane.showMessageDialog(null, "Ingrediente adicionado!"); 
					t1.setText(null);
					t2.setText(null);
				   }else {
					   telaNovoIngrediente.dispose();
				  }
			}
	}
}

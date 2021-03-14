package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Controller.AtendenteControl;
import Controller.GerenteControl;
import DTO.PizzaDTO;

public class TelaPizzaGrande extends JDialogo{
	
	private GerenteControl control = new GerenteControl();	
	private JComboBox<String> opcao1;
	private JComboBox<String> opcao2;
	private JComboBox<String> opcao3;
	private JComboBox<String> opcao4;
	private JComboBox<String> opcao5;
	
	public TelaPizzaGrande() {
		setSize(300, 280);
		setTitle("Pizza Grande");
        adicionarComponentes();
        setVisible(true);
    }

	private void adicionarComponentes() {
		
		AdicionarComponentes.jLabel(this, "Sabor Um", 20, 10, 100, 20);
	    
		AdicionarComponentes.jLabel(this, "Sabor Dois", 20, 50, 100, 20);
		
		AdicionarComponentes.jLabel(this, "Sabor Três", 20, 90, 100, 20);
	    
		AdicionarComponentes.jLabel(this, "Sabor Quatro", 20, 130, 100, 20);
		
		AdicionarComponentes.jLabel(this, "Sabor Cinco", 20, 170, 100, 20);
		
		JButton salvar = AdicionarComponentes.botao(this, "Salvar", 20, 210, 100, 35);
		salvar.addActionListener(new Ouvinte(this));	
		
		JButton cancelar = AdicionarComponentes.botao(this, "Cancelar", 170, 210, 100, 35);
		cancelar.addActionListener(new Ouvinte(this));	
		
		String sabores[]=control.getSaboresPizzas().getSaboresDePizzas();
		
		opcao1 = AdicionarComponentes.jComboBox(this, sabores, 100, 10, 150, 30);
		
		opcao2 = AdicionarComponentes.jComboBox(this, sabores, 100, 50, 150, 30);
		
		opcao3 = AdicionarComponentes.jComboBox(this, sabores, 100, 90, 150, 30);
		
		opcao4 = AdicionarComponentes.jComboBox(this, sabores, 100, 130, 150, 30);
		
		opcao5 = AdicionarComponentes.jComboBox(this, sabores, 100, 170, 150, 30);
	}
	
	public class Ouvinte implements ActionListener{
		private TelaPizzaGrande pizzaGrande;
		
		public Ouvinte(TelaPizzaGrande pizzaGrande) {
			this.pizzaGrande = pizzaGrande;
		}
		
		public void actionPerformed(ActionEvent e) {
			String botao = e.getActionCommand();
			if(botao.equals("Salvar")) {
				String sabores = opcao1.getSelectedItem().toString()+" "+opcao2.getSelectedItem().toString()+" "+opcao3.getSelectedItem().toString()+" "+opcao4.getSelectedItem().toString()+" "+opcao5.getSelectedItem().toString();			
				String[] nSabores = sabores.split(" ");
				float total = 0;
				
				AtendenteControl atendenteControl = new AtendenteControl();			
				PizzaDTO pdto = new PizzaDTO();
				pdto.setSaboresDePizzas(nSabores);
				total = atendenteControl.total(pdto).getTotal();
				dispose();
				
				TelaAtendente.setSaboresDasPizzas(sabores);
				TelaAtendente.getTotal().setText(Float.toString(total));						
			}else {
				
			}
			pizzaGrande.dispose();		
		}
	}
}

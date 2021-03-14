package View;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class TelaPadrao extends JFrame {
	
	public TelaPadrao() {
		setSize(540, 420);
		metodoPadrao();  
    }
	public final void metodoPadrao() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
 
        try {
        	String tema =  "com.jtattoo.plaf.mint.MintLookAndFeel";
            UIManager.setLookAndFeel(tema);
        } catch (InstantiationException | IllegalAccessException  |
                     UnsupportedLookAndFeelException | ClassNotFoundException e) {
            System.out.println("Erro LAF : " + e.getMessage());
        }
        adicionarComponentes();       
	}
	
	public abstract void adicionarComponentes();
	
//	public void windowClosing(WindowEvent evt) 
//	{  e n faz sentido pq a gente n chama o metodo e eu n sei onde chamar isso
//	ConectaBd.desconectabd();
//	System.out.println("fechou eu acho n kkk tinha caido anet ha");
//	System.exit(0); 
//	} 

}
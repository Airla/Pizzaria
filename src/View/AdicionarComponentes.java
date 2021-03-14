package View;

import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class AdicionarComponentes{

	public static JButton botaoComIcone(JFrame janela, ImageIcon icone, String nomeBotao, int x, int y, int w, int h ) {
		JButton botao = new JButton(nomeBotao);
		botao.setBounds(x, y, w, h);
		botao.setIcon(icone);
		janela.add(botao);
		return botao;
	}
	
	public static JButton botaoComIconePaiel(JPanel painel, ImageIcon icone, String nomeBotao, int x, int y, int w, int h ) {
		JButton botao = new JButton(nomeBotao);
		botao.setBounds(x, y, w, h);
		botao.setIcon(icone);
		painel.add(botao);
		return botao;
	}
	
	public static JButton botaoPersoalisado(JPanel painel, ImageIcon icone, String nomeBotao) {
		JButton botao = new JButton(nomeBotao);
		botao.setIcon(icone);
		botao.setVerticalTextPosition(SwingConstants.BOTTOM);
		botao.setHorizontalTextPosition(SwingConstants.CENTER);
		botao.setBorder(null);
		painel.add(botao);
		return botao;
	}
	
	public static JButton botao(JFrame janela, String nomeBotao, int x, int y, int w, int h ) {
		JButton botao = new JButton(nomeBotao);
		botao.setBounds(x, y, w, h);
		janela.add(botao);
		return botao;
	}
	
	public static JButton botao(JDialogo janela, String nomeBotao, int x, int y, int w, int h ) {
		JButton botao = new JButton(nomeBotao);
		botao.setBounds(x, y, w, h);
		janela.add(botao);
		return botao;
	}
	
	public static JButton botaoPainel(JPanel janela, String nomeBotao, int x, int y, int w, int h ) {
		JButton botao = new JButton(nomeBotao);
		botao.setBounds(x, y, w, h);
		janela.add(botao);
		return botao;
	}
	
	public static JTextField jTextField(JFrame janela, int x, int y, int w, int h ) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, w, h);
		janela.add(jTextField);
		return jTextField;
	}
	
	public static JTextField jTextFieldPainel(JPanel painel, int x, int y, int w, int h ) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, w, h);
		painel.add(jTextField);
		return jTextField;
	}
	
	public static JPasswordField jPasswordField(JFrame janela, int x, int y, int w, int h ) {
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setBounds(x, y, w, h);
		janela.add(jPasswordField);
		return jPasswordField;
	}
	
	public static JFormattedTextField jFormattedTextField(JFrame janela, String mascara, int x, int y, int w, int h ) {
		 
		MaskFormatter formatoMascara=null;
		    try {
				 formatoMascara= new MaskFormatter(mascara);
			} catch (ParseException e) {
			}
		    
		JFormattedTextField jFormattedTextField = new JFormattedTextField(formatoMascara);
		jFormattedTextField.setBounds(x, y, w, h);
		janela.add(jFormattedTextField);
		return jFormattedTextField;
	}
	
	public static JFormattedTextField jFormattedTextFieldPainel(JPanel painel, String mascara, int x, int y, int w, int h ) {
		 
		MaskFormatter formatoMascara=null;
		    try {
				 formatoMascara= new MaskFormatter(mascara);
			} catch (ParseException e) {
			}
		    
		JFormattedTextField jFormattedTextField = new JFormattedTextField(formatoMascara);
		jFormattedTextField.setBounds(x, y, w, h);
		painel.add(jFormattedTextField);
		return jFormattedTextField;
	}
	
	public static JLabel jLabelComIcone(JFrame janela, String icone, int x, int y, int w, int h ) {
		ImageIcon fundo = new ImageIcon(icone);
		JLabel jLabel = new JLabel(fundo);
		jLabel.setBounds(x, y, w, h);
		janela.add(jLabel);
		return jLabel;
	}
	
	public static JLabel jLabel(JFrame janela, String nome, int x, int y, int w, int h ) {
		JLabel jLabel = new JLabel(nome);
		jLabel.setBounds(x, y, w, h);
		janela.add(jLabel);
		return jLabel;
	}
	
	public static void jLabel(JPanel painel, String nome, int x, int y, int w, int h ) {
		JLabel jLabel = new JLabel(nome);
		jLabel.setBounds(x, y, w, h);
		painel.add(jLabel);
	}
	
	public static JLabel jLabel(JDialogo janela, String nome, int x, int y, int w, int h ) {
		JLabel jLabel = new JLabel(nome);
		jLabel.setBounds(x, y, w, h);
		janela.add(jLabel);
		return jLabel;
	}
	
	public static void jLabelPainel(JPanel painel, String nome, int x, int y, int w, int h ) {
		JLabel jLabel = new JLabel(nome);
		jLabel.setBounds(x, y, w, h);
		painel.add(jLabel);
	}
	
	public static JLabel jLabelComIcone(JFrame janela, String nomeIcone, String tipText, int x, int y, int w, int h ) {
		ImageIcon icone = new ImageIcon(nomeIcone);
		JLabel jLabel = new JLabel(icone);		
		jLabel.setBounds(x, y, w, h);
		janela.add(jLabel);
		return jLabel;
	}
	
	public static JComboBox<String> jComboBox(JFrame janela, String[] vetor, int x, int y, int w, int h ) {
		JComboBox<String> jComboBox = new JComboBox<>(vetor);
		jComboBox.setBounds(x, y, w, h);
		janela.add(jComboBox);
		return jComboBox;
	}
	
	public static JComboBox<String> jComboBox(JDialogo janela, String[] vetor, int x, int y, int w, int h ) {
		JComboBox<String> jComboBox = new JComboBox<>(vetor);
		jComboBox.setBounds(x, y, w, h);
		janela.add(jComboBox);
		return jComboBox;
	}
	
	public static JComboBox<String> jComboBoxPainel(JPanel painel, String[] vetor, int x, int y, int w, int h ) {
		JComboBox<String> jComboBox = new JComboBox<>(vetor);
		jComboBox.setBounds(x, y, w, h);
		painel.add(jComboBox);
		return jComboBox;
	}
	public static JMenuItem jManuSair(JFrame frame, ImageIcon icone) {		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu();
		menu.setIcon(icone);
		menuBar.add(menu);
		JMenuItem sair = new JMenuItem("Sair");
		menu.add(sair);
		frame.setJMenuBar(menuBar);
		return sair;
		
	}

	public static JTextArea textArea(JDialogo janela, int x, int y, int w, int h ) {
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(x, y, w, h);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		janela.add(jTextArea);
		return jTextArea;	
	}
	
//	public static JTable adicionartableUmaColuna(JFrame janela, DefaultTableModel modelo, String coluna, JTable tabela, int x, int y, int w, int h) {
//		modelo = new DefaultTableModel() {
//			public boolean isCellEditable(int row, int column) {
//			       //all cells false
//			       return false;
//			    }
//		};
//		modelo.addColumn(coluna);
//		
//		tabela = new JTable(modelo);
//	
//		JScrollPane scroll = new JScrollPane(tabela);
//		scroll.setBounds(x, y, w, h);
//		janela.add(scroll);
//		return 
//	}
}

package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import DTO.ClienteDTO;

public class ClienteDAOXML{

	private File arquivoClientes = new File ("BancoDeDadosClientes.xml");
	private ArrayList<String[]> clientes = this.recuperarCliente();
	
	public ArrayList<String[]> getCliente(){
		return clientes;		
	}

	/** Metodo adicionarCliente contem os codigos de persistencia em PostgreSQL
	 * é responsavel por salvar os clientes
	*/
	
	public void salvarCliente(ClienteDTO cdto) {
		String[] cliente = {cdto.getNome(), cdto.getCPF(), cdto.getRua(), cdto.getBairro(), Integer.toString(cdto.getnCasa()), cdto.getTelefone()};
		clientes.add(cliente);
		this.adicionarCliente(clientes);
		
	}
	
//	metodos que fazem persistencia de dados
	
	public void adicionarCliente(ArrayList<String[]> clientes) {
		XStream xstream = new XStream (new DomDriver("ISO-8859-1"));
		String xml = "<?xml version =\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(clientes);
		
		try {
			if(!arquivoClientes.exists())
				arquivoClientes.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivoClientes);
			gravar.print(xml);
			gravar.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<String[]> recuperarCliente() {
		XStream xstream = new XStream (new DomDriver("ISO-8859-1"));
		try {
			if(arquivoClientes.exists()) {
				FileInputStream fis = new FileInputStream(arquivoClientes);
				return (ArrayList<String[]>) xstream.fromXML(fis);
			}else {
				ArrayList<String[]> clientes = new ArrayList<>();
				this.adicionarCliente(clientes);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<String[]>();			
	}
	
}

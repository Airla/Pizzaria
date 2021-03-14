package DAO;

import java.sql.*;

public class ConectaBd {

	private volatile static Connection con;

	private ConectaBd() {}
	
	public static Connection conectabd() throws ClassNotFoundException {

		if(con == null) {
			synchronized (ConectaBd.class) {
				if(con == null) {
					try {
						Class.forName("org.postgresql.Driver");
					    con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pizzaria","postgres","abacaxi");
						return con;
					}
					catch(SQLException error) {
						System.out.println("Não foi possivel conectar com o banco de dados!\n"+error.getMessage());
					} 
				}
			}
		}
		return con;
	}
}

package com.nosqlinjection;
import java.sql.*;


public class ValidaLogin {

	private String pathBDSQLite;
	
	public ValidaLogin(String thepathSQLite){
		pathBDSQLite = thepathSQLite;
	}

	public boolean processaLogin(String user, String password){
		//Tenho que abrir o banco, rodar o query e verificar o resultado

		 Connection c = null;
		 Statement stmt = null;
		 boolean validou=false;
      
	        try {
        	 	Class.forName("org.sqlite.JDBC");
         		c = DriverManager.getConnection("jdbc:sqlite:MyDB.db");

			//Rodar query para validar!
			stmt = c.createStatement();
      			
			ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) as r FROM myUsers  where usuario='"
				       	+ user + "' and senha='"+password+"';"  );
      			
      			
			if ( rs.next() ) {
         			int r = rs.getInt("r");
				if(r >0){
					validou=true;
				}
      			}
			rs.close();
      			stmt.close();
      			c.close();

      		} catch ( Exception e ) {
         		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         		System.exit(0);
      		}

		
		return validou;
	}

	public static void main(String[] args) {
		ValidaLogin myValida = new ValidaLogin("myDB.db");

        	System.out.println("daniel, teste123 ==>"+ myValida.processaLogin("daniel","teste123"));

		System.out.println("admin,admin123 ==>"+ myValida.processaLogin("admin","admin123"));

		System.out.println("' or true -- ====>"+ myValida.processaLogin("' or true --","qualquersenha"));
    	}


}

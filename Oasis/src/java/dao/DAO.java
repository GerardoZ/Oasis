/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author robertocardielrodriguez
 */
public class DAO {
    private Connection con;
    
    public void setCon(Connection con){
        this.con=con;
    }
    public Connection getCon(){
        return con;
    }
    
    public void Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skynet?user=root&password=root");
            
        } catch (Exception e) {
            System.out.println("error:"+e);
        }
    }
    public void Cerrar(){
        try {
            if(con!=null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch (Exception e) {
        }
}
    
}


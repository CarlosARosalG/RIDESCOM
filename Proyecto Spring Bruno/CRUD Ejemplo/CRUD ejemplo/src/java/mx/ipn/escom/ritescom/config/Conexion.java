/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ritescom.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 *
 * @author spy51
 */
public class Conexion {
    public DriverManagerDataSource Conectarp(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3308/puser");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    
    public DriverManagerDataSource ConectarApp(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3308/ridescom");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}

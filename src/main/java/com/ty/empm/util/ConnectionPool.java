package com.ty.empm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

    private static ArrayList<Connection> cp = new ArrayList<>();
   private  static String driverPath ="org.postgresql.Driver";
   private static  String url = "jdbc:postgresql://localhost:5432/emp";
   private  static String user = "postgres";
   private static String password = "1234";
    private static final int POOL_SIZE =10;

    static {
        for(int i = 1 ; i<=POOL_SIZE;i++){
            cp.add(createConnection());
        }
    }

    private static Connection createConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnectionObject(){
        if(!cp.isEmpty()){
            return  cp.remove(0);
        }else{
            return getConnectionObject();
        }
    }

    public static void sendbackConnection(Connection connection){
        if(cp.size()<=POOL_SIZE){
             cp.add(connection);
        }
        else {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



}

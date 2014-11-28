    package com.ddm.interview.IapUtil;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class JDBCConnectMySQL {

       
        
       
       
        public static void createTable(String sql) throws Exception{
            Connection conn = null;
            Statement stmt = null;
            
            
            
            try{
                conn = getDBConnection();
                stmt = conn.createStatement();
                System.out.println(sql);
                stmt.execute(sql);
                System.out.println("Table \"t_user\" is created!");
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                if(stmt!=null){
                    stmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }
            
            
        }
        
        private static Connection getDBConnection() throws Exception{
        	   String DB_DRIVER = SystemPropertyUtil.getValueByKey("driver");
               String DB_CONNECTION = SystemPropertyUtil.getValueByKey("url");
              String DB_USER = SystemPropertyUtil.getValueByKey("user");
              String DB_PASSWORD = SystemPropertyUtil.getValueByKey("password");
        	
        	Connection conn = null;
            try{
                Class.forName(DB_DRIVER);
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            try{
                conn = DriverManager.getConnection(DB_CONNECTION,DB_USER, DB_PASSWORD);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
            return conn;
        }

    }
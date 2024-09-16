
package emp.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class services {
   
     private static final String inserd_employee="INSERT INTO employee (name,password,gender,phone,email,address,salary) values(?,?,?,?,?,?,?);";
    private static final String select_employee="SELECT empid,name,password,gender,phone,email,address,salary from employee where empid=?";
    private static final String selectALL_employee="SELECT * FROM employee";
    private static final String delete_employee=" DELETE FROM employee where empid=?;";
    private static final String update_employee= "UPDATE employee SET name = ?, password = ?,gender=?, phone = ?, email = ?, address = ?, salary = ? where empid= ?; ";
   
   private static final String con="jdbc:mysql://localhost:3306/employeedb?"; 

    
    
    
    
    public Connection connect() throws ClassNotFoundException{
    Connection connection=null;
    try{
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(con,"root","");
       }catch(SQLException e){
           e.printStackTrace();
        }
       catch(ClassNotFoundException e){
            e.printStackTrace();
      }
    return connection;
    }
    
    public int registration(employee std) throws ClassNotFoundException, SQLException{
    int result=0;
    	
    try (Connection connection =connect();
               PreparedStatement preparedStatement = connection.prepareStatement(inserd_employee)) {
           // preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, std.getName());
            preparedStatement.setString(2, std.getPassword());
            preparedStatement.setString(3, std.getGender());
            preparedStatement.setString(4, std.getPhone());
            preparedStatement.setString(5, std.getEmail());
            preparedStatement.setString(6, std.getAddress());
            preparedStatement.setString(7, std.getSalary());
            
            System.out.println(preparedStatement);
            result=preparedStatement.executeUpdate();
        }catch(SQLException e){
    
           e.printStackTrace();
        }
        return result;
        }
     public boolean updateEmp(employee std) throws ClassNotFoundException, SQLException{
    boolean rowUpdate = false;
    	
    try (Connection connection =connect();
               PreparedStatement preparedStatement = connection.prepareStatement(update_employee);) {
            preparedStatement.setString(1, std.getName());
            preparedStatement.setString(2, std.getPassword());
            preparedStatement.setString(3, std.getGender());
            preparedStatement.setString(4, std.getPhone());
            preparedStatement.setString(5, std.getEmail());
            preparedStatement.setString(6, std.getAddress());
            preparedStatement.setString(7, std.getSalary());
           preparedStatement.setInt(8, std.getEmpid());
            System.out.println(preparedStatement);
            rowUpdate=preparedStatement.executeUpdate() >0 ;
        }catch(SQLException e){
    
           e.printStackTrace();
        }
        return rowUpdate;
        }
     
   // select employee with id
     public employee selectEmp(int stdid) throws ClassNotFoundException{
     
     employee std=null;
     try (Connection connection =connect();
               PreparedStatement preparedStatement = connection.prepareStatement(select_employee);) {         
            preparedStatement.setInt(1,stdid);
            System.out.println(preparedStatement);          
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
             String name=rs.getString("name");
             String password=rs.getString("password");
             String gender=rs.getString("gender");
             String phone=rs.getString("phone");
             String email=rs.getString("email");
             String address=rs.getString("address");
           String salary=rs.getString("salary");
           
             std= new employee(stdid, name, password,gender, phone, email, address,salary);
           }
            }catch(SQLException e){
    
           e.printStackTrace();
            }
         return std;
         }
            
       public List<employee> selectAllEmp() throws ClassNotFoundException{
           List<employee> stds=new ArrayList();
     
     try (Connection connection =connect();
               PreparedStatement preparedStatement = connection.prepareStatement(selectALL_employee);) {
          
            System.out.println(preparedStatement);        
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
             int stdid=rs.getInt("empid");
             String name=rs.getString("name");
             String password=rs.getString("password");
             String gender=rs.getString("gender");
             String phone=rs.getString("phone");
             String email=rs.getString("email");
             String address=rs.getString("address");
            String salary=rs.getString("salary");
         
             stds.add(new employee(stdid, name, password,gender, phone, email, address,salary));
           }
            }catch(SQLException e){
    
           e.printStackTrace();
        }
            
             
         return stds;
         }
     
     //delete employee 
         public boolean deleteEmp(int stdid) throws ClassNotFoundException, SQLException{
             boolean rowDelete;
     
             try (Connection connection =connect();
                       PreparedStatement pstatement = connection.prepareStatement(delete_employee);) {
                       pstatement.setInt(1,stdid);
                       rowDelete=pstatement.executeUpdate()>0;
                    pstatement.setInt(1,stdid);
                }
             return rowDelete;
             }
         
  private void printSQLException(SQLException ex) {

		for (Throwable e : ex) {

			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
	
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}



   
}

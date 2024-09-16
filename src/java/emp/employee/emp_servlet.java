/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "emp_servlet", urlPatterns = {"/"})
public class emp_servlet extends HttpServlet {

    services serv;
  public emp_servlet(){
       this.serv=new services();
    } 
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                this.doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action =request.getServletPath();
       try {
          switch(action){
           case "/add": insertEmp(request, response);break;
          case "/new": showNewForm(request, response); break;
          case "/delete": deleteEmp(request, response); break;
        case "/update": updateEmp(request, response); break;
        case "/edit":showEditForm(request, response);   break;
        case "/list": listEmp(request, response); break;
         default: listEmp(request, response);break; }
          
            }catch(ClassNotFoundException ex) {
                      Logger.getLogger(emp_servlet.class.getName()).log(Level.SEVERE, null, ex);  }
              catch (SQLException ex) {
                Logger.getLogger(emp_servlet.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
           
    
    
    // functions 
     private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher dispatcher=request.getRequestDispatcher("employee_form.jsp");
          dispatcher.forward(request, response);
  }
     
   private void insertEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String Name=request.getParameter("name");
        String Password=request.getParameter("password");
        String Gender=request.getParameter("gender");
        String Phone=request.getParameter("phone");
        String Email=request.getParameter("email");
        String Address=request.getParameter("address");
         String Salary=request.getParameter("salary");
        employee newstd=new employee(Name,Password,Gender, Phone, Email, Address,Salary);        
        services oprstd=new services();
   
        oprstd.registration(newstd);
          response.sendRedirect("list");    
   }
    private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        int id=Integer.parseInt(request.getParameter("empid"));
        serv.deleteEmp(id);
       response.sendRedirect("list");
  
   }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
      int id=Integer.parseInt(request.getParameter("empid"));
      employee existingStd=serv.selectEmp(id);
      RequestDispatcher dispatcher=request.getRequestDispatcher("employee_form.jsp");
      request.setAttribute("employee", existingStd);
       dispatcher.forward(request, response);
  
   }
      private void updateEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {      
        int id=Integer.parseInt(request.getParameter("empid"));
       String Name=request.getParameter("name");
        String Password=request.getParameter("password");
        String Gender=request.getParameter("gender");
        String Phone=request.getParameter("phone");
        String Email=request.getParameter("email");
        String Address=request.getParameter("address");
        String Salary=request.getParameter("salary");
        employee stdup=new employee(id,Name,Password,Gender, Phone, Email, Address,Salary);
        serv.updateEmp(stdup);
        response.sendRedirect("list");
      }
   private void listEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
       List<employee> listEmp=serv.selectAllEmp();
       request.setAttribute("listEmp", listEmp);
       
       RequestDispatcher dispatcher=request.getRequestDispatcher("emp_list.jsp");
          dispatcher.forward(request, response);
  
   }
   
}

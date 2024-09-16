/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.employee;


public class employee {
    private   int empid;
 private   String name;
 private   String password;
 private   String gender;
 private   String phone;
 private   String email;
 private   String address; 
 private String salary;
    employee(int stdid, String name, String password, String gender, String phone, String email, String address,String salary) {
        this.empid=stdid;
        this.name=name;
        this.password=password;
        this.phone=phone;
        this.gender=gender;
        this.email=email;
        this.address=address;
        this.salary=salary;
    }

    employee(String Name, String Password, String Gender, String Phone, String Email, String Address, String salary) {

        this.name=Name;
        this.password=Password;
        this.phone=Phone;
        this.gender=Gender;
        this.email=Email;
        this.address=Address;
        this.salary=salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

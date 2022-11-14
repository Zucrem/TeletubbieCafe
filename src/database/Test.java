/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Zucrem
 */
public class Test {
    public static void main(String[] args){
        Emp emp = new Emp(10,"Name",3);
        EmployeeTable.insertEmployee(emp);
	//fuck you bitch
    }
}

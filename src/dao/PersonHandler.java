/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

// import bo.Staff;
import bo.Person;
import java.sql.ResultSet;
import utils.PasswordEncryptor;
import utils.SQLUtil;

/**
 *
 * @author Pham Van Vung
 */
public class PersonHandler {

    private SQLUtil sqlUtil;

    public PersonHandler() {
        sqlUtil = new SQLUtil();
    }

    public Person login(String username, String password) {
        Person per = null; 
        //encrypt
        password = PasswordEncryptor.encryptPassword(password);
        String stm = String.format("select pId, name, role from Person where username='%s' and password='%s'", username, password);
        ResultSet rsPerson = sqlUtil.executeQuery(stm);
        try {
            if (rsPerson!=null && rsPerson.next()) {
                int pId = rsPerson.getInt("pId");
                String name = rsPerson.getString("name");
                int role = rsPerson.getInt("role");
                per = new Person(pId, name, role);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return per;
    }
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

/**
 *
 * @author Pham Van Vung
 */
public class Person {
    private int pId;
    private String name;
    private int role;

    public Person(int pId, String name, int role) {
        this.pId= pId;
        this.name = name;
        this.role = role;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}

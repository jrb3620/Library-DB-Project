/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Vector;

/**
 *
 * @author Pham Van Vung
 */
public class Book {
    private int bId;
    private String bTitle;
    private String bAuthor;
    private int bPages;
    private int chId;
    private String chName;

    public Book(int bId, String bTitle, String bAuthor, int bPages, int chId) {
        this.bId = bId;
        this.bTitle = bTitle;
        this.bAuthor = bAuthor;
        this.bPages = bPages;
        this.chId = chId;
    }
    public Vector<Object> getRow(){
        Vector<Object> ret = new Vector();
        ret.add(this.bId);
        ret.add(this.bTitle);
        ret.add(this.bAuthor);
        ret.add(this.bPages);
        ret.add(this.chId);
        return ret;
    }
    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getsTitle() {
        return bTitle;
    }

    public void setsTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getsAuthor() {
        return bAuthor;
    }

    public void setsAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
    
    public int getPages(){
        return bPages;
    }
    
    public void setsPages(int bPages){
        this.bPages = bPages;
    }

    public int getChId() {
        return chId;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }
}

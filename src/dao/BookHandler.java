/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQLUtil;

/**
 *
 * @author Pham Van Vung
 */
public class BookHandler {

    private SQLUtil sqlUtil;

    public BookHandler() {
        sqlUtil = new SQLUtil();
    }

    public int addBook(String bTitle, String bAuthor, int bPages, int chId) {
        String cmdTemplate = "insert into Book(bTitle, bAuthor, bPages, chId) values('%s', '%s', %d, %d)";
        String stmStr = String.format(cmdTemplate, bTitle, bAuthor, bPages, chId);
        return sqlUtil.executeUpdate(stmStr);
    }
    
    public int deleteBook(int bId){
        String stm = String.format("delete from book where bId = %d", bId);
        return sqlUtil.executeUpdate(stm);
    }
    
    public int updateBook(int bId, String bTitle, String bAuthor, int bPages, int chId){
        String cmdTemplate = "update Book set bTitle='%s', bAuthor='%s', bPages=%d, chId=%d where bId=%d";
        String stmStr = String.format(cmdTemplate, bTitle, bAuthor, bPages, chId, bId);
        return sqlUtil.executeUpdate(stmStr);
    }
    
    public List<Book> getBook(String keyword){
        String stmStr = String.format( "select * from Book where bTitle like '%s'", "%"+keyword+"%");
        List<Book> book = new ArrayList<>();
        ResultSet rs  = sqlUtil.executeQuery(stmStr);
        try {
            while(rs.next()){
                int bId = rs.getInt("bId");
                String bTitle = rs.getString("bTitle");
                String bAuthor = rs.getString("bAuthor");
                int bPages = rs.getInt("bPages");
                int chId = rs.getInt("chId");
                
                Book s = new Book(bId, bTitle, bAuthor, bPages, chId);
                book.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
}

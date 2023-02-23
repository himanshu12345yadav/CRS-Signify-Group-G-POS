/**
 * 
 */
package com.signify.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.jdbc.UserDAOInterface;
import java.util.Scanner;
public class UserDAOImplementation implements UserDAOInterface{
	public String[] login(String username, String password)
	{
		String userid = "";
		String roleid = "";
		Connection conn = null;
		PreparedStatement stmt = null;
				
		try{
			   
			   conn = DriverManager.getConnection(helper.Ids.DB_URL,helper.Ids.USER,helper.Ids.PASS);
			   stmt = conn.prepareStatement(SQLConstants.LOGIN_USER);
			   stmt.setString(1, username);
			   stmt.setString(2, password);
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next())
			   {
			      userid = rs.getString("userid");
			      roleid = Integer.toString(rs.getInt("roleid"));
			   }
			   
			   rs.close();
			   stmt.close();
			   conn.close();
			     			      
			}
		catch(SQLException se){
			 se.printStackTrace();
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
		     try{
			       if(stmt!=null)
			          stmt.close();
			 }catch(SQLException se2){
			 }try{
			    if(conn!=null)
			       conn.close();
			 	}catch(SQLException se){
			       se.printStackTrace();
			    }
		}
		String[] ans = {String.valueOf(roleid),userid};
		return ans;
	}
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
    Connection conn = null;
    PreparedStatement stmtSelect = null;
    PreparedStatement stmtUpdate = null;
    ResultSet rs = null;
    boolean success = false;
    
    try {
        conn = DriverManager.getConnection(helper.Ids.DB_URL, helper.Ids.USER, helper.Ids.PASS);
        stmtSelect = conn.prepareStatement(SQLConstants.VIEW_USER);
        stmtSelect.setString(1, username);
        stmtSelect.setString(2, oldPassword);
        rs = stmtSelect.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        if (count == 1) {
            stmtUpdate = conn.prepareStatement(SQLConstants.UPDATE_PASSWORD);
            stmtUpdate.setString(1, newPassword);
            stmtUpdate.setString(2, username);
            int rowsAffected = stmtUpdate.executeUpdate();
            if (rowsAffected == 1) {
                success = true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmtSelect != null) stmtSelect.close();
            if (stmtUpdate != null) stmtUpdate.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return success;
}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyEmpMgmtApp.dao;

import MyEmpMgmtApp.dbutil.DBConnection;
import MyEmpMgmtApp.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author atulb
 */
public class Empdao {

    public static boolean addEmp(EmpPojo obj) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into emp values(?,?,?)");
        ps.setInt(1, obj.getEmpno());
        ps.setString(2, obj.getEname());
        ps.setDouble(3, obj.getEsal());
        int count = ps.executeUpdate();
        return (count == 1);

    }

    public static ArrayList<EmpPojo> getAllEmp() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from emp");
        ArrayList<EmpPojo> emplist = new ArrayList<>();
        while (rs.next()) {
            int eno = rs.getInt(1);
            String ename = rs.getString(2);
            Double esal = rs.getDouble(3);
            EmpPojo obj = new EmpPojo(eno, ename, esal);
            emplist.add(obj);
        }
        return emplist;
    }

    public static EmpPojo findEmpById(int eno) throws SQLException {

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from emp where enum = ? ");
        ps.setInt(1, eno);
        ResultSet rs = ps.executeQuery();
        EmpPojo e = null;
        if (rs.next()) {
            e = new EmpPojo();
            e.setEname(rs.getString(2));
            e.setEsal(rs.getDouble(3));
            e.setEmpno(eno);
        }
        return e;

    }

    public static boolean updateDetails(EmpPojo obj) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update emp set enum = ?,esal = ? where ename = ?");
        boolean res = false;
        ps.setInt(1, obj.getEmpno());
        ps.setDouble(2, obj.getEsal());
        ps.setString(3, obj.getEname());
        int count2 = ps.executeUpdate();
        if (count2 == 1) {
            res = true;
        }
        return res;

    }

    public static boolean delete(int eno) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from emp where enum = ?");
        ps.setInt(1, eno);
        int count = ps.executeUpdate();
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

}

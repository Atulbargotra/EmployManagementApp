/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyEmpMgmtApp.pojo;

/**
 *
 * @author atulb
 */
public class EmpPojo {

    @Override
    public String toString() {
        return "EmpPojo{" + "empno=" + empno + ", ename=" + ename + ", esal=" + esal + '}';
    }

    public EmpPojo() {
    }

    public EmpPojo(int empno, String ename, Double esal) {
        this.empno = empno;
        this.ename = ename;
        this.esal = esal;
    }

    private int empno;
    private String ename;
    private Double esal;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getEsal() {
        return esal;
    }

    public void setEsal(Double esal) {
        this.esal = esal;
    }

}

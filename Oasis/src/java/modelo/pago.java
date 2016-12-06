/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author angel
 */
public class pago {
 private String bank;
 private String lastFour;
 private String num;
 private String monthExpiration;
 private String yearExpiration;
 private String secCode;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    

    public String getMonthExpiration() {
        return monthExpiration;
    }

    public void setMonthExpiration(String monthExpiration) {
        this.monthExpiration = monthExpiration;
    }

    public String getYearExpiration() {
        return yearExpiration;
    }

    public void setYearExpiration(String yearExpiration) {
        this.yearExpiration = yearExpiration;
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }


}

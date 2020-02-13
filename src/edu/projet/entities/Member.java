/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.entities;

/**
 *
 * @author Mey
 */
public class Member {
    private int idM;
    private String NameM;
    private int CinM ;
    private int idUser;
    private int idW;

    public Member(int idM, String NameM, int CinM, int idUser, int idW) {
        this.idM = idM;
        this.NameM = NameM;
        this.CinM = CinM;
        this.idUser = idUser;
        this.idW = idW;
    }

    public Member() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getNameM() {
        return NameM;
    }

    public void setNameM(String NameM) {
        this.NameM = NameM;
    }

    public int getCinM() {
        return CinM;
    }

    public void setCinM(int CinM) {
        this.CinM = CinM;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdW() {
        return idW;
    }

    public void setIdW(int idW) {
        this.idW = idW;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idM;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.idM != other.idM) {
            return false;
        }
        return true;
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

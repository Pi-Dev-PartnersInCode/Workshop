/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mey
 */
public class Member {
   
private user idUser;
private user firstName;
private user lastName;
private user e_mailAddress;
private user password;
private user address;
private user dateOfBirth;
private user phoneNumber;

private Workshop idW;

    public user getIdUser() {
        return idUser;
    }

    public void setIdUser(user idUser) {
        this.idUser = idUser;
    }

    public user getFirstName() {
        return firstName;
    }

    public void setFirstName(user firstName) {
        this.firstName = firstName;
    }

    public user getLastName() {
        return lastName;
    }

    public void setLastName(user lastName) {
        this.lastName = lastName;
    }

    public user getE_mailAddress() {
        return e_mailAddress;
    }

    public void setE_mailAddress(user e_mailAddress) {
        this.e_mailAddress = e_mailAddress;
    }

    public user getPassword() {
        return password;
    }

    public void setPassword(user password) {
        this.password = password;
    }

    public user getAddress() {
        return address;
    }

    public void setAddress(user address) {
        this.address = address;
    }

    public user getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(user dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public user getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(user phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Workshop getIdW() {
        return idW;
    }

    public void setIdW(Workshop idW) {
        this.idW = idW;
    }
    
    
    
    
}

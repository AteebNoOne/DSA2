/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa_project;

/**
 *
 * @author BSP
 */
public class LoginData {
    private String username;
    private String password;
    private LoginData next;

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
        this.next = null;
    }

    // Getters and setters for username, password, and next node
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginData getNext() {
        return next;
    }

    public void setNext(LoginData next) {
        this.next = next;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa_project;

public class LoginDataLinkedList {
    private static LoginData head;
//hamza 
    public LoginDataLinkedList() {
        this.head = null;
    }

    // Method to add a new login data entry to the linked list
    public void addLoginData(String username, String password) {
        LoginData newLoginData = new LoginData(username, password);

        if (head == null) {
            // If the linked list is empty, set the new entry as the head
            head = newLoginData;
        } else {
            // Find the last node in the linked list and append the new entry
            LoginData current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newLoginData);
        }
    }
// shayan
    // Method to search for login data by username
    public static LoginData findLoginData(String username) {
        LoginData current = head;
        while (current != null) {
            if (current.getUsername().equals(username)) {
                return current;
            }
            current = current.getNext();
        }
        return null; // Username not found
    }
}

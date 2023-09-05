/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa_project;

/**
 *
 * @author BSP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

class Employee {
    int id;
    String name;
    String surname;
    int age;

    Employee(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

public class EmployeeManagementUI {
    private JFrame frame;
    private LinkedList<Employee> employeeList;

    private JTextField idField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;

    private JTextArea displayArea;

    public EmployeeManagementUI() {
        employeeList = new LinkedList<>();
        frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a gradient background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color startColor = new Color(0, 102, 204); // Blue
                Color endColor = new Color(204, 204, 255); // Light Blue
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        frame.add(backgroundPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        idField = new JTextField();
        nameField = new JTextField();
        surnameField = new JTextField();
        ageField = new JTextField();

        inputPanel.add(new JLabel("Employee ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Surname:"));
        inputPanel.add(surnameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);

        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Employee");
        JButton retrieveButton = new JButton("Retrieve Details");
        JButton editButton = new JButton("Edit Employee");
        JButton deleteButton = new JButton("Delete Employee");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrieveEmployee();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editEmployee();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(retrieveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addEmployee() {
        // Get data from input fields
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String surname = surnameField.getText();
        int age = Integer.parseInt(ageField.getText());

        // Create an employee object and add it to the linked list
        Employee employee = new Employee(id, name, surname, age);
        employeeList.add(employee);

        // Clear input fields
        idField.setText("");
        nameField.setText("");
        surnameField.setText("");
        ageField.setText("");

        displayArea.append("Employee added: " + employee.id + ", " + employee.name + ", " + employee.surname + ", " + employee.age + "\n");
    }

    private void retrieveEmployee() {
        // Retrieve and display employee details
        int idToRetrieve = Integer.parseInt(idField.getText());
        for (Employee employee : employeeList) {
            if (employee.id == idToRetrieve) {
                displayArea.append("Employee Details: " + employee.id + ", " + employee.name + ", " + employee.surname + ", " + employee.age + "\n");
                return; // Found, so no need to continue searching
            }
        }
        displayArea.append("Employee with ID " + idToRetrieve + " not found.\n");
    }

    private void editEmployee() {
        // Edit employee details
        int idToEdit = Integer.parseInt(idField.getText());
        for (Employee employee : employeeList) {
            if (employee.id == idToEdit) {
                employee.name = nameField.getText();
                employee.surname = surnameField.getText();
                employee.age = Integer.parseInt(ageField.getText());

                displayArea.append("Employee edited: " + employee.id + ", " + employee.name + ", " + employee.surname + ", " + employee.age + "\n");
                return; // Found and edited, so no need to continue searching
            }
        }
        displayArea.append("Employee with ID " + idToEdit + " not found.\n");
    }

    private void deleteEmployee() {
        // Delete employee
        int idToDelete = Integer.parseInt(idField.getText());
        for (Employee employee : employeeList) {
            if (employee.id == idToDelete) {
                employeeList.remove(employee);
                displayArea.append("Employee deleted: " + employee.id + ", " + employee.name + ", " + employee.surname + ", " + employee.age + "\n");
                return; // Found and deleted, so no need to continue searching
            }
        }
        displayArea.append("Employee with ID " + idToDelete + " not found.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementUI();
            }
        });
    }
}

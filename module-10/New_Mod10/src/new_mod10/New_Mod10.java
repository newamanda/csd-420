/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Amanda New
//CSD420-A311
//Module 10

//imports
package new_mod10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Admin
 */
//establish JFrame for design
public class New_Mod10 extends JFrame{
    
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;
    private Connection connection;
    private PreparedStatement displayStmt, updateStmt;
    
    //set design parameters
    public New_Mod10() {
        setTitle("Fan Data");
        setLayout(new FlowLayout());
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel idLabel = new JLabel("ID: ");
        idField = new JTextField(10);
        
        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameField = new JTextField(20);
        
        JLabel lastNameLabel = new JLabel ("Last Name: ");
        lastNameField = new JTextField(20);
        
        JLabel favoriteTeamLabel = new JLabel("Favorite Team: ");
        favoriteTeamField = new JTextField(20);
        
        displayButton = new JButton("Display");
        updateButton = new JButton("Update");
        
        add(idLabel);
        add(idField);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(favoriteTeamLabel);
        add(favoriteTeamField);
        add(displayButton);
        add(updateButton);
        
        displayButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRecord();
            }
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
        
        connectToDatabase();
    }
    //connect to database
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/databasedb";
            String username = "student1";
            String password = "pass";
            
            connection = DriverManager.getConnection(url, username, password);
            
            displayStmt = connection.prepareStatement("SELECT * FROM fans WHERE ID = ?");
            updateStmt = connection.prepareStatement("UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?");
            
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //display information
    private void displayRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            displayStmt.setInt(1, id);
            ResultSet resultSet = displayStmt.executeQuery();
            
            if (resultSet.next()) {
                firstNameField.setText(resultSet.getString("firstname"));
                lastNameField.setText(resultSet.getString("lastname"));
                favoriteTeamField.setText(resultSet.getString("favoriteteam"));
            }
            
            else {
                JOptionPane.showMessageDialog(this, "Record Not Found");
            }
            
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //update information
    private void updateRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String favoriteTeam = favoriteTeamField.getText();
            
            updateStmt.setString(1, firstName);
            updateStmt.setString(2, lastName);
            updateStmt.setString(3, favoriteTeam);
            updateStmt.setInt(4, id);
            
            int rowsUpdated = updateStmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Updated!");
            }
            else {
                JOptionPane.showMessageDialog(this, "Failure!");
            }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //close to prevent additional updates
    private void closeDatabase() {
        try {
            if (connection !=null) {
                connection.close();
            }
            if (displayStmt != null) {
                displayStmt.close();
            }
            if (updateStmt != null) {
                updateStmt.close();
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                New_Mod10 app = new New_Mod10();
                app.setVisible(true);
            }
        });
    }
    
}

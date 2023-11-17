/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Darren
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

//CREATE TABLE games (
//    id int PRIMARY KEY,
//    name varchar(80),
//    genre varchar(30),
//    price int
//);
//
//CREATE TABLE users (
//    id int PRIMARY KEY,
//    name varchar(80),
//    email varchar(50),
//    `password` int
//);
//
//CREATE TABLE transactions (
//    id int PRIMARY KEY AUTO_INCREMENT,
//    user_id int,
//    game_id int,
//    FOREIGN KEY(user_id) REFERENCES users(id),
//    FOREIGN KEY(game_id) REFERENCES games(id)
//);


public class DatabaseHandler {

    public Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/game_store";
    private final String username = "root";
    private final String password = "";

    private Connection logOn() {
        try {
            //Load JDBC Driver
            Class.forName(driver).newInstance();
            //Buat Object Connection
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
        return con;
    }

    private void logOff() {
        try {
            //tutup koneksi
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
    }

    public void connect() {
        try {
            con = logOn();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }

    public void disconnect() {
        try {
            logOff();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }
}
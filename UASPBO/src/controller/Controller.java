/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DetailTransaction;
import model.Games;
import model.Transaction;
import model.User;
/**
 *
 * @author Darren
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    // INSERT
    public boolean addTransaction(int userId, int gameId) {
        conn.connect();
        String query = "INSERT INTO transactions (user_id, game_id) VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, gameId);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return (false);
        }
    }

    // SELECT WHERE
    public User getUser(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'";
        User user = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return (user);
    }
    
    public ArrayList<Games> getGames(int userId) {
        conn.connect();
        String query = "SELECT * FROM games WHERE id NOT IN (SELECT game_id FROM transactions WHERE user_id =" + userId + ");";
        ArrayList<Games> games = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                games.add(new Games(rs.getInt("id"), rs.getString("name"), rs.getString("genre"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return (games);
    }
    
    public ArrayList<DetailTransaction> getDetailTransactions(int userId) {
        conn.connect();
        String query = "SELECT id, user_id, (SELECT name FROM users WHERE id=user_id) AS user_name, game_id, (SELECT name FROM games WHERE id=game_id) AS game_name, (SELECT price FROM games WHERE id=game_id) AS total_price FROM transactions WHERE user_id =" + userId +";";
        ArrayList<DetailTransaction> detailTransactions = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                detailTransactions.add(new DetailTransaction(rs.getInt("id"), rs.getInt("user_id"), rs.getString("user_name"), rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("total_price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return (detailTransactions);
    }
}

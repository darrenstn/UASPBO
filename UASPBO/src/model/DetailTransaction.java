/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Darren
 */
public class DetailTransaction {
    private int id;
    private int userId;
    private String userName;
    private int gameId;
    private String gameName;
    private int totalPrice;

    public DetailTransaction(int id, int userId, String userName, int gameId, String gameName, int totalPrice) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.gameId = gameId;
        this.gameName = gameName;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    
}

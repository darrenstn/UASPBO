/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.Games;
import model.User;

/**
 *
 * @author Darren
 */
public class GameList extends JFrame{
    JTextField fTitle = new JTextField("Game List");
    Controller ctrlr = new Controller();
    
    public GameList(User user){
        ArrayList<Games> gameList = ctrlr.getGames(user.getId());
        
        JPanel panelGame = new JPanel();
        GridLayout gl = new GridLayout(0,1,2,2);
        panelGame.setLayout(gl);
        
        JButton menuTransaction = new JButton("Menu Transaction");
        
        menuTransaction.addActionListener(e -> {
            new MenuTransactions(user);
        });
        
        ArrayList<JTextField> nameGame = new ArrayList<>();
        ArrayList<JTextField> genreGame = new ArrayList<>();
        ArrayList<JTextField> priceGame = new ArrayList<>();
        ArrayList<JButton> buyGame = new ArrayList<>();
        
        for (Games tmpGame : gameList) {
            int index = gameList.indexOf(tmpGame);
            nameGame.add(new JTextField(tmpGame.getName()));
            genreGame.add(new JTextField(tmpGame.getGenre()));
            priceGame.add(new JTextField(tmpGame.getPrice()));
            buyGame.add(new JButton("Buy"));
            buyGame.get(index).addActionListener(e -> {
                boolean success = ctrlr.addTransaction(user.getId(), tmpGame.getId());
                if (success) {
                    JOptionPane.showMessageDialog(null, "Berhasil Membeli", "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Membeli", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            });
            
            panelGame.add(nameGame.get(index));
            panelGame.add(genreGame.get(index));
            panelGame.add(priceGame.get(index));
            panelGame.add(buyGame.get(index));
        }
        
        
        JLabel labelEmail = new JLabel("Email : ");
        JTextField emailLogin = new JTextField("");
        JLabel labelPassword = new JLabel("Password : ");
        JTextField passwordLogin = new JTextField("");
        JButton login = new JButton("Login");
        
        login.addActionListener(e -> {
            email = emailLogin.getText();
            password = passwordLogin.getText();
            
            User user = ctrlr.getUser(email, password);
            
            if(user!=null){
                new (p);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Login", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        panelGame.add(labelEmail);
        panelGame.add(emailLogin);
        panelGame.add(labelPassword);
        panelGame.add(passwordLogin);
        panelGame.add(login);
        
        this.add(panelGame);
        this.setTitle(fTitle.getText());
        this.setSize(300, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

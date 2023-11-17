/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.User;

/**
 *
 * @author Darren
 */
public class Login extends JFrame{
    JTextField fTitle = new JTextField("Login");
    String email;
    String password;
    Controller ctrlr = new Controller();
    public Login(){
        JPanel panelLogin = new JPanel();
        GridLayout gl = new GridLayout(0,1,2,2);
        panelLogin.setLayout(gl);
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
                new GameList(user);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Login", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        panelLogin.add(labelEmail);
        panelLogin.add(emailLogin);
        panelLogin.add(labelPassword);
        panelLogin.add(passwordLogin);
        panelLogin.add(login);
        
        this.add(panelLogin);
        this.setTitle(fTitle.getText());
        this.setSize(300, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

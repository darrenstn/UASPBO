/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.DetailTransaction;
import model.Games;
import model.User;

/**
 *
 * @author Darren
 */
public class MenuTransactions extends JFrame{
    JTextField fTitle = new JTextField("Menu Transactions");
    Controller ctrlr = new Controller();
    
    MenuTransactions(User user){
        ArrayList<DetailTransaction> transactionsList = ctrlr.getDetailTransactions(user.getId());
        
        JPanel panelTransaction = new JPanel();
        GridLayout gl = new GridLayout(0,1,2,2);
        panelTransaction.setLayout(gl);
        String result = "";
        JTextArea finalResult = new JTextArea();
        
        for (DetailTransaction tmpDt : transactionsList) {
            result += tmpDt.toString() + "\n";
        }
        finalResult.setText(result);
        panelTransaction.add(finalResult);
        
        this.add(panelTransaction);
        this.setTitle(fTitle.getText());
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
    

package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class RegisterView extends JFrame{


    JLabel username=new JLabel("USERNAME:");
    JTextField usernameText=new JTextField();
    JLabel password=new JLabel("PASSWORD:");
    JPasswordField passwordText = new JPasswordField();
    JButton backButton=new JButton("Back");
    JButton readyButton=new JButton("READY!");
    MainFrame mainFrame=new MainFrame();
    public RegisterView() {
        this.setSize(700, 500);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(200, 80, 90));

        JLabel title = new JLabel("CREATE AN ACCOUNT:");
        title.setBounds(100, 5, 500, 100);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 40));
        title.setVisible(true);
        this.add(title);


        username.setBounds(230,120,200,40);
        this.add(username);
        usernameText.setBounds(230,160,180,30);
        this.add(usernameText);


        password.setBounds(230,200,200,40);
        this.add(password);
        passwordText.setBounds(230,240,180,30);
        this.add(passwordText);

        backButton.setBounds(470,400,150,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    dispose();
                    MainFrame v=new MainFrame();
                }
            }
        });
        this.add(backButton);

        readyButton.setBounds(240,300,150,30);
        readyButton.setFocusable(false);
        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==readyButton)
                {   ArrayList<String> listaClienti2=new ArrayList<String>();
                    for(int i=0;i<mainFrame.listaClienti.size();i++)
                    {
                        listaClienti2.add(mainFrame.listaClienti.get(i));
                    }
                    String u = usernameText.getText();
                    String pass = passwordText.getText();
                    String userPlusPass=u+" "+pass;
                    listaClienti2.add(userPlusPass);
                    mainFrame.setListaClienti(listaClienti2);
                    JOptionPane.showMessageDialog(null,"Valid Register Client");
                    System.out.println("ID si PAROLA Clienti");
                    for(int i=0;i<mainFrame.listaClienti.size();i++)
                        System.out.println(mainFrame.listaClienti.get(i));
                }
            }
        });
        this.add(readyButton);

        this.setVisible(true);
    }
}

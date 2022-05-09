package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;

public class MainFrame {

    private final static String USER = "admin";
    private final static String PASSWORD = "admin";

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JLabel title = new JLabel("WELCOME!");
    JButton administrator = new JButton("ADMINISTRATOR");
    JButton client=new JButton("CLIENT");
    JButton employee = new JButton("EMPLOYEE");
    JLabel  username=new JLabel("USERNAME:");
    JTextField usernameText=new JTextField();
    JLabel password=new JLabel("PASSWORD:");
    JPasswordField passwordText = new JPasswordField();
    JButton register = new JButton("REGISTER");
    ArrayList<String> listaClienti=new ArrayList<String>();

    public ArrayList<String> getListaClienti() {
        return listaClienti;
    }

    public void setListaClienti(ArrayList<String> listaClienti) {
        this.listaClienti = listaClienti;
    }

    public MainFrame() {

        listaClienti.add("client1 parola1");
        listaClienti.add("client2 parola2");

        frame.setSize(800, 500);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(200, 80, 90));


        title.setBounds(250, 10, 300, 70);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 50));
        title.setVisible(true);
        frame.add(title);

        panel.setSize(900,300);
        panel.setBounds(0,0,800,500);
        panel.setBackground(new Color(200, 80, 90));
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);


        username.setBounds(10,120,100,40);
        panel.add(username);
        usernameText.setBounds(50,160,180,30);
        panel.add(usernameText);

        password.setBounds(10,200,100,40);
        panel.add(password);
        passwordText.setBounds(50,240,180,30);
        panel.add(passwordText);

        register.setBounds(10,320,200,50);
        register.setFocusable(false);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==register)
                {
                    frame.dispose();
                    RegisterView registerFrame = new RegisterView();
                }
            }
        });

        panel.add(register);

        administrator.setBounds(420,100,200,50);
        administrator.setFocusable(false);

        administrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == administrator) {

                    String u = usernameText.getText();
                    String pass = passwordText.getText();

                    if (u.equals(USER))
                            if(pass.equals(PASSWORD)) {
                        frame.dispose();
                        AdminView adminV = new AdminView();
                    } else {
                        JOptionPane.showMessageDialog(null, "LOGIN FAILED FOR ADMIN");
                        frame.dispose();
                    }
                }
            }
        });

        panel.add(administrator);

        client.setBounds(420,210,200,50);
        client.setFocusable(false);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==client) {
                    int gasit=0;
                    String u = usernameText.getText();
                    String pass = passwordText.getText();
                    String userPlusParola=u+" "+pass;
                    for(int i=0;i<listaClienti.size();i++)
                    {
                        if(userPlusParola.equals(listaClienti.get(i)))
                        {
                              frame.dispose();
                               ClientView clientV = new ClientView();
                                gasit=1;
                        }
                    }
                    if(gasit==0)
                    {JOptionPane.showMessageDialog(null, "LOGIN FAILED FOR CLIENT");
                    frame.dispose(); }
                }
            }
        });


        panel.add(client);
        employee.setBounds(420,320,200,50);
        employee.setFocusable(false);

        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==employee)
                {
                    frame.dispose();
                    EmployeeView employeeV = new EmployeeView("ioana");
                }
            }
        });
        panel.add(employee);
        frame.setVisible(true);
    }
}
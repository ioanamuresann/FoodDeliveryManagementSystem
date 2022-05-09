package GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class EmployeeView extends JFrame implements Observer {

    JButton backButton;

    public EmployeeView(String s){
        this.setSize(1180, 550);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(200, 80, 90));

        JLabel title = new JLabel("EMPLOYEE");
        title.setBounds(400, 5, 300, 70);
        title.setForeground(new Color(0, 0, 0));
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 50));
        title.setVisible(true);
        this.add(title);

        backButton=new JButton("Back");
        backButton.setBounds(930,10,150,30);
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

        JPanel jPanel=new JPanel();
        jPanel.setBorder(new EtchedBorder());
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(10,100,900,500);
        jPanel.setBackground(Color.WHITE);
        jPanel.setVisible(true);


        JLabel label = new JLabel(s);
        label.setBounds(10,100,900,500);
        label.setForeground(new Color(0, 0, 0));
        label.setBackground(new Color(200, 80, 90));
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label.setVisible(true);
        jPanel.add(label);

        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, "New Order!");
    }

}
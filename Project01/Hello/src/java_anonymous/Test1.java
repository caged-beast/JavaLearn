package java_anonymous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简单的GUI编程
public class Test1 {
    public static void main(String[] args) {
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        JButton btn = new JButton("登录");
        win.add(panel);
        panel.add(btn);
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(win,"哈哈哈哈");
//            }
//        });
        btn.addActionListener((ActionEvent e)-> {
                JOptionPane.showMessageDialog(win,"哈哈哈哈");
        });
        win.setSize(400,300);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}

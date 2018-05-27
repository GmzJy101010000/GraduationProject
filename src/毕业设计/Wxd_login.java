package 毕业设计;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;



public class Wxd_login{

public static void main(String[] args) {
final String userName = "zgm";
final String passwrod = "123456";

final JFrame jFrame = new JFrame("登陆界面");
Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
jFrame.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 200, 150);
jFrame.setResizable(false);
jFrame.setLayout(null);
jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label1 = new JLabel("帐号");
label1.setBounds(25, 10, 100, 30);
jFrame.add(label1);

JLabel label2 = new JLabel("密码");
label2.setBounds(25, 40, 100, 30);
jFrame.add(label2);

final JTextField text1 = new JTextField();
text1.setBounds(65, 15, 130, 20);
jFrame.add(text1);

final JPasswordField text2 = new JPasswordField();
text2.setBounds(65, 45, 130, 20);
jFrame.add(text2);

JButton b1 = new JButton("注册");
b1.setBounds(25, 75, 170, 40);
JButton button = new JButton("Login");
button.setBounds(25, 125, 170, 40);
button.addActionListener(new ActionListener() {


public void actionPerformed(ActionEvent e) {
    String a1=text1.getText();
    String a2=text2.getText();
	user u=user_check.check(a1);
	
if(u!=null&&u.getPwd().equals(a2)) {
JOptionPane.showMessageDialog(null, "登陆成功,欢迎使用！", "提示", JOptionPane.INFORMATION_MESSAGE);
try {
	new wxdmain();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
jFrame.dispose();
} else {
JOptionPane.showMessageDialog(null, "帐号或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
text1.setText("");
text2.setText("");
}
}
});
jFrame.add(button);
jFrame.add(b1);
jFrame.setSize(220, 200);

jFrame.setVisible(true);
}

}
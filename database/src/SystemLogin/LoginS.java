package SystemLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginS {

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginS window = new LoginS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(76, 71, 79, 38);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(76, 120, 79, 38);
		frame.getContentPane().add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(163, 82, 159, 20);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(165, 131, 157, 20);
		frame.getContentPane().add(txtpassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(180, 11, 79, 38);
		frame.getContentPane().add(lblLogin);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					String url="jdbc:ucanaccess://C:/Users/heathermarchand/eclipse-workspace/database/DB/database1.accdb";
					Connection conn= DriverManager.getConnection(url);
					System.out.println("Connection Successful");
					
					String name=txtusername.getText();
					String password=txtpassword.getText();	
					
					String query="SELECT * from tblUsers where username=? and password=?";
					PreparedStatement statement = conn.prepareStatement(query);
					statement.setString(1,name);
					statement.setString(2,password);
					
					ResultSet set=statement.executeQuery();
					if(set.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful");
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login");
					}
					
				}catch(Exception i) {
				i.printStackTrace();
				System.out.println("Unable to Connect");
			}
			}
		});
		
		btnSubmit.setBounds(180, 180, 89, 23);
		frame.getContentPane().add(btnSubmit);
	
}
}


package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import detail.Sign;

public class Loginform extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField phone_txf;
	private JTextField email_txf;
	private JPasswordField password_txf;

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Loginform frame = new Loginform();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public Loginform() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 600, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(216, 10, 2, 2);
	contentPane.add(scrollPane);
	
	JLabel lblNewLabel = new JLabel("Password");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel.setBounds(86, 135, 91, 14);
	contentPane.add(lblNewLabel);
	
	email_txf = new JTextField();
	email_txf.setBackground(new Color(245, 245, 245));
	email_txf.setBounds(86, 94, 214, 34);
	contentPane.add(email_txf);
	email_txf.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Email");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel_1.setBounds(87, 69, 46, 14);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("LOGIN");
	lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
	lblNewLabel_2.setBounds(133, 10, 116, 29);
	contentPane.add(lblNewLabel_2);
	
	final JButton login = new JButton("LOGIN");
	login.setBackground(new Color(25, 25, 112));
	login.setForeground(new Color(255, 255, 255));
	login.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			Clinic_System menuForm = new Clinic_System();
             // Hide the current login frame
             setVisible(false);
             
			Sign s = new Sign();
			if(e.getSource()==login) {
				s.setEmail(email_txf.getText());
				char[] passwordChars = password_txf.getPassword();
				String passwordString = new String(passwordChars);
				s.setSetpassword(passwordString);
				s.login();
			}
		}
	});
	login.setBounds(88, 225, 212, 39);
	contentPane.add(login);
	
	password_txf = new JPasswordField();
	password_txf.setBackground(new Color(245, 245, 245));
	password_txf.setBounds(88, 160, 212, 34);
	contentPane.add(password_txf);


	// Create New Account Button
     JButton createAccountButton = new JButton("Create New Account");
     createAccountButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Create a new frame for registration form
        	 Signup registrationForm = new Signup();
            
             // Hide the current login frame
             setVisible(false);
         }
     });
     createAccountButton.setBounds(88, 320, 212, 39);
     contentPane.add(createAccountButton);
 }}



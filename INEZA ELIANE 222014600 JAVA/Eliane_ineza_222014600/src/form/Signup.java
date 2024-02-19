package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import detail.Sign;

public class Signup implements ActionListener {
	JFrame frame;
	JLabel fname_lb=new JLabel("First Name");
    JLabel lname_lb=new JLabel( "Last Name");
	JLabel gender_lb=new JLabel("Gender");
	JLabel phone_lb=new JLabel("Telephone");
	JLabel status_lb=new JLabel("Martial Status");
	JLabel Dob_lb=new JLabel("Date of Birth");
	JLabel email_lb=new JLabel("Email");
	JLabel password_lb=new JLabel("Set Password");
	JLabel pin_lb=new JLabel("Confirm Password");
	
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	JTextField phone_txf=new JTextField();
	String []martial_Status={"Select option","Single", "Married","Divorce"};
	JComboBox<String> StatusBox = new JComboBox<>(martial_Status);
	String []Dob={"1988","1989","1990","1991", "1992","1993", "1994","1995", "1996","1997", "1998","1999", "2000",
            "2001", "2002","2003", "2004","2005"};
	JComboBox<String> DobBox = new JComboBox<>(Dob);
	JTextField email_txf=new JTextField();
	JPasswordField password_txf=new JPasswordField();
	JPasswordField pin_txf=new JPasswordField();
	JButton signup_btn=new JButton("SINGN UP");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	
	public Signup() {
		createForm();
	}
	
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                           CREATE ACCOUNT     ");
		frame.setBounds(0, 0, 500, 500);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		setLocationandSize();
		
	}


	private void setLocationandSize() {
		fname_lb.setBounds(10, 10, 100, 30);
		lname_lb.setBounds(10, 50, 100, 30);
		gender_lb.setBounds(10, 90, 100, 30);
		phone_lb.setBounds(10, 130, 100, 30);
		status_lb.setBounds(10, 170, 100, 30);
		Dob_lb.setBounds(10, 210, 100, 30);
		email_lb.setBounds(10, 250, 100, 30);
		password_lb.setBounds(10, 290, 100, 30);
		pin_lb.setBounds(10, 330, 100, 30);

		fname_txf.setBounds(120, 10, 200, 30);
		lname_txf.setBounds(120, 50, 200, 30);
		genderBox.setBounds(120, 90, 200, 30);
		phone_txf.setBounds(120, 130, 200, 30);
		StatusBox.setBounds(120, 170, 200, 30);
		DobBox.setBounds(120, 210, 200, 30);
		email_txf.setBounds(120, 250, 200, 30);
		password_txf.setBounds(120, 290, 200, 30);
		pin_txf.setBounds(120, 330, 200, 30);
		signup_btn.setBounds(100,370, 100, 40);
		addcomponentforFrame();

		
	}


	private void addcomponentforFrame() {
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(gender_lb);
		frame.add(phone_lb);
		frame.add(status_lb);
		frame.add(Dob_lb);
		frame.add(email_lb);
		frame.add(password_lb);
		frame.add(pin_lb);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(genderBox);
		frame.add(phone_txf);
		frame.add(StatusBox);
		frame.add(DobBox);
		frame.add(email_txf);
		frame.add(password_txf);
		frame.add(pin_txf);
		frame.add(signup_btn);
		ActionEvent();
		
	}


	private void ActionEvent() {
	signup_btn.addActionListener(this);
		
	}


	public static void main(String[] args) {
		Signup signup=new Signup();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Sign s= new Sign(null, null, null, null, null, null, null, null, null);
		if (e.getSource()==signup_btn) {
			s.setFname(fname_txf.getText());
			s.setLname(lname_txf.getText());
			String selectedOption=(String) genderBox.getSelectedItem();
			s.setGender(selectedOption);
			s.setPhone(phone_txf.getText());
			String selectedOption1=(String) StatusBox.getSelectedItem();
			s.setGender(selectedOption1);
			String selectedOption2=(String) DobBox.getSelectedItem();
			s.setGender(selectedOption2);
			s.setEmail(email_txf.getText());
			s.setSetpassword(password_txf.getText());
			s.setConfirmpassword(pin_txf.getText());
			s.insertData();
		}
		
	}

}

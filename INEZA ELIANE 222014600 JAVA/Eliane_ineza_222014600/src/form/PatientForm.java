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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import detail.Patient;

public class PatientForm implements ActionListener {

	JFrame frame;
	JLabel Pid_lb=new JLabel("PID");
    JLabel name_lb=new JLabel( "Name");
	JLabel gender_lb=new JLabel("Gender");
	JLabel telephone_lb=new JLabel("Telephone");
	JLabel email_lb=new JLabel("Email");
	JLabel address_lb=new JLabel("Address");
	
	JTextField Pid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	JTextField telephone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	
	public PatientForm() {
     createForm();
		
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                           PATIENT FORM     ");
		frame.setBounds(0, 0, 1000, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		setLocationandSize();
		
	}

	private void setLocationandSize() {
		Pid_lb.setBounds(10, 10, 100, 30);
		name_lb.setBounds(10, 50, 100, 30);
		gender_lb.setBounds(10, 90, 100, 30);
		telephone_lb.setBounds(10, 130, 100, 30);
		email_lb.setBounds(10, 170, 100, 30);
		address_lb.setBounds(10, 210, 100, 30);
		Pid_txf.setBounds(120, 10, 200, 30);
		name_txf.setBounds(120, 50, 200, 30);
		genderBox.setBounds(120, 90, 200, 30);
		telephone_txf.setBounds(120, 130, 200, 30);
		email_txf.setBounds(120, 170, 200, 30);
		address_txf.setBounds(120, 210, 200, 30);
		insert_btn.setBounds(10,290, 80, 30);
		Read_btn.setBounds(90,290, 80, 30);
		update_btn.setBounds(180,290, 80, 30);
		delete_btn.setBounds(270,290, 80, 30);
		table.setBounds(400, 10, 500, 300);
		setFontforall();
		
	}

	private void setFontforall() {
		frame.add(Pid_lb);
		frame.add(name_lb);
		frame.add(gender_lb);
		frame.add(telephone_lb);
		frame.add(email_lb);
		frame.add(address_lb);
		frame.add(Pid_txf);
		frame.add(name_txf);
		frame.add(genderBox);
		frame.add(telephone_txf);
		frame.add(email_txf);
		frame.add(address_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		ActionEvent();
		
	}

	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		addcomponentforFrame();
	}

	private void addcomponentforFrame() {
		frame.add(Pid_lb);
		frame.add(name_lb);
		frame.add(gender_lb);
		frame.add(telephone_lb);
		frame.add(email_lb);
		frame.add(address_lb);
		frame.add(Pid_txf);
		frame.add(name_txf);
		frame.add(genderBox);
		frame.add(telephone_txf);
		frame.add(email_txf);
		frame.add(address_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add( table);
	}

	public static void main(String[] args) {
	PatientForm pf=new PatientForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Patient patient=new Patient(0, null, null, null, null, null);
		if (e.getSource()==insert_btn) {
			patient.setName(name_txf.getText());
			String selectedOption=(String) genderBox.getSelectedItem();
			patient.setGender(selectedOption);
			patient.setTelephone(telephone_txf.getText());
			patient.setEmail(email_txf.getText());
			patient.setAddress(address_txf.getText());
			patient.insertData();
			}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=Patient.populateTable();
			table.setModel(tableModel);
	}else if (e.getSource()==update_btn) {
		int Pid=Integer.parseInt(Pid_txf.getText());
		patient.setName(name_txf.getText());
		patient.setGender((String)genderBox.getSelectedItem());
		patient.setTelephone(telephone_txf.getText());
		patient.setEmail(email_txf.getText());
		patient.setAddress(address_txf.getText());
		patient.update(Pid);
	}else {
		int Pid=Integer.parseInt(Pid_txf.getText());
		patient.delete(Pid);
}
		}}



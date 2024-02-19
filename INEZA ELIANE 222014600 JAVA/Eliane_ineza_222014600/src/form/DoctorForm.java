package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import detail.Doctor;
import detail.Patient;

public class DoctorForm implements ActionListener {
	JFrame frame;
	JLabel Did_lb=new JLabel("DID");
    JLabel name_lb=new JLabel("Name");
	JLabel telephone_lb=new JLabel("Telephone");
	JLabel email_lb=new JLabel("Email");
	JLabel qualification_lb=new JLabel("Qualification");
	JLabel specialisation_lb=new JLabel("Specialization");
	
	JTextField Did_txf=new JTextField();
	JTextField name_txf=new JTextField ();
	JTextField telephone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	String []qualification={"select option....","Assistant doctor", "Doctor"};
	JComboBox<String> qualificationBox = new JComboBox<>(qualification);
	String []specialisation={"select option....","NeuroSurgery", "Pediatrics","Gynecology and Obstetrics","Emergency",
			"Ophthamology","Internal Medicine","Orthopedic Surgery","Dermatology"};
	JComboBox<String> specialisationBox = new JComboBox<>(specialisation);
		
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	
	public DoctorForm () {
		createForm();
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         DOCTOR FORM             ");
		frame.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}

	private void setLocationandSize() {
		Did_lb.setBounds(10, 10, 100, 30);
		name_lb.setBounds(10, 50, 100, 30);
		telephone_lb.setBounds(10, 90, 100, 30);
		email_lb.setBounds(10, 130, 100, 30);
		qualification_lb.setBounds(10, 170, 100, 30);
		specialisation_lb.setBounds(10, 210, 100, 30);
		Did_txf.setBounds(120, 10, 200, 30);
		name_txf.setBounds(120, 50, 200, 30);
		telephone_txf.setBounds(120, 90, 200, 30);
		email_txf.setBounds(120, 130, 200, 30);
		qualificationBox.setBounds(120, 170, 200, 30);
		specialisationBox.setBounds(120, 210, 200, 30);
		table.setBounds(420, 10, 500, 400);

		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		table.setBounds(400, 10, 500, 300);

		setFontforall();
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 12);
		Did_lb.setFont(font);
		name_lb.setFont(font);
		telephone_lb.setFont(font);
		email_lb.setFont(font);
		qualification_lb.setFont(font);
		specialisation_lb.setFont(font);
		
		Did_txf.setFont(font);
		name_txf.setFont(font);
		telephone_txf.setFont(font);
		email_txf.setFont(font);
		qualificationBox.setFont(font);
		specialisationBox.setFont(font);
		table.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}

	private void addcomponentforFrame() {
		frame.add(Did_lb);
		frame.add(name_lb);
		frame.add(telephone_lb);
		frame.add(email_lb);
		frame.add(qualification_lb);
		frame.add(specialisation_lb);
		frame.add(Did_txf);
		frame.add(name_txf);
		frame.add(telephone_txf);
		frame.add(email_txf);
		frame.add(qualificationBox);
		frame.add(specialisationBox);
		frame.add(table);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add( table);

		ActionEvent();
		
	}

	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
	}

	public static void main(String[] args) {
		DoctorForm df=new DoctorForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	Doctor d=new Doctor(0, null, null, null, null, null);
	if (e.getSource()==insert_btn) {
		d.setName(name_txf.getText());
		d.setTelephone(telephone_txf.getText());
		d.setEmail(email_txf.getText());
		String selectedOption=(String) qualificationBox.getSelectedItem();
		d.setQualification(selectedOption);
		String selectedOption1=(String) specialisationBox.getSelectedItem();
		d.setSpecialisation(selectedOption1);
		d.insertData();
		
	}
	else if ((e.getSource()==Read_btn)) {
		DefaultTableModel tableModel=d.populateTable();
		table.setModel(tableModel);

}else if (e.getSource()==update_btn) {
	int Did=Integer.parseInt(Did_txf.getText());
	d.setName(name_txf.getText());
	d.setTelephone(telephone_txf.getText());
	d.setEmail(email_txf.getText());
	d.setQualification((String)qualificationBox.getSelectedItem());
	d.setSpecialisation((String)specialisationBox.getSelectedItem());
	d.update(Did);
	}else {
		int Did=Integer.parseInt(Did_txf.getText());
		d.delete(Did);
}
	}}

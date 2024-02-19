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

import detail.Nurse;
import detail.Patient;

public class NurseForm implements ActionListener{
	JFrame frame;
	JLabel Nid_lb=new JLabel("NID");
    JLabel name_lb=new JLabel("Name");
	JLabel gender_lb=new JLabel("Gender");
	JLabel telephone_lb=new JLabel("Telephone");
	JLabel email_lb=new JLabel("Email");
	
	JTextField Nid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	String []gender={"select option.....","Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	JTextField telephone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	
	public NurseForm() {
		createForm();
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("           NURSE FORM       ");
		frame.setBounds(0, 0, 1000, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}

	private void setLocationandSize() {
		Nid_lb.setBounds(10, 10, 100, 30);
		name_lb.setBounds(10, 50, 100, 30);
		gender_lb.setBounds(10, 90, 100, 30);
		telephone_lb.setBounds(10, 130, 100, 30);
		email_lb.setBounds(10, 170, 100, 30);
		Nid_txf.setBounds(160, 10, 200, 30);
		name_txf.setBounds(160, 50, 200, 30);
		genderBox.setBounds(160, 90, 200, 30);
		telephone_txf.setBounds(160, 130, 200, 30);
		email_txf.setBounds(160, 170, 200, 30);
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		table.setBounds(400, 10, 500, 300);

		setFontforall();
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 12);
		Nid_lb.setFont(font);
		name_lb.setFont(font);
		gender_lb.setFont(font);
		telephone_lb.setFont(font);
		email_lb.setFont(font);
		
		Nid_txf.setFont(font);
		name_txf.setFont(font);
		genderBox.setFont(font);
		telephone_txf.setFont(font);
		email_txf.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}

	private void addcomponentforFrame() {
		frame.add(Nid_lb);
		frame.add(name_lb);
		frame.add(gender_lb);
		frame.add(telephone_lb);
		frame.add(email_lb);
		
		frame.add(Nid_txf);
		frame.add(name_txf);
		frame.add(genderBox);
		frame.add(telephone_txf);
		frame.add(email_txf);
		
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
		NurseForm nf=new NurseForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Nurse n=new Nurse(0, null, null, null, null);
		if (e.getSource()==insert_btn) {
			n.setName(name_txf.getText());
			String selectedOption=(String) genderBox.getSelectedItem();
			n.setGender(selectedOption);
			n.setTelephone(telephone_txf.getText());
			n.setEmail(email_txf.getText());
			n.insertData();
			}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=n.populateTable();
			table.setModel(tableModel);
		
	}
		else if (e.getSource()==update_btn) {
			int Nid=Integer.parseInt(Nid_txf.getText());
			n.setName(name_txf.getText());
			n.setGender((String)genderBox.getSelectedItem());
			n.setTelephone(telephone_txf.getText());
			n.setEmail(email_txf.getText());
			n.update(Nid);
	}
		else {
			int Nid=Integer.parseInt(Nid_txf.getText());
			n.delete(Nid);
}
}}
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

import detail.Clinic;
import detail.Patient;

public class ClinicForm implements ActionListener {
	JFrame frame;
	JLabel Cid_lb=new JLabel("CID");
	JLabel name_lb=new JLabel("Name");
	JLabel location_lb=new JLabel("Location");
	JLabel type_lb=new JLabel("Type");
	
	JTextField Cid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	String []location={"select option.....","Huye", "Muhanga","Ruhango","Nyamagabe","Nyaruguru","Gisagara","kamonyi","Nyanza",
			"Kicukiro","nyarugenge","Gasabo"};
	JComboBox<String> locationBox = new JComboBox<>(location);
	String []type={"select option....","PRIVATE", "PUBLIC"};
	JComboBox<String> typeBox = new JComboBox<>(type);
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();

	public ClinicForm() {
		createForm();
	}
	
	
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         CLINIC FORM            ");
		frame.setBounds(0, 0, 1000, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}



	private void setLocationandSize() {
		Cid_lb.setBounds(10, 10, 100, 30);
		name_lb.setBounds(10, 50, 100, 30);
		location_lb.setBounds(10, 90, 100, 30);
		type_lb.setBounds(10, 130, 100, 30);
		Cid_txf.setBounds(160, 10, 200, 30);
		name_txf.setBounds(160, 50, 200, 30);
		locationBox.setBounds(160, 90, 200, 30);
		typeBox.setBounds(160, 130, 200, 30);
		insert_btn.setBounds(10,170, 100, 30);
		Read_btn.setBounds(100,170, 100, 30);
		update_btn.setBounds(190,170, 100, 30);
		delete_btn.setBounds(280,170, 100, 30);
		table.setBounds(400, 10, 500, 300);
		setFontforall();
		
	}



	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 12);
		Cid_lb.setFont(font);
		name_lb.setFont(font);
		location_lb.setFont(font);
		type_lb.setFont(font);
		
		
		Cid_txf.setFont(font);
		name_txf.setFont(font);
		locationBox.setFont(font);
		typeBox.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}

	private void addcomponentforFrame() {
		frame.add(Cid_lb);
		frame.add(name_lb);
		frame.add(location_lb);
		frame.add(type_lb);
		frame.add(Cid_txf);
		frame.add(name_txf);
		frame.add(locationBox);
		frame.add(typeBox);
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
		ClinicForm cl=new ClinicForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Clinic c=new Clinic(0, null, null, null);
		if (e.getSource()==insert_btn) {
			c.setName(name_txf.getText());
			String selectedOption=(String) locationBox.getSelectedItem();
			c.setLocation(selectedOption);
			String selectedOption1=(String) typeBox.getSelectedItem();
			c.setType(selectedOption1);
			c.insertData();
	}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=c.populateTable();
			table.setModel(tableModel);


}else if (e.getSource()==update_btn) {
	int Cid=Integer.parseInt(Cid_txf.getText());
	c.setName(name_txf.getText());
	c.setLocation((String)locationBox.getSelectedItem());
	c.setType((String)typeBox.getSelectedItem());
	c.update(Cid);
		}else {
			int Cid=Integer.parseInt(Cid_txf.getText());
			c.delete(Cid);
	}
}}
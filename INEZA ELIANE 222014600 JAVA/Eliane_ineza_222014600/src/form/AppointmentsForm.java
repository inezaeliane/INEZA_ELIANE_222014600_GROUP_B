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

import detail.Appointment;
import detail.Patient;

public class AppointmentsForm  implements ActionListener{
	JFrame frame;
	JLabel Aid_lb=new JLabel("AID");
	JLabel issuedate_lb=new JLabel("IssueDate");
	JLabel returndate_lb=new JLabel("ReturnDate");
	JLabel Pid_lb=new JLabel("Patient ");
	JLabel Cid_lb=new JLabel("Clinic ");
	JLabel Did_lb=new JLabel("Doctor");
	
	
	JTextField Aid_txf=new JTextField();
	JTextField issuedate_txF=new	JTextField();
	JTextField returndate_txf=new JTextField();
	JTextField Pid_txF=new	JTextField();
	JTextField Cid_txf=new JTextField();
	JTextField Did_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();

	public AppointmentsForm() {
		createForm();
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         APPOINTMENT FORM            ");
		frame.setBounds(0, 0, 1000, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
		
	}

	private void setLocationandSize() {
		Aid_lb.setBounds(10, 10, 100, 30);
		issuedate_lb.setBounds(10, 50, 100, 30);
		returndate_lb.setBounds(10, 90, 100, 30);
		Pid_lb.setBounds(10, 130, 100, 30);
		Cid_lb.setBounds(10, 170, 100, 30);
		Did_lb.setBounds(10, 210, 100, 30);
		Aid_txf.setBounds(120, 10, 200, 30);
		issuedate_txF.setBounds(120, 50, 200, 30);
		returndate_txf.setBounds(120, 90, 200, 30);
		Pid_txF.setBounds(120, 130, 200, 30);
		Cid_txf.setBounds(120, 170, 200, 30);
		Did_txf.setBounds(120, 210, 200, 30);
		insert_btn.setBounds(10,250, 100, 30);
		Read_btn.setBounds(100,250, 100, 30);
		update_btn.setBounds(190,250, 100, 30);
		delete_btn.setBounds(280,250, 100, 30);
		table.setBounds(400, 10, 500, 300);

		setFontforall();
		
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 12);
		Aid_lb.setFont(font);
		issuedate_lb.setFont(font);
		returndate_lb.setFont(font);
		Pid_lb.setFont(font);
		Cid_lb.setFont(font);
		Did_lb.setFont(font);
		
		Aid_txf.setFont(font);
		issuedate_txF.setFont(font);
		returndate_txf.setFont(font);
		Pid_txF.setFont(font);
		Cid_txf.setFont(font);
		Did_txf.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}

	private void addcomponentforFrame() {
		frame.add(Aid_lb);
	    frame.add(issuedate_lb);
	    frame.add(returndate_lb);
		frame.add(Pid_lb);
		frame.add(Cid_lb);
		frame.add(Did_lb);
		frame.add(Aid_txf);
		frame.add(issuedate_txF);
		frame.add(returndate_txf);
		frame.add(Pid_txF);
		frame.add(Cid_txf);
		frame.add(Did_txf);
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
		AppointmentsForm AF=new AppointmentsForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Appointment a=new Appointment(0, null, null, null, null, null);
		if (e.getSource()==insert_btn) {
	         a.setIssueDate(issuedate_txF.getText());
			a.setReturnDate(returndate_txf.getText());
		    a.setPid(Pid_txF.getText());
			a.setCid(Cid_txf.getText());
			a.setDid(Did_txf.getText());
			a.insertData();
			
			}
		else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=a.populateTable();
			table.setModel(tableModel);

		}
		else if (e.getSource()==update_btn) {
			int Aid=Integer.parseInt(Aid_txf.getText());
			a.setIssueDate(issuedate_txF.getText());
			a.setReturnDate(returndate_txf.getText());
		    a.setPid(Pid_txF.getText());
			a.setCid(Cid_txf.getText());
			a.setDid(Did_txf.getText());

			a.update(Aid);
		
	}
		else {
			int Aid=Integer.parseInt(Aid_txf.getText());
			a.delete(Aid);

}
}}
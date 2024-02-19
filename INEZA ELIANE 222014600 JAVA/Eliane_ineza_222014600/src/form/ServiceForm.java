package form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import detail.Service;

public class ServiceForm implements ActionListener{
	JFrame frame;
	JLabel Sid_lb=new JLabel("SID");
	JLabel Servicename_lb=new JLabel("Service Name");
	JLabel Servicecost_lb=new JLabel("Service Cost");
	JLabel Pid_lb=new JLabel("Patient ");
	JLabel Cid_lb=new JLabel("Clinic ");
	JLabel Did_lb=new JLabel("Doctor");
	JLabel Aid_lb=new JLabel("Appointment");
	
	JTextField Sid_txf=new JTextField();
	JTextField Servicename_txF=new	JTextField();
	JTextField Servicecost_txf=new JTextField();
	JTextField Pid_txF=new	JTextField();
	JTextField Cid_txf=new JTextField();
	JTextField Did_txf=new JTextField();
	JTextField Aid_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	public ServiceForm () {
		createForm();
	}

	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         CLINIC SERVICE           ");
		frame.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
		
	}

	private void setLocationandSize() {
		Sid_lb.setBounds(10, 10, 150, 30);
		Servicename_lb.setBounds(10, 50, 150, 30);
		Servicecost_lb.setBounds(10, 90, 150, 30);
		Pid_lb.setBounds(10, 130, 150, 30);
		Cid_lb.setBounds(10, 170, 150, 30);
		Did_lb.setBounds(10, 210, 150, 30);
		Aid_lb.setBounds(10, 250, 150, 30);
		Sid_txf.setBounds(160, 10, 200, 30);
		Servicename_txF.setBounds(160, 50, 200, 30);
		Servicecost_txf.setBounds(160, 90, 200, 30);
		Pid_txF.setBounds(160, 130, 200, 30);
		Cid_txf.setBounds(160, 170, 200, 30);
		Did_txf.setBounds(160, 210, 200, 30);
		Aid_txf.setBounds(160, 250, 200, 30);
		insert_btn.setBounds(10,320, 100, 30);
		Read_btn.setBounds(100,320, 100, 30);
		update_btn.setBounds(190,320, 100, 30);
		delete_btn.setBounds(280,320, 100, 30);
		table.setBounds(400, 10, 500, 300);
		setFontforall();
		
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		Sid_lb.setFont(font);
		Servicename_lb.setFont(font);
		Servicecost_lb.setFont(font);
		Pid_lb.setFont(font);
		Cid_lb.setFont(font);
		Did_lb.setFont(font);
		Aid_lb.setFont(font);
		
		Sid_txf.setFont(font);
		Servicename_txF.setFont(font);
		Servicecost_txf.setFont(font);
		Pid_txF.setFont(font);
		Cid_txf.setFont(font);
		Did_txf.setFont(font);
		Aid_txf.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}

	private void addcomponentforFrame() {
		frame.add(Sid_lb);
	    frame.add(Servicename_lb);
	    frame.add(Servicecost_lb);
		frame.add(Pid_lb);
		frame.add(Cid_lb);
		frame.add(Did_lb);
		frame.add(Aid_lb);
		frame.add(Sid_txf);
		frame.add(Servicename_txF);
		frame.add(Servicecost_txf);
		frame.add(Pid_txF);
		frame.add(Cid_txf);
		frame.add(Did_txf);
		frame.add(Aid_txf);
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
		ServiceForm sf=new ServiceForm();
				

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Service s=new Service(0, null, 0, null, null, null, null);
		if (e.getSource()==insert_btn) {
	         s.setService_name(Servicename_txF.getText());
	         s.setService_cost(Integer.parseInt(Servicecost_txf.getText()));
		    s.setPid(Pid_txF.getText());
			s.setCid(Cid_txf.getText());
			s.setDid(Did_txf.getText());
			s.setAid(Aid_txf.getText());
			s.insertData();
			s.viewData();
			}else if ((e.getSource()==Read_btn)) {

				DefaultTableModel tableModel=s.populateTable();
				table.setModel(tableModel);
			}else if (e.getSource()==update_btn) {
				int Sid=Integer.parseInt(Sid_txf.getText());
				s.setService_name(Servicename_txF.getText());
				s.setService_cost(Integer.parseInt(Servicecost_txf.getText()));
			    s.setPid(Pid_txF.getText());
				s.setCid(Cid_txf.getText());
				s.setDid(Did_txf.getText());
				s.setAid(Aid_txf.getText());
				s.update(Sid);
	}
			else {
				int Sid=Integer.parseInt(Sid_txf.getText());
				s.delete(Sid);
		}

}}

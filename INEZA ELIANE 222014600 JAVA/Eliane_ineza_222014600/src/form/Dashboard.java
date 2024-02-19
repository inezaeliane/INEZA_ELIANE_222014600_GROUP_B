package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard implements ActionListener{
	JFrame frame;
	JMenu home, Patient, Doctor, Nurse, Clinic,Appointment ,Service;
	JMenuItem  Insert,Display,Update,Delete;
	public Dashboard() {
		createWindow();
	
} 
			
private void createWindow() {
	frame = new JFrame("Menu form with main Menu");
	frame.setSize(400, 400);

	JMenuBar mb = new JMenuBar(); // Create a new menu bar
	home = new JMenu("Home");
	Patient = new JMenu("Patient");
	Doctor = new JMenu("Doctor");
	//Nurse = new JMenu("Nurse");
	//Clinic=new JMenu("Clinic");

	Insert = new JMenuItem("Insert");
	Display = new JMenuItem("Display");
	Update = new JMenuItem("Update");
	Delete=new JMenuItem("Delete");
	Patient.add(Insert);
	Patient.add(Display);
	Patient.add(Update);
	Patient.add(Delete);
	
	Insert = new JMenuItem("Insert");
	Display = new JMenuItem("Display");
	Update = new JMenuItem("Update");
	Delete=new JMenuItem("Delete");
	Doctor.add(Insert);
	Doctor.add(Display);
	Doctor.add(Update);
	Doctor.add(Delete);
	
	/*Insert = new JMenuItem("Insert");
	Read = new JMenuItem("Read");
	Update = new JMenuItem("Update");
	Delete=new JMenuItem("Delete");
	Nurse.add(Insert);
	Nurse.add(Read);
	Nurse.add(Update);
	Nurse.add(Delete);
	
	Insert = new JMenuItem("Insert");
	Read = new JMenuItem("Read");
	Update = new JMenuItem("Update");
	Delete=new JMenuItem("Delete");
	Clinic.add(Insert);
	Clinic.add(Read);
	Clinic.add(Update);
	Clinic.add(Delete);*/
	
	mb.add(home);
	mb.add(Patient);
	mb.add(Doctor);
	//mb.add(Nurse);
	//mb.add(Clinic);

	frame.setJMenuBar(mb); // Set the menu bar to the frame

	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	componentsOnFrame();
	}


	private void componentsOnFrame() {
		home = new JMenu("Home");
		Patient = new JMenu("Patient");
		Doctor = new JMenu("Doctor");
		//Nurse = new JMenu("Nurse");
		//Clinic=new JMenu("Clinic");
		
		addactionEvent();
	
}

	private void addactionEvent() {
		Display.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new Dashboard();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Display) {
			PatientForm pf=new PatientForm();
			frame.dispose();
		
	}

}
}
package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Clinic_System implements ActionListener {
	JFrame frame;
	JMenu home,  Patient, Doctor, Nurse, Clinic,Appointment ,Service, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,PatientDelete,PatientUpdate,PatientRead;
	JMenuItem DoctorDelete,DoctorUpdate,DoctorRead;
	JMenuItem NurseDelete,NurseUpdate,NurseRead;
	JMenuItem ClinicDelete,ClinicUpdate,ClinicRead;
	JMenuItem AppointmentDelete,AppointmentUpdate,AppointmentRead;
	JMenuItem ServiceDelete,ServiceUpdate,ServiceRead;
	
	
	Clinic_System (){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Patient = new JMenu("Patient");
		Doctor= new JMenu("Doctor");
		Nurse = new JMenu("Nurse");
		Clinic=new JMenu("Clinic");
		Appointment=new JMenu("Appointment");
		Service=new JMenu("Service");

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		PatientRead = new JMenuItem("Read");
		PatientUpdate = new JMenuItem("Update");
		PatientDelete = new JMenuItem("Delete");
		Patient.add(PatientRead);
		Patient.add(PatientUpdate);
		Patient.add(PatientDelete);

		DoctorRead =new JMenuItem("Read");
		DoctorUpdate =new JMenuItem("Update");
		DoctorDelete =new JMenuItem("Delete");
		
		Doctor.add(DoctorRead);
		Doctor.add(DoctorUpdate);
		Doctor.add(DoctorDelete);
		
		NurseRead =new JMenuItem("Read");
		NurseUpdate =new JMenuItem("Update");
		NurseDelete =new JMenuItem("Delete");
		Nurse.add(NurseRead);
		Nurse.add(NurseUpdate);
		Nurse.add(NurseDelete);
		
		ClinicRead =new JMenuItem("Read");
		ClinicUpdate =new JMenuItem("Update");
		ClinicDelete =new JMenuItem("Delete");
		Clinic.add(ClinicRead);
		Clinic.add(ClinicUpdate);
		Clinic.add(ClinicDelete);
		
		AppointmentRead =new JMenuItem("Read");
		AppointmentUpdate =new JMenuItem("Update");
		AppointmentDelete =new JMenuItem("Delete");
		Appointment.add(AppointmentRead);
		Appointment.add(AppointmentUpdate);
		Appointment.add(AppointmentDelete);
		
		ServiceRead =new JMenuItem("Read");
		ServiceUpdate =new JMenuItem("Update");
		ServiceDelete =new JMenuItem("Delete");
		Service.add(ServiceRead);
		Service.add(ServiceUpdate);
		Service.add(ServiceDelete);
		
		
		

		

		mb.add(home);
		mb.add(Patient);
		mb.add(Doctor);
		mb.add(Nurse);
		mb.add(Clinic);
		mb.add(Appointment);
		mb.add(Service);
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		Patient = new JMenu("Patient");
		Doctor = new JMenu("Doctor");
		Nurse =new JMenu("Nurse");
		Clinic =new JMenu("Clinic");
		Appointment=new JMenu("Appointment");
		Service =new JMenu("Service");
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Patient.add(i2);
		Patient.add(i3);
		Patient.add(i4);
		Doctor.add(i2);
		Doctor.add(i3);
		Doctor.add(i4);
		Nurse.add(i2);
		Nurse.add(i3);
		Nurse.add(i4);
		Clinic.add(i2);
		Clinic.add(i3);
		Clinic.add(i4);
		Appointment.add(i2);
		Appointment.add(i3);
		Appointment.add(i4);
		Service.add(i2);
		Service.add(i3);
		Service.add(i4);
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		PatientRead.addActionListener(this);
		DoctorRead.addActionListener(this);
		NurseRead.addActionListener(this);
		ClinicRead.addActionListener(this);
		AppointmentRead.addActionListener(this);
		ServiceRead.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new Clinic_System();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==PatientRead) {
			PatientForm pf=new PatientForm();
			frame.dispose();
		}else if (e.getSource()==DoctorRead) {
			DoctorForm df=new DoctorForm();
			frame.dispose();
		}else if (e.getSource()==NurseRead) {
			NurseForm nf=new NurseForm();
			frame.dispose();
		}else if (e.getSource()==ClinicRead) {
			ClinicForm cf=new ClinicForm();
			frame.dispose();
			}else if (e.getSource()==AppointmentRead) {
				AppointmentsForm af=new AppointmentsForm();
				frame.dispose();
				}else if (e.getSource()==ServiceRead) {
					ServiceForm sf=new ServiceForm();
					frame.dispose();
	}

}
}
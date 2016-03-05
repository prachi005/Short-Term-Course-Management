import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import javax.swing.JTextField;



import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Component;

public class Erp {
	static  ArrayList<Faculty> facultyList =new ArrayList<Faculty>();
	static  ArrayList<Student> studentList =new ArrayList<Student>();
	static  ArrayList<Course> courseList =new ArrayList<Course>();
	private JFrame frame;
	int selC=-1;
	
	
  
	
	CardLayout cl = new CardLayout();
	JPanel panelCont = new JPanel();
	public JTextArea display;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erp window = new Erp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Erp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		  
        try
     {
        File f= new File("kgp.ser");
         
        if(!f.exists()){
           f.createNewFile();
           
          // JOptionPane.showConfirmDialog(null, "New file created");
                    
           }
           else{
               FileInputStream fileIn = new FileInputStream(f);
               ObjectInputStream in = new ObjectInputStream(fileIn);
               facultyList= (ArrayList<Faculty>)in.readObject();
               studentList= (ArrayList<Student>)in.readObject();
              courseList= (ArrayList<Course>)in.readObject();
                    in.close();
                     fileIn.close();
                    
                     //JOptionPane.showConfirmDialog(null, "file successfully read");
                    

                    

           }
     }catch(IOException i)
        {
    	 JOptionPane.showConfirmDialog(null, "Empty File");
          
        }catch(ClassNotFoundException c)
        {
        	 JOptionPane.showConfirmDialog(null, "class not found");
           
           
        }

		frame = new JFrame("erp");
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setMaximumSize(new Dimension(300, 300));
		frame.setBounds(new Rectangle(65, 24, 100, 300));
		frame.setBounds(100, 100, 426, 300);
		 //frame.setSize(10000,900);
		 // frame.setMinimumSize(new Dimension(300,300));
		 // frame.setMaximumSize(new Dimension(300,300));
		    frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainpanel = new JPanel();
		JPanel coursepanel = new JPanel();
		JPanel participantpanel = new JPanel();
		JPanel instructorpanel = new JPanel();
		JPanel cordypanel = new JPanel();
		JPanel viewpanel = new JPanel();
		
		//mainpanel buttons
		JButton bNCourse = new JButton("Add new Course");
		JButton bCourse = new JButton("Edit Course");
		JButton bNStudent = new JButton("New Student");
		JButton bStudent = new JButton("Edit Student");
		JButton bNFaculty = new JButton("New Faculty");
		JButton bFaculty = new JButton("Edit Faculty");
		JButton bCDel= new JButton("Delete Course");
		JButton bListAll= new JButton("List All Courses");
		mainpanel.setLayout(new GridLayout(0,2,15,10));
		mainpanel.add(bNCourse);
		mainpanel.add(bCourse);
		mainpanel.add(bNStudent);
		mainpanel.add(bStudent);
		mainpanel.add(bNFaculty);
		mainpanel.add(bFaculty);
		mainpanel.add(bCDel);
		mainpanel.add(bListAll);
		
		

		//edit Course
		
		bCourse.addActionListener(new MainAct("2"));
		//bStudent.addActionListener(new MainAct("3"));
		//bFaculty.addActionListener(new MainAct("4"));

		//newStudent
		bNStudent.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent s1) {
				Student s=new Student();
				s.newStudent();
				
				studentList.add(s);
				savefile();
				
				
				
			}
		});
		
		
		//editStudent
		bStudent.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent se) {
			String name=JOptionPane.showInputDialog("Enter name of student");
			Student s=studentList.get(searchStudent(name));
				s.editStudent();
				
				savefile();
				
				
				
			}
		});
		
		
		bFaculty.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent se) {
			String name=JOptionPane.showInputDialog("Enter name of faculty");
			Faculty s=facultyList.get(searchFaculty(name));
				s.editFaculty();
				
				savefile();
				
				
			}
		});
		
		
		
		//new course
		bNCourse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent c1) {
				Course s=new Course();
				s.newCourse();
				
				
				courseList.add(s);
				savefile();
				
			}
		});
		
		//new Faculty
		bNFaculty.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent f1) {
				Faculty s=new Faculty();
				s.newFaculty();
				
				facultyList.add(s);
				savefile();
				
				}
				
		});
		
		
bCDel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent l1) {
				clear();
				savefile();
				String nam=JOptionPane.showInputDialog("Enter course name");
				int c= searchCourse(nam);
				if(c==-1){
					JOptionPane.showMessageDialog(null, "No Such course");
				}
				else{
					
			        
			        courseList.remove(c);
			        savefile();
				}
			}
				
		});
bListAll.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent l2) {
		clear();
		savefile();
		frame.setTitle("List of all Courses");
		cl.show(panelCont, "6");
		display.setText("");

		Date present =new Date();
        Calendar c = Calendar.getInstance(); 
        Date temp;
        for(Course x : courseList){
        temp=x.getStartDate();
        c.setTime(temp); 
        c.add(Calendar.DATE, x.getDuration()+365*5);
        temp = c.getTime();
        if(temp.after(present)){
        	  x.list(display);
              display.append("\n\n");        }
	
      }
		
		
       
		
	}
		
});


		
		
		
		
		
		// edit coursepanel buttons
		JButton bFee = new JButton("Edit fees");
		JButton bDuration = new JButton("Edit Duration");
		JButton bCordy = new JButton("Edit Coordinator");
		JButton bParticipant = new JButton("Edit Student");
		JButton bmainmenu = new JButton("Main menu");
		JButton bInstructor = new JButton("Edit Faculty");
		
		
		coursepanel.setLayout(new GridLayout(0,1,50,20));
		coursepanel.add(bFee);
		coursepanel.add(bDuration);
		coursepanel.add(bCordy);
		coursepanel.add(bParticipant);
		coursepanel.add(bInstructor);
		coursepanel.add(bmainmenu);
		
		
		//course panel actions
		bFee.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent c1) {
				String core= JOptionPane.showInputDialog("Enter course name");
				int n= searchCourse(core);
				if(n==-1){
					JOptionPane.showMessageDialog(null, "No such course exists");
				}
				else{
					
			String nfee=JOptionPane.showInputDialog("Enter new Fees");
			 
            try {
                long fee =Long.parseLong(nfee);
                courseList.get(n).setCourseFee(fee);
                JOptionPane.showMessageDialog(null, "Fee changed");
                savefile();
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Invalid data");
           

        }
			
				}
			
			}
		});
		
		
		
bDuration.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent c2) {
				String core= JOptionPane.showInputDialog("Enter course name");
				int n= searchCourse(core);
				if(n==-1){
					JOptionPane.showMessageDialog(null, "No such course exists");
				}
				else{
					
			String nfee=JOptionPane.showInputDialog("Enter new Duration in days");
			 
            try {
                int dura =Integer.parseInt(nfee);
                courseList.get(n).setDuration(dura);
                JOptionPane.showMessageDialog(null, "Duration changed");
                savefile();
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Invalid data");
           

        }
			
				}
			
			}
		});
		
		bmainmenu.addActionListener(new MainAct("1"));
		


		
bParticipant.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent s3) {
				String nam=JOptionPane.showInputDialog("Enter name of course");
				selC= searchCourse(nam);
				if(selC==-1){
					JOptionPane.showMessageDialog(null, "no such Course exists");
				}
				else{
					frame.setTitle("Edit course: "+courseList.get(selC).getName()+" Participants");
				cl.show(panelCont, "3");
				}
			}
				
		});

bInstructor.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent c4) {
		String nam=JOptionPane.showInputDialog("Enter name of course");
		selC= searchCourse(nam);
		if(selC==-1){
			JOptionPane.showMessageDialog(null, "no such Course exists");
		}
		else{
			frame.setTitle("Edit course: "+courseList.get(selC).getName()+" Instructors");
		cl.show(panelCont, "4");
		}
	}
		
});

bCordy.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent s3) {
		String nam=JOptionPane.showInputDialog("Enter name of course");
		selC= searchCourse(nam);
		if(selC==-1){
			JOptionPane.showMessageDialog(null, "no such Course exists");
		}
		else{
			frame.setTitle("Edit course: "+courseList.get(selC).getName()+ " Coordinators");
		cl.show(panelCont, "5");
		}
	}
		
});

		//bParticipant.addActionListener(new MainAct("3"));
		//bInstructor.addActionListener(new MainAct("4"));
		//bCordy.addActionListener(new MainAct("5"));
		

		
		panelCont.setLayout(cl);
		
		panelCont.add(mainpanel, "1");
		panelCont.add(coursepanel, "2");
		panelCont.add(participantpanel, "3");
		panelCont.add(instructorpanel, "4");
		panelCont.add(cordypanel, "5");
		panelCont.add(viewpanel, "6");
		viewpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 376, 223);
		viewpanel.add(scrollPane);
		
		display = new JTextArea();
		scrollPane.setViewportView(display);
		display.setColumns(10);
		display.setEditable(false);
		JButton bLmain = new JButton("Main Menu");
		bLmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				savefile();
				frame.setTitle("ERP");
				cl.show(panelCont, "1");
			}
		});
		bLmain.setBounds(133, 235, 117, 25);
		viewpanel.add(bLmain);
		cordypanel.setLayout(null);
		
		
		cl.show(panelCont, "1");
		
		
		//instructorpanel
		
		JButton bInew = new JButton("Create Add new Faculty");
		bInew.setBounds(42, 72, 299, 25);
		JButton bIassign = new JButton("Add an existing Faculty to the Course");
		bIassign.setBounds(42, 109, 299, 25);
		JButton bIedit = new JButton("Edit Instructor Details");
		bIedit.setBounds(42, 146, 299, 25);
		JButton bIdelete = new JButton("Delete Faculty");
		bIdelete.setBounds(42, 183, 299, 25);
		JButton bImain = new JButton("Main menu");
		bImain.setBounds(153, 220, 111, 25);
		instructorpanel.setLayout(null);
		instructorpanel.add(bInew);
		instructorpanel.add(bIassign);
		instructorpanel.add(bIedit);
		instructorpanel.add(bIdelete);
		instructorpanel.add(bImain);
		
		JLabel label = new JLabel("Edit Instructors");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBounds(124, 30, 118, 15);
		instructorpanel.add(label);
bInew.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent f1) {
				 Faculty ins = new Faculty();
				 ins.newFaculty();
				 facultyList.add(ins);
				 courseList.get(selC).instructors.add(ins);
				 savefile();
				 
				
			}
				
		});

bIassign.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent f2) {
		 String nam=JOptionPane.showInputDialog("Enter name of instructor");
		 int selF= searchFaculty(nam);
		 if(selF==-1){
			 JOptionPane.showMessageDialog(null, "No such faculty exists"  );
		 }
		 else{
		 courseList.get(selC).instructors.add(facultyList.get(selF));
		 savefile();
		 }
		 
		
	}
		
});


bIedit.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent f3) {
		 String nam=JOptionPane.showInputDialog("Enter name of instructor");
		 int selF= courseList.get(selC).searchInstructor(nam);
		 if(selF==-1){
			 JOptionPane.showMessageDialog(null, "No such instructor is alloted this course"  );
		 }
		 else{
		 courseList.get(selC).instructors.get(selF).editFaculty();
		 savefile();
		 }
		 
		
	}
		
});
	

bIdelete.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent f4) {
		 deleteInstructor(courseList.get(selC));
		 savefile();
		
	}
	
		
});
	
		
bImain.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent s3) {
		clear();
		savefile();
		frame.setTitle("ERP");
		cl.show(panelCont, "2");
		
	}
		
});	
		
		
		//participantpanel
		
				JButton bPnew = new JButton("Add new participant");
				bPnew.setBounds(32, 71, 326, 25);
				JButton bPassign = new JButton("Add an existing Participant to the Course");
				bPassign.setBounds(32, 108, 326, 25);
				JButton bPedit = new JButton("Edit Participant");
				bPedit.setBounds(32, 140, 326, 25);
				JButton bPdelete = new JButton("Delete Participant");
				bPdelete.setBounds(32, 177, 326, 25);
				JButton bPmain = new JButton("mainmenu");
				bPmain.setBounds(130, 214, 142, 25);
				participantpanel.setLayout(null);
				participantpanel.add(bPnew);
				participantpanel.add(bPassign);
				participantpanel.add(bPedit);
				participantpanel.add(bPdelete);
				participantpanel.add(bPmain);
				
				JLabel lblEditParticipants = new JLabel("Edit Participants");
				lblEditParticipants.setBounds(130, 26, 126, 25);
				participantpanel.add(lblEditParticipants);
		
		
				bPnew.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent p1) {
						 Student ins = new Student();
						 ins.newStudent();
						 studentList.add(ins);
						 courseList.get(selC).participants.add(ins);
						 savefile();
						 
						
					}
						
				});
				
				bPmain.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent s3) {
						clear();
						savefile();
						frame.setTitle("erp");
						cl.show(panelCont, "2");
						
					}
						
				});	
					

		bPassign.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent p2) {
				 String nam=JOptionPane.showInputDialog("Enter name of participant");
				 int selP= searchStudent(nam);
				 if(selP==-1){
					 JOptionPane.showMessageDialog(null, "No such participant is alloted this course"  );
				 }
				 else{
				 courseList.get(selC).participants.add(studentList.get(selP));
				 savefile();
				 }
				
			}
				
		});


		bPedit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent p3) {
				 String nam=JOptionPane.showInputDialog("Enter name of participant");
				 int selF= courseList.get(selC).searchParticipant(nam);
				 if(selF==-1){
					 JOptionPane.showMessageDialog(null, "No such participant is alloted this course"  );
				 }
				 else{
				 courseList.get(selC).participants.get(selF).editStudent();
				 savefile();
				 }
				 
				
			}
				
		});
			

		bPdelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent p4) {
				 deleteParticipant(courseList.get(selC));
				 savefile();
				
			}
			
				
		});
		
		
		
		//CordyPanel
		
		JButton button = new JButton("Edit Coordinator Details");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cd4) {
				
				 
				 if(courseList.get(selC).getCoordinator()==null){
					 JOptionPane.showMessageDialog(null, "No  coordinator has been  alloted this course"  );
				 }
				 else{
				 courseList.get(selC).getCoordinator().editFaculty();
				 savefile();
				 }
			}
		});
		button.setBounds(73, 57, 261, 25);
		cordypanel.add(button);
		
		JButton btnCreateAndAssign = new JButton("Create and assign new Coordinator");
		btnCreateAndAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cd3) {
				 Faculty ins = new Faculty();
				 ins.newFaculty();
				 facultyList.add(ins);
				 courseList.get(selC).setCoordinator(ins);
				 savefile();
			}
		});
		btnCreateAndAssign.setBounds(73, 94, 261, 25);
		cordypanel.add(btnCreateAndAssign);
		
		JButton btnAssignAnExisting = new JButton("Assign an Existing Coordinator");
		btnAssignAnExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cd2) {
				String cord=JOptionPane.showInputDialog("Enter name of faculty");
				int assg=searchFaculty(cord);
				if(assg==-1){
					JOptionPane.showMessageDialog(null, "No such Faculty Exists");
				}
				else{
					courseList.get(selC).setCoordinator(facultyList.get(assg));
					savefile();
				}
			}
		});
		btnAssignAnExisting.setBounds(73, 131, 261, 25);
		cordypanel.add(btnAssignAnExisting);
		
		JButton bCdmain = new JButton("Back");
		bCdmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cd1) {
				clear();
				savefile();
				frame.setTitle("ERP");
				cl.show(panelCont, "2");
			}
		});
		bCdmain.setBounds(146, 182, 117, 25);
		cordypanel.add(bCdmain);
		
		
		
		
		
		   
		
	
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);


		
		
		
		

	}
	
	//Initialize finish
	
	
	
	
	
	
	
	
	
	

	



public int searchCourse(String t)
{

    for(int n = 0; n < courseList.size(); n++)
    {
         if(courseList.get(n).compareTo(t) == 1)
         {  

              return n;
         }
    }
    return -1;
}
	//Action Listener for changing cardpanel MainAct(int n)
	private class MainAct implements ActionListener{
		String choice;
		MainAct(String s){
			 choice=s;
			
		}
		
	// change panel
		public void actionPerformed(ActionEvent arg) {
			cl.show(panelCont, choice);
		}
		
		
		
	}
	
	
	
	public void savefile(){

        FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream("kgp.ser");
      out = new ObjectOutputStream(fos);
      out.writeObject(facultyList);
            out.writeObject(studentList);
                  out.writeObject(courseList);

      out.close();
      fos.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
	}
	
	 public int searchStudent(String t)
	    {

	        for(int n = 0; n < studentList.size(); n++)
	        {
	             if(studentList.get(n).compareTo(t) == 1)
	             {  

	                  return n;
	             }
	        }
	        return -1;
	    }

	 
	 
	 public int searchFaculty(String t)
	    {

	        for(int n = 0; n < facultyList.size(); n++)
	        {
	             if(facultyList.get(n).compareTo(t) == 1)
	             {  

	                  return n;
	             }
	        }
	        return -1;
	    }
	 
	 
	  public void deleteInstructor(Course core){
		  String nam = JOptionPane.showInputDialog("Enter name of Instructor to be deleted");
	        int pos= core.searchInstructor(nam);
	        if(pos==-1){
	            JOptionPane.showMessageDialog(null, "There is no Instructor with name:"+nam+" in this course ");
	           
	        }
	        else{
	        	core.instructors.remove(pos);
	        }
	  }
	  
	  public void deleteParticipant(Course core){
		  String nam = JOptionPane.showInputDialog("Enter name of participant to be deleted");
	        int pos= core.searchParticipant(nam);
	        if(pos==-1){
	            JOptionPane.showMessageDialog(null, "There is no Student with name:"+nam+" in this course ");
	           
	        }
	        else{
	        	core.participants.remove(pos);
	        }
	  }
	  public void clear(){
		 try{
		  if(courseList!=null){
		  for(Course x: courseList){
			  
			  if(x.getName()==null){
				 
				  courseList.remove(x);
			  }
			  else {
				 

				  x.clear();
			  }
		  }
		  }
		 }catch(Exception ee){
			 
			  clear();
		  }
		 
		 try{
		  if(studentList!=null){
		  for(Student x: studentList){
			  if(x.getName()==null){
				  studentList.remove(x);
			  }
		  }
		  }
		 }catch(Exception ew){
			 
			  clear();
		  }
		 
		 try{ 
		  if(facultyList!=null){
		  for(Faculty x: facultyList){
			  if(x.getFacultyName()==null){
				  facultyList.remove(x);
			  }
		  }
		  }
		 }catch(Exception eq){
			 
			  clear();
		  }
	 
		  
	  }

}


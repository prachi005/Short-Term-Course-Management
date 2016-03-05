

import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JTextArea;

import java.io.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.awt.event.InputMethodEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class Course implements Serializable {
	private String courseName;
	private long fee;
	private Date startDate;
	private int duration ;
	private Faculty coordinator;
	public ArrayList<Faculty> instructors  = new ArrayList<Faculty>();
	public ArrayList<Student> participants = new ArrayList<Student>();
	
	final JFrame  newSFrame = new JFrame("Add New Course");
    JLabel lName = new JLabel("Name: ");
    JLabel lFees = new JLabel("Fees: ");
    JLabel lStartD = new JLabel("Start Date(dd-mm-yyyy): ");
    JLabel lDuration = new JLabel("Duration: ");
  

    JTextField  tName = new JTextField(10);
   
    final JTextField  tFees = new JTextField(10);
    JTextField  tStartD = new JTextField(10);
    JTextField  tDuration = new JTextField(10);
	
	
	public Course(){
		
	}
	public Course(String name) {
		
		courseName = name;
		
		}
	
	public Course(String name,long fees,Date date,int dura){
		courseName =name;
		fee =fees;
		startDate = date;
		duration =dura;
		coordinator=null;

		
		
	}
	
	public int compareTo(String t)
	{
	    if(this.courseName.equals(t))
	       return 1;
	    else if(!this.courseName.equals(t))
	       return 0;
	    else
	       return -1;
	}
	public void setCourseName(String dur){
		courseName = dur ;
		
	}
	
	
	
	public void setDuration(int dur){
		duration = dur ;
		
	}
	
	public void setCourseFee(long fees){
		fee =fees ;
		
	}
	
	public void setStartDate(Date dates){
		
		startDate = dates ;
		
	}
	
	public void setCoordinator(Faculty cordy){
		coordinator = cordy ;
		
	}
	
	public void addInstructor(String name){
		courseName =name ;
		
	}
	
	public Faculty getCoordinator(){
		return coordinator;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	public String getName(){
		return courseName;
	}
	
	
	public int searchParticipant(String t)
	{

	    for(int n = 0; n < participants.size(); n++)
	    {
	         if(participants.get(n).compareTo(t) == 1)
	         {  

	              return n;
	         }
	    }
	    return -1;
	}
	
	public int searchInstructor(String t)
	{

	    for(int n = 0; n < instructors.size(); n++)
	    {
	         if(instructors.get(n).compareTo(t) == 1)
	         {  

	              return n;
	         }
	    }
	    return -1;
	}

	public void list(JTextArea text){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		text.append("Course name: "+courseName+"\n");
		text.append("Course startdate : "+dateFormat.format(startDate)+"\n");
		text.append("duration: "+ duration+"\n");
		text.append("fee: "+fee+"\n");
		text.append("\n");
		text.append("Coordinator:"+"\n");
		if(coordinator== null){
		    text.append("no Coordinator has been assigned to this course\n");
		  }
		  else
		{ 
		    coordinator.list(text);
		}
		text.append("\n");
		text.append("\n");
		text.append("instructors:\n");

		for(Faculty x : instructors){
			x.list(text);
		}
		text.append("\n\n");

		text.append("participants:\n");

		for(Student x : participants){
			x.list(text);
		}
	}
	
	
	
	public void newCourse(){
		
		
	   
	   
	    newSFrame.setSize(500,500);
	    newSFrame.setResizable(false);
	
         
         JButton Save = new JButton("Save Added!");
         Save.addActionListener(new ActionListener() {
     	    
 			public void actionPerformed(ActionEvent e) {
 				
 				
 		        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
 		        SimpleDateFormat ftt = new SimpleDateFormat ("dd MM yyyy");
 		        
 		       try { 
 		    	  startDate = ft.parse(tStartD.getText());
			 		    	 try{
			 	 		    	  Long fee= Long.parseLong(tFees.getText());
			 	 		    	
			 	 	 			setCourseFee(fee);
			 	 	 		 
							 	  		      try{
							 	  		    	int durat =Integer.parseInt(tDuration.getText());
							 	  		    	duration=durat;
							 	  		     courseName=tName.getText();
							 	 		     
							 	 			newSFrame.setVisible(false);
							 	  	 			
							 	  		       }
							 	  		      catch(Exception en){
							 	  		    	  JOptionPane.showMessageDialog(null, "Invalid Duration");
							 	  		    	  }
			 	 	 			
			 	 		       }
			 		    	 catch(Exception ef){
			 	 		    	  JOptionPane.showMessageDialog(null, "Invalid Fees");
			 	 		    	  }
		        } 
		        catch(ParseException ex){
		            
		           try{
		        	   startDate=ftt.parse(tStartD.getText());
		        	   
		        	   try{
		 	 		    	  Long fee= Long.parseLong(tFees.getText());
		 	 		    	
		 	 	 			setCourseFee(fee);
		 	 	 		 
						 	  		      try{
						 	  		    	int durat =Integer.parseInt(tDuration.getText());
						 	  		    	duration=durat;
						 	  		     courseName=tName.getText();
						 	 		     
						 	 			newSFrame.setVisible(false);
						 	  	 			
						 	  		       }
						 	  		      catch(Exception en){
						 	  		    	  JOptionPane.showMessageDialog(null, "Invalid Duration");
						 	  		    	  }
		 	 	 			
		 	 		       }
		 		    	 catch(Exception ef){
		 	 		    	  JOptionPane.showMessageDialog(null, "Invalid Fees");
		 	 		    	  }
		          } catch (ParseException ed) { 
			            JOptionPane.showMessageDialog(null, "Invalid Date");
			           
			        }
		        }
 		       
 		      
 		      
 				
 			 	 
 			 
 		   
 				
 			}
 		});

         

          JPanel centerPane = new JPanel();
         
          centerPane.add(lName);
          centerPane.add(tName);
        
          centerPane.add(lFees);
          centerPane.add(tFees);
          centerPane.add(lStartD);
          centerPane.add(tStartD);
          centerPane.add(lDuration);
          centerPane.add(tDuration);
          
          centerPane.add(Save);

          centerPane.setLayout(new GridLayout(0,2));



newSFrame.getContentPane().add(centerPane,BorderLayout.CENTER);


          newSFrame.setVisible(true);
	    
	    
	}
	 public void clear(){
		 if(coordinator!=null){
		if(coordinator.getFacultyName()==null){
			coordinator=null;
		}
		 }
		 if(participants!=null){
		  for(Student x: participants){
			  if(x.getName()==null){
				  participants.remove(x);
			  }
		  }
		 }
		 if(instructors!=null){
		  for(Faculty x: instructors){
			  if(x.getFacultyName()==null){
				  instructors.remove(x);
			  }
		  }
	  }
	 }
	
	
	
	
}

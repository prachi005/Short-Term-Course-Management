


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
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
public class Faculty implements Serializable
{
    private String p_name;
    private String p_address;
    private  String p_mobile;
    private  String p_department;
     private String p_email;
     public boolean p_Alive;
     int saveadded;
     final JFrame  newFFrame = new JFrame("Add New");
     JLabel lName = new JLabel("Name: ");
     JLabel lEmail = new JLabel("EMail: ");
     JLabel lNumber = new JLabel("Number: ");
     JLabel lAddress = new JLabel("Address: ");
     //JLabel lOrg = new JLabel("Organisation: ");
     JLabel lDep = new JLabel("Department: ");
     JTextField  tName = new JTextField(10);
	   
	    JTextField  tEMail = new JTextField(10);
	    JTextField  tNumber = new JTextField(10);
	    JTextField  tAddress = new JTextField(10);
	    JTextField  tDep = new JTextField(10);
	    JButton Save = new JButton("Save Added!");
    //Constructor for faculty
   public Faculty(String nameOfFaculty,String addressOfFaculty,String mobileNumber,String departmentName,String emailAddress){
       p_name=nameOfFaculty;
       p_address=addressOfFaculty;
       p_mobile=mobileNumber;
       p_department = departmentName;
       p_email =emailAddress ;
       p_Alive= true;
       saveadded=0;
    }
   
   public Faculty() {
	
}

public int compareTo(String t)
   {
       if(this.p_name.equals(t))
          return 1;
       else if(!this.p_name.equals(t))
          return 0;
       else
          return -1;
   }
    
  
    
   public void editFacultyName(String newName){
       p_name=newName;
       
}

 public void editFacultyAddress(String newAddress){
       p_address=newAddress;
       
}

 public void editFacultyMobileNumber(String number){
       p_mobile=number;
       
}

 public void editFacultyDepartmentName(String newDepartment){
       p_department=newDepartment;
       
}

 public void editFacultyEmail(String newEmail){
       p_email=newEmail;
       
}

public String getFacultyName(){
    return p_name;
    
}

public String getFacultyAddress(){
    return p_address;
    
}

public String getFacultyMobile(){
    return p_mobile;
    
}
public String getFacultyDepartment(){
    return p_department;
    
}

public String getFacutlyEmail(){
    return p_email;
    
}

public void list(JTextArea text){
	text.append("Faculty name: "+p_name+"\n");
	text.append("Faculty address: "+p_address+"\n");
	text.append("Mobile number: "+ p_mobile+"\n");
	text.append("department: "+p_department+"\n");
	text.append("Email Id: "+p_email+"\n");
}



public void newFaculty(){
	
	newFFrame.setTitle("Add New Faculty");
	    newFFrame.setSize(500,500);
	    newFFrame.setResizable(false);
	    saveadded=1;
        
         
        
         Save.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				  saveadded=1;
 				editFacultyName(tName.getText());
 				editFacultyAddress(tAddress.getText());
 				editFacultyDepartmentName(tDep.getText());
 				editFacultyEmail(tEMail.getText());
 				editFacultyMobileNumber(tNumber.getText());
 				
 			newFFrame.setVisible(false);
 				
 			}
 		});

         

          JPanel centerPane = new JPanel();
         
          centerPane.add(lName);
          centerPane.add(tName);
        
          centerPane.add(lEmail);
          centerPane.add(tEMail);
          centerPane.add(lNumber);
          centerPane.add(tNumber);
          centerPane.add(lAddress);
          centerPane.add(tAddress);
          centerPane.add(lDep);
          centerPane.add(tDep);
         
          centerPane.add(Save);

          centerPane.setLayout(new GridLayout(0,2));



newFFrame.getContentPane().add(centerPane,BorderLayout.CENTER);


          newFFrame.setVisible(true);
	    
	    
	}


public void editFaculty(){
	
	newFFrame.setTitle("Edit "+p_name);

	Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editFacultyName(tName.getText());
				editFacultyAddress(tAddress.getText());
				editFacultyDepartmentName(tDep.getText());
				editFacultyEmail(tEMail.getText());
				editFacultyMobileNumber(tNumber.getText());
				
			newFFrame.setVisible(false);
				
			}
		});

	newFFrame.setVisible(true);

}

}


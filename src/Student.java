


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
public class Student implements Serializable
{
    String name;
    String address;
    String mobile;
    String organisation;
    String email;
    boolean alive;
    
    final JFrame  newSFrame = new JFrame("Add New");
    JLabel lName = new JLabel("Name: ");
    JLabel lEmail = new JLabel("EMail: ");
    JLabel lNumber = new JLabel("Number: ");
    JLabel lAddress = new JLabel("Address: ");
    JLabel lOrg = new JLabel("Organisation: ");
   // JLabel lDep = new JLabel("Department: ");
    JButton Save = new JButton("Save Added");

    JTextField  tName = new JTextField(10);
   
    JTextField  tEMail = new JTextField(10);
    JTextField  tNumber = new JTextField(10);
    JTextField  tAddress = new JTextField(10);
    JTextField  tOrg = new JTextField(10);
   //Constructor for student
   public Student(String nameofstudent,String addressOfStudent,String mobileNumber,String organisationName,String emailAddress){
       name=nameofstudent;
       address=addressOfStudent;
       mobile=mobileNumber;
       organisation = organisationName;
       email =emailAddress ;
       alive= true;
    }
    
   public Student() {

}

public int compareTo(String t)
   {
       if(this.name.equals(t))
          return 1;
       else if(!this.name.equals(t))
          return 0;
       else
          return -1;
   }

       
   public void editStudentName(String newName){
       name=newName;
       
}

 public void editStudentAddress(String newAddress){
       address=newAddress;
       
}

 public void editStudentMobileNumber(String number){
       mobile=number;
       
}

 public void editStudentOrganisationName(String neworg){
       organisation=neworg;
       
}

 public void editStudentEmail(String newEmail){
       email=newEmail;
       
}

public String getName(){
    return name;
    
}

public String getAddress(){
    return address;
    
}

public String getMobile(){
    return mobile;
    
}
public String getOrg(){
    return organisation;
    
}

public String getEmail(){
    return email;
    
}

public void list(JTextArea text){
	text.append("Student name: "+name+"\n");
	text.append("Student address: "+address+"\n");
	text.append("Mobile number: "+ mobile+"\n");
	text.append("Organistion: "+organisation+"\n");
	text.append("Email Id: "+email+"\n");
}



public void newStudent(){
	
	
	newSFrame.setTitle("Add new Student ");
    newSFrame.setSize(500,500);
    newSFrame.setResizable(false);


     
    
     Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentName(tName.getText());
				editStudentAddress(tAddress.getText());
				editStudentMobileNumber(tNumber.getText());
				editStudentOrganisationName(tOrg.getText());
				editStudentEmail(tEMail.getText());
			newSFrame.setVisible(false);
			
		
				
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
      centerPane.add(lOrg);
      centerPane.add(tOrg);
     
      centerPane.add(Save);
     
      centerPane.setLayout(new GridLayout(0,2));



newSFrame.getContentPane().add(centerPane,BorderLayout.CENTER);


      newSFrame.setVisible(true);
    
    
}


public void editStudent(){
	
	newSFrame.setTitle("Edit "+name);
	newSFrame.setVisible(true);
	 Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentName(tName.getText());
				editStudentAddress(tAddress.getText());
				editStudentMobileNumber(tNumber.getText());
				editStudentOrganisationName(tOrg.getText());
				editStudentEmail(tEMail.getText());
			newSFrame.setVisible(false);
			
		
				
			}
		});


}





}
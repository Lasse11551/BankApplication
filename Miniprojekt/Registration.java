//The design have been made with GUI, and the functions/methods have been coded by me
//Throughout the making of this program i have been seeking information from the Internet and from friends
//I have been getting of help from Kasper Kronborg and Jeppe Paaske

package Miniprojekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Registration extends JFrame {

	//Variables i have for this class - Panels and text fields
	private JPanel contentPane;
	private JTextField txtFullName;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Constructor
	public Registration() {
		//This object is for the "login" screen - used in the buttons - line 136, 148
		Login login = new Login();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Different text fields and labels to build the design of registration------------------------------------------------------------------------------------------------------------------------------------------
		txtFullName = new JTextField();
		txtFullName.setBounds(113, 40, 176, 20);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(113, 90, 176, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(113, 140, 176, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblFullName = new JLabel("Full name:");
		lblFullName.setBounds(24, 43, 79, 14);
		contentPane.add(lblFullName);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(24, 93, 79, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(24, 143, 79, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(165, 11, 92, 14);
		contentPane.add(lblRegistration);
		
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Register button
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                                        //When the register button is pressed ... happens
				
			    String computer = System.getProperty("user.home");	                        //Making a variable that get access to the users system, for me to be able to get the file on their desktop
				
				                                                                            //PrintWriter makes the text file on the desktop
			    PrintWriter fullnamewriter;                                                 //Local PrintWriter variable
				PrintWriter userwriter;                                                     //Local PrintWriter variable
				PrintWriter passwriter;                                                     //Local PrintWriter variable
				try {
					fullnamewriter = new PrintWriter(computer + "/Desktop/FullName.txt");   //Positions where the PrintWriter should place the file
					userwriter = new PrintWriter(computer + "/Desktop/Username.txt");       //Positions where the PrintWriter should place the file
					passwriter = new PrintWriter(computer + "/Desktop/Password.txt");       //Positions where the PrintWriter should place the file
					
					fullnamewriter.write(txtFullName.getText());                            //This is the text the user have registered as, so the PrintWriter know what to enter in the file
					userwriter.write(txtUsername.getText());                                //This is the text the user have registered as, so the PrintWriter know what to enter in the file
					passwriter.write(txtPassword.getText());                                //This is the text the user have registered as, so the PrintWriter know what to enter in the file
					
					fullnamewriter.close();                                                 //Closes the PrintWriter
					userwriter.close();                                                     //Closes the PrintWriter
					passwriter.close();                                                     //Closes the PrintWriter
					setVisible(false);                                                      //Sets the visibility of registration page as false (it disappears)
					login.setVisible(true);                                                 //Sets the visibility of login page as true
				} catch (Exception e1) {                                                    //If an exception happens here i will know, because of PrintStackTrace
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(315, 203, 89, 23);
		contentPane.add(btnRegister);
		
		//Back button
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {   //If this button is clicked it will go back to the login screen
				setVisible(false);                     //Sets registration false
				login.setVisible(true);                //And sets login true
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		
	}
}

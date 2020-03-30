//The design have been made with GUI, and the functions/methods have been coded by me
//Throughout the making of this program i have been seeking information from the Internet and from friends
//I have been getting of help from Kasper Kronborg and Jeppe Paaske

package Miniprojekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	//Variables i have for this class - Panels, String, buttons and TextFields
	private JPanel contentPane;
	private JTextField txtUsername;
	private JButton btnRegistration;
	protected String usernameInput;
	protected String passwordInput;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//The login button
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();                           //Getting the text the user have written as username to login and making a local String variable from it
				String password = passwordField.getText();                         //Getting the text the user have written as password to login and making a local String variable from it
				
				String computer = System.getProperty("user.home");                 //Making a variable that get access to the users system, for me to be able to get the file on their desktop
				
				File usernameFile = new File(computer + "/Desktop/Username.txt");  //Accessing the file saved on their desktop when they registered - for the username
				File passwordFile = new File(computer + "/Desktop/Password.txt");  //Accessing the file saved on their desktop when they registered - for the password
				
				try {
					Scanner usernameScan = new Scanner(usernameFile);              //Scanning the file on their desktop - username
					Scanner passwordScan = new Scanner(passwordFile);              //Scanning the file on their desktop - password
					usernameInput = usernameScan.nextLine();                       //Jumps down a line in the text file, and the line it jumped it will scan - username
					passwordInput = passwordScan.nextLine();                       //Jumps down a line in the text file, and the line it jumped it will scan - password
					usernameScan.close();                                          //Closes the username file scanner
					passwordScan.close();                                          //Closes the password file scanner
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if (username.equals(usernameInput) && password.equals(passwordInput)) {    //Check if the written username and password are equal to the ones they registered with (the ones in the text file on their desktop)
					
				Menu menu = new Menu();                                                    //Objects for the other classes/screens - used in the buttons for this class/screen
				setVisible(false);                                                         //Set the visibility of login screen/frame to false
				menu.setVisible(true);                                                     //And the Menu(AccountPanel) screen/frame to true 
			
				} else {
				JOptionPane.showMessageDialog(btnLogin, "Invalid Username or Password");   //If the entered username or password is wrong this message will pop up
			}
		 }
			
			
		});
		btnLogin.setBounds(254, 146, 89, 23);
		contentPane.add(btnLogin);
		
		//The registration button
		btnRegistration = new JButton("Registration");
		btnRegistration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {        //If clicked
				Registration regis = new Registration();    //Object for the other class/screen - used in the buttons for this class/screen
				setVisible(false);                          //Set the visibility of login screen/frame to false
				regis.setVisible(true);                     //And the registration screen/frame to true 
			}
		});
		btnRegistration.setBounds(50, 227, 125, 23);
		contentPane.add(btnRegistration);
		
		//A text field the user can write in - this is where the user writes their username
		txtUsername = new JTextField();
		txtUsername.setBounds(50, 127, 145, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblWelcome = new JLabel("Welcome to the bank of Lasse");
		lblWelcome.setBounds(50, 38, 184, 14);
		contentPane.add(lblWelcome);
		
		//A Password text field the user can write in (this will make the text apear as dots) - this is where the user writes their password
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 170, 145, 20);
		contentPane.add(passwordField);
		
		
	}
}

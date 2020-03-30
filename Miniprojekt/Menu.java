//The design have been made with GUI, and the functions/methods have been coded by me
//Throughout the making of this program i have been seeking information from the Internet and from friends
//I have been getting of help from Kasper Kronborg and Jeppe Paaske

package Miniprojekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Menu extends JFrame {
	
	Account account = new Account();
	Login login = new Login();

	private JPanel MenuPanel;
	private JTextField DepositTxtFieldDeposit;
	private JTextField WithdrawTxtFieldWithdraw;
	private JTextField TransferTxtFieldTransfer;

	private String fullnameInput;
	private String usernameInput;
	private String passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(135, 206, 235));
		MenuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 105, 414, 145);
		MenuPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenu.setBounds(194, 11, 60, 14);
		MenuPanel.add(lblMenu);

		
		//Account menu----------------------------------------------------------------------------------------------------------------------------------------------------
		JPanel AccountPanel = new JPanel();
		AccountPanel.setBackground(new Color(135, 206, 235));
		layeredPane.add(AccountPanel, "name_104168363065300");
		AccountPanel.setLayout(null);
		
		JLabel lblYourAccount = new JLabel("Your Account");
		lblYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourAccount.setBounds(156, 11, 101, 14);
		AccountPanel.add(lblYourAccount);
		
		JLabel lblConsumer = new JLabel("Consumer: " + account.consumerBalance);
		lblConsumer.setBounds(119, 48, 181, 14);
		AccountPanel.add(lblConsumer);
		
		JLabel lblSavings = new JLabel("Savings: " + account.savingsBalance);
		lblSavings.setBounds(119, 84, 161, 14);
		AccountPanel.add(lblSavings);
		
		//Deposit menu----------------------------------------------------------------------------------------------------------------------------------------------------
		JPanel DepositPanel = new JPanel();
		DepositPanel.setBackground(new Color(135, 206, 235));
		layeredPane.add(DepositPanel, "name_97886463172500");
		DepositPanel.setLayout(null);
		
		JLabel lblDepositAmount = new JLabel("Deposit amount:");
		lblDepositAmount.setBounds(81, 69, 98, 14);
		DepositPanel.add(lblDepositAmount);
		
		//Withdraw menu----------------------------------------------------------------------------------------------------------------------------------------------------
		JPanel WithdrawPanel = new JPanel();
		WithdrawPanel.setBackground(new Color(135, 206, 235));
		layeredPane.add(WithdrawPanel, "name_97889941705400");
		WithdrawPanel.setLayout(null);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw amount: ");
		lblWithdrawAmount.setBounds(81, 69, 109, 14);
		WithdrawPanel.add(lblWithdrawAmount);
		
		//Transfer menu----------------------------------------------------------------------------------------------------------------------------------------------------
		JPanel TransferPanel = new JPanel();
		TransferPanel.setBackground(new Color(135, 206, 235));
		layeredPane.add(TransferPanel, "name_97891929170000");
		TransferPanel.setLayout(null);
		
		JLabel lblTransferAmount = new JLabel("Transfer amount: ");
		lblTransferAmount.setBounds(81, 38, 109, 14);
		TransferPanel.add(lblTransferAmount);
		
		JLabel lblOr = new JLabel("Or");
		lblOr.setBounds(205, 82, 46, 14);
		TransferPanel.add(lblOr);
		
		//UserID menu----------------------------------------------------------------------------------------------------------------------------------------------------
		
		String computer = System.getProperty("user.home");
		
		File fullnameFile = new File(computer + "/Desktop/FullName.txt");
		File usernameFile = new File(computer + "/Desktop/Username.txt");
		File passwordFile = new File(computer + "/Desktop/Password.txt");
		
		try {
			Scanner fullnameScan = new Scanner(fullnameFile);
			Scanner usernameScan = new Scanner(usernameFile);
			Scanner passwordScan = new Scanner(passwordFile);
			
			fullnameInput = fullnameScan.nextLine();
		    usernameInput = usernameScan.nextLine();
			passwordInput = passwordScan.nextLine();
			
			fullnameScan.close();
			usernameScan.close();
			passwordScan.close();
	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel UserIdPanel = new JPanel();
		UserIdPanel.setBackground(new Color(135, 206, 235));
		layeredPane.add(UserIdPanel, "name_97906190497800");
		UserIdPanel.setLayout(null);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setBounds(169, 11, 99, 14);
		UserIdPanel.add(lblAccountDetails);
		
		JLabel lblFullNameDetails = new JLabel("Full Name: " + fullnameInput);
		lblFullNameDetails.setBounds(42, 40, 322, 14);
		UserIdPanel.add(lblFullNameDetails);
		
		JLabel lblUsernameDetails = new JLabel("Username: " + usernameInput);
		lblUsernameDetails.setBounds(42, 65, 322, 14);
		UserIdPanel.add(lblUsernameDetails);
		
		JLabel lblPasswordDetails = new JLabel("Password: " + passwordInput);
		lblPasswordDetails.setBounds(42, 90, 322, 14);
		UserIdPanel.add(lblPasswordDetails);
		
		//Buttons and txtFields----------------------------------------------------------------------------------------------------------------------------------------------------
		
		DepositTxtFieldDeposit = new JTextField();
		DepositTxtFieldDeposit.setBounds(178, 66, 101, 20);
		DepositPanel.add(DepositTxtFieldDeposit);
		DepositTxtFieldDeposit.setColumns(10);
		
		WithdrawTxtFieldWithdraw = new JTextField();
		WithdrawTxtFieldWithdraw.setBounds(191, 66, 101, 20);
		WithdrawPanel.add(WithdrawTxtFieldWithdraw);
		WithdrawTxtFieldWithdraw.setColumns(10);
		
		TransferTxtFieldTransfer = new JTextField();
		TransferTxtFieldTransfer.setBounds(184, 35, 86, 20);
		TransferPanel.add(TransferTxtFieldTransfer);
		TransferTxtFieldTransfer.setColumns(10);
		
		//Button to get to the deposit menu
		JButton btnDepositMenu = new JButton("Deposit");
		btnDepositMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositPanel.setVisible(true);
				if (DepositPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					UserIdPanel.setVisible(false);
					AccountPanel.setVisible(false);
				}
				
			}
		});
		btnDepositMenu.setBounds(19, 53, 89, 23);
		MenuPanel.add(btnDepositMenu);
		
		//Button to get to the withdraw menu
		JButton btnWithdrawMenu = new JButton("Withdraw");
		btnWithdrawMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawPanel.setVisible(true);
				if (WithdrawPanel.isVisible()) {
					DepositPanel.setVisible(false);
					TransferPanel.setVisible(false);
					UserIdPanel.setVisible(false);
					AccountPanel.setVisible(false);
				}
			}
		});
		btnWithdrawMenu.setBounds(122, 53, 89, 23);
		MenuPanel.add(btnWithdrawMenu);
		
		//Button to get to the transfer menu
		JButton btnTransferMenu = new JButton("Transfer");
		btnTransferMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferPanel.setVisible(true);
				if (TransferPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					DepositPanel.setVisible(false);
					UserIdPanel.setVisible(false);
					AccountPanel.setVisible(false);
				}
			}
		});
		btnTransferMenu.setBounds(221, 53, 89, 23);
		MenuPanel.add(btnTransferMenu);
		
		//Button to get to the UserID menu
		JButton btnUserIdMenu = new JButton("UserID");
		btnUserIdMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserIdPanel.setVisible(true);
				if (UserIdPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					DepositPanel.setVisible(false);
					AccountPanel.setVisible(false);
				}
			}
		});
		btnUserIdMenu.setBounds(320, 53, 89, 23);
		MenuPanel.add(btnUserIdMenu);
		
		//Deposit buttons------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnBackDeposit = new JButton("Back");
		btnBackDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountPanel.setVisible(true);
				if (AccountPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					DepositPanel.setVisible(false);
					DepositPanel.setVisible(false);
				}
			}
		});
		btnBackDeposit.setBounds(10, 111, 89, 23);
		DepositPanel.add(btnBackDeposit);
		
		JButton btnDepositFunds = new JButton("Deposit");
		btnDepositFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                             //When the button is pressed ... happens
				account.setConsumerDeposit(Double.parseDouble(DepositTxtFieldDeposit.getText()));    //This take the method i made in "Account" and uses it - "Double.parseDouble is to be able to make a number perform as a String, i force it
				lblConsumer.setText("Consumer: " + account.consumerBalance);                         //Set the consumer label with a new text - only the amount of money actually changes 
			}
		});
		btnDepositFunds.setBounds(315, 111, 89, 23);
		DepositPanel.add(btnDepositFunds);
		
		//Withdraw buttons-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnBackWithdraw = new JButton("Back");
		btnBackWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountPanel.setVisible(true);
				if (AccountPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					DepositPanel.setVisible(false);
					WithdrawPanel.setVisible(false);
				}
			}
		});
		btnBackWithdraw.setBounds(10, 111, 89, 23);
		WithdrawPanel.add(btnBackWithdraw);
		
		JButton btnWithdrawFunds = new JButton("Withdraw");
		btnWithdrawFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setConsumerWithdraw(Double.parseDouble(WithdrawTxtFieldWithdraw.getText()));
				lblConsumer.setText("Consumer: " + account.consumerBalance);
			}
		});
		btnWithdrawFunds.setBounds(315, 111, 89, 23);
		WithdrawPanel.add(btnWithdrawFunds);
		
		//Transfer buttons-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnBackTransfer = new JButton("Back");
		btnBackTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountPanel.setVisible(true);
				if (AccountPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					UserIdPanel.setVisible(false);
					DepositPanel.setVisible(false);
				}	
			}
		});
		btnBackTransfer.setBounds(10, 111, 89, 23);
		TransferPanel.add(btnBackTransfer);
		
		//RadioButtons to select which account you want to transfer to---------------------------------------------------------------------------------------------------------------------------------------------------------------
		JRadioButton rdbtnToSavings = new JRadioButton("To Savings");              //Had to put this object up here for the rdbtnToConsumer to know to de-select "To Savings" if "To Consumer" were selected
		JRadioButton rdbtnToConsumer = new JRadioButton("To Consumer");
		rdbtnToConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnToConsumer.isSelected()) {                                 //If one RadioButton is selected the other cant be selected at the same time
					rdbtnToSavings.setSelected(false);
				}
			}
		});
		rdbtnToConsumer.setBounds(237, 78, 110, 23);
		TransferPanel.add(rdbtnToConsumer);
		
		//JRadioButton rdbtnToSavings = new JRadioButton("To Savings");
		rdbtnToSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnToSavings.isSelected()) {
					rdbtnToConsumer.setSelected(false);
				}
			}
		});
		rdbtnToSavings.setBounds(85, 78, 100, 23);
		TransferPanel.add(rdbtnToSavings);
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Transfer funds button
		JButton btnTransferFunds = new JButton("Transfer");
		btnTransferFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnToSavings.isSelected()) {                                                            //If the savings RadioButton is selected ... happens
					account.setToSavingsTransfer(Double.parseDouble(TransferTxtFieldTransfer.getText()));
					lblSavings.setText("Savings: " + account.savingsBalance);                                //"resets" the label
					lblConsumer.setText("Consumer: " + account.consumerBalance);                             //"resets" the label
				}
				else if(rdbtnToConsumer.isSelected()) {                                                      //If the consumer RadioButton is selected ... happens
					account.setToConsumerTransfer(Double.parseDouble(TransferTxtFieldTransfer.getText()));
					lblConsumer.setText("Consumer: " + account.consumerBalance);
					lblSavings.setText("Savings: " + account.savingsBalance);
				}
				else {                                                                                                     //If none of them are selected ... happens
					JOptionPane.showMessageDialog(btnTransferFunds, "You have to select 'To Savings' or 'To Consumer'");   //Gives a message to the user that they have to choose savings or consumer to transfer
				}
			}
		});
		btnTransferFunds.setBounds(315, 111, 89, 23);
		TransferPanel.add(btnTransferFunds);

		//UserID buttons-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnBackUserID = new JButton("Back");
		btnBackUserID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountPanel.setVisible(true);
				if (AccountPanel.isVisible()) {
					WithdrawPanel.setVisible(false);
					TransferPanel.setVisible(false);
					UserIdPanel.setVisible(false);
					DepositPanel.setVisible(false);
				}	
			}
		});
		btnBackUserID.setBounds(10, 115, 89, 23);
		UserIdPanel.add(btnBackUserID);
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				if (login.isVisible()) {
				AccountPanel.setVisible(false);
				DepositPanel.setVisible(false);
				WithdrawPanel.setVisible(false);
				TransferPanel.setVisible(false);
				UserIdPanel.setVisible(false);
				}
			}
		});
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(0, 122, 89, 23);
		AccountPanel.add(btnLogout);
		
	}
}

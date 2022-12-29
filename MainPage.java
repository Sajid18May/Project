import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JPasswordField;

public class MainPage {

	private JFrame frmImageSteganography;
	private JTextArea messageField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmImageSteganography.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageSteganography = new JFrame();
		frmImageSteganography.setType(Type.POPUP);
		frmImageSteganography.setResizable(false);
		frmImageSteganography.setBackground(new Color(255, 255, 255));
		frmImageSteganography.setFont(new Font("Android Nation", Font.BOLD, 15));
		frmImageSteganography.setTitle("IE_MCKVIE");
		frmImageSteganography.setSize(480,480);
		frmImageSteganography.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel optionsPanel = new JPanel();
		frmImageSteganography.getContentPane().add(optionsPanel, BorderLayout.SOUTH);
		optionsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton encryptButton = new JButton("Encrypt");
		encryptButton.setFont(new Font("Open Sans", Font.BOLD, 16));
		optionsPanel.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setFont(new Font("Open Sans", Font.BOLD, 16));
		optionsPanel.add(decryptButton);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setBackground(new Color(1, 35, 69));
		frmImageSteganography.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
		fieldsPanel.setLayout(null);
		
		JLabel messageLabel = new JLabel("SECRET MASSAGE");
		messageLabel.setForeground(new Color(255, 255, 255));
		messageLabel.setFont(new Font("Open Sans", Font.BOLD, 19));
		messageLabel.setBounds(141, 10, 174, 37);
		fieldsPanel.add(messageLabel);
		
		messageField = new JTextArea();
		messageField.setFont(new Font("Open Sans", Font.PLAIN, 16));
		messageField.setBounds(32, 57, 394, 93);
		fieldsPanel.add(messageField);
		messageField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Open Sans", Font.PLAIN, 16));
		passwordField.setBounds(221, 217, 145, 37);
		fieldsPanel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setBackground(new Color(255, 255, 255));
		passwordLabel.setBounds(92, 215, 119, 37);
		fieldsPanel.add(passwordLabel);
		
		ActionListener encryptListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File imageFile = FileChooser.MakeFileChooser();
				if(imageFile != null) {
					EncryptLSB.Encrypt(imageFile, messageField.getText());
				}
			}
		};
		encryptButton.addActionListener(encryptListener);
		
		ActionListener decryptListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password=new String(passwordField.getPassword());
				File imageFile = FileChooser.MakeFileChooser();
				if(imageFile != null && password.equals("Encrypt")) {
				DecryptLSB.Decrypt();
				}
				else
					System.out.println("WRONG PASSWORD");
			}
		};
		decryptButton.addActionListener(decryptListener);
	}
}

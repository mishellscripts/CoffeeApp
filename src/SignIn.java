import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Ellipse2D;

public class SignIn extends JFrame {

	//decorations instance variables
	Font fontB = new Font("plain", Font.BOLD, 24);
	Font font = new Font("plain", Font.PLAIN, 16);
	Color brownTan = new Color(214, 152, 94);
	Color pinkTan = new Color(214, 132, 87);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);

	public SignIn(CoffeeModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//		setLayout(new GridLayout(0, 1));


		//logo
		//		JPanel logoPanel = new JPanel() {
		//			public void paintComponent(Graphics g) {
		//				super.paintComponent(g);
		//				Graphics2D g2 = (Graphics2D) g;
		//				Logo logo = new Logo();
		//				logo.draw(g2);
		//			}
		//		};
		//		logoPanel.setSize(new Dimension(200, 200));
		//		JTextArea space = new JTextArea("\n\n\n\n\n\n\n\n\n\n\n");
		//		space.setEditable(false);
		//		logoPanel.add(space);
		JPanel logoPanel = new JPanel();
		Logo logo = new Logo(160, 160);
		JButton logoButton = new JButton(logo);
		logoButton.setFocusPainted(false);
		logoButton.setContentAreaFilled(false);
		logoButton.setBorderPainted(false);
		logoPanel.add(logoButton);

		add(new JLabel("\n"));
		add(new JLabel("\n"));
		add(new JLabel("\n"));
		add(logoPanel);


		//sign in
		JPanel signInPanel = new JPanel();
		JLabel signInLabel = new JLabel("Sign In");
		signInLabel.setFont(fontB);
		signInLabel.setForeground(darkRed);
		JTextField signInID = new JTextField("Enter your ID");
		signInID.setBorder(new LineBorder(darkRed));
		signInID.setFont(font);
		signInID.setForeground(darkRed);
		signInID.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (signInID.getText().equals("Enter your ID"))
				{
					signInID.setText("");
				}
			}
			public void focusLost(FocusEvent event) {
				if (signInID.getText().equals("")) {
					signInID.setText("Enter your ID");
				} 
			}
		});	
		JPasswordField signInPass = new JPasswordField("Enter your password", 20);
		signInPass.setBorder(new LineBorder(darkRed));
		signInPass.setFont(font);
		signInPass.setForeground(darkRed);
		char defaultChar = signInPass.getEchoChar();
		signInPass.setEchoChar((char) 0);
		signInPass.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String pass = new String(signInPass.getPassword());
				if (pass.equals("Enter your password"))
				{
					signInPass.setText("");
					signInPass.setEchoChar(defaultChar);
				}
			}
			public void focusLost(FocusEvent event) {
				String pass = new String(signInPass.getPassword());
				if (pass.equals("")) {
					signInPass.setEchoChar((char) 0);
					signInPass.setText("Enter your password");
				}
			}
		});	
		
		JButton signInButton = new JButton("Confirm");
		signInButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//make sure sign in stuff
				String desiredID = signInID.getText();
				String desiredPass = new String(signInPass.getPassword());
				if (model.signIn(desiredID, desiredPass)) {
					MainMenu menu = new MainMenu(model);
					dispose();
				}
				else {
					// sad display error for non-existent user
				}

			}

		});
		//		signInButton.setForeground(lightTan);
		signInButton.setFocusPainted(false);
		signInButton.setContentAreaFilled(false);
		signInButton.setBorder(new LineBorder(darkRed));


		//		signInPanel.setLayout(new BoxLayout(signInPanel, BoxLayout.Y_AXIS));
		signInPanel.setLayout(new GridLayout(0, 1));
		signInPanel.add(signInLabel);
		signInPanel.add(new JLabel("ID"));
		signInPanel.add(signInID);
		signInPanel.add(new JLabel("Password"));
		signInPanel.add(signInPass);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(signInButton);
		signInPanel.add(new JLabel("\n"));


		//sign up
		JPanel signUpPanel = new JPanel();
		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//make sure sign in stuff
				SignUp signUp = new SignUp(model);
				dispose();
			}

		});
		//		signUp.setForeground(lightTan);
		signUp.setFocusPainted(false);
		signUp.setContentAreaFilled(false);
		signUp.setBorder(new LineBorder(darkRed));

		signInPanel.add(signUp);
		//		signInPanel.setAlignmentX(LEFT_ALIGNMENT);
		Border b = new EmptyBorder(0, 0, 0, 0);
		Border margin = new EmptyBorder(70,120,200,120);
		signInPanel.setBorder(new CompoundBorder(b, margin));
		add(signInPanel);


		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


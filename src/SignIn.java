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
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color darkBlue = new Color(62, 89, 130);	

	public SignIn(CoffeeModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


		//logo
		JPanel logoPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				Logo logo = new Logo();
				logo.draw(g2);
			}
		};
		logoPanel.setSize(new Dimension(200, 200));
		JTextArea space = new JTextArea("\n\n\n\n\n\n\n\n\n\n\n");
		space.setEditable(false);
		logoPanel.add(space);
		add(logoPanel);


		//sign in
		JPanel signInPanel = new JPanel();
		JLabel signInLabel = new JLabel("Sign In");
		signInLabel.setFont(fontB);
		signInLabel.setForeground(darkBlue);
		JTextField signInID = new JTextField("Enter your ID");
		signInID.setFont(font);
		signInID.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				signInID.setText("");
			}
			public void focusLost(FocusEvent event) {
				if (signInID.getText().equals("")) {
					signInID.setText("Enter your ID");
				}
			}
		});	
		JPasswordField signInPass = new JPasswordField(10);
		signInPass.setFont(font);
		signInPass.setForeground(darkBlue);
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
		signInButton.setForeground(darkBlue);
		signInButton.setFocusPainted(false);
		signInButton.setContentAreaFilled(false);
		signInPanel.setLayout(new BoxLayout(signInPanel, BoxLayout.Y_AXIS));
		signInPanel.add(signInLabel);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("ID"));
		signInPanel.add(signInID);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("Password"));
		signInPanel.add(signInPass);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(signInButton);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("\n"));
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
		signUp.setForeground(darkBlue);
		signUp.setFocusPainted(false);
		signUp.setContentAreaFilled(false);
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


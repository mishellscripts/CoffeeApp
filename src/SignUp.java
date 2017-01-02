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

public class SignUp extends JFrame {

	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);

	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);

	public SignUp(CoffeeModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


		JPanel panel = new JPanel();
		JLabel signUpLabel = new JLabel("Sign Up");
		signUpLabel.setFont(fontB);
		signUpLabel.setForeground(darkRed);

		JTextField name = new JTextField("Enter your name");
		name.setFont(font);
		name.setBorder(new LineBorder(darkRed));
		name.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (name.getText().equals("Enter your name"))
					name.setText("");
			}
			public void focusLost(FocusEvent event) {
				if (name.getText().equals("")) {
					name.setText("Enter your name");
				}
			}
		});	

		JTextField id = new JTextField("Enter your ID");
		id.setFont(font);
		id.setBorder(new LineBorder(darkRed));
		id.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (id.getText().equals("Enter your ID"))
					id.setText("");
			}
			public void focusLost(FocusEvent event) {
				if (id.getText().equals("")) {
					id.setText("Enter your ID");
				}
			}
		});	

		JPasswordField pass = new JPasswordField("Enter your password", 20);
		pass.setFont(font);
		pass.setForeground(lightTan);
		pass.setBorder(new LineBorder(darkRed));
		char defaultChar = pass.getEchoChar();
		pass.setEchoChar((char) 0);
		pass.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String p = new String(pass.getPassword());
				if (p.equals("Enter your password"))
				{
					pass.setText("");
					pass.setEchoChar(defaultChar);
				}
			}
			public void focusLost(FocusEvent event) {
				String p = new String(pass.getPassword());
				if (p.equals("")) {
					pass.setEchoChar((char) 0);
					pass.setText("Enter your password");
				}
			}
		});	

		JPasswordField reEnterPass = new JPasswordField("Confirm your password", 20);
		reEnterPass.setFont(font);
		reEnterPass.setForeground(lightTan);
		reEnterPass.setBorder(new LineBorder(darkRed));
		char defaultChar2 = reEnterPass.getEchoChar();
		reEnterPass.setEchoChar((char) 0);
		reEnterPass.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String p = new String(reEnterPass.getPassword());
				if (p.equals("Confirm your password"))
				{
					reEnterPass.setText("");
					reEnterPass.setEchoChar(defaultChar2);
				}
			}
			public void focusLost(FocusEvent event) {
				String p = new String(reEnterPass.getPassword());
				if (p.equals("")) {
					reEnterPass.setEchoChar((char) 0);
					reEnterPass.setText("Confirm your password");
				}
			}
		});	

		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//get user's entered account info and check that matches/not already used
				String desiredPass = new String(pass.getPassword());
				String checkPass = new String(reEnterPass.getPassword());
				if(desiredPass.equals(checkPass))
				{
					String desiredID = id.getText();
					if(model.checkIfUnusedID(desiredID))
					{
						String desiredName = name.getText();
						model.signUp(desiredName, desiredID, desiredPass);
						SignIn signIn = new SignIn(model);
						dispose();
					}
					else
					{
						//display error for id is already used
					}
				}
				else
				{
					//display error for mismatched passwords
				}

			}

		});
		confirm.setForeground(darkRed);
		confirm.setBorder(new LineBorder(darkRed));
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(signUpLabel);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("Name"));
		panel.add(name);
		panel.add(new JLabel("ID"));
		panel.add(id);
		panel.add(new JLabel("Password"));
		panel.add(pass);
		panel.add(new JLabel("Confirm password"));
		panel.add(reEnterPass);
		panel.add(new JLabel("\n"));
		panel.add(confirm);

		Border b = new EmptyBorder(0, 0, 0, 0);
		Border margin = new EmptyBorder(120,120,200,120);
		panel.setBorder(new CompoundBorder(b, margin));


		add(panel);
		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


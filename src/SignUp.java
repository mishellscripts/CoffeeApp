import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignUp extends JFrame {

	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color darkBlue = new Color(62, 89, 130);	

	public SignUp(CoffeeModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		JLabel signUpLabel = new JLabel("Sign Up");
		signUpLabel.setFont(fontB);
		signUpLabel.setForeground(darkBlue);
		JTextField name = new JTextField("Enter your name");
		name.setFont(font);
		name.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
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
		id.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				id.setText("");
			}
			public void focusLost(FocusEvent event) {
				if (id.getText().equals("")) {
					id.setText("Enter your ID");
				}
			}
		});	
		JPasswordField pass = new JPasswordField(10);
		pass.setFont(font);
		pass.setForeground(darkBlue);
		JPasswordField reEnterPass = new JPasswordField(10);
		reEnterPass.setFont(font);
		reEnterPass.setForeground(darkBlue);
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
		confirm.setForeground(darkBlue);
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(signUpLabel);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("Name"));
		panel.add(name);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("ID"));
		panel.add(id);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("Password"));
		panel.add(pass);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("Confirm password"));
		panel.add(reEnterPass);
		panel.add(new JLabel("\n"));
		panel.add(confirm);
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("\n"));
		panel.add(new JLabel("\n"));

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


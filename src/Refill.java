import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Refill extends JFrame {

	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public Refill(CoffeeModel model)
	{	
		NavigationBar nav = new NavigationBar(model, this);
		//GridLayout layout = new GridLayout(1, 2);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
//		layout.setHgap(-275);

		JPanel arrowPanel = new JPanel();
		JButton arrow = new JButton("<<");
		arrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (arrow.getText().equals("<<"))
				{
					arrow.setText(">>");
					remove(nav);
				}
				else if (arrow.getText().equals(">>"))
				{
					arrow.setText("<<");
//					add(nav, 1, 0);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					c.weightx = 0.2;
					c.weighty = 1;
					c.ipady = 700;
					
					add(nav, c);
				}
			}
		});
		arrow.setFocusPainted(false);
		arrow.setContentAreaFilled(false);
		arrow.setBorder(new LineBorder(darkRed, 2, false));
		arrow.setFont(new Font("monospaced", Font.PLAIN, 14));
		arrowPanel.setLayout(new BorderLayout());
		arrowPanel.add(arrow, BorderLayout.WEST);

		
		JPanel mainPanel = new JPanel();
//		JTextArea text = new JTextArea("test");
//		text.setOpaque(false);
//		mainPanel.add(text);
		//show user's current balance
		String balance = model.getCurrentUser().displayBalance();
		JLabel balLabel = new JLabel(" " + balance);
		balLabel.setFont(fontB);
		mainPanel.add(balLabel);
		arrowPanel.add(mainPanel, BorderLayout.CENTER);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.2;
		c.weighty = 1;
		c.ipady = 700;
		
		add(nav, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		
		
		add(arrowPanel, c);


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
		//		add(logoPanel);



		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


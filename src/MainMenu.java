import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public MainMenu(CoffeeModel model)
	{	
		NavigationBar nav = new NavigationBar(model);
		GridLayout layout = new GridLayout(1, 2);
//		layout.setHgap(-275);
		setLayout(layout);

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
					add(nav, 1, 0);
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
		JTextArea text = new JTextArea("test");
		text.setOpaque(false);
		mainPanel.add(text);
		arrowPanel.add(text, BorderLayout.CENTER);
		
		
		add(nav);
		add(arrowPanel);


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


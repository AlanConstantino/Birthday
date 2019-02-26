import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BirthdayGUI{
	private JFrame frame;
	private JPanel centerPanel, southPanel;

	public void setUpFrame(){
		frame = new JFrame();
		frame.setSize(200, 100); // setSize(width, height)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // frame won't be resizable

		// sets up center and southern panel
		modifyCenterPanel();
		updateCenterPanelToFrame();
		modifySouthPanel();
		updateSouthPanelToFrame();

		// sets frame to visible as well as in the middle of the screen
		frame.setLocationRelativeTo(null); // will show frame at the center of the screen
		frame.setVisible(true); // must be the last line to show all content
	}

	public void modifyCenterPanel(){
		// centerPanel
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		JLabel question = new JLabel("Is it your birthday?");
		centerPanel.add(question);
	}

	public void updateCenterPanelToFrame(){
		frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
	}

	public void modifySouthPanel(){
		// southPanel
		southPanel = new JPanel();
		southPanel.setBackground(Color.white);
		JButton yesB = new JButton("Yes");
		yesB.addActionListener(new YesListener());
		JButton noB = new JButton("No");
		noB.addActionListener(new NoListener());
		southPanel.add(yesB);
		southPanel.add(noB);
	}

	public void updateSouthPanelToFrame(){
		frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
	}

	public void resetFrameToStart(){
		modifyCenterPanel();
		updateCenterPanelToFrame();
		modifySouthPanel();
		updateSouthPanelToFrame();
		frame.validate();
	}

	public void start(){
		setUpFrame();
	}

	public static void main(String[] args){
		BirthdayGUI gui = new BirthdayGUI();
		gui.start();
	}

	class YesListener extends BirthdayGUI implements ActionListener{
		private JPanel newCenterPanel;

		@Override
		public void modifyCenterPanel(){
			newCenterPanel = new JPanel(); // creates a new panel
			newCenterPanel.setBackground(Color.white); // sets background color of pane to white
			JLabel label = new JLabel("Happy Birthday!"); // creates a new label
			newCenterPanel.add(label); // adds label to new panel

		}

		@Override
		public void updateCenterPanelToFrame(){
			frame.getContentPane().add(BorderLayout.CENTER, newCenterPanel); // adds new pane to center
			frame.remove(southPanel); // removes southern panel
			frame.validate(); // update frame
		}

		public void actionPerformed(ActionEvent event){
			modifyCenterPanel();
			updateCenterPanelToFrame();
		}
	}

	class NoListener extends BirthdayGUI implements ActionListener{
		private JPanel newCenterPanel;

		@Override
		public void modifyCenterPanel(){
			newCenterPanel = new JPanel(); // creates a new panel
			newCenterPanel.setBackground(Color.white); // sets background color of pane to white
			JLabel label = new JLabel("Hang in there!"); // creates a new label
			newCenterPanel.add(label); // adds label to new panel

		}

		@Override
		public void updateCenterPanelToFrame(){
			frame.getContentPane().add(BorderLayout.CENTER, newCenterPanel); // adds new pane to center
			frame.remove(southPanel); // removes southern panel
			frame.validate(); // update frame
		}

		public void actionPerformed(ActionEvent event){
			modifyCenterPanel();
			updateCenterPanelToFrame();
		}
	}
}

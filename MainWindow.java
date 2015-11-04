
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class MainWindow extends JFrame {
	
	private int remainingGuesses;
	private String wrongGuesses;
	private String word;
	private String visible;
	
	private static String[] threes = {"cat", "dog", "bat", "tag", "bag", "bay", "hay", "mug", "can", "tab", "wax", "rat"};
	private static String[] fours = {"love", "hate", "work", "code", "card", "bath", "late"};

	public MainWindow(String toGuess) {
		remainingGuesses = 10;
		wrongGuesses = "";
		word = toGuess;

		visible = "";

		for(int i = 0; i < word.length(); ++i) {
			visible += "_ ";
		}

		JPanel corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());
		
		final JLabel status = new JLabel("You have "+remainingGuesses+" remaining", SwingConstants.CENTER);
		final JLabel wrong = new JLabel("Wrong guesses so far: "+wrongGuesses);
		final JLabel visibleLabel = new JLabel(visible, SwingConstants.CENTER);
		final JTextField input = new JTextField(); 
		
		JPanel southPanel = new JPanel(new GridLayout(4, 1));
		southPanel.add(status);
		southPanel.add(visibleLabel);
		southPanel.add(input);
		southPanel.add(wrong);
		
		final JButton quit = new JButton("Quit");
		final JButton newGame = new JButton("New Game");
		JPanel northPanel = new JPanel(new GridLayout(1,2));
		northPanel.add(newGame);
		northPanel.add(quit);
		
		corePanel.add(northPanel,BorderLayout.NORTH);
		corePanel.add(southPanel, BorderLayout.SOUTH);
		
		final HangmanFigure hf = new HangmanFigure();
		corePanel.add(hf, BorderLayout.CENTER);
		
		this.add(corePanel, BorderLayout.CENTER);
		
		newGame.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
					corePanel.setVisible(false);
				    mainMenu();
					input.setEnabled(false);
			}
		});
		
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = input.getText();
				
				if(text.length()  == 1 && text.matches("[a-z]")) {
					
					boolean guessFound = false;
					
					for(int i = 0; i < word.length(); ++i) {
						if(text.charAt(0) == word.charAt(i)) {
							guessFound = true;
							
							String newVisible = "";
							for(int j = 0; j < visible.length(); ++j) {
								if(j == (i*2)) {
									newVisible += word.charAt(i);
								}
								else {
									newVisible += visible.charAt(j);
								}
							}
							visible = newVisible;
							visibleLabel.setText(visible);
						}
					}
					
					if(!guessFound) {
						if(--remainingGuesses >= 0) {
							status.setText("You have "+remainingGuesses+" guesses remaining");
							wrongGuesses += text+" ";
							wrong.setText("Wrong guesses so far: "+wrongGuesses);
							hf.set();
						}
						else {
							status.setText("You lost: the word was "+word);
							input.setEnabled(false);
							hf.set();							
						}
					}
					else {
						String actualVisible = "";
						for(int i = 0; i < visible.length(); i+=2) {
							actualVisible += visible.charAt(i);
						}
						
						if(actualVisible.equals(word)) {
							status.setText("Congratulations, you have won!");
							input.setEnabled(false);
						}
					}
					
				}
				else {
					System.out.println("Invalid input!");
				}
				
				input.setText("");
			}
			
		});
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void mainMenu() {
		JFrame menu = new JFrame();
		menu.setSize(301, 330);
	    menu.setTitle("Main Menu");
		menu.setVisible(true);
		
		final JButton easy = new JButton("Easy");
		easy.setLocation(0,0);
		easy.setSize(100, 150);
		menu.add(easy);
		easy.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int len  = 0 + (int)(Math.random()*1); 
				int wordLoc = 0;
				if(len==0) 
				{
					wordLoc = 0 + (int)(Math.random()* (threes.length));
					new MainWindow(threes[wordLoc]);
				}
				else 
				{
					wordLoc = 0 + (int)(Math.random()* (fours.length));
					new MainWindow(fours[wordLoc]);
				}
			}
			}
		);
		
		
		final JButton quit = new JButton("Quit");
		quit.setLocation(0, 151);
		quit.setSize(150,150);
		menu.add(quit);
		quit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		mainMenu();
	}
}

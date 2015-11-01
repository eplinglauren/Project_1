import java.util.Random;

public class Word extends MainWindow{
	private String difficulty;
	//creating lists of possible words
	private String[] easy= {"cat", "java", "tree", "mice", "corn", "tile", "poke", "hey", "farm", "sky", "shoe", "ere", "back", "wave", "are"};
	private String[] medium= {"horse", "alpaca", "system", "hungry", "window", "curtain", "winner", "phone", "cheese", "writing", "barley", "button", "wrong", "right", "helllo"};
	private String[] hard= {"cat", "java", "tree", "mice", "corn", "tile", "poke", "hey", "farm", "sky", "shoe", "ere", "back", "wave", "are"};
	
	/**
	 initializes a Word object with input String difficult
	 @param difficult
	 */
	
	public Word(String difficult)
	{
		super(difficult);
		difficulty= difficult;
	}
	
	/**
	 Picks a random number
	 decides (if loop) if the @difficulty is easy, medium, or hard
	 goes to the spot in the array specified by the previously picked random number and assigns that value to String word
	 @return randomly assigned word
	 */
	public String assignWord()
	{
		String word;
		Random randomGenerator = new Random();
		int randomInt= randomGenerator.nextInt(15);
		if (difficulty=="easy")	{
		word= easy[randomInt];
		}
		if (difficulty=="medium"){
		word= medium[randomInt];
		}
		else{
		word= hard[randomInt];
		}
		return word;
	}
}

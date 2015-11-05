import java.util.Random;

public class Word implements Words{
	private String difficulty;
	//creating lists of possible words
	private String[] easy= {"cat", "java", "tree", "mice", "corn", "tile", "poke", "hey", "farm", "sky", "shoe", "ere", "back", "wave", "are"};
	private String[] medium= {"horse", "alpaca", "system", "hungry", "window", "curtain", "winner", "phone", "cheese", "writing", "barley", "button", "wrong", "right", "hello"};
	private String[] hard= {"pavement", "plantain", "splendid", "forwards", "forewarn", "leathers", "mustangs", "skylight", "backspace", "interface", "implement", "diamonds", "bicycles", "landscape", "cisterns"};
	
	/**
	 initializes a Word object with input String difficult
	 @param difficult
	 */
	
	public Word(String difficult)
	{
		difficulty= difficult;
	}
	
	/**
	 Picks a random number
	 decides (if loop) if the @difficulty is easy, medium, or hard
	 goes to the spot in the array specified by the previously picked random number and assigns that value to String word
	 @return randomly assigned word
	 */
	public String returnWord()
	{
		String word;
		Random randomGenerator = new Random();
		int randomInt= randomGenerator.nextInt(15);
		if (difficulty=="hard")	{
		word= hard[randomInt];
		}
		else if (difficulty=="medium"){
		word= medium[randomInt];
		}
		else{
		word= easy[randomInt];
		}
		return word;
	}
}

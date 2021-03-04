package part1;
import java.util.Random;

/**
 * Generate markov class of order 0 with random text
 */
public class MarkovZero {

    private String myText;
	private Random myRandom;

	/**
	 * constructor initiates myRandom
	 */
	public MarkovZero() {
		myRandom = new Random();
	}


	/**
	 * Set random with input seed
	 *
	 * @param seed received from user input (args[1])
	 */
	public void setSeed(int seed){	myRandom = new Random(seed);
	}


	/**
	 * Set training text with input string
	 *
	 * @param s
	 */
	public void setTraining(String s){
		myText = s.trim();
	}

	/**
	 * Generate random text
	 *
	 * @param numChars len of text to be generated
	 * @return generated random text
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
}
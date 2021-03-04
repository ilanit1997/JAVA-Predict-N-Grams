package part1;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;


/**
 * Generate markov class with order one
 *
 * generate random text dependent on last char - meaning current char is picked at random from list
 * generated by getfollows
 *
 */

public class MarkovOne {
    private String myText;
    private Random myRandom;

    /**
     * Constructor initiates myRandom
     */
    public MarkovOne() {
        myRandom = new Random();
    }


    /**
     * Set random with input seed
     *
     * @param seed
     */
    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * Set training text with input string
     *
     * @param s
     */
    public void setTraining(String s) {
        myText = s.trim();
    }

    /**
     * Generate random text relying on previous char
     *
     * next char is picked from a list generated by getFollows
     * @param numChars len of text to be generated
     * @return generated random text
     */
    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numChars; k++) {
            if (k == 0) {
                int index = myRandom.nextInt(myText.length()-1);
                sb.append(myText.charAt(index));
                continue;
            }
            ArrayList<String> arr = getFollows(sb.substring(k-1, k));
            int index = myRandom.nextInt(arr.size());
            sb.append(arr.get(index));
        }
        return sb.toString();
    }

    /**
     * Generate list which contains chars following our key
     *
     * @param key current string
     * @return list of chars
     */
    public ArrayList<String> getFollows(String key) {
        int len = myText.length();
        int key_len = key.length();
        ArrayList<String> arr = new ArrayList<>(len);
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (i + key_len > len-1){
                break;
            }
            if ((i == len-1) && (myText.substring(i, i+key_len).equals(key))){
                break;
            }
            if (myText.substring(i, i+key_len).equals(key)) {
                arr.add(index++, myText.substring(i+key_len, i+key_len+1));
            }
        }
        return arr;
    }

}
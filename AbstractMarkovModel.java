package part2;

import java.util.*;

/**
 * This abstract class consists of general method to execute on specific markov model
 *
 */
public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int myOrder;


    /**
     * Concatenate print message with order number of current markov
     * @return str Concatenated string
     */
    public String toString(){
        String str = "MarkovModel of order ";
        str += myOrder;
        return str;
    }
    @Override
    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * Constructor of myRandom
     */
    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    @Override
    final public void setTraining(String s) {
        myText = s.trim();
    }

    @Override
    abstract public String getRandomText(int numChars);

    /**
     * Generate list which contains chars following our key
     *
     * @param key current string
     * @return list of chars
     */
    protected ArrayList<String> getFollows(String key) {
        int len = myText.length();
        int key_len = key.length();
        ArrayList<String> arr = new ArrayList<>(len);
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (i + key_len > len - 1) {
                break;
            }
            if ((i == len - 1) && (myText.substring(i, i + key_len).equals(key))) {
                break;
            }
            if (myText.substring(i, i + key_len).equals(key)) {
                arr.add(index++, myText.substring(i + key_len, i + key_len + 1));
            }
        }
        return arr;
    }

}

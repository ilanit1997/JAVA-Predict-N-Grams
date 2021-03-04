package part2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class generated random text using Hashmap
 */
public class EfficientMarkovModel extends AbstractMarkovModel {
    private HashMap<String, ArrayList<String>> myHashMap;

    /**
     * Concatenate print message with order number of current markov
     * @return str Concatenated string
     */
    @Override
    public String toString(){
        String str = "EfficientMarkovModel of order ";
        str += myOrder;
        return str;
    }

    /**
     * Constructor initiates myOrder
     */
    public EfficientMarkovModel(int N) {
        this.myOrder = N;
    }

    /**
     * Generate Hashmap which consisted of : key - every string in text, and value - list every following char to key
     *
     */
    public void buildMap(){
        myHashMap = new HashMap<>();
        ArrayList<String> list;
        int len = myText.length();
        for (int i=0; i<=len-myOrder-1; i++) {
            String key = myText.substring(i, i + myOrder);
            String value = myText.substring(i + myOrder, i + myOrder + 1);
                if (myHashMap.containsKey(key)) {
                // if the key has already been used,
                // we'll just grab the array list and add the value to it
                list = myHashMap.get(key);
                list.add(value);
            } else {
                // if the key hasn't been used yet,
                // we'll create a new ArrayList<String> object, add the value
                // and put it in the array list with the new key
                list = new ArrayList<String>();
                list.add(value);
                myHashMap.put(key, list);
            }
        }
        String lastKey = myText.substring(len-myOrder, len);
        if (!myHashMap.containsKey(lastKey)){
            list = new ArrayList<String>();
            myHashMap.put(lastKey, list);
        }
    }

    @Override
    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numChars; k++) {
            if (k == 0) {
                int index = myRandom.nextInt(myText.length()- myOrder);
                sb.append(myText.substring(index, index + myOrder));
                k+= myOrder-1;
                continue;
            }
            int len_sb = sb.length();
            ArrayList<String> arr = getFollows(sb.substring(len_sb-myOrder, len_sb));
            if (arr.size() == 0){
                break;
            }
            int index = myRandom.nextInt(arr.size());
            sb.append(arr.get(index));
        }
        return sb.toString();
    }

    /**
     * Returns a list of following chars to key in Hashmap
     *
     * @param key current string
     * @return list of following chars to key
     */
    public ArrayList<String> getFollows(String key) {
        return myHashMap.get(key);
    }


}


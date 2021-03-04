package part2;

import util.SEFileUtil;

/**
 * The class is used run markov model Efficiently using Hashmap
 */
public class MarkovRunnerWithInterfaceEfficient {

    /***
     * Build map and Generate 3 paragraphs of random text relying on map
     *
     * @param markov
     * @param text
     * @param size of text to generate
     * @param seed
     */
    public void runModel(EfficientMarkovModel markov, String text, int size, int seed) {
        markov.setSeed(seed);
        markov.setTraining(text);
        markov.buildMap();
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    /**
     * Process text and execute efficient run
     *
     * @param trainingFilePath
     * @param seed
     */
    public void testHashMap(String trainingFilePath, int seed){
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        EfficientMarkovModel emFive = new EfficientMarkovModel(5);
        runModel(emFive, st, size, seed);
    }


    public static void main(String[] args) {
        int secondArg;
        MarkovRunnerWithInterfaceEfficient markovRunner = new MarkovRunnerWithInterfaceEfficient();
        if (args.length != 2){
            System.out.println("Please pass two arguments: 1.input_file 2.seed");
            System.exit(1);
        }
        try {
            secondArg = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e) {
            System.out.println("The second argument must be an integer");
            System.exit(1);
        }
        markovRunner.testHashMap(args[0], Integer.parseInt(args[1]));
    }
}

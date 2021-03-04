package part1;
import java.util.ArrayList;

//This class is meant to test some functions (mainly - getFollows)
public class Test {
    public void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList arrayList = markov.getFollows(".");
        System.out.println(arrayList);


    }

    public static void main(String[] args) {
        Test mytest = new Test();
        mytest.testGetFollows();
    }
}

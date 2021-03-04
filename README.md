# Predict-Text-N-Grams
**Main description:**

Train character selection based on an input text.

In this project we create a text generation system based on markov process described as follows:

Order 0 - choice is independent from last stages.

Order 1 - choice of char at time t is dependent of time t-1.

Order 2 - choice of char at time t is dependent of time t-1 and t-2 and so on.


**Part 1:**

**Classes:**

1. MarkovZero - generate random text.

2. MarkovOne - rely on 1 chars in choice of next char.

3. MarkovFour - rely on 4 chars in choice of next char.

4. MarkovModel - rely on N chars in choice of next char.

5. MarkovRunner - run and test MarkovZero, MarkovOne, MarkovFour, MarkovModel.

6. Tester - run tests

**Methods:**

1. main - recieve file path from data folder.

2. RunMarkovZero - create MarkovZero object of text file, and generate 3 random text snippets from file.

3. getFollows - method recieves key as string and find consecutives chars to key from an inner variable named myText, finally saving 
this into ArrayList and returning it.

4. getRandomText - chooses next char to be printed by finding all consecutive char from training set, and choosing one randomly.

For Example: 
Let's suppose myText is : "this is a test yes this is a test.”
getFollows(“t”) will return: “h”, “e”, “ “, “h”, “e”, “.” because t appears 6 times.


**Part 2:**  
Similar to part 1 but with Abstract Classes and Interface. 
Improve run time of getRandomText with HashMap.

**Classes:**

1. MarkovRunnerWithInterface.
2. AbstractMarkovModel.
3. EfficientMarkovModel.
4. MarkovRunnerWithInterfaceEfficient

**Methods:**

BuildMap - used to create HashMap.

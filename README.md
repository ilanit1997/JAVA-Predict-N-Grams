# Predict-Text-N-Grams
**Main description**

Train character selection based on an input text.
In this project we create a text generation system based on markov process described as follows:

order 0 - choice is independent from last stages.

order 1 - choice of char at time t is dependent of time t-1.

order 2 - choice of char at time t is dependent of time t-1 and t-2 and so on.


**Part 1**

**Classes**

a. MarkovZero - generate random text.

b. MarkovOne - rely on 1 chars in choice of next char.

c. MarkovFour - rely on 4 chars in choice of next char.

d. MarkovModel - rely on N chars in choice of next char.

e. MarkovRunner - run and test MarkovZero, MarkovOne, MarkovFour, MarkovModel.

f. Tester - run tests

**Methods**

a. main - recieve file path from data folder.

b. RunMarkovZero - create MarkovZero object of text file, and generate 3 random text snippets from file.

c. getFollows - method recieves key as string and find consecutives chars to key from an inner variable named myText, finally saving 
this into ArrayList and returning it.

d. getRandomText - chooses next char to be printed by finding all consecutive char from training set, and choosing one randomly.

for example: 
let's suppose myText is : "this is a test yes this is a test.”

e. getFollows(“t”) will return: “h”, “e”, “ “, “h”, “e”, “.” because t appears 6 times.


**Part 2** - similar to part 1 but with Abstract Classes and Interface

**Classes**

a. MarkovRunnerWithInterface.
b. AbstractMarkovModel.


**Part 3** - improve run time of getRandomText with HashMap.

**Classes**

a. EfficientMarkovModel.
b. MarkovRunnerWithInterfaceEfficient.

**Methods**

buildMap - used to create HashMap.

# Predict-Text-N-Grams

Train character selection based on an input text

In this project we create a text generation system based on markov process described as follows:

order 0 - choice is independent from last stages

order 1 - choice of char at time t is dependent of time t-1

order 2 - choice of char at time t is dependent of time t-1 and t-2
and so on

**Part 1**

**CLASSES:**

MarkovZero - generate random text

MarkovOne - rely on 1 chars in choice of next char

MarkovFour - rely on 4 chars in choice of next char

MarkovModel - rely on N chars in choice of next char

MarkovRunner - run and test MarkovZero, MarkovOne, MarkovFour, MarkovModel

Tester - run tests

**METHODS:**

main - recieve file path from data folder

RunMarkovZero - create MarkovZero object of text file, and generate 3 random text snippets from file

getFollows -method recieves key as string and find consecutives chars to key from an inner variable named myText, finally saving 
this into ArrayList and returning it.

getRandomText - chooses next char to be printed by finding all consecutive char from training set, and choosing one randomly.

for example: 

let's suppose myText is : "this is a test yes this is a test.”

getFollows(“t”) will return: “h”, “e”, “ “, “h”, “e”, “.” because t appears 6 times

**Part 2**

same as part 1 but with Abstract Classes and Interface

**CLASSES:**

MarkovRunnerWithInterface

AbstractMarkovModel

**part 3**

improving run time of getRandomText

**CLASSES:**

EfficientMarkovModel

MarkovRunnerWithInterfaceEfficient

**METHODS**

buildMap - used to create HashMap

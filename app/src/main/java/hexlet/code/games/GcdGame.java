package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public class GcdGame {
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Find the greatest common divisor of given numbers.";

    public static int calculatingGcd(int firstNum, int secondNum, int decrement) {
        int gcd = firstNum - decrement;
        decrement += 1;
        return firstNum % gcd == 0 && secondNum % gcd == 0 ? gcd : calculatingGcd(firstNum, secondNum, decrement);
    }

    public static String[][] getQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            var questionsAndAnswersPair = new String[2];
            int firstNum = Utils.getRandomInt(1, UPPER_BOUND);
            int secondNum = Utils.getRandomInt(1, UPPER_BOUND);
            int gcd = calculatingGcd(firstNum, secondNum, 0);
            questionsAndAnswersPair[0] = firstNum + " " + secondNum;
            questionsAndAnswersPair[1] = String.valueOf(gcd);
            questionsAndAnswers[i] = questionsAndAnswersPair;
        }
        return questionsAndAnswers;
    }

    public static void run() {
        Engine.run(getQuestionsAndAnswers(), TASK);
    }
}

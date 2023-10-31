package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    public static void run() {
        //Greeting
        String userName = Engine.greeting();

        //Setting variables
        String expressionToAsk;
        char[] operators = {'+', '-', '*'};
        String rightAnswer;
        boolean resultWin = true;

        //Describing a task
        Engine.describeTask("What is the result of the expression?");

        //Three rounds or quit
        for (int i = 0; i < 3; i++) {
            //forming a question
            int firstNum = Engine.random(100);
            int secondNum = Engine.random(100);
            char currOperator = operators[Engine.random(3)];
            expressionToAsk = firstNum + " " + currOperator + " " + secondNum;
            System.out.println("Question: " + expressionToAsk);

            //discovering the right answer
            if (currOperator == '+') {
                rightAnswer = String.valueOf(firstNum + secondNum);
            } else if (currOperator == '-') {
                rightAnswer = String.valueOf(firstNum - secondNum);
            } else {
                rightAnswer = String.valueOf(firstNum * secondNum);
            }
            //getting the answer, comparing values, announcing results
            resultWin = Engine.getAnswerCheckResult(rightAnswer);
            if (!resultWin) {
                break;
            }
        }

        //Congratulations or another try
        Engine.resulting(resultWin, userName);
    }
}

/*
 * Name: Rohan Sharma
 * ID: 
 * Date: 28/2/2016
 * Filename: ArithExpression.java
 * Details: CSC115 Assignment 3
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ArithExpression {
 
    private TokenList postfixTokens;
    private TokenList infixTokens;
 
    /**
     * Sets up a legal standard Arithmetic expression.
     * The only parentheses accepted are "(" and ")".
     * @param word An arithmetic expression in standard infix order.
     *      An invalid expression is not expressly checked for, but will not be
     *      successfully evaluated, when the <b>evaluate</b> method is called.
     * @throws InvalidExpressionException if the expression cannot be properly parsed,
     *      or converted to a postfix expression.
     */
    public ArithExpression(String word) {
        if (Tools.isBalancedBy("()",word)) {
            tokenizeInfix(word);
            infixToPostfix();
        } else {
            throw new InvalidExpressionException("Parentheses unbalanced");
        }
    }
 
    /*
     * A private helper method that tokenizes a string by separating out
     * any arithmetic operators or parens from the rest of the string.
     * It does no error checking.
     * The method makes use of Java Pattern matching and Regular expressions to
     * isolate the operators and parentheses.
     * The operands are assumed to be the substrings delimited by the operators and parentheses.
     * The result is captured in the infixToken list, where each token is
     * an operator, a paren or a operand.
     * @param express The string that is assumed to be an arithmetic expression.
     */
    private void tokenizeInfix(String express) {
        infixTokens  = new TokenList(express.length());
 
        // regular expression that looks for any operators or parentheses.
        Pattern opParenPattern = Pattern.compile("[-+*/^()]");
        Matcher opMatcher = opParenPattern.matcher(express);
 
        String matchedBit, nonMatchedBit;
        int lastNonMatchIndex = 0;
        String lastMatch = "";
 
        // find all occurrences of a matched substring
        while (opMatcher.find()) {
            matchedBit = opMatcher.group();
            // get the substring between matches
            nonMatchedBit = express.substring(lastNonMatchIndex, opMatcher.start());
            nonMatchedBit = nonMatchedBit.trim(); //removes outside whitespace
            // The very first '-' or a '-' that follows another operator is considered a negative sign
            if (matchedBit.charAt(0) == '-') {
                if (opMatcher.start() == 0 ||  
                    !lastMatch.equals(")") && nonMatchedBit.equals("")) {
                    continue;  // ignore this match
                }
            }
            // nonMatchedBit can be empty when an operator follows a ')'
            if (nonMatchedBit.length() != 0) {
                infixTokens.append(nonMatchedBit);
            }
            lastNonMatchIndex = opMatcher.end();
            infixTokens.append(matchedBit);
            lastMatch = matchedBit;
        }
        // parse the final substring after the last operator or paren:
        if (lastNonMatchIndex < express.length()) {
            nonMatchedBit = express.substring(lastNonMatchIndex,express.length());
            nonMatchedBit.trim();
            infixTokens.append(nonMatchedBit);
        }
    }
 
    /**
     * Determines whether a single character string is an operator.
     * The allowable operators are {+,-,*,/,^}.
     * @param op The string in question.
     * @return True if it is recognized as a an operator.
     */
    public static boolean isOperator(String op) {
        switch(op) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
                return true;
            default:
                return false;
        }
    }
       
    /**
     * NOTE TO STUDENT: These requirements don't show up in the
     * java documentation because it is a private method.
     * It is private because it directly accesses the data fields. 
     *
     * A private method that initializes the postfixTokens data field.
     * It takes the information from the infixTokens data field.
     * If, during the process, it is determined that the expression is invalid,
     * an InvalidExpressionException is thrown.
     * Note that since the only method that calls this method is the constructor,
     * the Exception is propogated through the constructor.
     */
    private void infixToPostfix() {
        StringStack S = new StringStack();
        TokenList bufferList = new TokenList();
        for(int i = 0; i < infixTokens.size(); i++){
            if(!isOperator(infixTokens.get(i))){

                if(infixTokens.get(i).equals("(")){
                    S.push(infixTokens.get(i));
                    continue;
                }
                if(infixTokens.get(i).equals(")")){
                    while(!S.peek().equals("(")) {// change this!

                        bufferList.append(S.pop());
                    }
                    S.pop();
                }
                else{
                    bufferList.append(infixTokens.get(i));
                }
            }
            else{
                while(!S.isEmpty() && !S.peek().equals("(") && precedence(infixTokens.get(i)) <= precedence(S.peek())){
                    bufferList.append(S.pop());
                }
                S.push(infixTokens.get(i));
            }
        }
        while(!S.isEmpty()){
            bufferList.append(S.pop());
            //Check for case if the operator is a open or closing bracket
        }
        this.postfixTokens = bufferList;
    }

    /**
     * @return Returns the infix expression of the Object ArithExpression
     */
    public String getInfixExpression() {
 
        return infixTokens.toString();
    }
    /**
     * @return Returns the postfix expression of the Object ArithExpression
     */
    public String getPostfixExpression() {
 
        return postfixTokens.toString();
    }

    /**
     * Evaluates the expression stored inside of posfixTokens
     * for the Object ArtithExpression
     * @return The answer from evaluation of the expression
     */
    public double evaluate() {
		StringStack S = new StringStack();
        String operand2, operand1;
        double result;
        String resultString;

        for(int i = 0; i < postfixTokens.size();i++){
            if(!isOperator(postfixTokens.get(i))){
                S.push(postfixTokens.get(i));
            }
            else if(isOperator(postfixTokens.get(i))){
                String operator = postfixTokens.get(i);
                operand2 = S.pop();
                operand1 = S.pop();
                double op2 = Double.parseDouble(operand2);
                double op1 = Double.parseDouble(operand1);
                switch (operator){
                    case "+": result = op1 + op2;
                        resultString = Double.toString(result);
                        S.push(resultString);
                        break;
                    case "-": result = op1 - op2;
                        resultString = Double.toString(result);
                        S.push(resultString);
                        break;
                    case "*": result = op1 * op2;
                        resultString = Double.toString(result);
                        S.push(resultString);
                        break;
                    case "/": result = op1 / op2;
                        resultString = Double.toString(result);
                        S.push(resultString);
                        break;
                    case "^": result = Math.pow(op1,op2);
                        resultString = Double.toString(result);
                        S.push(resultString);
                        break;
                }
            }
        }return Double.parseDouble(S.pop());
    }

    /**
     *Private helper method that
     * assigns a number to an operator in terms of precedence
     * @param operator Operator which has to be arranged for precedence
     * @return The number that is assigned
     */
    private int precedence(String operator){
        switch (operator) {
            case "^":
                return 2;
            case "*":
            case "/":
                return 1;
            case "+":
            case "-":
                return 0;
            default:
                return -1;
        }
    }

    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
 
       ArithExpression A = new ArithExpression("(5-2/3+9)*5+5");
       System.out.println(A.getPostfixExpression());
       System.out.println(A.evaluate());
 
 
      }
           
}
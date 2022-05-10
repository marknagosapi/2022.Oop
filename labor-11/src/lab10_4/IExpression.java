package lab10_4;

import java.util.EmptyStackException;

public interface IExpression {
    public static boolean isOperator(String op){
        op = op.trim();
        return op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-");
    }

    public static double evaluate( String postfixExpression) throws ExpressionException, StackException {
        String[] temps = postfixExpression.split(" ");
        Stack stack = new Stack(temps.length);
        for(String item : temps){
            item = item.trim();
            if(!isOperator(item)){
                try {
                    stack.push(Double.parseDouble(item));
                }
                catch (NumberFormatException e){
                    throw new ExpressionException("Wrong operand: " + item);
                }
            }
            else if(isOperator(item)){
                try {
                    double number1 = (double) stack.top();
                    stack.pop();
                    double number2 = (double) stack.top();
                    stack.pop();
                    double result;
                    if(item.equals("+")){
                        result = number1 + number2;
                        stack.push(result);
                    }
                    else if(item.equals("-")){
                        result = number2 - number1;
                        stack.push(result);
                    }
                    else if(item.equals("/")){
                        result = number2 / number1;
                        stack.push(result);
                    }
                    else if(item.equals("*")){
                        result = number1 * number2;
                        stack.push(result);
                    }
                }
                catch (StackException e){
                    throw new ExpressionException("Wrong postfix expression");
                }
            }
        }
        try {
            return (double) stack.top();
        }catch (EmptyStackException e){
            throw new ExpressionException("Wrong postfix expression");
        }
    }
}

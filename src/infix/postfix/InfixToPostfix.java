package infix.postfix;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {
    public String infixPostfix(String infix) {
        String postfix = "";
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('(');
        infix = infix.concat(String.valueOf(')'));
        for (int i = 0; i < infix.length(); i++) {
            char element = infix.charAt(i);
            //step 3
            if (Character.isAlphabetic(element) || Character.isDigit(element)) {
                postfix = postfix.concat(Character.toString(element));
            }
            //step 4
            else if (element=='('){
                stack.push(element);
            }
            //step 5
            else if(isOperator(element)){
                while ( !stack.isEmpty()){
                    //step 5.a
                    if(precedence(stack.peek())>=precedence(element)){
                        //leaving space for associativity
                        postfix=postfix.concat(Character.toString(stack.pop()));

                    }
                    //step 5.b
                    else{
                        stack.push(element);
                        break;
                    }
                }
            }
            //step 6
            else if(element==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix=postfix.concat(Character.toString(stack.pop()));
                }
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
            }
        }
        return postfix;
    }
    private boolean isOperator(char elementFromInfix) {
        boolean response = switch (elementFromInfix) {
            case '*', '/', '^', '+', '-' -> true;
            default -> false;
        };
        return response;
    }
    private  int precedence(char element){
        return switch (element){
            case '^'-> 3;
            case '*','/'-> 2;
            case '+','-'->1;
            default -> 0;
        };
    }
}

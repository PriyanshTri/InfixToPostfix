package main;

import infix.postfix.InfixToPostfix;

public class Driver{
    public static void main(String[] args) {
        InfixToPostfix converter=new InfixToPostfix();
        String infix="A+(B*C-(D/E^F)*G)*H";
        String postfix= converter.infixPostfix(infix);
        System.out.println("postfix= "+postfix);
    }
}


package evaluator.arith;

import java.util.ArrayList;


import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;


public class ArithInFixEvaluator implements PostFixEvaluator<Integer> {


    private final StackInterface<Operand<Integer>> stack;
    private final StackInterface<Operator<Integer>> second;

    /**
     * Constructs an {@link ArithInFixEvaluator}.
     */
    public ArithInFixEvaluator() {
        this.stack = new LinkedStack<Operand<Integer>>();
        this.second = new LinkedStack<Operator<Integer>>();
        //TODO Initialize to your LinkedStack
    }
    /**
     * Evaluates a postfix expression.
     * @return the result
     */
    @Override
    public Integer evaluate(String expr) {
        // TODO Use all of the things they've built so far to
        // create the algorithm to do post fix evaluation

        ArithPostFixParser parser = new ArithPostFixParser(expr);
        while (parser.hasNext()) {
            switch (parser.nextType()) {
                case OPERAND:
                    this.stack.push(parser.nextOperand());
                    //TODO What do we do when we see an operand?
                    break;
                case OPERATOR:
                    if (second.isEmpty()) {
                        second.push(parser.nextOperator());
                    } else {
                        boolean checkforEmpty = false;
                        Operator<Integer> op = parser.nextOperator();
                        while (!checkforEmpty && second.top().getPrecedence() < op.getPrecedence()) {
                            if (!second.isEmpty()) {
                                Operator<Integer> opnow = second.top();
                                for (int i = second.pop().getNumberOfArguments() - 1; i >= 0; i--) {
                                    opnow.setOperand(i, stack.pop());
                                }
                                stack.push(opnow.performOperation());
                            }
                            if (second.isEmpty()) {
                                checkforEmpty = true;
                            }
                        }
                        second.push(op);
                    }


                    break;
                default:
                    throw new IllegalStateException("Could not perform operation");
                    //TODO If we get here, something went terribly wrong
            }
        }
    
        while (!second.isEmpty()) {
            Operator<Integer> opn = second.pop();

            for (int i = opn.getNumberOfArguments()-1;i>=0; i--) {
                opn.setOperand(i,  stack.pop());
            }

            stack.push(opn.performOperation());
        }
        if(this.stack.size() != 1) {
            throw new IllegalPostFixExpressionException("Could not perform operation");
        }
        return this.stack.pop().getValue();
    }
}

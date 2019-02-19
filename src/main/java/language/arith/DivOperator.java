package language.arith;

import language.Operand;
import language.Operator;
import language.BinaryOperator;

/**
 * The {@link DivOperator} is an operator that performs division on two
 * integers.
 * @author jcollard, jddevaug
 *
 */
public class DivOperator extends BinaryOperator<Integer> {

  //TODO Before you get started, have you looked at the
  // PlusOperator class? You'll notice that it is taking advantage
  // of the abstract BinaryOperator class. Take a moment to
  // also look at that class. Finally, you should implement
  // this class.
  @Override
  public Operand<Integer> performOperation() {
    Operand<Integer> op0 = this.getOp0();
    Operand<Integer> op1 = this.getOp1();
    if (op0 == null || op1 == null) {
      throw new IllegalStateException("Could not perform operation prior to operands being set.");
    }
    if(op1.getValue() == 0){
      throw new IllegalStateException("Illegal operation with 0 at the denominator");
    }
    Integer result = op0.getValue() /op1.getValue();
    return new Operand<Integer>(result);
  }

}

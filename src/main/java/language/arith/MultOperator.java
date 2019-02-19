package language.arith;

import language.Operand;
import language.BinaryOperator;
import language.Operator;

/**
 * The {@code MultOperator} is an operator that performs multiplication on two
 * integers.
 * @author jcollard, jddevaug
 *
 */
public class MultOperator extends BinaryOperator<Integer> {

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
    Integer result = op0.getValue() * op1.getValue();
    return new Operand<Integer>(result);
  }


}

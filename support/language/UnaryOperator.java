package language;

/**
 * A {@link BinaryOperator} is an {@link Operator} that performs an
 * operation on two arguments.
 * @author jcollard, jddevaug
 *
 * @param <T> they type of the {@link Operand} being evaluated
 */
public abstract class UnaryOperator<T> implements Operator<T> {

    private Operand<T> op0;

    /**
     * Returns the number of arguments.
     * @ return 2
     */
    @Override
    public final int getNumberOfArguments() {
        return 1;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setOperand(int i, Operand<T> operand) {
        if (operand == null) {
            throw new NullPointerException("Could not set null operand.");
        }
        if (i > 0) {
            throw new IllegalArgumentException("Unary operator only accepts operands 0 "
                    + "but recieved " + i + ".");
        }
        if (i == 0) {
            if (op0 != null) {
                throw new IllegalStateException("Position " + i + " has been previously set.");
            }
            op0 = operand;
        }
    }

    /**
     * Returns the first operand.
     * @return the first operand
     */
    public Operand<T> getOp0() {
        return op0;
    }

    /**
     * Returns the second operand.
     * @return the second operand
     */


}

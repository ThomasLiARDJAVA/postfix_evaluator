package stack;
import java.util.Iterator;
import java.util.Stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
  private Stack<T> stack = new Stack();
  /**
   * {@inheritDoc}.
   */
  @Override
  public T pop() throws StackUnderflowException {
    // TODO Auto-generated method stub
    return stack.pop();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public T top() throws StackUnderflowException {
    // TODO Auto-generated method stub
    return stack.peek();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return stack.isEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return stack.size();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void push(T elem) {
    // TODO Auto-generated method stub
    stack.push(elem);
  }

}

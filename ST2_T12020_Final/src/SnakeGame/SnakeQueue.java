//ok

package SnakeGame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;


public class SnakeQueue {
  Queue q = new LinkedList<>();
  
  SnakeDot head = q.peek();
  
  public SnakeDot getHead() {
	  return head;
  }
  
  public void snakeMove() {
	  
  }

}

//ok

package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;


public class SnakeQueue {
  Queue head = null;
    
  public void addHead(int x, int y, Color c ) {
	  head = (Queue) new SnakeDot (x,y,c);
  }
  
  public void snakeMove() {
	  
  }

}

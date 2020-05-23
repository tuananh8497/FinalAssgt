
package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeQueue {
  SnakeDot head = null;
  Queue<SnakeDot> snake = new LinkedList<SnakeDot>();
  
  public void addHead(int x, int y, Color c) {
    head =  new SnakeDot(x, y, c);
    snake.add(head);
  }

  public void addJoint(int x, int y, Color c) {
    SnakeDot newJoint = new SnakeDot(x, y, c);
    snake.add(newJoint);
  }

  public void addTail(Color c) {
    SnakeDot curr = head;
    while (curr.getNext() != null) {
      curr = curr.getNext();
    }
    SnakeDot newJoint = new SnakeDot(curr.getX() + 10, curr.getY() + 10, c);
    curr.setNext(newJoint);
  }

  public SnakeDot getHead() {
    return head;
  }

  public SnakeDot getJoint(int i) {
    SnakeDot curr = head;
    for (int k = 0; k < i; k++) {
      curr = curr.getNext();
    }
    return curr;
  }

  public void addFirst(SnakeDot snakeDot) {
    snakeDot.setNext(head);
    head = snakeDot;
  }

  public void addLast(SnakeDot snakeDot) {
    if (head == null) {
      head =  snakeDot;
      return;
    }

    SnakeDot curr = head;
    while (curr.getNext() != null) {
      curr = curr.getNext();
    }
    curr.setNext(snakeDot);
  }
// abc
  public void snakeMove(int dots, boolean left, boolean right, boolean up, boolean down,
      final int SIZE) {

    for (int z = dots; z > 0; z--) {
      if (z == 0) {
        getHead().getX();
        getHead().getY();
      } else {
        getJoint(z).setX(getJoint(z - 1).getX());
        getJoint(z).setY(getJoint(z - 1).getY());
      }
    }
    // Move the head to left
    if (Board.leftDirection) {
      head.setX(getHead().getX() - SIZE);
    }
    // Move the head to right
    if (Board.rightDirection) {
      head.setX(getHead().getX() + SIZE);
    }
    // Move the head up
    if (Board.upDirection) {
      head.setY(getHead().getY() - SIZE);
    }
    // Move the head down
    if (Board.downDirection) {
      head.setY(getHead().getY() + SIZE);
    }
  }

}

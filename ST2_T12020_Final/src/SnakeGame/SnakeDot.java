package SnakeGame;

import java.awt.Color;
import java.util.Queue;

public class SnakeDot {
  int x;
  int y;
  Color color;
  SnakeDot next = null;

  public SnakeDot(int x, int y, Color color) {
    super();
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void asHead() {
    this.color = Color.red;
  }

  public void setPos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color c) {
    this.color = color;
  }

  public SnakeDot getNext() {
    return next;
  }

  public void setNext(SnakeDot dot) {
    this.next = (SnakeDot) dot;
  }
}

package SnakeGame;

import java.awt.Color;
import java.util.Queue;

public class SnakeDot {
  int x;
  int y;
  Color color;

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

  public Color getC() {
    return color;
  }

  public void setC(Color c) {
    this.color = color;
  }


}

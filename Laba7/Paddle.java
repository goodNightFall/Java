package Laba7;

import javax.swing.*;

public abstract class Paddle extends JPanel implements Runnable {
  protected int x;
  protected int y;
  protected int width;
  protected int height;
  protected int ySpeed = 0;
  protected volatile boolean isThreadRunning = true;

  Paddle() {
    this.setFocusable(true);
  }

  public int getCurrentX() {
    return this.x;
  }

  public int getCurrentY() {
    return this.y;
  }

  public int getCurrentWidth() {
    return this.width;
  }

  public int getCurrentHeight() {
    return this.height;
  }

  public void resetPaddle() {
    x = (getWidth() - width) / 2;
    y = (getHeight() - height) / 2;
  }

  public void closeThread() {
    this.isThreadRunning = false;
  }
}
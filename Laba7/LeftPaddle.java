package Laba7;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LeftPaddle extends Paddle {
  public LeftPaddle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    this.setFocusable(true);

    new Thread(this).start();
  }

  public void keyPressed(KeyEvent e) {
    // Обработка нажатий клавиш W и S для левой ракетки

    if (e.getKeyCode() == KeyEvent.VK_W) {
      ySpeed = -10;
    } else if (e.getKeyCode() == KeyEvent.VK_S) {
      ySpeed = 10;
    }
  }

  public void keyReleased(KeyEvent e) {
    // Обработка отпускания клавиш для остановки ракеток
    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
      ySpeed = 0;
    }
  }

  @Override
  public void run() {
    while (isThreadRunning) {
      y += ySpeed;

      if (y <= 0 || y >= getHeight() - height - Main.MARGIN_BOTTOM) {
        y -= ySpeed;
      }

      // Перерисовываем панель
      repaint();

      // Приостанавливаем поток на короткое время (чтобы увидеть анимацию)
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // Рисуем круглый мяч
    Rectangle paddle = new Rectangle(x, y, width, height);
    g2d.setColor(Color.RED);
    g2d.fill(paddle);
  }
}
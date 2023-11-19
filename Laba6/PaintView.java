package Laba6;

import javax.swing.*;
import java.awt.*;

public class PaintView extends JPanel {

  private PaintModel paintModel;
  private JPanel topPanel;
  private JPanel paintPanel;

  JButton black;
  JButton red;
  JButton green;
  JButton blue;

  JButton dot;
  JButton line;
  JButton oval;
  JButton rect;

  JButton reset;

  public PaintView(PaintModel paintModel) {
    this.paintModel = paintModel;
    topPanel = new JPanel(new GridLayout(1, 11));
    paintPanel = new JPanel(new BorderLayout());

    black = new JButton("Black");
    red = new JButton("Red");
    green = new JButton("Green");
    blue = new JButton("Blue");

    dot = new JButton("Dot");
    line = new JButton("Line");
    oval = new JButton("Oval");
    rect = new JButton("Rectangle");

    reset = new JButton("Reset");

    topPanel.add(black);
    topPanel.add(red);
    topPanel.add(green);
    topPanel.add(blue);

    topPanel.add(dot);
    topPanel.add(line);
    topPanel.add(oval);
    topPanel.add(rect);

    topPanel.add(reset);

    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(750, 450));
    this.add(topPanel, BorderLayout.NORTH);
    this.add(paintPanel, BorderLayout.SOUTH);

  }

  public void drawDot(Graphics g, Shape shape) {
    g.fillOval(shape.getX(), shape.getY(), 10, 10);
  }

  public void drawMyLine(Graphics g, Shape shape) {
    g.drawLine(shape.getX(), shape.getY(), shape.getXMoved(), shape.getYMoved());
  }

  public void drawOval(Graphics g, Shape shape) {
    g.fillOval(shape.getNewX(), shape.getNewY(), shape.getWidth(), shape.getHeight());
  }

  public void drawRect(Graphics g, Shape shape) {
    g.fillRect(shape.getNewX(), shape.getNewY(), shape.getWidth(), shape.getHeight());
  }

  public void drawShape(Graphics g, Shape shape) {
    String color = shape.getColor();
    changeColor(g, color);
    String form = shape.getShape();
    if (form.equals("dot")) {
      drawDot(g, shape);
    } else if (form.equals("line")) {
      drawMyLine(g, shape);
    } else if (form.equals("oval")) {
      drawOval(g, shape);
    } else {
      drawRect(g, shape);
    }
  }

  public void changeColor(Graphics g, String color) {
    switch (color) {
      case "black":
        g.setColor(Color.black);
        break;
      case "red":
        g.setColor(Color.red);
        break;
      case "green":
        g.setColor(Color.green);
        break;
      case "blue":
        g.setColor(Color.blue);
        break;
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Shape shape : paintModel.getShapes()) {
      drawShape(g, shape);
    }

  }
}
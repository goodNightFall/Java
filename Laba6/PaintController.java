package Laba6;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintController extends JFrame implements ActionListener {

  private PaintModel paintModel;
  private PaintView paintView;

  public PaintController() {
    paintModel = new PaintModel();
    paintView = new PaintView(paintModel);

    paintView.black.addActionListener(this);
    paintView.red.addActionListener(this);
    paintView.green.addActionListener(this);
    paintView.blue.addActionListener(this);

    paintView.dot.addActionListener(this);
    paintView.line.addActionListener(this);
    paintView.oval.addActionListener(this);
    paintView.rect.addActionListener(this);

    paintView.reset.addActionListener(this);

    paintView.addMouseListener(new MouseAdapter() {

      @Override
      public void mousePressed(MouseEvent e) {
        String color = paintModel.getColor();
        String form = paintModel.getShape();
        int x = e.getX();
        int y = e.getY();
        Shape shape = new Shape(color, form, x, y);
        paintModel.addShape(shape);
        paintView.repaint();
      }
    });

    paintView.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        paintModel.mouseMoved(x, y);
        paintView.repaint();
      }
    });

    setVisible(true);
    add(paintView);
    pack();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Black":
        paintModel.setColor("black");
        break;
      case "Red":
        paintModel.setColor("red");
        break;
      case "Green":
        paintModel.setColor("green");
        break;
      case "Blue":
        paintModel.setColor("blue");
        break;
      case "Dot":
        paintModel.setShape("dot");
        break;
      case "Line":
        paintModel.setShape("line");
        break;
      case "Oval":
        paintModel.setShape("oval");
        break;
      case "Rectangle":
        paintModel.setShape("rectangle");
        break;
      case "Reset":
        paintModel.setShapes(new ArrayList<>());
        paintView.repaint();
    }
  }

}
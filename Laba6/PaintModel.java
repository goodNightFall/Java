package Laba6;

import java.util.ArrayList;

public class PaintModel {

  private String color;
  private String shape;
  private ArrayList<Shape> shapes;

  public PaintModel() {

    this.color = "black";
    this.shape = "dot";
    shapes = new ArrayList<>();
  }

  public String getColor() {
    return color;
  }

  public String getShape() {
    return shape;
  }

  public ArrayList<Shape> getShapes() {
    return shapes;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }

  public void setShapes(ArrayList<Shape> shapes) {
    this.shapes = shapes;
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  public void mouseMoved(int x, int y) {
    if (!shapes.isEmpty()) {
      Shape shape = shapes.get(shapes.size() - 1);
      shape.mouseMoved(x, y);
    }
  }
}
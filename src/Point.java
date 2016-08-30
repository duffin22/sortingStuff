/**
 * Created by matthewtduffin on 06/07/2016.
 */
public class Point {
  public int x;
  public int y;

  //constructor defaults to (0,0) if nothing defined
  public Point() {
  //call regular constructor inside zero arg constructor
    this(0,0);
  }
  //2 argument constructor
  public Point(int x, int y) {
    this.x=x;
    this.y=y;
  }
  //overwrite toString method to give in coordinate form
  public String toString() {
    return "("+this.x+","+this.y+")";
  }

}

/**
 * Created by matthewtduffin on 06/07/2016.
 */
public class Car {
  public int wheels=4;
  public String model;
  public String color;

  public Car(String model, String color) {
    this.model=model;
    this.color=color;
  }

  public String toString() {
    return this.color+" "+this.model;
  }


}

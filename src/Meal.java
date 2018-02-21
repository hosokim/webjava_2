
public abstract class Meal implements Cloneable {
  private String mName;
  private int mPrice;

  public Meal(String name, int price) {
    mName = name;
    mPrice = price;
  }

  public String getName() {
    return mName;
  }

  public int getPrice() {
    return mPrice;
  }

  public Meal clone() {
    Meal meal = null;
    try {
      meal = (Meal) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return meal;
  }
}

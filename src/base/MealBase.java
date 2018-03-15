package base;

public abstract class MealBase implements Cloneable {
  private String mName;
  private int mPrice;

  public MealBase(String name, int price) {
    mName = name;
    mPrice = price;
  }

  public String getName() {
    return mName;
  }

  public int getPrice() {
    return mPrice;
  }

  public MealBase clone() {
    MealBase meal = null;
    try {
      meal = (MealBase) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return meal;
  }
}

package advanced;
import base.MealBase;

public class CanBigSizeMeal extends MealBase {
  private boolean mIsBig = false;

  public CanBigSizeMeal(String name, int price) {
    super(name, price);
  }

  @Override
  public int getPrice() {
    int price = super.getPrice();
    if (mIsBig) {
      price += 100;
    }
    return price;
  }

  public void setBigSize(boolean isBig) {
    mIsBig = isBig;
  }

  @Override
  public String getName() {
    return super.getName() + (mIsBig ? " 大盛" : "");
  }

}

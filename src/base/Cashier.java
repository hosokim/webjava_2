package base;
import java.util.List;

public abstract class Cashier {
  private List<MealBase> mCheck;
  public void putCheck(List<MealBase> check) {
    mCheck = check;
  }

  public int getAllPrice() {
    int allPrice = 0;
    for (MealBase m : mCheck) {
      allPrice += m.getPrice();
    }
    return allPrice;
  }

  public int pay(int yen) {
    return  yen - getAllPrice();
  }
}

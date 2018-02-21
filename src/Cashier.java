import java.util.List;

public abstract class Cashier {
  private List<Meal> mCheck;
  public void putCheck(List<Meal> check) {
    mCheck = check;
  }

  public int getAllPrice() {
    int allPrice = 0;
    for (Meal m : mCheck) {
      allPrice += m.getPrice();
    }
    return allPrice;
  }

  public int pay(int yen) {
    return  yen - getAllPrice();
  }
}

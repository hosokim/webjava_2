package advanced;
import base.Cashier;

public class DiscountCashier extends Cashier {
  private boolean mUseCoupon = false;

  public void setUseCoupon(boolean isUse) {
    mUseCoupon = isUse;
  }

  @Override
  public int getAllPrice() {
    int price = super.getAllPrice();
    if (mUseCoupon) {
      price -= 300;
    }
    return price;
  }


}

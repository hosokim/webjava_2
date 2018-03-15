package simple;
import base.Staff;

public class BegginerStaff extends Staff {

  @Override
  public void createMenu() {
    mMenu = new FoodsMenu();
  }

  @Override
  public void createCashier() {
    mCashier = new SimpleCashier();
  }
}

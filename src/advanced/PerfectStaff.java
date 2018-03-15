package advanced;
import base.MealBase;
import base.Staff;
import util.ScannerUtil;

public class PerfectStaff extends Staff {

  @Override
  public void createMenu() {
    mMenu = new BigSizeFoodsMenu();
  }

  @Override
  public void createCashier() {
    mCashier = new DiscountCashier();
  }

  @Override
  public void checkAndAddMenu(int mealId) {
      MealBase meal = mMenu.get(mealId);
      meal = bigSizeCheck(meal);
      mCheck.add(meal);
  }
  
  private MealBase bigSizeCheck(MealBase meal) {
    if (meal instanceof CanBigSizeMeal) {
      System.out.println("スタッフ：大盛りにしますか？(y/n)");
      if (tellYesOrNo()) {
        ((CanBigSizeMeal)meal).setBigSize(true);
      } else {
        ((CanBigSizeMeal)meal).setBigSize(false);
      }
    }
    return meal;
  }

  @Override
  public int checkAllPrice() {
      int allPrice = mCashier.getAllPrice();
      System.out.println("スタッフ：お会計は"+allPrice+"円になります");
      return allPrice = checkCoupon(allPrice);
  }
  
  private int checkCoupon(int allPrice) {
    if (mCashier instanceof DiscountCashier) {
      System.out.println("スタッフ：クーポン券はお持ちですか？(y/n)");
      if (tellYesOrNo()) {
        ((DiscountCashier)mCashier).setUseCoupon(true);
        allPrice = mCashier.getAllPrice();
        System.out.println("スタッフ：お会計変わりまして"+allPrice+"円になります");
      } else {
        ((DiscountCashier)mCashier).setUseCoupon(false);
      }
    }
    return allPrice;
  }

  private boolean tellYesOrNo() {
    String input = ScannerUtil.getNextInput();
    if ("y".equalsIgnoreCase(input)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void sendOff() {
    System.out.println("スタッフ：またのお越しをお待ちしております");
  }
}

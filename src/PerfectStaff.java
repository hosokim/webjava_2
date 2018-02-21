import java.util.List;

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
  public List<Meal> order() {
    System.out.println("スタッフ：メニューをどうぞ");
    mMenu.show();

    System.out.println("スタッフ：ご注文番号を教えてください");
    System.out.println("スタッフ：終了する場合はendを押してください");
    do {
      String input = mScan.next();
      if ("end".equalsIgnoreCase(input)) {
        break;
      } else {
        int id = Integer.parseUnsignedInt(input);
        Meal meal = mMenu.get(id);
        meal = bigSizeCheck(meal);
        mCheck.add(meal);
      }
      System.out.println("スタッフ：続けてご注文をどうぞ");
    } while(true);

    System.out.println("スタッフ：ご注文の品をどうぞ");
    mCashier.putCheck(mCheck);
    return mCheck;
  }

  private Meal bigSizeCheck(Meal meal) {
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
  public int check() {
    int allPrice = mCashier.getAllPrice();
    System.out.println("スタッフ：お会計は"+allPrice+"円になります");
    allPrice = checkCoupon(allPrice);
    System.out.println("スタッフ：お支払金額を入金してください");
    int yen = 0;
    do {
      String input = mScan.next();
      yen = Integer.parseUnsignedInt(input);
      if (allPrice <= yen) {
        break;
      } else {
        System.out.println("スタッフ：不足しています。お支払金額を入金してください");
      }
    }while(true);
    int otsuri = mCashier.pay(yen);
    if (otsuri > 0) {
      System.out.println("スタッフ：お釣り"+ otsuri +"円のお返しです。ありがとうございました");
    } else {
      System.out.println("スタッフ：ありがとうございました。");
    }
    return otsuri;
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
    String input = mScan.next();
    if ("y".equalsIgnoreCase(input)) {
      return true;
    } else {
      return false;
    }
  }

}

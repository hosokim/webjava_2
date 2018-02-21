import java.util.List;

public class BegginerStaff extends Staff {

  @Override
  public void createMenu() {
    mMenu = new FoodsMenu();
  }

  @Override
  public void createCashier() {
    mCashier = new SimpleCashier();
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
        mCheck.add(meal);
      }
    } while(true);

    System.out.println("スタッフ：ご注文の品をどうぞ");
    mCashier.putCheck(mCheck);
    return mCheck;
  }

  @Override
  public int check() {
    int allPrice = mCashier.getAllPrice();
    System.out.println("スタッフ：お会計は"+allPrice+"円になります");
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
      System.out.println("スタッフ：お釣りのお返しです。ありがとうございました");
    } else {
      System.out.println("スタッフ：ありがとうございました。");
    }
    return otsuri;
  }

}

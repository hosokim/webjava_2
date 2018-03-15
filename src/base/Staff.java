package base;
import java.util.ArrayList;
import java.util.List;
import util.ScannerUtil;

public abstract class Staff {
  protected Menu mMenu;
  protected List<MealBase> mCheck;
  protected Cashier mCashier;

  public Staff() {
    createMenu();
    createCashier();
    mCheck = new ArrayList<MealBase>();
  }
  public abstract void createMenu();
  public abstract void createCashier();
  public List<MealBase> order() {
      System.out.println("スタッフ：メニューをどうぞ");
      mMenu.show();

      System.out.println("スタッフ：ご注文番号を教えてください");
      System.out.println("スタッフ：終了する場合はendを入力してください");
      do {
        String input = ScannerUtil.getNextInput();
        if ("end".equalsIgnoreCase(input)) {
          break;
        } else {
          int id = Integer.parseInt(input);
          checkAndAddMenu(id);
          System.out.println("スタッフ：他にご注文はございますか？終了する場合はendを入力してください");
        }
      } while(true);

      System.out.println("スタッフ：ご注文の品をどうぞ");
      mCashier.putCheck(mCheck);
      return mCheck;
  }

  public void checkAndAddMenu(int mealId) {
      MealBase meal = mMenu.get(mealId);
      mCheck.add(meal);
  }

  public int check() {
      int allPrice = checkAllPrice();
      System.out.println("スタッフ：お支払金額を入金してください");
      int yen = 0;
      do {
        String input = ScannerUtil.getNextInput();
        yen = Integer.parseInt(input);
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

  public int checkAllPrice() {
      int allPrice = mCashier.getAllPrice();
      System.out.println("スタッフ：お会計は"+allPrice+"円になります");
      return allPrice;

  }

  public void sendOff() {
  }
}

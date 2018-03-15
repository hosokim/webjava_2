import java.util.List;

import advanced.PerfectStaff;
import base.MealBase;
import base.Staff;
import simple.BegginerStaff;
import util.ScannerUtil;

public class SampleRestaurantMain {

  public static void main(String[] args) {
    SampleRestaurantMain restaurant = SampleRestaurantMain.getInstance();
    restaurant.start();
  }

  public static SampleRestaurantMain getInstance() {
    return new SampleRestaurantMain();
  }

  public void start() {
    System.out.println("システム：どちらのスタッフを呼びますか？");
    System.out.println("          a:普通のスタッフ  b:パーフェクトなスタッフ");
    String id = ScannerUtil.getNextInput();
    Staff staff = null;
    if ("a".equalsIgnoreCase(id)) {
      staff = new BegginerStaff();
    } else {
      staff = new PerfectStaff();
    }
    System.out.println("客：注文お願いします");
    List<MealBase> meals = staff.order();
    if (meals != null && meals.size() > 0) {
      System.out.println("客：もぐもぐ...");
      for (MealBase meal : meals) {
        System.out.println("客："+meal.getName()+" おいしい。");
      }

      System.out.println("客：会計お願いします");
      staff.check();

      staff.sendOff();
    }
  }
}

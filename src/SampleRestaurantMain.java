import java.util.List;
import java.util.Scanner;

public class SampleRestaurantMain {

  private Scanner mScan;

  public static void main(String[] args) {
    SampleRestaurantMain restaurant = SampleRestaurantMain.getInstance();
    restaurant.start();
  }

  public static SampleRestaurantMain getInstance() {
    return new SampleRestaurantMain();
  }

  public void start() {
//    Staff staff = new BegginerStaff();
    Staff staff = new PerfectStaff();
    System.out.println("客：注文お願いします");
    List<Meal> meals = staff.order();
    if (meals != null && meals.size() > 0) {
      System.out.println("客：もぐもぐ...");
      for (Meal meal : meals) {
        System.out.println("客："+meal.getName()+" おいしい。");
      }

      System.out.println("客：会計お願いします");
      staff.check();

      staff.sendOff();
    }
  }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Staff {
  protected Scanner mScan;
  protected Menu mMenu;
  protected List<Meal> mCheck;
  protected Cashier mCashier;

  public Staff() {
    createMenu();
    createCashier();
    mCheck = new ArrayList<Meal>();
    mScan = new Scanner(System.in);
  }
  public abstract void createMenu();
  public abstract void createCashier();
  public abstract List<Meal> order();
  public abstract int check();

  public void sendOff() {
    mScan.close();
  }
}

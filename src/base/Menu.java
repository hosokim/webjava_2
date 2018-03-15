package base;

public abstract class Menu {
  public Menu() {
    create();
  }
  public abstract void create();
  public abstract void show();
  public abstract MealBase get(int id);
}

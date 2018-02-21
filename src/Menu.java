
public abstract class Menu {
  public Menu() {
    create();
  }
  public abstract void create();
  public abstract void show();
  public abstract Meal get(int id);
}

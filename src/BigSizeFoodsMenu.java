import java.util.ArrayList;
import java.util.List;

public class BigSizeFoodsMenu extends Menu {

  List<Meal> mFoods;

  @Override
  public void create() {
    mFoods = new ArrayList<Meal>();
    mFoods.add(new CanBigSizeMeal("ラーメン", 700));
    mFoods.add(new CanBigSizeMeal("チャーハン", 650));
    mFoods.add(new BaseMeal("卵スープ", 500));
  }

  @Override
  public void show() {
    for (int i=0; i < mFoods.size(); i++) {
      Meal meal = mFoods.get(i);
      if (meal instanceof CanBigSizeMeal) {
        System.out.println("No."+i+" "+meal.getName()+" :"+meal.getPrice()+"円 +100円で大盛にできます");
      } else {
        System.out.println("No."+i+" "+meal.getName()+" :"+meal.getPrice()+"円");
      }
    }
  }

  @Override
  public Meal get(int id) {
    if (mFoods.size() > id) {
      return mFoods.get(id).clone();
    } else {
      return null;
    }
  }

}

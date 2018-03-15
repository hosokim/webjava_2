package simple;
import java.util.ArrayList;
import java.util.List;

import base.MealBase;
import base.Menu;

public class FoodsMenu extends Menu {
  List<MealBase> mFoods;

  @Override
  public void create() {
    mFoods = new ArrayList<MealBase>();
    mFoods.add(new Meal("ラーメン", 700));
    mFoods.add(new Meal("チャーハン", 650));
    mFoods.add(new Meal("卵スープ", 500));
  }

  @Override
  public void show() {
    for (int i=0; i < mFoods.size(); i++) {
      MealBase meal = mFoods.get(i);
      System.out.println("No."+i+" "+meal.getName()+" :"+meal.getPrice()+"円");
    }
  }

  @Override
  public MealBase get(int id) {
    if (mFoods.size() > id) {
      return mFoods.get(id);
    } else {
      return null;
    }
  }

}

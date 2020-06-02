import java.util.*;

/**
 * @author jgz
 * @Date 2020-04-19 11:01
 */
public class DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String,TreeMap> table = new TreeMap<>();
        List<String> set = new ArrayList<>();
        for (List<String> order : orders){
            if (!set.contains(order.get(2))){
                set.add(order.get(2));
            }
        }
        Collections.sort(set, (o1, o2) -> o1.compareTo(o2));
        for (List<String> order : orders){
            String tableNum = order.get(1);
            if (!table.containsKey(order.get(1))){
                TreeMap<String, Integer> temp = new TreeMap<>();
                for (String s : set){
                    temp.put(s, 0);
                }
                table.put(tableNum, temp);
            }
            TreeMap<String,Integer> foods = table.get(tableNum);
            String food = order.get(2);
            foods.put(food, foods.get(food) + 1);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();
        foodNames.add("Table");
        for (String s : set){
            foodNames.add(s);
        }
        res.add(foodNames);
        List<String> stringList = new ArrayList<>(table.keySet());
        Collections.sort(stringList, (o1, o2) -> Integer.valueOf(o1) - Integer.valueOf(o2));
        for (String s : stringList){
            List<String> foodsNum = new ArrayList<>();
            foodsNum.add(s);
            TreeMap<String, Integer> temp = table.get(s);
            for (Integer num : temp.values()){
                foodsNum.add(num.toString());
            }
            res.add(foodsNum);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        String[][] strings = new String[][]{{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        for (String[] strings1 :strings){
            lists.add(Arrays.asList(strings1));
        }
        List<List<String>> res = new DisplayTable().displayTable(lists);
    }
}

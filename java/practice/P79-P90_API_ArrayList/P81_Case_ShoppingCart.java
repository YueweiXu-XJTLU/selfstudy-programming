package S8_ArrayList;

import java.util.ArrayList;

public class P81_Case_ShoppingCart {
    public static void main(String[] args) {
        ArrayList<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("item1_a");
        shoppingCart.add("item2_a");
        shoppingCart.add("item3");
        shoppingCart.add("item4_a");
        shoppingCart.add("item5");
        shoppingCart.add("item6_a");
        shoppingCart.add("item7");
        shoppingCart.add("item8");
        shoppingCart.add("item9_a");
        System.out.println(shoppingCart);
        //We need to delete all items with "_a"

        //iterate over the shoppingCart and remove
        //i1, i2, i3, i4, i5, i6, i7, i8, i9
        // 0   1   2   3   4   5   6   7   8
        // i
        // i2, i3, i4, i5, i6, i7, i8, i9 (size = 8)
        //      i
        //here error occurs, delete i1, i++ then i2 is skipped

        //solution1: recover the index location
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).contains("_a")) {
                shoppingCart.remove(i);
                i--; //to solve the error above
                //i3, i4, i5, i6, i7, i8, i9 (size = 7)
                // i
                //i3, i4, i5, i6, i7, i8, i9 (size = 7)
                //     i
                //i3, i5, i6, i7, i8, i9 (size = 6)
                //     i
                //i3, i5, i6, i7, i8, i9 (size = 6)
                //         i
                //i3, i5, i7, i8, i9 (size = 5)
                //         i
                //i3, i5, i7, i8, i9 (size = 5)
                //            i
                //i3, i5, i7, i9 (size = 4)
                //            i //here i is exactly 4, hence stop the loop --> "i < shoppingCart.size()" (changed size) won't case errors
            }
        }
        System.out.println(shoppingCart);

        //solution2: iterate in reverse order
        ArrayList<String> shoppingCart2 = new ArrayList<>();
        shoppingCart2.add("item1_a");
        shoppingCart2.add("item2_a");
        shoppingCart2.add("item3");
        shoppingCart2.add("item4_a");
        shoppingCart2.add("item5");
        shoppingCart2.add("item6_a");
        shoppingCart2.add("item7");
        shoppingCart2.add("item8");
        shoppingCart2.add("item9_a");
        System.out.println(shoppingCart2);
        
        for (int i = shoppingCart2.size() - 1;  i <= 0 ; i--) {
            if (shoppingCart2.get(i).contains("_a")) {
                shoppingCart2.remove(i);
            }
        }
        System.out.println(shoppingCart2);
    }

}

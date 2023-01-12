package Ch08_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class Q04_PowerSet {
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> prefix = new ArrayList<>();
        getSubsets(list, subsets, prefix, 0);
        return subsets;
    }

    public static void getSubsets(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> prefix, int index){
        if (index == list.size()){
            return;
        }

        // Including the element in index
        prefix.add(list.get(index));
        subsets.add((ArrayList<Integer>) prefix.clone());
        getSubsets(list, subsets, prefix, index + 1);
        prefix.remove(prefix.size() - 1);

        // Excluding the element in index
        getSubsets(list, subsets, prefix, index + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        ArrayList<ArrayList<Integer>> subsets2 = getSubsets(list);
        System.out.println(subsets2.toString());
    }

}

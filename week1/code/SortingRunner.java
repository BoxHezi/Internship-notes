import java.util.Arrays;

public class SortingRunner {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        System.out.println("Bubble");
        int[] forBubble = initArray();
        sorting.bubble(forBubble);
        System.out.println(Arrays.toString(forBubble));

        System.out.println("Selection");
        int[] forSelection = initArray();
        sorting.bubble(forSelection);
        System.out.println(Arrays.toString(forSelection));

        System.out.println("Insertion");
        int[] forInsertion = initArray();
        sorting.insertion(forInsertion);
        System.out.println(Arrays.toString(forInsertion));

        System.out.println("Quick");
        int[] forQuick = initArray();
        sorting.quick(forQuick, 0, forQuick.length - 1);
        System.out.println(Arrays.toString(forQuick));

        System.out.println("Merge");
        int[] forMerge = initArray();
        sorting.mergeSort(forMerge);
        System.out.println(Arrays.toString(forMerge));

    }

    private static int[] initArray() {
        return new int[]{32, 21, 4, 19, 17, 8, 9, 63, 44, 78, 93, 25};
    }

}

public class Sorting {

    // 冒泡
    public int[] bubble(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // 选择
    public int[] selection(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 交换元素
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    // 插入
    public int[] insertion(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int k = i - 1;
            while (k >= 0 && arr[k] > arr[i]) {
                k--;
            }
            int temp = arr[i];
            // 将元素后移1位，腾出k+1
            for (int j = i; j > k + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[k + 1] = temp;
        }
        return arr;
    }

    // 快速
    public int[] quick(int[] arr, int left, int right) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        if (left < right) {
            int pivot = calPivot(arr, left, right);

            // 左子数组
            arr = quick(arr, left, pivot - 1);
            // 右子数组
            arr = quick(arr, pivot + 1, right);
        }
        return arr;
    }

    private int calPivot(int[] arr, int left, int right) {
        // 选取基准
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (i < j) {
            // 从右向左开始与pivot做对比
            while (i < j && arr[j] > pivot) {
                j--;
            }
            // 从左向右开始与pivot做对比
            while (i < j && arr[i] < pivot) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        if (arr[left] > arr[j]) {
            arr[left] = arr[j];
            arr[j] = pivot;
        }
        return j;
    }

    public int[] mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        System.arraycopy(arr, 0, left, 0, left.length);

        int[] right = new int[arr.length - left.length];
        System.arraycopy(arr, left.length, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        arr = merge(arr, left, right);

        return arr;
    }

    private int[] merge(int[] arr, int[] left, int[] right) {
        int leftNum = left.length;
        int rightNum = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftNum && j < rightNum) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftNum) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightNum) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }
}

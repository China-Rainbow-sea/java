package day1;

public class ArrayUtil {
    public static void main(String[] args){
        int[] arr = new int[]{1, 30, 9, 8, 6, 30, 20, 66, 60, 99};
        ArrayTest arrayTest = new ArrayTest(); // 实例化对象,调用构造方法,静态的访问非静态的

        System.out.println(arrayTest.arrMax(arr));
        System.out.println(arrayTest.arrMin(arr));
        System.out.println(arrayTest.arrSum(arr));
        System.out.println(arrayTest.arrAvg(arr));
        System.out.println(arrayTest.getIndex(arr,99));
        System.out.println(arrayTest.getIndex(arr,0));
        arrayTest.arrPlay(arrayTest.arrCopy(arr));
        arrayTest.arrSort(arr);
        arrayTest.arrPlay(arr);
        arrayTest.arrReverse(arr);
        arrayTest.arrPlay(arr);

    }

}


class ArrayTest{
    // 求数组的最大值
    public int arrMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    // 求数组的最小值
    public int arrMin(int[] arr){
        int min = arr[0];
        for(int i = 0; i<arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }

        return min;
    }


    // 求数组的总和
    public int arrSum(int[] arr){
        int sum = 0;  // 局部变量必须赋予初始值,才可以使用

        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }

        return sum;
    }


    // 求数组的平均值
    public double arrAvg(int[] arr){
        return this.arrSum(arr)/arr.length;
    }



    // 查找数组中的某个数值的索引
    public int getIndex(int[] arr,int dest){
        for(int i = 0; i <arr.length;i++){
            if(dest == arr[i]){
                return i;
            }
        }

        return -1; // 该数值在数组中不存在；
    }



    // 数组排序
    public void arrSort(int[] arr){
        for(int i = 0; i<arr.length-1;i++){
            for(int j = 1; j < arr.length-i;j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



    // 数组打印
    public void arrPlay(int[] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    // 复制数组

    public int[] arrCopy(int[] arr){
        int[] arrcopy = new int[arr.length];

        for(int i = 0; i < arr.length;i++){
            arrcopy[i] = arr[i];
        }

        return arrcopy;
    }


    // 反转数组
    public void arrReverse(int[] arr){
        for(int i = 0; i <arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }


}
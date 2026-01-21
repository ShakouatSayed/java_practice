import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class count_minimum_bitwise_array2 {
    public int[] minimumBitwiseArray(List<Integer> nums){
        int n = nums.size();
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int x = nums.get(i);
            int res = -1;
            int dis = 1;

            while((x & dis) != 0){
                res = x - dis;
                dis <<= 1;
            }
            result[i] = res;

        }
        return result;
    }

    public static void main(String[] args){
        count_minimum_bitwise_array2 cmba = new count_minimum_bitwise_array2();

        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);

        int[] result = cmba.minimumBitwiseArray(nums);
        System.out.println(Arrays.toString(result));
    }
}

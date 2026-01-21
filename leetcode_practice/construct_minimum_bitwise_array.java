package leetcode_practice;
import java.util.Arrays;
import java.util.List;

public class construct_minimum_bitwise_array {
    
    public int[] minBitwiseArray(List<Integer> nums){
        int[] result = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            int orginal = nums.get(i);
            int candidate = -1;

            for(int j = 1; j < orginal; j++){
                if((j | (j + 1)) == orginal){
                    candidate = j;
                    break;
                }
            }

            result[i] = candidate;
        }
        return result;
    }


    public static void main(String args[]){
        construct_minimum_bitwise_array msl = new construct_minimum_bitwise_array();
        
        List<Integer> nums = Arrays.asList(2, 3, 5, 7);
        int[] result = msl.minBitwiseArray(nums);

        System.out.println("The result is: "+Arrays.toString(result));
    }
}

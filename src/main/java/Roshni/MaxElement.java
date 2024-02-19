package Roshni;

import java.util.HashMap;
import java.util.Map;

public class MaxElement {


//    Output: 3
public static void main(String[] args) {
    int[] nums = {3,2,3};
    //majorityElement(nums);
    System.out.println(majorityElement(nums));
}
    public static int majorityElement(int[] nums) {
        int max=0; int min =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
          //  System.out.println("here 1 "+ nums[i]);
            if(hm.containsKey(nums[i])) {
               // hm.merge(nums[i], 1, Integer::sum);
                System.out.println("here 2 "+ nums[i]);
                  int  currentValue = hm.get(nums[i]);
                hm.put(nums[i], currentValue+1);
              //  hm.computeIfPresent(nums[i], (k, v) -> v + 1);
            } else {
                System.out.println("here 3 "+ nums[i]);
                hm.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            System.out.println("value is" + m.getValue());
            if(m.getValue() > max) {
              //  min = max;
                max = m.getValue();
            }
            System.out.println("Here is am "+max );
            return max;
        }
        return max;
    }
}

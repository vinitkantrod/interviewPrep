package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo2DArray2570 {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] res = new int[1001][2];
        for (int[] i : nums1) {
            int idx = i[0];
            res[idx] = new int[] {i[0], i[1]};
        }
        for (int[] i : nums2) {
            int idx = i[0];
            int[] e = res[idx];
            if (e[1] != 0) {
                e[1] = e[1] + i[1];
                res[idx] = new int[]{e[0], e[1]};
            } else {
                res[idx] = new int[]{i[0], i[1]};
            }
        }
        List<Integer[]> tempRes = new ArrayList<>();
        for (int i =0; i < res.length; i++) {
            if (res[i][1] > 0) tempRes.add(new Integer[]{res[i][0], res[i][1]});
        }
        int[][] r = new int[tempRes.size()][2];
        for (int i = 0; i < tempRes.size(); i++) {
            r[i] = new int[]{tempRes.get(i)[0], tempRes.get(i)[1]};
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] n1 = {{148,597},{165,623},{306,359},{349,566},{403,646},{420,381},{566,543},{730,209},{757,875},{788,208},{932,695}};
        int[][] n2 = {{74,669},{87,399},{89,165},{99,749},{122,401},{138,16},{144,714},{148,206},{177,948},{211,653},{285,775},{309,289},{349,396},{386,831},{403,318},{405,119},{420,153},{468,433},{504,101},{566,128},{603,688},{618,628},{622,586},{641,46},{653,922},{672,772},{691,823},{693,900},{756,878},{757,952},{770,795},{806,118},{813,88},{919,501},{935,253},{982,385}};
        System.out.println(Arrays.toString(mergeArrays(n1, n2)));
    }
}

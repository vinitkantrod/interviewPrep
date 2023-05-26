package com.vinit.dsalgo.arrays.leetcode;

public class AvgSalaryExMinAndMax1491 {

    public static double average(int[] salary) {

        double minSal = Double.MAX_VALUE;
        double maxSal = Double.MIN_VALUE;
        int count = 0;
        double sum = 0d;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            minSal = Math.min(minSal, salary[i]);
            maxSal = Math.max(maxSal, salary[i]);
        }
        sum = sum - minSal - maxSal;
        return sum / salary.length - 2;

//        double minSal = Double.MAX_VALUE;
//        double maxSal = Double.MIN_VALUE;
//        int count = 0;
//        double sum = 0d;
//        for (int i = 0; i < salary.length; i++) {
//            double sal = salary[i];
//            System.out.println(sal);
//            if (minSal == Double.MAX_VALUE) minSal = sal;
//            if (maxSal == Double.MIN_VALUE) maxSal = sal;
//            if (sal < minSal && minSal == maxSal) {
//                minSal = sal;
//            } else if (sal > maxSal && maxSal == minSal) {
//                maxSal = sal;
//            }else if (sal < minSal && minSal != maxSal) {
//                sum += minSal;
//                minSal = sal;
//                count++;
//            } else if (sal > maxSal && minSal != maxSal) {
//                sum += maxSal;
//                maxSal = sal;
//                count++;
//            } else if (sal > minSal && sal < maxSal) {
//                sum += sal;
//                count++;
//            }
//            System.out.println(minSal + " - " + maxSal);
//            System.out.println(count + " :: " + sum);
//        }
//        return sum / count;
    }

    public static void main(String[] args) {
//        int[] s = {100, 200, 300, 400};
//        int[] s = {400, 300, 200, 100};
        int[] s = {400, 100, 300, 200};
        System.out.println(average(s));
    }
}

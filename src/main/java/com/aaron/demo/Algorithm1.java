package com.aaron.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leecode
 * @description: 两数之和
 * @author: tianpanke
 * @create: 2020-05-17
 **/
public class Algorithm1 {
    /**
    *desc:给定一个整数数组nums和一个目标值target,请你在该数组中找出和为目标值
    *的两个整数，并返回他们的数组下标。
     */
    public static void main(String[] args) {

    }

    /**
     *algorithm1:暴力法，两次迭代计算所有情形下的和并比较目标值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] twoSum1(int [] array, int target){
        int len=array.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(target==array[i]+array[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /**
     * algorithm2:两遍哈希表，为了对运行时间复杂度进行优化，我们需要一种
     * 更有效的方法来检查数组中是否存在目标元素，如果存在我们需要找出他的
     * 索引。保持数组中的每个元素与其索引对应的最好方法就是哈希表。
     * 通过以空间换取时间的方式，我们可以将查找时间从O(n)降低到O(1)。哈希表
     * 正式为此目的而构建的，它支持以近似恒定的时间进行快速查找。我们用近似来
     * 描述，因为一旦出现冲突，查找用时可能退化到O(n)。但只要你仔细地挑选哈希
     * 函数，在哈希表中进行查找耗时应当被摊销为O(1)。
     * 第一次迭代，我们将每个元素的值和它的索引添加到表中。
     * 第二次迭代，我们检查每个元素对应的目标元素（target-array[i]）是否存在
     * 与哈希表中，注意该元素不能是array[i]本身。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum2(int []array,int target){
        Map<Integer,Integer> map=new HashMap<>();
        int len=array.length;
        for(int i=0;i<len;i++){
            map.put(array[i],i);
        }
        for(int i=0;i<len;i++){
            int complement=target-array[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }
    /**
     * algorithm3:一次哈希，在算法2的基础之上进行改良。在仅有的一次迭代中
     * 往哈希表中塞元素，同时判断target-当前元素是否存在于哈希表中。
     */
    public int[] twoSum3(int []array,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++){
            int complement=target-array[i];
            if(map.containsKey(complement)){
                return new int[]{i,map.get(complement)};
            }
        }
        return  null;
    }
}

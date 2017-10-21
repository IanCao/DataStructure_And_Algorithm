package Algorithm;

public class MaxGap {
    /*
    １０位数字使用１１个桶，最后肯定最少有一个桶是没有数字的，那就是这个桶的左右两侧的差为最大值
     */
    public static void main(String[] args){
        int[] value = ArraysUtils.createRandomArrays(10);
        System.out.println(maxGap(value));
    }

    private static int bucket(int currentValue,int maxValue,int minValue,int buckets){
        System.out.println((currentValue - minValue)*buckets/(maxValue - minValue));
        return (currentValue - minValue)*buckets/(maxValue - minValue) ;
    }

    private static int maxGap(int[] value){
        int buckets = value.length + 1;

        int max = value[0];
        int min = value[0];

        for (int i = 0;i<value.length;i++){
            max = Math.max(max,value[i]);
            min = Math.min(min,value[i]);
        }

        int[] mins = new int[buckets];
        int[] maxs = new int[buckets];
        boolean[] hasNum = new boolean[buckets];

        for(int i=0;i<value.length;i++){
            int tag = bucket(value[i],max,min,value.length);
            maxs[tag] = hasNum[tag]?Math.max(maxs[tag],value[i]):value[i];
            mins[tag] = hasNum[tag]?Math.min(mins[tag],value[i]):value[i];
            hasNum[tag] = true;
        }

        int maxValues = 0;
        int minValues = 0;
        int gap = 0;
        int i = 0;
        while (i < buckets){
            while (i<buckets && hasNum[i]){
                i++;
            }

            if(i >= buckets){
                break;
            }

            maxValues = maxs[--i];
            i++;

            while (i<buckets && !hasNum[i]){
                i++;
            }

            if(i >= buckets){
                break;
            }

            minValues = mins[i];

            gap = (minValues - maxValues)>gap?minValues - maxValues:gap;
            System.out.println(minValues+" "+maxValues);
        }

        return gap;
    }
}

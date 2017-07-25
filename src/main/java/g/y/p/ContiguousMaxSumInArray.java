package g.y.p;

public class ContiguousMaxSumInArray {
    public static void main(String[] args) {
        int[] array = {31,-41,59,26,-53,58,97,-93,-23,84};
        int[] result = findContiguousMax(array);
        System.out.println("max sum "+result[0]+" : start from "+result[1]+" till "+result[2]);
    }

    /**
     *
     * @return max, begin, end
     */
    public static int[] findContiguousMax(int[] a){
        int[] result = {-1,-1,-1};
        int maxendinghere = 0;
        int maxsofar = 0;

        int begin_index = -1;

        int end_index = -1;


        for(int i=0;i<a.length;i++){
            if(maxendinghere<=0 && maxendinghere+a[i]>0){
                begin_index = i;
            }

            maxendinghere = Math.max(maxendinghere+a[i],0);

            if(maxendinghere>maxsofar){
                result[1] = begin_index;
                result[2] = i;
            }
            maxsofar = Math.max(maxsofar,maxendinghere);
            result[0] = maxsofar;

        }
        return result;
    }
}

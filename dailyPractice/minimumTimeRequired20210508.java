import java.util.Arrays;

/**
 * @ClassName minimumTimeRequired20210508
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/8 15:19
 * @Version 1.0
 */

public class minimumTimeRequired20210508 {
    int ans = 0x3f3f3f3f;
    int n,k;
    int[] jobs;
    public static void main(String[] args) {

        minimumTimeRequired20210508 test = new minimumTimeRequired20210508();
        int[] jobs = new int[]{1,2,4};
        int k = 2;
        System.out.println(test.minimumTimeRequired(jobs,k));

    }

    public int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k]; //每个工人的工作时间向量
        dfs(0,0,sum,0);
        return ans;
    }

    public void dfs(int index,int used,int[] sum,int max){
        if(max >= ans) return;
        if(index == n){
            ans = max;
            return;
        }

        // 回溯
        if(used < k){  //优先分配未工作的工人
            sum[used] = jobs[index];
            dfs(index+1,used+1,sum,Math.max(sum[used],max));
            sum[used] = 0;
        }
        for(int i = 0;i<used;i++){
            sum[i] += jobs[index];
            dfs(index+1,used,sum,Math.max(sum[i],max));
            sum[i] -= jobs[index];
        }
    }

}

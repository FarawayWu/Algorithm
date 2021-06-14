package algorithm.dynamicplanning;

import com.company.DataHelperInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NumberOfTower implements DataHelperInterface<List<List<Integer>>> {
    private List<List<Integer>> triangle;
    private int n;
    private int [][] dp;
    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.n = triangle.size() - 1;
        this.dp = new int[n+1][n+1];
        return minSum(0, 0);
    }

    //递推写法
    private int minSum(List<List<Integer>> triangle) {
        int n = triangle.size() -1;
        int [][] dp = new int[n+1][n+1];
        for (int i = n; i >= 0; --i) {
            for(int j = 0; j <= i; j++) {
                if(i == n) {
                    //边界
                    dp[n][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }

    //递归写法
    private int minSum(int i, int j) {
        if(i == n) {
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        return dp[i][j] = Math.min(minSum(i+1, j), minSum(i+1, j+1)) + triangle.get(i).get(j);
    }


    @Override
    public List<List<Integer>> prepareInput() {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        ll.add(l4);
        return ll;
    }

    @Override
    public void startOutput() {
        System.out.println(minimumTotal(prepareInput()));
    }
}

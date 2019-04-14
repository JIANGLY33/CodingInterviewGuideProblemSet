package StackAndQueue.HanoiProblem;

/** 递归解法
 *
 */
public class Resolution1 {
    private int move(int n,String left, String mid, String right, String src, String dest) {
        if( n <= 0)return 0;
        if( n == 1) {
            if(src.equals(mid)||dest.equals(mid)) {
                System.out.println("Move 1 from " + src + " to " + dest);
                return 1;
            }
            else {
                System.out.println("Move 1 from " + src + " to mid");
                System.out.println("Move 1 from mid to " + dest);
                return 2;
            }
        }
        if(src.equals(mid)||dest.equals(mid)) {
            String another = (src.equals(left)||dest.equals(left)) ? right:left;
            int part1 = move(n-1,left,mid,right,left,another);
            int part2 = 1;
            System.out.println("Move " + n + " from " + src + " to " + dest);
            int part3 = move(n-1,left,mid,right,another,dest);
            return part1 + part2 + part3;
        }
        else {
            int part1 = move(n-1,left,mid,right,src,dest);
            int part2 = 1;
            System.out.println("Move " + n + " from " + src + " to mid ");
            int part3 = move(n-1,left,mid,right,dest,src);
            int part4 = 1;
            System.out.println("Move " + n + " from mid to " + dest );
            int part5 = move(n-1,left,mid,right,src,dest);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void resolve(int n, String src, String dest) {

        System.out.println("It will move " +
                new Resolution1().move(n,"left","mid","right",src,dest)
                + " steps. ");
    }
}

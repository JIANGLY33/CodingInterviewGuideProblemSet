package StackAndQueue.HanoiProblem;

import java.util.Stack;

/** 迭代解法
 *
 */
public class Resolution2 {

    private static int fStackToStack(Action[] action, Action oppPreAct, Action nowAct,
                     Stack<Integer> src, Stack<Integer> dest, String from, String to) {
        if(action[0] != oppPreAct && src.peek() < dest.peek()) {
            dest.push(src.pop());
            System.out.println("Move " + dest.peek() + " from " + from + " to " + to );
            action[0] = nowAct;
            return 1;
        }
        return 0;
    }

    private static int move(int n, String left, String mid, String right) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for(int i = n; i > 0; i--) {
            ls.push(i);
        }
        int step = 0;
        Action[] action = new Action[]{Action.No};
        while(rs.size() != n+1) {
            step += fStackToStack(action,Action.LToM,Action.MToL,ms,ls,"mid","left");
            step += fStackToStack(action,Action.MToL,Action.LToM,ls,ms,"left","mid");
            step += fStackToStack(action,Action.MToR,Action.RToM,rs,ms,"right","mid");
            step += fStackToStack(action,Action.RToM,Action.MToR,ms,rs,"mid","right");
        }
        return step;
    }

    public static void resolve(int n) {
        int count = move(n,"left","mid","right");
        System.out.println("It will move " + count + " steps. ");
    }

    public static void main(String[] args) {
        Resolution2.resolve(2);
    }
}

enum Action {
    No, LToM, MToL, RToM, MToR
}

package StackAndQueue.SortStackByStack;

import java.util.Stack;

/** 思路简述：用B栈来实现A栈中所有元素的排序，我们只需要保证A栈中的所有元素进入B栈后是按照升序或者降序排列的即可，因为一
 *  旦所有元素在B栈中有序排列，我们将B栈的这些元素再直接压入A栈，那么这些元素在A栈中也将会是有序的。
 *  假设我们要实现A栈中的所有元素自底向上是递增的，那么我们的目标是让A栈中的所有元素在进入B栈后是自底向上递减的。而为了
 *  完成这一目标，我们需要在把A栈中的元素压入B栈时采取一定的策略：我们把每次从A栈弹出的元素称为temp。若B栈为空，则temp可
 *  以被直接压入B栈；若temp小于B栈栈顶元素，则temp也直接被压入B栈；若temp大于B栈栈顶元素，则将temp栈顶元素弹出并重新压入
 *  A栈（因为要对所有元素进行排序，所以我们不能丢弃任何一个元素），直到B栈栈顶元素小于temp或B栈为空时才将temp压入B栈。按
 *  以上策略维护的B栈将满足其中所有元素都是自底向上递减的需求，最后将B栈中的元素依次弹出再压入A栈即可完成本题求解。
 */
public class StackSort {
    public static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while(!s.empty()) {
            int cur = s.pop();
            if(temp.empty())temp.push(cur);
            else {
                while(!temp.empty() && cur > temp.peek())
                    s.push(temp.pop());
                temp.push(cur);
            }
        }
        while(!temp.empty())
            s.push(temp.pop());
    }
}

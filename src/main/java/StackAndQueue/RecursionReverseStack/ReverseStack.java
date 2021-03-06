package StackAndQueue.RecursionReverseStack;

import java.util.Stack;

/**
 *
 */
public class ReverseStack {
    /**  算法思路 **/
    /** 先pop出栈顶元素，若此时栈为空，说明该元素是栈的最后一个元素 **/
    /** 若栈非空，则递归调用自身，每次调用均取出此刻的栈底元素 **/
    /** 取出栈底元素后将先前取出的栈顶元素重新压入栈中，并将取出的栈底元素返回 **/
    public static int getAndRemoveLastElem(Stack<Integer> s) {
        int result = s.pop();
        if(s.empty()){
            return result;
        }else {
            int last = getAndRemoveLastElem(s);
            s.push(result);
            return last;
        }
    }

    /** 若栈为空则无需执行任何操作 **/
    /** 若栈非空，则取出栈中最后一个元素，再递归地调用自身，将栈中剩余元素逆序，再将先前取出的栈底元素压入栈中 **/
    public static void reverseStack(Stack<Integer> s) {
        if(s.empty())return;
        else{
            int elem = getAndRemoveLastElem(s);
            reverseStack(s);
            s.push(elem);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 10; i++)s.push(i);
        reverseStack(s);
        for(int i = 0; i < 10; i++) System.out.println(s.pop());
    }
}

/** 反思 **/
/** 关于递归函数，可以从异步和同步的视角入手 **/
/** 异步视角：调用递归函数后，我们直接得到理想的返回结果，并转向下一行代码，而不必深究递归函数内部究竟发生了什么。 **/
/** 同步视角：我们跟随递归函数的调用去一步一步理解它的每次调用会造成什么结果，以及函数的返回顺序，返回结果是什么。 **/
/** 无论是异步还是同步的视角，书写递归函数，我们都需要先找到递归出口，并决定在递归出口时如何操作。 **/
/** 就getAndRemoveLastElem()函数而言，递归出口显然是堆栈为空的情况，当堆栈为空时显然我们取出的元素即是栈底元素，故返回该元素即可。 **/
/** 接下来分别从异步和同步的视角来看待逻辑代码 **/
/** 异步：既然已知堆栈非空，那我们直接调用getAndRemoveLastElem()即可取出栈底元素，为了保证栈与初始态仅有栈底元素的差别，我们将先前
          为了判断递归出口所取出的栈顶元素重新压入栈中，然后将取出的栈底元素返回即可。
    同步：已知堆栈非空，调用getAndRemoveLastElem将不断地重复调用自身，每一次重复调用都将取出一个栈顶元素，最终栈中元素被全部取出，递
          归来到了递归出口，递归出口返回栈底元素，最后一个被调用的函数返回栈底元素后，倒数第二个被调用的函数接收到它的返回值并继续执行
          接下来的代码，即倒数第二个被调用的函数将它先前取出的栈顶元素重新压入栈中，然后将栈底元素返回，接下来倒数第三个被调用的函数接收
          到了倒数第二个被调用的函数的返回值后继续执行它接下来的代码……以此类推，当所有GetAndRemoveLastElem()执行完毕后，取出栈底元素的
          任务也就完成了。
    通过以上的叙述我们可以直观的感受到，异步视角相比同步视角，显然更容易理解，而在思考代码逻辑时需要从哪种视角切入，仁者见仁。
    （个人感觉如果能熟练地用异步视角来分解递归问题将会更加高效）
 **/
/** 递归函数本身必须起到减小规模的作用，否则单纯的调用函数本身是毫无意义的。而如何将减小问题规模和分解解决问题的步骤完美协调好
    正是解决递归问题的一个难点。（通常减小问题的规模寓于分解出的解决问题步骤的某一步中）
 **/

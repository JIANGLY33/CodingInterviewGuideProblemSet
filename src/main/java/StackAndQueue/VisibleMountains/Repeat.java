package StackAndQueue.VisibleMountains;

/** 没有重复值的情况，用公式计算得：n = 2 * i -3
 * 公式说明：假设有i个节点，按照“小找大”的原则，除了最大节点和次大节点外，其他每个节点都只对应两对最小山峰对
 * 再加上最大节点和次大节点这一对，故得到：2*（i-2）+1
 */
public class Repeat {
    public static int record(int[] array) {
        return 2 * array.length -3;
    }
}

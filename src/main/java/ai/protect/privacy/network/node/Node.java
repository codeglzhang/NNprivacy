package ai.protect.privacy.network.node;

import java.util.List;

/**
 * 神经网络中的节点抽象类，所有类型的节点都必须继承此类
 *
 * @see MaxNode
 * @see AvgNode
 * @see SimpleNode
 * @author CodeGang
 * @since jdk1.8
 */
public abstract class Node {
    /**
     * 神经节点的值
     */
    public Object value;

    /**
     * 此神经节点的激活函数
     */
    public ActiveFunction activeFunction;

    /**
     * 此神经节点的操作接口eg: +,-,*,max
     */
    public Options options;

    /**
     * 节点序号，用于日志输入和调试
     */
    public int serialNumber;

    public Node() {
    }

    public Node(ActiveFunction activeFunction, Options options) {
        this.activeFunction = activeFunction;
        this.options = options;
    }

    public Node(Object value, ActiveFunction activeFunction, Options options, int serialNumber) {
        this.value = value;
        this.activeFunction = activeFunction;
        this.options = options;
    }

    /**
     * 根据输入数据计算此节点的值
     * @param data 输入数据
     * @param weights 权重参数
     * @param bias 偏差
     */
    public abstract void compute(List data, Object[] weights, Object bias);

    /**
     * 克隆此节点
     * @return 克隆的新节点
     */
    @Override
    public abstract Node clone();
}

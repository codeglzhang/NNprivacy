package ai.protect.privacy.network.node;

import java.util.List;

/**
 * 在没有使用密码学技术保护计算情况下，正常计算的节点
 * @author CodeGang
 * @since jdk1.8
 */
public class SimpleNode extends Node {
    public SimpleNode() {
        options = new SimpleOptions();
        activeFunction = new ReLu();
    }

    public SimpleNode(ActiveFunction activeFunction, Options options) {
        super(activeFunction, options);
    }

    @Override
    public void compute(List data, Object[] weights, Object bias) {
        value=bias;
        for (int index = 0; index < weights.length; index++) {
            Object tmp = data.get(index);
            if (tmp != null) {
                value = options.add(value, options.multiply(weights[index], data.get(index)));
            }
        }
        value=activeFunction.compute(value,options);
    }

    @Override
    public Node clone() {
        return new SimpleNode(activeFunction,options);
    }
}

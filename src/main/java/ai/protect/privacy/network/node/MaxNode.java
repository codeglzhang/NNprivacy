package ai.protect.privacy.network.node;

import java.util.List;

/**
 * 输出输入数据中最大值的节点，用于pool层{@link ai.protect.privacy.network.layercomputer.PoolLayerComputer}
 * @author CodeGang
 * @since jdk1.8
 */
public class MaxNode extends Node {
    public MaxNode() {
    }

    public MaxNode(ActiveFunction activeFunction, Options options) {
        super(activeFunction, options);
    }

    public MaxNode(Object value, ActiveFunction activeFunction, Options options, int serialNumber) {
        super(value, activeFunction, options, serialNumber);
    }

    @Override
    public void compute(List data, Object[] weights, Object bias) {
        value=options.getMax(data);
    }

    @Override
    public Node clone() {
        return new MaxNode(activeFunction,options);
    }
}

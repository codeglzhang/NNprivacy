package ai.protect.privacy.network.node;

import java.util.List;

/**
 * 根据输入数据输出平均值的节点用于池化层{@link ai.protect.privacy.network.layercomputer.PoolLayerComputer}
 * @author CodeGang
 * @since jdk1.8
 */
public class AvgNode extends Node {
    public AvgNode() {
    }

    public AvgNode(Object value, ActiveFunction activeFunction, Options options, int serialNumber) {
        super(value, activeFunction, options, serialNumber);
    }

    public AvgNode(ActiveFunction activeFunction, Options options) {
        super(activeFunction, options);
    }

    @Override
    public void compute(List data, Object[] weights, Object bias) {
        value=options.getAvg(data);
    }

    @Override
    public Node clone() {
        return new AvgNode(this.activeFunction,this.options);
    }
}


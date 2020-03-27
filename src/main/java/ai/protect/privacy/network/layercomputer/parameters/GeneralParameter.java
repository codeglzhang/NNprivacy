package ai.protect.privacy.network.layercomputer.parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * 全连接层的参数类
 * @author CodeGang
 * @since jdk1.8
 */
public class GeneralParameter implements Parameters {
    /**
     * 权重矩阵，一行参数表示计算一个节点的所有权重参数
     */
    public Object[][] weights;
    /**
     * 偏差数组
     */
    public Object[] bias;
    @Override
    public Parameters fromList(List list) {
        weights= (Object[][]) list.get(0);
        bias = (Object[])list.get(1);
        return this;
    }

    @Override
    public List toList() {
        List list =new ArrayList();
        list.add(weights);
        list.add(bias);
        return list;
    }

    @Override
    public int nodeSize() {
        return weights.length;
    }
}

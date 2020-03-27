package ai.protect.privacy.network.layercomputer;

import ai.protect.privacy.network.node.Node;
import ai.protect.privacy.network.layercomputer.parameters.GeneralParameter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 全连接层的计算器
 * @author CodeGang
 * @since jdk1.8
 */
public class GeneralLayerComputer implements LayerComputer {
    public GeneralParameter parameter = new GeneralParameter();

    public GeneralLayerComputer() {
    }

    public GeneralLayerComputer(GeneralParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameter(List parameter) {
        this.parameter.fromList(parameter);
    }

    @Override
    public List compute(List input, List<Node> nodes) {
        List layerData = new ArrayList<>(nodes.size());
        Iterator<Node> nodeIter = nodes.iterator();
        int i = 0;
        //便利该层中每一个节点，并调用其compute方法进行计算
        while (nodeIter.hasNext()){
            Node node = nodeIter.next();
            node.compute(input,parameter.weights[i],parameter.bias[i]);
            layerData.add(node.value);
            i++;
        }
        return layerData;
    }
}

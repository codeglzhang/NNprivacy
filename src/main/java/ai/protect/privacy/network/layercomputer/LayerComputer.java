package ai.protect.privacy.network.layercomputer;

import ai.protect.privacy.network.node.Node;

import java.util.List;

/**
 * 神经层计算的接口
 * @author CodeGang
 */
public interface LayerComputer {
    void setParameter(List parameter);
    /**
     * 进行一层的计算
     * @param input 输入
     * @param nodes 该层的神经元
     * @return 输出
     */
    List compute(List input,List<Node> nodes);
 }

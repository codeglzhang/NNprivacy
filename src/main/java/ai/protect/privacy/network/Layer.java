package ai.protect.privacy.network;


import ai.protect.privacy.network.layercomputer.LayerComputer;
import ai.protect.privacy.network.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 神经网络实体的神经层实体，
 *
 * @author CodeGang
 * @since jdk1.8
 */
public class Layer {
    /**
     * 该层的计算类，封装了如何计算该层节点的值
     */
    private LayerComputer computer;

    /**
     * 组成该层的神经元节点
     */
    private List<Node> nodes = new ArrayList<>();

    /**
     * 层序号，用于日志记录和调试时方便区分
     */
    private int serialNumber=0;

    /**
     * 像网络层中添加神经元节点
     * @param node
     * @return
     */
    public boolean add(Node node){
        node.serialNumber=nodes.size();
        return nodes.add(node);
    }

    /**
     * 计算此层网络每个神经节点的值
     * @param data 该层输入的数据
     * @return 该层输出的结果
     */
    public List compute(List data){
       return computer.compute(data,nodes);
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public void setSerialNumber(int number){
        serialNumber=number;
    }

    public void setComputer(LayerComputer computer) {
        this.computer = computer;
    }

    public int size(){
        return nodes.size();
    }
}

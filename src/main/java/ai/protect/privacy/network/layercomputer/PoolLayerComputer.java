package ai.protect.privacy.network.layercomputer;

import ai.protect.privacy.network.node.Node;
import ai.protect.privacy.network.layercomputer.parameters.PoolParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责计算pool层的计算类，目前仅支持2d数据
 * @author CodeGang
 * @since jdk1.8
 */
public class PoolLayerComputer implements LayerComputer {
    public PoolParameter parameter=new PoolParameter();

    public PoolLayerComputer() {
    }

    public PoolLayerComputer(PoolParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameter(List parameter) {
        this.parameter.fromList(parameter);
    }

    @Override
    public List compute(List input, List<Node> nodes) {

        //将输入的一维数据还原为2维数据(2维+通道)
        Object[][][] channels = CovUtils.changeTo2D(input,parameter.column,
                parameter.row,parameter.paddingRow,parameter.paddingColumn,parameter.channel);
        List result = new ArrayList();
        //计算每一个通道
        for(int i =0;i<parameter.channel;i++){
            result.addAll(computeOneChannel(channels[i],nodes.subList(i*parameter.blockNumber,
                    (i+1)*parameter.blockNumber)));
        }
        return result;
    }

    /**
     * 计算一个通道对应图像的pool输出，并将计算结果存入网络层中的节点
     * @param channel 该通道的图像
     * @param nodes 进行具体计算的节点列表
     * @return 计算结果
     */
    private List computeOneChannel(Object[][] channel, List<Node> nodes){
        List result = new ArrayList();
        List block = new ArrayList();
        int nodeIndex = 0;
        for (Node node : nodes){
            block.clear();
            CovUtils.get2dBlock(channel,block,(nodeIndex/parameter.blockColumnNum)*parameter.stride[0],
                    (nodeIndex%parameter.blockColumnNum)*parameter.stride[1],parameter.blockRow,parameter.blockColumn);
            node.compute(block,null,null);
            result.add(node.value);
            nodeIndex++;
        }
        return result;
    }

    private void getBlock(Object[][] image, List block,int beginRow, int beginColumn){
        for(int i = beginRow;i<parameter.blockRow;i++){
            for (int j=beginColumn;j<parameter.blockColumn;j++){
                block.add(image[i][j]);
            }
        }
    }
}

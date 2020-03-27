package ai.protect.privacy.network.layercomputer;

import ai.protect.privacy.network.layercomputer.parameters.Cov2dParameter;
import ai.protect.privacy.network.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维卷积层的计算器
 * @author CodeGang
 * @since jdk1.8
 */
public class Cov2dLayerComputer implements LayerComputer {

    /**
     * 卷积层所需的参数类
     */
    private Cov2dParameter parameter = new Cov2dParameter();

    public Cov2dLayerComputer() {
    }

    public Cov2dLayerComputer(Cov2dParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameter(List parameter) {
        this.parameter.fromList(parameter);
    }

    @Override
    public List compute(List input, List<Node> nodes) {
        //将输入数据从一维转换为二维多通道
        Object[][][] channels = CovUtils.changeTo2D(input,parameter.column,parameter.row,
                parameter.paddingRow,parameter.paddingColumn,parameter.inChannel);
        /*将二维多通道数据转换为一张大的二维数组，
        使得数据格式符合Implementing convolution as a matrix multiplication 的原理。
        data中的一个List表示一个块的所有通道数据.
        */
        List<List> data = new ArrayList<>();
        for (int bIndex = 0;bIndex<parameter.blockNumber;bIndex++){
            List block = new ArrayList();
            for (int chIndex =0;chIndex<parameter.inChannel;chIndex++){
                CovUtils.get2dBlock(channels[chIndex],block,(bIndex/parameter.blockColumnNum)*parameter.stride[0],
                        (bIndex%parameter.blockColumnNum)*parameter.stride[1],parameter.blockRow,parameter.blockColumn);
            }
            data.add(block);
        }

        //进行计算
        int biasIndex = 0;
        List result = new ArrayList();
        for (Object[] weight:parameter.weights){
            Object bias = parameter.bias[biasIndex];
            int outIndex = 0;
            for (List item:data){
                Node node = nodes.get(outIndex+parameter.blockNumber*biasIndex);
                node.compute(item,weight,bias);
                result.add(node.value);
                outIndex++;
            }
            biasIndex++;
        }

        return result;
    }

}

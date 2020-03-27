package ai.protect.privacy.network.layercomputer.parameters;


import java.util.ArrayList;
import java.util.List;

/**
 * 二维卷积层的参数类
 * @see ai.protect.privacy.network.layercomputer.Cov2dLayerComputer
 * @author CodeGang
 * @since jdk1.8
 */
public class Cov2dParameter implements Parameters {
    /**
     * 输入数据行的大小
     */
    public Integer row = 0;
    /**
     * 输入数据列的大小
     */
    public Integer column = 0;
    /**
     * 填充数据行大小的1/2
     */
    public Integer paddingRow = 0;
    /**
     * 填充数据行大小的1/2
     */
    public Integer paddingColumn = 0;
    /**
     * 块行的大小
     */
    public Integer blockRow =0;
    /**
     * 块列的大小
     */
    public Integer blockColumn = 0;
    /**
     * 权重矩阵，一行参数表示一个通道的所有权重参数
     */
    public Object [][] weights;
    /**
     * 输入的通道数目
     */
    public Integer inChannel=0;
    /**
     * 输出的通道数目
     */
    public Integer outChannel=0;
    /**
     * 步长设置，stride[0]为行方向的步长，stride[1]为列方向的步长
     */
    public Integer[] stride;
    /**
     * 该层的偏差数组
     */
    public Object[] bias;
    /**
     * 一列块的数目
     */
    public Integer blockColumnNum = 0;
    /**
     * 一行块的数目
     */
    public Integer blockRowNum = 0;
    /**
     * 输入数据可以划分的总块数
     */
    public Integer blockNumber = 0;


    @Override
    public Parameters fromList(List list) {
        row= (Integer) list.get(0);
        column= (Integer) list.get(1);
        paddingRow= (Integer) list.get(2);
        paddingColumn= (Integer) list.get(3);
        blockRow= (Integer) list.get(4);
        blockColumn= (Integer) list.get(5);
        weights= (Object[][]) list.get(6);
        inChannel = (Integer) list.get(7);
        outChannel = (Integer) list.get(8);
        stride= (Integer[]) list.get(9);
        bias= (Object[]) list.get(10);
        blockRowNum= (row+paddingRow*2-blockRow)/stride[0]+1;
        blockColumnNum=(column+paddingColumn*2-blockColumn)/stride[1]+1;
        blockNumber = blockColumnNum*blockRowNum;
        return this;
    }


    @Override
    public List toList() {
        List list = new ArrayList();
        list.add(row);
        list.add(column);
        list.add(paddingRow);
        list.add(paddingColumn);
        list.add(blockRow);
        list.add(blockColumn);
        list.add(weights);
        list.add(inChannel);
        list.add(outChannel);
        list.add(stride);
        list.add(bias);
        return list;
    }

    @Override
    public int nodeSize() {
        return outChannel*blockNumber;
    }


}

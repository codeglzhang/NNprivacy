package ai.protect.privacy.network.layercomputer.parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * 2d的池化参数类
 * @author CodeGang
 * @since jdk1.8
 */
public class PoolParameter implements Parameters {
    /**
     * 输入数据行的大小
     */
    public Integer row=0;
    /**
     * 输入数据列的大小
     */
    public Integer column=0;
    /**
     * 需要填充的行数目的1/2
     */
    public Integer paddingRow=0;
    /**
     * 需要填充的列数目的1/2
     */
    public Integer paddingColumn=0;
    /**
     * 块的行大小
     */
    public Integer blockRow=0;
    /**
     * 块的列大小
     */
    public Integer blockColumn=0;
    /**
     * 步长，stride[0]行方向的步长,stride[1]列方向的步长
     */
    public Integer[] stride;
    /**
     * 输入数据的通道数
     */
    public Integer channel=0;
    /**
     * 一行块的数目
     */
    public Integer blockRowNum = 0;
    /**
     * 一列块的数目
     */
    public Integer blockColumnNum = 0;
    /**
     * 一张单通道图像包含的块数
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
        stride= (Integer[]) list.get(6);
        channel= (Integer) list.get(7);
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
        list.add(stride);
        list.add(channel);
        return list;
    }

    @Override
    public int nodeSize() {
        return channel*blockNumber;
    }
}

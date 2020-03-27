package ai.protect.privacy.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *  神经网络实体，包含了许多的神经层 {@link Layer},通过add()方法添加网络层来构造网络，
 *  通过调用每一层的predict()方法来进行计算.
 *
 * @author CodeGang
 * @since jdk 1.8
 */
public class Network {
    /**
     * 网络层列表
     */
    public List<Layer> layers = new ArrayList<>();


    /**
     * 像网络添加一层神经层
     * @param layer 添加的神经层
     * @return 添加结果，成功返回True，失败返回False
     */
    public boolean add(Layer layer){
        layer.setSerialNumber(layers.size());
        return layers.add(layer);
    }
//    public boolean remove(Layer layercomputer){return layers.remove(layercomputer);}

    /**
     * 根据各层参数对数据进行计算
     * @param data 输入数据
     * @return 计算结果
     */
    public List predict(List data){
        Iterator<Layer> layerIter = layers.iterator();
        List tmpData = data;
        while (layerIter.hasNext()){
            Layer layer = layerIter.next();
            tmpData = layer.compute(tmpData);
        }
        return tmpData;
    }
}

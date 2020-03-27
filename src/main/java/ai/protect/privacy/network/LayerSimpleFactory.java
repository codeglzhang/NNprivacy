package ai.protect.privacy.network;

import ai.protect.privacy.network.layercomputer.*;
import ai.protect.privacy.network.layercomputer.parameters.Cov2dParameter;
import ai.protect.privacy.network.layercomputer.parameters.GeneralParameter;
import ai.protect.privacy.network.layercomputer.parameters.PoolParameter;
import ai.protect.privacy.network.node.Node;
import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


/**
 * 神经层的简单工厂类
 * @author CodeGang
 * @since jdk1.8
 */
public class LayerSimpleFactory {
    public LayerSimpleFactory() {
    }

    /**
     * 创建一个神经网络层
     * @param layertype 要创建的神经层的类别
     * @param paramsFile 神经层的参数文件地址
     * @param node 该层包含的节点
     * @return 创建的神经层
     */
    public Layer createLayer(LAYERTYPE layertype, String paramsFile, Node node){
        String json = null;
        Gson gson = new Gson();
        try {
            if(paramsFile!=null&&paramsFile.length()>0) {
                File params = new File(paramsFile);
                json = FileUtils.readFileToString(params);
            }
            Layer layer = new Layer();
            switch (layertype){
                case POOL:
                    PoolParameter poolParameter = gson.fromJson(json,PoolParameter.class);
                    layer.setComputer(new PoolLayerComputer(poolParameter));
                    for (int i =0;i<poolParameter.nodeSize();i++){
                        layer.add(node.clone());
                    }
                    break;
                case CONVOLUTION:
                    Cov2dParameter cov2dParameter = gson.fromJson(json,Cov2dParameter.class);
                    layer.setComputer(new Cov2dLayerComputer(cov2dParameter));
                    for(int i =0;i<cov2dParameter.nodeSize();i++){
                        layer.add(node.clone());
                    }
                    break;
                case DROPOUT:
                    layer.setComputer(new DropoutLayerComputer(node.options));
                    break;
                case GENERAL:
                default:
                    GeneralParameter generalParameter = gson.fromJson(json,GeneralParameter.class);
                    layer.setComputer(new GeneralLayerComputer(generalParameter));
                    for (int i =0 ;i<generalParameter.nodeSize();i++){
                        layer.add(node.clone());
                    }
                    break;
            }
            return layer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

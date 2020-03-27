package ai.protect.privacy.network.layercomputer;

import ai.protect.privacy.network.node.Node;
import ai.protect.privacy.network.node.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Dropout层计算器
 * @author CodeGang
 * @since jdk1.8
 */
public class DropoutLayerComputer implements LayerComputer{
    public Options options;
    public double prob=0.5;

    public DropoutLayerComputer() {
    }

    public DropoutLayerComputer(Options options) {
        this.options = options;
    }

    @Override
    public void setParameter(List parameter) {

    }

    @Override
    public List compute(List input, List<Node> nodes) {
        List result = new ArrayList();
        //遍历该层节点，随机丢弃值@todo p在引入加密算法后，是否需要跟着一起加密
        for(Object item : input){
            double p = Math.random();
            if(p<prob){
                p=1;
            }else {
                p=0;
            }
            result.add(options.multiply(p,item));
        }

        return result;
    }
}

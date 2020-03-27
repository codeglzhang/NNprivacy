package ai.protect.privacy.network;

/**
 * 神经网络层的类型，目前支持池化层、2d卷积层、全连接层，Dropout层
 * @author CodeGang
 * @since jdk1.8
 */

public enum LAYERTYPE {
    //池化层
    POOL,
    //卷积层
    CONVOLUTION,
    //全连接层，一般层
    GENERAL,
    DROPOUT
}

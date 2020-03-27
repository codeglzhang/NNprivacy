package ai.protect.privacy.network.layercomputer.parameters;

import java.util.List;

/**
 * 神经层的参数接口
 * @author CodeGang
 * @since jdk1.8
 */
public interface Parameters {
    /**
     * 通过列表设置参数
     * @param list 参数列表
     * @return 装配好的参数类
     */
    Parameters fromList(List list);
    List toList();

    /**
     * 获取该层所需的节点数目
     * @return 节点数
     */
    int nodeSize();
}

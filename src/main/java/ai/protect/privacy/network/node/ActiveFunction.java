package ai.protect.privacy.network.node;

/**
 * 激活函数接口
 * @see SimpleFunction
 * @see ReLu
 * @author CodeGang
 */
public interface ActiveFunction {
    Object compute(Object data, Options options);
}

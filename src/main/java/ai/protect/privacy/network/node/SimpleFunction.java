package ai.protect.privacy.network.node;

/**
 * 不做任何处理的激活函数
 * @author CodeGang
 * @since jdk1.8
 */
public class SimpleFunction implements ActiveFunction {
    @Override
    public Object compute(Object data, Options options) {
        return data;
    }
}

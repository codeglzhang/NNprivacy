package ai.protect.privacy.network.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Relu函数
 * @author CodeGang
 * @since jdk1.8
 */
public class ReLu implements ActiveFunction {
    @Override
    public Object compute(Object data, Options options) {
        List tmp = new ArrayList();
        tmp.add(data);
        tmp.add(0);
        return options.getMax(tmp);
    }
}

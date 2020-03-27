package ai.protect.privacy.network.node;

import java.math.BigInteger;
import java.util.List;

/**
 * 神经网络计算的操作接口，重点实现部分，
 * 密码学中定义的不同计算操作需通过继承此接口实现
 *
 * @see SimpleOptions
 * @author CodeGang
 */
public interface Options {
    Object add(final Object data1, final Object data2);
    Object multiply(final Object data1,final Object data2);
    Object getMax(List data);
    Object getAvg(List data);
}

package ai.protect.privacy.network.node;

import java.util.List;

/**
 * 正常的数据运算（+,-,*,max,avg）
 * @author CodeGang
 * @since jdk1.8
 */
public class SimpleOptions implements Options {
    @Override
    public Object add(Object data1, Object data2) {
        return (Double)data1+(Double)data2;
    }

    @Override
    public Object multiply(Object data1, Object data2) {
        return Double.valueOf(data1+"")*Double.valueOf(data2+"");
    }

    @Override
    public Object getMax(List data) {

        Double max = Double.valueOf(data.get(0)+"");
        for (Object tmp:data){
            if(max<Double.valueOf(tmp+"")) {
                max = Double.valueOf(tmp+"");
            }
        }
        return max;
    }

    @Override
    public Object getAvg(List data) {
        Double avg = 0d;
        for (Object tmp:data){
            avg+=Double.valueOf(tmp+"");
        }
        return avg;
    }
}

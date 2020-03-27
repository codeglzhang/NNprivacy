package ai.protect.privacy.network;


import ai.protect.privacy.network.layercomputer.parameters.PoolParameter;

import org.junit.Test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

    @Test
     public void changeToImages() {
        List list =new ArrayList();
        Integer[][] a =new Integer[1][1];
        List b = new ArrayList();
        b.add(a);
        a[0][0]=1;
        list.add(1);
        list.add(BigDecimal.ONE);
        list.add(false);
        list.add(b);

        List<Object[][]> c = (List<Object[][]>) list.get(3);
        Integer[][] d = (Integer[][]) c.get(0);

        PoolParameter parameter = new PoolParameter();
        parameter.stride=new Integer[2];


    }
}

package digui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author masun
 * @date 2021/12/3
 */
public class FeiBo {
    public static final Map<Integer, Long> FEI_BO = new HashMap<>(16);

    static {
        FEI_BO.put(0, 0L);
        FEI_BO.put(1, 1L);
    }

    public static Long fei(int n) {
        if (FEI_BO.containsKey(n)) {
            return FEI_BO.get(n);
        }
        Long l = fei(n - 1) + fei(n - 2);
        FEI_BO.put(n, l);
        return l;
    }

    public static Long fei2(int n) {
        if (FEI_BO.containsKey(n)) {
            return FEI_BO.get(n);
        }
        return fei2(n - 1) + fei2(n - 2);
    }


}

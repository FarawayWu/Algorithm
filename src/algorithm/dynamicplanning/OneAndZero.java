package algorithm.dynamicplanning;

import com.company.DataHelperInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class OneAndZero implements DataHelperInterface<String[]> {

    public int findMaxForm(String[] strs, int m, int n) {
        //sort
        if(strs.length == 0) {
            return 0;
        }
        if(m == 0 && n == 0) {
            return 0;
        }
        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j < i; j++) {
                if(strs[i].length() < strs[j].length()) {
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }
        int passNum = 0;
        for(int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            boolean pass = true;
            int lastM = m;
            int lastN= n;
            for(int j = 0; j < cur.length(); j++) {
                if(cur.charAt(j) == '0') {
                    if(m <= 0) {
                        pass = false;
                        break;
                    } else {
                        m--;
                    }
                } else {
                    if(n <= 0) {
                        pass = false;
                        break;
                    } else {
                        n--;
                    }
                }
            }
            if(pass) {
                passNum ++ ;
            } else {
                m = lastM;
                n = lastN;
            }
        }
        System.out.println(passNum);
        return passNum;
    }

    @Override
    public String[] prepareInput() {
        String [] strings = new String[] {"10","0001","111001","1","0"};
        return strings;
    }

    @Override
    public void startOutput() {
        findMaxForm(prepareInput(), 4, 3);

    }
}

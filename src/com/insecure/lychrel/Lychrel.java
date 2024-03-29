package com.insecure.lychrel;

import java.math.BigInteger;

/**
 * Created by Karan.Khosla on 1/5/14.
 */
public class Lychrel {

    public static int convergesAtIteration(int n, int limit) {
        return converge(BigInteger.valueOf(n), 0, limit);
    }

    public static int converge(BigInteger n, int iteration, int limit) {
        if(!isPalindrome(n) && iteration < limit)
            return converge(n.add(reverse(n)), iteration+1, limit);
        else
            return iteration;
    }

    public static BigInteger reverse(BigInteger n) {
        char nDigits[] = n.toString().toCharArray();
        char rDigits[] = new char[nDigits.length];
        int lastIndex = nDigits.length-1;

        for (int i=0; i<nDigits.length; i++)
            rDigits[i] = nDigits[lastIndex-i];

        return new BigInteger(new String(rDigits));
    }

    public static boolean isPalindrome(BigInteger n) {
        String digits = n.toString();
        int lastIndex = digits.length()-1;

        for (int i = 0; i < digits.length(); i++)
            if (digits.charAt(i) != digits.charAt(lastIndex-i))
                return false;
            return true;
    }
}
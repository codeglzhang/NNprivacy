package ai.protect.privacy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int times=20;
        for (int i = 1;i<=times;i++){
            outPut(100*i);
        }
    }
    public static void setUp(int modelSize){
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(512,random);
        BigInteger q = BigInteger.probablePrime(512,random);

        BigInteger n = p.multiply(q);

        BigInteger u = BigInteger.probablePrime(1024,random).mod(n);
        BigInteger g = BigInteger.probablePrime(1024,random).mod(n);

        BigInteger h = u.modPow(p,n);
        long begin = System.currentTimeMillis();
        BigInteger m =new BigInteger("125");
        for (int i =0;i<=modelSize;i++){
            BigInteger r =new BigInteger(1024,random);
            g.modPow(m,n).multiply(h.modPow(r,n)).mod(n);
        }
        long end = System.currentTimeMillis();
        System.out.println(modelSize+":"+(end-begin));
    }

    public static void client(int dataSize){
        List<Integer> data = new ArrayList<>(dataSize);
        Random random = new Random();

        for (int i=0;i<dataSize;i++){
            data.add(random.nextInt());
        }
        long begin = System.currentTimeMillis();
        BigInteger q = BigInteger.probablePrime(1024,random);
        BigInteger u = new BigInteger(1024,random).mod(q);
        BigInteger v = new BigInteger(1024,random).mod(q);
        BigInteger w = u.multiply(v).mod(q);
        BigInteger z = new BigInteger(1024,random).mod(q);

        BigInteger u1 = new BigInteger(512,random).mod(q);
        BigInteger v1 = new BigInteger(512,random).mod(q);
        BigInteger w1 =  new BigInteger(512,random).mod(q);
        BigInteger z1 = new BigInteger(512,random).mod(q);

        BigInteger u2 = u.subtract(u1);
        BigInteger v2 = v.subtract(v1);
        BigInteger w2 = w.subtract(w1);
        BigInteger z2 = z.subtract(z1);

        for (int a : data){
            int result = a-random.nextInt();
        }
        long end = System.currentTimeMillis();
        System.out.println(dataSize+":"+(end-begin));
    }
    public static void outPut(int dataSize){
        List<Integer> s0 = new ArrayList<>(dataSize);
        List<Integer> s1 = new ArrayList<>(dataSize);
        Random random = new Random();

        for (int i=0;i<dataSize;i++){
           s0.add(random.nextInt());
           s1.add(random.nextInt());
        }

        long begin = System.currentTimeMillis();
        for (int i =0;i<dataSize;i++){
            int a = s0.get(i)+s1.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(dataSize+":"+(end-begin));

    }
}

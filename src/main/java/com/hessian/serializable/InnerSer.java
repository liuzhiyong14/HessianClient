package com.hessian.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

/* Java序列化允许将一个对象状态写入Byte流里 */
/* 并且可以从其他地方把该Byte流的数据读出来 */
public class InnerSer {

    public static void main(String[] args) {
        try {
            /* 序列化 */
            A a = new A("A", "100");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(a);
            byte[] byteArray = os.toByteArray();
            System.out.println("序列化后的二进制：" + new BigInteger(1, byteArray).toString(2));
            //System.out.println("序列化后的十六进制：" + new BigInteger(1, byteArray).toString(16));

            /* 反序列化 */
            ByteArrayInputStream is = new ByteArrayInputStream(byteArray);
            ObjectInputStream ois = new ObjectInputStream(is);
            System.out.println("反序列化后的对象" + ois.readObject().getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package myspring;

import java.io.*;

/**
 * @author zhujiameng
 * @create 2018-08-08 14:31
 **/
public class Prototype implements Cloneable,Serializable {

    public Object clone() throws CloneNotSupportedException {
        return  (Prototype)super.clone();
    }


    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();

    }
}

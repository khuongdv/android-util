package com.songokute.androidutil.datautil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Admin on 4/18/2016.
 */
public class DataUtils {
    /**
     * Return a completely alike object. Only work with serializable objects
     *
     * @param input
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T deepClone(T input) throws Exception {
        T ret = null;
        if (isNullObject(ret)) {
            return ret;
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(input);
            oos.flush();
            oos.close();
            bos.close();
            byte[] byteData = bos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ret = (T) ois.readObject();
            bais.close();
            ois.close();
        } catch (Exception ex) {
            ret = null;
        }
        return ret;
    }

    /**
     * Check if object is null
     *
     * @param o
     * @return
     */
    public static boolean isNullObject(Object o) {
        return o == null;
    }


}

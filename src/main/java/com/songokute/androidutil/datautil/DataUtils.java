package com.songokute.androidutil.datautil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Admin on 4/18/2016.
 */
public class DataUtils {
    /**
     * Utils relate to String
     */
    public static class STRING {
        /**
         * trim string
         *
         * @param s
         * @return
         */
        public static String trim(String s) {
            if (OBJECT.isNullObject(s)) {
                return "";
            }
            return s.trim();
        }

        /**
         * Check if string is empty
         *
         * @return
         */
        public static boolean isStringEmpty(String s) {
            return trim(s).equals("");
        }
    }

    /**
     * Utils relate to Object
     */
    public static class OBJECT {
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

    /**
     * Util relate to List
     */
    public static class LIST {
        /**
         * Check if list is null or has no element
         * @param list
         * @return
         */
        public static boolean isNullOrEmpty(List list){
            return OBJECT.isNullObject(list) || list.isEmpty();
        }
    }


}

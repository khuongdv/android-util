package com.songokute.androidutil;

import com.songokute.androidutil.restutil.RESTUtils;

/**
 * Created by Admin on 4/18/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String url = "http://localhost:8910/api/cate/list";
//        System.out.println(RESTUtils.getJSONObject(url));
        System.out.println(RESTUtils.getJSONArray("http://dantri.com.vn"));
    }
}

package cn.dxxy.utils;

import java.util.UUID;

public class Util {

    //返回一个随机的UUID作为一个考试的唯一记录，
    public static String getUUID() {
        return UUID.randomUUID().toString().split("-")[0];
    }

}

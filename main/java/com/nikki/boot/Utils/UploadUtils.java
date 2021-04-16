package com.nikki.boot.Utils;


import java.io.File;

/**
 * 上传文件工具
 */
public class UploadUtils {
    public final static String IMG_PATH = "static/upload/images";
    public static File getImgDirFile(){
        String fileDirPath = new String("src/main/resources/" + IMG_PATH);
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        return fileDir;
    }
}

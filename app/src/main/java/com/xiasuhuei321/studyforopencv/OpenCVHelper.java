package com.xiasuhuei321.studyforopencv;

import android.graphics.Bitmap;

/**
 * Created by xiasuhuei321 on 2017/7/25.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class OpenCVHelper {
    static {
        // 在Android.mk文件中指定了lib的名字为OpenCV
        System.loadLibrary("OpenCV");
    }

    public Bitmap blur(Bitmap bitmap) {
        // 获取原始图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 初始化一个用来存储图片所有像素的int数组
        int[] pixels = new int[width * height];
        // 把原始图片的所有原始像素存入数组中
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        bitmap.recycle();
        // 通过jni本地方法毛玻璃化图片
        blurImage(pixels, width, height);
        // 创建一个新的图片
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        // 把处理后的图片像素设置给新图片
        newBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return newBitmap;
    }

    public Bitmap gray(Bitmap bitmap) {
        // 获取原始图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        bitmap.recycle();
        pixels = gray(pixels, width, height);
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        newBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return newBitmap;
    }

    public static native int[] gray(int[] buf, int w, int h);

    public static native void blurImage(int[] pixels, int w, int h);


}

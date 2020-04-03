package com.lgl.io.bufferedstream.copyfile;

import java.io.*;

/**
 * @author lgl
 * @Description: 线程接口
 * @date 2020/3/29 10:29 下午
 */
public class CopyFileImpl implements Runnable {
    private String methodName;
    private String fileName;

    public CopyFileImpl(String methodName, String fileName) {
        this.methodName = methodName;
        this.fileName = fileName;
    }

    /**
     * 使用普通流copy文件
     *
     * @param fileName
     */
    public void copy(String fileName) {
        long l1 = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream("copyAim1.txt")) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
            long l2 = System.currentTimeMillis();
            System.out.println("普通copy[" + fileName + "]: 耗时 :" + (l2 - l1) + "毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用缓冲流copy文件
     *
     * @param fileName
     */
    public void bufferedCopy(String fileName) {
        long l1 = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copyAim2.txt"));) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes);
            }
            long l2 = System.currentTimeMillis();
            System.out.println("缓冲copy[" + fileName + "]: 耗时 :" + (l2 - l1) + "毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (this.methodName.equals("copy") && (this.fileName != null && this.fileName != "")) {
            copy(this.fileName);
        } else if (this.methodName.equals("bufferedCopy") && (this.fileName != null && this.fileName != "")) {
            bufferedCopy(this.fileName);
        }
    }
}

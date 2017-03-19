package com.gipplelake.thinking_in_java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dengqg
 * 旧io可以使用FileOutputStream，FileInputStream，RandomAccessFile获取通道
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);//告知FileChannel向ByteBuffer中存储字节
        buff.flip();//必须调用缓冲器的flip，让它做好让别人读取字节的准备
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }

        FileChannel fc2 = new FileOutputStream("data2.txt").getChannel();
        while (fc.read(buff) != -1) {
            buff.flip();//准备从缓冲区读数据，写入通道中
            fc2.write(buff);
            buff.clear();//准备从通道中读数据，写入缓冲区中
        }


    }
}

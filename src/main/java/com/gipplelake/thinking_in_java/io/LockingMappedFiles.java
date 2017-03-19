package com.gipplelake.thinking_in_java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *内存映射通常应用于比较大的文件，我们可能需要对文件进行部分加锁，以便其他进程可以修改文件未被加锁的部分。
 * @author dengqg
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF;
    static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile("test.dat", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }
        new LockAndModify(out, 0,  LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.position(start);
            buff = mbb.slice();
            start();
        }

        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked" + start + "to" + end);
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.limit() - 1));
                fl.release();
                System.out.println("Released:" + start + "to " + end);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}

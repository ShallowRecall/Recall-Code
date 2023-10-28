package com.hspedu.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "src/textFiles/note.txt";
        //创建一个FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
//            3）write(int)：写入单个字符
            fileWriter.write('H');
//            4）write(char[])：写入指定数组
            fileWriter.write(chars);
//            5）writer(char[],off,len)：写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(),0,3);
//            6）writer(String)：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7）write(string,off,len)：写入字符串的指定部分
            fileWriter.write("上海天津",0,2);
            //在数据量大的情况下，可以使用循环操作

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //对于FileWriter，一定要关闭流，或者flush才能真正的把数据写入到文件
            /*
                看看代码
                private void writeBytes() throws IOException {
                bb.flip();
                int lim = bb.limit();
                int pos = bb.position();
                assert (pos <= lim);
                int rem = (pos <= lim ? lim - pos : 0);

                    if (rem > 0) {
                if (ch != null) {
                    if (ch.write(bb) != rem)
                        assert false : rem;
                } else {
                    out.write(bb.array(), bb.arrayOffset() + pos, rem);
                }
                }
                bb.clear();
                }

             */
            try {
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("程序结束...");


    }
}

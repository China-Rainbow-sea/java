package day26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝目录以及目录下的所有文件
 */
public class CopyAll {


    /**
     * 拷贝目录下的所有文件
     * @param srcFile
     * @param destFile
     */
    private static void copyDir(File srcFile, File destFile) {
        // 判断该拷贝对象是否是文件，
        if(srcFile.isFile()) {
            // srcFile如果是文件的话，将文件拷贝完，就返回了递归结束，因为文件都是最后的东西的
            // 是文件拷贝，一边读一边写
            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream(srcFile);

                String path = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() :
                        "\\" + srcFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(destFile);
                // 一边读，一边写
                byte[] bytes = new byte[1024*1024];  // 一次复制1mb
                int readCout = 0;

                while((readCout = in.read(bytes)) != -1) {
                    out.write(bytes,0,readCout);  // 读到多少返回多少
                }

                // 刷新
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return;
        }

        // 获取被拷贝的目录下面的子目录：该目录下的目录和文件
        File[] files = srcFile.listFiles();

        for (File file : files) {

            // 判断该文件是否在同一个目录下
            if(file.isDirectory()) {
                // D:/curse/02-javaSe/ 被拷贝的目录
                // C:/curse/02-javaSe/ 到的目录  两者之间的目录盘必须是一样的

                // 获取所有文件的(包括目录和文件)绝对路径
                String srcDir = file.getAbsolutePath();
                String destDir = file.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() :
                        "\\" + srcDir.substring(3);

                File newFile = new File(destDir);
                // 判断该 目录是否存在，不存在创建
                if(!newFile.exists()) {
                    newFile.mkdirs();  // 多重目录的创建
                }

            }
            // 递归调用
            copyDir(file,destFile);  // 将其中的文件/目录，拷贝到 destFile目录中
        }
    }
}

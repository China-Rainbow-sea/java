package day26;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * java.io.FileInputStream:
 *   1. 文件存储输入流，万能的，任何类型的文件都可以采用这个流来读。集合 + 反射 + 泛型
 *   2. 字节的方式，完成输入的操作，完成读的操作（硬盘---> 内存）
 *
 */
public class FileInputStreamTest {
    public static void main1(String[] args) {
        //1. 创建文件字节输入流对象 (将硬盘中的数据读取到内存当中)
        //文件路径: E:\Java\JavaRebuilt\src\day26(IDEA 会自动吧 "\"变成 "\\" 因为Java中的单个 \ 表示转义)
        // 两个表示 "\"
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:\\Java\\JavaRebuilt\\src\\day26\\temp");
            // 受用左斜杠"/"也是可以的 左斜杆不表示转义，所以一个就可以了。
            // fileInputStream = new FileInputStream(("E:/Java/JavaRebuilt/src/day26/temp"));

            // 开始读取数据:
            int readDate = fileInputStream.read();  // 这个方法的返回值是: 读取到"字节"本身
            System.out.println(readDate);  // 97

            readDate = fileInputStream.read();  // 这个方法的返回值是: 读取到"字节"本身
            System.out.println(readDate);  // 98

            readDate = fileInputStream.read();  // 这个方法的返回值是: 读取到"字节"本身
            System.out.println(readDate);  // 99

            readDate = fileInputStream.read();  // 这个方法的返回值是: 读取到"字节"本身
            System.out.println(readDate);  // 100

            // 当已经读到文件的末尾了，再读的时候读取不到任何数据。返回 -1；
            readDate = fileInputStream.read();  // 这个方法的返回值是: 读取到"字节"本身
            System.out.println(readDate);  // -1






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在finally 语句块当中确保流一定关闭。
            // 关闭的前提是: 流不是空的，流是 null的时候没有必要关闭(因为没有使用)
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 优化
     */
    public static void main2(String[] args) {
        // 创建字节流对象，调用构造器
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:/Java/JavaRebuilt/src/day26/temp");

            // 读取硬盘中的文件到内存当中
            while(true) {
                int readDate = fileInputStream.read();
                System.out.println(readDate);
                if(readDate == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main3(String[] args) {
        // 创建字节流对象，调用构造器
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:/Java/JavaRebuilt/src/day26/temp");

            // 读取硬盘中的文件到内存当中
            int readDate = 0;
           while ((readDate = fileInputStream.read()) != -1) {
               System.out.println(readDate);
           }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * int read(byte[] b)  一次最多读取 b.length 个字节
     * 减少硬盘和内存的交互，提高程序的执行效率
     * 将读取到的数据存储到 byte[] 数组当中
     * 并会覆盖前面的信息 abcd efcd
     * @param args
     */
    public static void main4(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 在main方法中：相对路径呢？相对路径一定是从当前所在位置作为起点开始找的
            // IDEA默认的当前路径是：当前工程Project的根就是IDEA的默认当前路径
            fileInputStream = new FileInputStream("src/day26/temp");

            // 开始读，采用 byte数组，一次读取多个字节，最多读取"数组.length" 个字节
            byte[] bytes = new byte[4];  // 准备一个4个长度的byte数组，一次最多读取 4 个字节
            int readDate = 0;

            // 这个方法返回值是：读取到字节的数量（不是字节本身）
            readDate = fileInputStream.read(bytes);
            System.out.println(readDate);   // 第一次读取到了 4 个字节
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));  // 将 byte[] 数组转换为 字符串 abcd


            readDate = fileInputStream.read(bytes);
            System.out.println(readDate);  // 第二次读取到了 2个字节
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));  // 将 byte[] 数组转换为 字符串  efcd


            // 当读取到文件末尾没有数据时，返回 -1；
            readDate = fileInputStream.read(bytes);
            System.out.println(readDate);  // -1
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));  // 将 byte[] 数组转换为 字符串 efcd

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


    public static void main5(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 在main方法中：相对路径呢？相对路径一定是从当前所在位置作为起点开始找的
            // IDEA默认的当前路径是：当前工程Project的根就是IDEA的默认当前路径
            fileInputStream = new FileInputStream("src/day26/temp");

            // 开始读，采用 byte数组，一次读取多个字节，最多读取"数组.length" 个字节
            byte[] bytes = new byte[4];  // 准备一个4个长度的byte数组，一次最多读取 4 个字节
            int readDate = 0;
            // read(byte[]) 返回读取到的的字节的个数，不是(字节本身)
            // 并将读取到的内容，存储到 byte[] 数组当中
            while ((readDate = fileInputStream.read(bytes)) != -1) {
                // 把 byte 数组转换成字符串，读到多少个转换多少个
                // new (bytes[] 数组,数组的起始位置,数组的结束位置(就是我们读取从文件中读取到的个数))
                String s = new String(bytes,0,readDate);
                System.out.print(s);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * fileInputStream.available();  判断文件中还有多少个字节没有读。
     * 可以判断文件中字节的个数，一开始的时候
     * @param args
     */
    public static void main6(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 在main方法中：相对路径呢？相对路径一定是从当前所在位置作为起点开始找的
            // IDEA默认的当前路径是：当前工程Project的根就是IDEA的默认当前路径
            fileInputStream = new FileInputStream("src/day26/temp");

            // 读取文件数据
            int readDate = 0;
            int num = 0;
            while((readDate = fileInputStream.read()) != -1) {  // 读取一个字符后
                System.out.println(readDate);
                num = fileInputStream.available();  // 判断还有多少个字节没有读取
                System.out.println(num);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 通过：fileInputStream.available();  方法创建 byte[] 数组的大小一次性读取到文件中的所有内容
     * 这样的方式：不适合太大的文件，因为 byte[] 数组不能存储太大，内存栈帧不足。
     * @param args
     */
    public static void main7(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/day26/temp");
            int available = fileInputStream.available();
            byte[] bytes = new byte[available];

            // 一次性将文件都存储到 bytes 文件当中
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    /**
     * 将内存中的数据写入到 文件当中
     * FileOutputStream
     * FileOutputStream.write(byte[]) 将内存中的byte[] 数据写入到文件当中。
     * 下面这种方式时：先将文件中清空，然后重新写入。
     * @param args
     */
    public static void main8(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            // 创建写入的对象
            fileOutputStream = new FileOutputStream("src/day26/temp");

            // 开始写
            byte[] bytes = {97, 98, 99, 100};
            // 将内存当中的内容写入到文件当中,如果文件不存在会自动创建该文件的，
            fileOutputStream.write(bytes);
            fileOutputStream.write(bytes,0,2); // 将bytes 数组中的部分内容写入到文件当中

            // 写完之后，最后刷新一定要刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 以追加的方式: 在文件末尾写入，不会清空原文件内容。
     */
    public static void main9(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            // 创建写入字节流对象，附加 true 表示: 在文件末尾写入，不会清空文件内容
            fileOutputStream = new FileOutputStream("src/day26/temp",true);

            byte[] bytes = new byte[] {100,101,102};
            // 将内存中的 bytes 内容写入到文件当中
            fileOutputStream.write(bytes);

            // 刷新内存通道:强制将内存当中没有写入到文件的数据，写入到文件当中
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 将String 中文转换成 byte[] 数组写入到文件当中
     * @param args
     */
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            // 创建写入字节流对象，附加 true 表示: 在文件末尾写入，不会清空文件内容
            fileOutputStream = new FileOutputStream("src/day26/temp",true);

            String str = "我是一个中国人，中国人,china";
            // 将内存中的 bytes 内容写入到文件当中
            byte[] bytes = str.getBytes();
            fileOutputStream.write(bytes);

            // 刷新内存通道:强制将内存当中没有写入到文件的数据，写入到文件当中
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件的拷贝，复制；
     */

}

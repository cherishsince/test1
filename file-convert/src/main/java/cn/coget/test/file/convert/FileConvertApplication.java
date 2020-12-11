package cn.coget.test.file.convert;

import java.io.File;
import java.io.IOException;

public class FileConvertApplication {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\" + System.currentTimeMillis() + "");
        file.createNewFile();

        file.renameTo(new File(file.getAbsolutePath() + "1.md"));
    }

    public class FileConvert {

        public void fileList(File file) {
        }
    }
}

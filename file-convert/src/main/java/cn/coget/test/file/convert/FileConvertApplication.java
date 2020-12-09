package cn.coget.test.file.convert;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileConvertApplication {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\" + System.currentTimeMillis() + ".md");
        FileUtils.writeLines(file, new ArrayList());
    }

    public class FileConvert {

        public void fileList(File file) {
        }
    }
}

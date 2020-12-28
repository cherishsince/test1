package cn.coget.test.file.convert.utils;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @author xiao.changwei
 */
public class CodeStatistics {
    private static final String rootPath = "E:\\projects\\onemall";
    //因包含过多第三方js库，js库不做统计
    private static final List<String> staticsFileSuffixes = Arrays.asList("java", "xml", "sql", "conf", "properties", "yaml", "yml", "html");
    private static final List<String> excludePath = Arrays.asList("deprecated", "node_modules");
    private static List<File> files = new LinkedList<>();
    private static int whiteLines = 0;
    private static int commentLines = 0;
    private static int normalLines = 0;

    public static void main(String[] args) {
        File rootDir = new File(rootPath);
        if (rootDir.exists()) {
            getFileRecursively(rootDir);
            if (files.size() > 0) {
                files.forEach(file -> Statistics(file));
                System.out.println("空行数：" + whiteLines);
                System.out.println("注释行数：" + commentLines);
                System.out.println("代码行数：" + normalLines);
                System.out.println("文件总数：" + files.size());
                System.out.println("========================");
                BigDecimal bigDecimal = new BigDecimal(commentLines).divide(new BigDecimal(commentLines + normalLines), 4, BigDecimal.ROUND_HALF_UP);
                NumberFormat percent = NumberFormat.getPercentInstance();
                percent.setMaximumFractionDigits(4);
                System.out.println("代码注释率：" + percent.format(bigDecimal.doubleValue()));
                //按类型分类
                Map<String, List<String>> collect = files.stream().collect(groupingBy(file -> getFileSuffix(file.getName()), mapping(File::getAbsolutePath, toList())));
            }
        }
    }

    private static void getFileRecursively(File file) {
        if (!shouldSkip(file) && file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                if (listFile.isDirectory()) {
                    getFileRecursively(listFile);
                } else {
                    if (!shouldSkip(file) && filterBySuffix(listFile)) {
                        files.add(listFile);
                    }
                }
            }
        } else {
            if (!shouldSkip(file) && filterBySuffix(file)) {
                files.add(file);
            }
        }

    }

    private static boolean shouldSkip(File file) {
        String absolutePath = file.getAbsolutePath();
        for (String exclude : excludePath) {
            if (absolutePath.contains(exclude)) {
                return true;
            }
        }
        return false;
    }

    private static boolean filterBySuffix(File file) {
        String[] split = file.getName().split("\\.");
        if (split.length >= 2) {
            String suffix = split[split.length - 1];
            if (staticsFileSuffixes.contains(suffix)) {
                return true;
            }
        }
        return false;
    }

    private static String getFileSuffix(String fileName) {
        String[] split = fileName.split("\\.");
        if (split.length >= 2) {
            return split[split.length - 1];
        }
        return "";
    }


    private static void Statistics(File file) {
        BufferedReader br = null;
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            try {
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.matches("^[\\s&&[^\\n]]*$")) {
                        whiteLines++;
                    } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                        commentLines++;
                        comment = true;
                    } else if (true == comment) {
                        commentLines++;
                        if (line.endsWith("*/")) {
                            comment = false;
                        }
                    } else if (line.startsWith("//")) {
                        commentLines++;
                    } else {
                        normalLines++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
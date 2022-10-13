package temp;


import java.io.File;
import java.io.IOException;

/**
 * @Auther: larson
 * @Since: 2020/08/26 18:02
 * @Description: 批量重命名文件
 */
public class bilibili {
    /**
     * 新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
     */
    static String newString = "";
    /**
     * 要被替换的字符串
     */
    static String oldString = "【生活情景英语系列】听力 对话能力暴增 涵盖日常交流、购物、职场面试、校园等场景英语 英文字幕 - ";
    /**
     * 文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径
     */
    static String root_dir = "C:\\Users\\邹东\\Desktop\\电脑版语音转文字8.24\\电脑版语音转文字8.24\\电脑版语音转文字.一梵设计\\软件\\音频转换结果";

    public static void main(String[] args) throws IOException {
        //递归遍历此路径下所有文件夹
        recursiveTraversalFolder(root_dir);
    }

    /**
     * 递归遍历文件夹获取文件
     */
    private static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("文件不存在! path=" + path);
            return;
        }

        File[] fileArr = folder.listFiles();
        if (null == fileArr || fileArr.length == 0) {
            System.out.println("文件夹是空的! fileArr=" + fileArr);
            return;
        }

        //文件所在文件夹路径+新文件名
        File newDir = null;
        //新文件名
        String newName = "";
        //旧文件名
        String fileName = null;
        //文件所在父级路径
        File parentPath = new File("");
        for (File file : fileArr) {
            //是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                recursiveTraversalFolder(file.getAbsolutePath());
                continue;
            }

            //是文件，判断是否需要重命名
            fileName = file.getName();
            parentPath = file.getParentFile();
            if (fileName.contains(oldString)) {
                //文件名包含需要被替换的字符串
                newName = fileName.replaceAll(oldString, newString);
                //文件所在文件夹路径+新文件名
                newDir = new File(parentPath + "/" + newName);
                //重命名
                file.renameTo(newDir);
                System.out.println("修改后：" + newDir);
            }
        }

    }
}




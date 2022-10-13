package temp;


import java.io.File;
import java.io.IOException;

/**
 * @Auther: larson
 * @Since: 2020/08/26 18:02
 * @Description: �����������ļ�
 */
public class bilibili {
    /**
     * ���ַ���,�����ȥ��ǰ׺��׺�����գ�����д����Ҫ�滻���ַ���
     */
    static String newString = "";
    /**
     * Ҫ���滻���ַ���
     */
    static String oldString = "�������龰Ӣ��ϵ�С����� �Ի��������� �����ճ����������ְ�����ԡ�У԰�ȳ���Ӣ�� Ӣ����Ļ - ";
    /**
     * �ļ�����·���������ļ��ĸ�Ŀ¼���ǵ��޸�Ϊ������ϵ��ļ�����·��
     */
    static String root_dir = "C:\\Users\\�޶�\\Desktop\\���԰�����ת����8.24\\���԰�����ת����8.24\\���԰�����ת����.һ�����\\���\\��Ƶת�����";

    public static void main(String[] args) throws IOException {
        //�ݹ������·���������ļ���
        recursiveTraversalFolder(root_dir);
    }

    /**
     * �ݹ�����ļ��л�ȡ�ļ�
     */
    private static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("�ļ�������! path=" + path);
            return;
        }

        File[] fileArr = folder.listFiles();
        if (null == fileArr || fileArr.length == 0) {
            System.out.println("�ļ����ǿյ�! fileArr=" + fileArr);
            return;
        }

        //�ļ������ļ���·��+���ļ���
        File newDir = null;
        //���ļ���
        String newName = "";
        //���ļ���
        String fileName = null;
        //�ļ����ڸ���·��
        File parentPath = new File("");
        for (File file : fileArr) {
            //���ļ��У������ݹ飬�����Ҫ�������ļ��У��������������
            if (file.isDirectory()) {
                System.out.println("�ļ���:" + file.getAbsolutePath() + "�������ݹ飡");
                recursiveTraversalFolder(file.getAbsolutePath());
                continue;
            }

            //���ļ����ж��Ƿ���Ҫ������
            fileName = file.getName();
            parentPath = file.getParentFile();
            if (fileName.contains(oldString)) {
                //�ļ���������Ҫ���滻���ַ���
                newName = fileName.replaceAll(oldString, newString);
                //�ļ������ļ���·��+���ļ���
                newDir = new File(parentPath + "/" + newName);
                //������
                file.renameTo(newDir);
                System.out.println("�޸ĺ�" + newDir);
            }
        }

    }
}




package framework.utilities;


import java.io.File;

public class FileUtil {

    public static void createDirectory(String filePath){
        File file = new File(filePath);
        file.mkdir();
    }

    public static void deleteFolderFiles(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) {
            for(File f: files) {
                f.delete();
            }
        }
    }

}

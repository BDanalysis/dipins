package com.xie.detection;

import java.io.File;

public class DeleteFile {
	public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("warn:file " + fileName + "is not exists");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }
    }
	
	public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                System.out.println("error:delete file " + fileName);
                return false;
            }
        } else {
            System.out.println("error:file" + fileName + "is not exists");
            return false;
        }
    }
	
	public static boolean deleteDirectory(String dir) {
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("error:delete dir" + dir );
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                flag = DeleteFile.deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            else if (files[i].isDirectory()) {
                flag = DeleteFile.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            return false;
        }
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

}

package com.koreait.board8;

import java.io.File;

public class MyFileUtils {
	public static void delFolder(String path) {
		File folder = new File(path);
		while(folder.exists()) {
			File[] fileList = folder.listFiles();
			if(fileList == null) {
				return;
			}
			for (int j = 0; j < fileList.length; j++) {
				File f = fileList[j];				
				if(f.isDirectory()) {
					delFolder(f.getPath());
				} else {
					f.delete();
				}
			}
			folder.delete();
		}
	}
}

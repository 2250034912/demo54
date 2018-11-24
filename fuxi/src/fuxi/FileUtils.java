package fuxi;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public class FileUtils {
	public static String find(String dir,String[] suffixs){
		File f = new File(dir);
		f.mkdirs();
		String []a1={"exe","txt"};
		String [] files = f.list(new FilenameFilter() {
			public boolean accept(File d ,String name ) {
				for(int i=0;i<a1.length;i++) {
					if(name.endsWith(a1[i])) {
						return true;
					}
				}
				return false;
			}
			
		});
		String b="";
		for(int i=0;i<files.length;i++) {
			//System.out.println(files[i]);
			suffixs[i]=files[i];
			 b = b+files[i];
		}
		return b;
	}
	public static void main(String[] args) {
		String a= "D:/java1/zhou";
		String [] b = new String[20];
		find(a,b);
		for(int i=0;i<b.length;i++) {
			if(b[i] != null) {
				System.out.println(b[i]);
			}
		}
	}

}

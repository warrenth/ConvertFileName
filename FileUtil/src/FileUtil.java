import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/*
 *  You can convert uppercase to lowercase
 *  Follow the steps below
 *  
 *  1. Make two folders named 'in' and 'out'
 *  2. You can write paths to code
 *  3. Run this program
 */

public class FileUtil {

	public static void main(String[] args) {
		String inFolder  = "C:\\word\\in";
		String outFolder = "C:\\word\\out";

		List<File> dirList = getDirFileList(inFolder);

		System.out.print(System.currentTimeMillis());
		for (int i=0; i<dirList.size(); i++)
		{

			String fileName = dirList.get(i).getName();
			System.out.println("before: " + fileName);
			
			// convert uppercase to lowercase 
			fileName = fileName.toLowerCase();
			System.out.println("aftger: " + fileName);

			// Copy files to "out" folder.
			fileCopy(inFolder+"\\"+fileName, outFolder+"\\"+fileName);
		}
	}

	/*
	 * copy files.
	 */
	private static void fileCopy(String inFileName, String outFileName) {
		try {
			
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			while((data=fis.read())!=-1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * read files in directory
	 */
	private static List<File> getDirFileList(String dirPath) {
		List<File> dirFileList = null;

		File dir = new File(dirPath);

		//check directory
		if (dir.exists())
		{
			// get file lists
			File[] files = dir.listFiles();

			// convert file arrays to file list 
			dirFileList = Arrays.asList(files);
		}

		return dirFileList;
	}

}

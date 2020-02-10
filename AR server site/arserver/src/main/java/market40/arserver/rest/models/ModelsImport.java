package market40.arserver.rest.models;
import java.io.File;
import java.io.FilenameFilter;

public class ModelsImport {

	/*
	 * public String path(String DIR) { return DIR; }
	 */


public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".txt"); }
        } );

    }



}

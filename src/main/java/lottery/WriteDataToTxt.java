package lottery;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author: chenwei
 * @date: 2021/7/22 23:33
 */
public class WriteDataToTxt {
    public static void writeStringDataToTxt(String data,String filePath){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
//            fileWriter.write("\n\t"+data);
            fileWriter.write("\n"+data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (filePath !=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

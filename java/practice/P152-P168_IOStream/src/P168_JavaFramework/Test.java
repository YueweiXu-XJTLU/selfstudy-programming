package P168_JavaFramework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        //common-io framework IO框架

        //第三方框架使用步骤：
        //1.官网下载框架
        //2.在项目中创建一个文件夹:lib
        //3.将.jar文件复制到lib文件夹
        //4.在jar文件上点右键，选择 Add as Library -> 点击OK
        //5.在类中导包使用

        FileUtils.copyFile(new File("P152-P168\\src\\P162_S1_BufferedStream\\picture.png"), new File("P152-P168\\src\\P168_JavaFramework\\Test.png"));

        //Java also have some advanced methods
//        Files.copy(Path.of("P152-P168\\src\\P162_S1_BufferedStream\\picture.png"), Path.of("P152-P168\\src\\P168_JavaFramework\\Test2.png"));
        //it won't over-write the existing file
    }
}

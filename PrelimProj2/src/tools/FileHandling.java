package tools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FileHandling {

    public boolean directoryExists(String directory){
        Path path = Paths.get(directory);
        return Files.exists(path);
    }

    public boolean createDirectory(String directory) throws Exception{
        Path path = Paths.get(directory);
        Files.createDirectory(path);
        return Files.exists(path);
    }
}

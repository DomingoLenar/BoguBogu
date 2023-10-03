package tools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FileHandling {

    /**
     * Checks if a directory exists at the specified path.
     *
     * @param directory The path to the directory to check.
     * @return True if the directory exists; otherwise, false.
     */
     
    public boolean directoryExists(String directory){
        Path path = Paths.get(directory);
        return Files.exists(path);
    }

    /**
     * Creates a new directory at the specified path.
     *
     * @param directory The path where the new directory should be created.
     * @return True if the directory was successfully created; otherwise, false.
     * @throws Exception If an error occurs during directory creation.
     */

    public boolean createDirectory(String directory) throws Exception{
        Path path = Paths.get(directory);
        Files.createDirectory(path);
        return Files.exists(path);
    }
}

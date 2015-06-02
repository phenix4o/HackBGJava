import java.io.File;
import java.io.IOException;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
 
 
 
public class LinkFinder { 
    public static void findDuplicateFiles(Path path) throws IOException {
        Collection<Set<Path>> files = getListOfDuplicateFiles(path);
        int totalSizeToBeDeleted;
         
    } 
     
    private static Collection<Set<Path>> getListOfDuplicateFiles(Path path)
            throws IOException {
        List<Path> allFiles = new ArrayList<Path>();
        getAllFiles(path, allFiles);
         
        Collection<Set<Path>> duplicatedFiles = new ArrayList<Set<Path>>();
        for (int i = 0; i < allFiles.size() - 1; i++) {
            for (int j = i + 1; j < allFiles.size(); j++) {
                Path file1 = allFiles.get(i);
                Path file2 = allFiles.get(j);
                 
                if (!areFilesEqual(file1, file2)) {
                    continue; 
                }  
                 
                addFilesToList(file1, file2, duplicatedFiles);
            } 
        } 
         
        return duplicatedFiles;
    } 
     
    private static void addFilesToList(Path file1, Path file2, Collection<Set<Path>> files) {
        boolean doesContain = false;
         
        for (Set<Path> fileSet : files) {
            if (fileSet.contains(file1)) {
                fileSet.add(file2);
                doesContain = true;
                break; 
            } 
        } 
         
        if (!doesContain){        
            Set<Path> setOfFiles = new HashSet<Path>(Arrays.asList(file1, file2));
            files.add(setOfFiles);
        } 
    } 
     
    private static void getAllFiles(Path path, List<Path> files) throws IOException {
                 
        if (Files.isSymbolicLink(path)) {
            path = Files.readSymbolicLink(path);
            if (!path.toFile().exists()) {
                return; 
            } 
        } 
         
        if(path.toFile().isFile()) {
            if (!Files.isRegularFile(path)) {
                return; 
            } 
             
            int size = Files.readAllBytes(path).length / 1024;
             
            if (size > 512) {
                return; 
            } 
             
            files.add(path);
        } 
         
        if (path.toFile().isDirectory()) {
            String[] children = path.toFile().list(); 
            for (String child : children) {
                getAllFiles((new File(child)).toPath(), files);
           }  
        }         
    } 
 
 
    private static boolean areFilesEqual(Path file1, Path file2) throws IOException {
        int hashCode1 = file1.hashCode();
        int hashCode2 = file2.hashCode();
         
        if (hashCode1 != hashCode2) {
            return false; 
        } 
         
        byte[] file1Bytes = Files.readAllBytes(file1);
        byte[] file2Bytes = Files.readAllBytes(file2);
         
        if (file1Bytes.length != file2Bytes.length) {
            return false; 
        } 
         
        return Arrays.equals(file1Bytes, file2Bytes);
    } 
} 
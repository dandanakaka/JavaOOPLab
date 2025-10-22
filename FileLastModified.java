import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileLastModified {
    public static void main(String[] args) {
        String filePath = "example.txt";
        
        File file = new File(filePath);
        
        if (file.exists()) {
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            System.out.println("File: " + file.getName());
            System.out.println("Last Modified: " + sdf.format(date));
        } else {
            System.out.println("File does not exist!");
        }
    }
}

class CreateDirectory {
    public static void main(String[] args) {
        String dirPath = "C:\\TestFolder\\MyNewDirectory";
        
        File directory = new File(dirPath);
        
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            
            if (created) {
                System.out.println("Directory created successfully!");
                System.out.println("Path: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory.");
                System.out.println("Check if you have write permissions.");
            }
        } else {
            System.out.println("Directory already exists at: " + directory.getAbsolutePath());
        }
    }
}

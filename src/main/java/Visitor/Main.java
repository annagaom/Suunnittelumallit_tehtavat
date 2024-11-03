package Visitor;

public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("document.txt", 10);
        File file2 = new File("image.jpg", 5);
        File file3 = new File("video.mp4", 20);
        File file4 = new File("notes.txt", 2);

        // Create directories and add files
        Directory dir1 = new Directory("Folder1");
        dir1.addElement(file1);
        dir1.addElement(file2);

        Directory dir2 = new Directory("Folder2");
        dir2.addElement(file3);
        dir2.addElement(file4);

        // Create a root directory and add other directories
        Directory rootDir = new Directory("Root");
        rootDir.addElement(dir1);
        rootDir.addElement(dir2);

        // Apply SizeCalculatorVisitor to calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        rootDir.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        // Apply SearchVisitor to find files with ".txt" extension
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        rootDir.accept(searchVisitor);
        System.out.println("Files with '.txt' extension:");
        for (File file : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}

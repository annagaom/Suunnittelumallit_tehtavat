package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String searchPattern;
    private final List<File> matchedFiles = new ArrayList<>();

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public List<File> getMatchedFiles() {
        return matchedFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No action needed for directories in the search, only files are accumulated
    }
}

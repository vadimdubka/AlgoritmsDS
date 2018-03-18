package wf;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*https://www.testdome.com/d/java-interview-questions/4 #8*/
public class Path {
    private       String        path;
    private final Deque<String> pathDeck;
    
    private final String separator = "/";
    private final String parentDir = "..";
    
    private String  move        = "(/|([a-zA-Z]+)|\\.\\.)";
    private Pattern movePattern = Pattern.compile(move);
    
    public Path(String path) {
        this.path = path;
        String[] arr = path.split("/");
        pathDeck = new ArrayDeque<>(Arrays.asList(arr));
        pathDeck.removeFirst();
    }
    
    public String getPath() {
        return path;
    }
    
    public void cd(String newPath) {
        if (separator.equals(newPath.substring(0, 1))) {
            path = newPath;
        } else {
            Matcher moveMatcher = movePattern.matcher(newPath);
            int end = 0;
            while (moveMatcher.find(end)) {
                int start = moveMatcher.start();
                end = moveMatcher.end();
                String moveStr = newPath.substring(start, end);
                makeMove(moveStr);
            }
            buildPath();
        }
    }
    
    private void buildPath() {
        StringBuilder pathBuilder = new StringBuilder(pathDeck.size() * 2);
        for (String s : pathDeck) {
            pathBuilder.append(separator);
            pathBuilder.append(s);
        }
        path = pathBuilder.toString();
    }
    
    private void makeMove(String moveStr) {
        if (moveStr.equals(parentDir)) {
            pathDeck.removeLast();
        } else if (!moveStr.equals(separator)) {
            pathDeck.addLast(moveStr);
        }
    }
    
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
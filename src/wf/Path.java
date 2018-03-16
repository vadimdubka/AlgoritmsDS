package wf;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {
    private String  path;
    private TreeSet folders;
    
    private static final String EMAIL_REGEX    =
        "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String PASSWORD_REGEX =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[\\w_-]{8,}$";
    
    private String folderNamePattern         = "\\w+";
    private String pathSeparatorPattern      = "\\/";
    private String moveToParentFolderPattern = "\\.\\.";
    
    //    private String move = "(/|\\w+|\\.\\.)";
    private String move = "(/|([a-zA-Z]+)|\\.\\.)";
    Pattern movePattern = Pattern.compile(move);
    
    public Path(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
    
    public void cd(String newPath) {
        Matcher moveMatcher = movePattern.matcher(newPath);
        int     start       = 0;
        int     end         = 0;
        while (moveMatcher.find(end)) {
            start = moveMatcher.start();
            end = moveMatcher.end();
            System.out.println(start + " " + end + " " + newPath.substring(start, end));
        }
    }
    
    private static boolean isMatchPattern(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
//        Path path = new Path("/a/b/c/d");
        Path path = new Path("/a/b/c/d/a/kb/c/d");
//        path.cd("../x");
        path.cd("/as../kb/c/d/a/b/c/d");
        System.out.println(path.getPath());
    }
}
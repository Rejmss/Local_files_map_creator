import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Path srcPath;
    private static ArrayList<String> paths = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь до исследуемой директории: ");
        srcPath = Paths.get(scanner.nextLine());

        filesScanner(srcPath);
        FileCreator creator = new FileCreator(paths);
        creator.createFile();

        System.out.println("Done! Maybe...");
    }

    private static void filesScanner(Path path) {
        File folder = new File(path.toString());

        try {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    String filePath = srcPath + "\\" + srcPath.relativize(file.toPath()).toString();
                    filePath = filePath.replace("D:\\JavaProjects\\Home tasks", "");
                    paths.add(filePath);
                    System.out.println(filePath);
                }else {
                    filesScanner(file.toPath());
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}

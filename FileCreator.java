import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class FileCreator {
    private ArrayList<String> linksList;

    public FileCreator(ArrayList<String> linksList) {
        this.linksList = linksList;
    }

    public void createFile(){
        mapWriter();
    }

    public void fileWriter(String text){
        try {
            FileOutputStream out = new FileOutputStream(new File("LocalSiteMap.txt"));
            out.write(text.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mapWriter(){
        Collections.sort(linksList);
        StringBuilder builder = new StringBuilder();
        builder.append("Записей в списке: ").append(linksList.size());
        for(String link : linksList){
            builder.append("\n").append(tabulator(link)).append(link);
        }
        System.out.println(builder.toString());
        fileWriter(builder.toString());
    }

    public String tabulator(String link){
        int counter = link.split("[\\\\]").length;
        return new String(new char[counter - 1]).replace("\0", "\t");
    }
}

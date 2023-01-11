package MainProgram;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ArrList_Data {

    private static ArrList_Data instance;
    private ArrayList<ArrayList<Object>> list;
    private int i;

    private ArrList_Data() {
        list = new ArrayList<>();
        i = 0;
    }

    public static ArrList_Data getInstance() {
        if (instance == null) {
            instance = new ArrList_Data();
        }
        return instance;
    }

    public ArrayList<ArrayList<Object>> getList() {
        return list;
    }
    
    public void addElement(String fileName, String filePath, ImageIcon icon) {
        list.add(new ArrayList<>());
        list.get(i).add(fileName);
        list.get(i).add(icon);
        list.get(i).add(filePath);
        i++;
    }
    
    public void resetList(){
        list.clear();
        i = 0;
    }
}

package MainProgram;

import java.util.ArrayList;

public class ArrList_Text {
    private static ArrList_Text instance;
    private ArrayList<ArrayList<String>> list;

    private ArrList_Text() {
        list = new ArrayList<>();
    }

    public static ArrList_Text getInstance() {
        if (instance == null) {
            instance = new ArrList_Text();
        }
        return instance;
    }

    public ArrayList<ArrayList<String>> getList() {
        return list;
    }
    
    public void addElement(ArrayList<String> listText) {
        list.add(listText);
    }
    
    public ArrayList<String> getElement(int index) {
        return list.get(index);
    }
    
    public void resetList(){
        list.clear();
    }
}

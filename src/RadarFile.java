import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ASUS on 14.07.2017.
 */
public class RadarFile{

    private String fileName;
    private File text;
    private Scanner scnr;
    private ArrayList<String> lines = new ArrayList<String>();

    public RadarFile(){

    }

    public RadarFile(String fileName) throws FileNotFoundException {
        this.fileName=fileName;
        text = new File(fileName);
        scnr = new Scanner(text);

        while(scnr.hasNextLine()){

            lines.add(scnr.nextLine());
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}

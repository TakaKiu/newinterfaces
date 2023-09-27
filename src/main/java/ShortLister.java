import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a Text File");


        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();


            List<String> shortWords = collectAll(selectedFile, new ShortWordFilter());


            System.out.println("Short Words:");
            for (String word : shortWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No file selected.");
        }
    }


    public static List<String> collectAll(File file, Filter filter) {
        List<String> acceptedWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (filter.accept(word)) {
                        acceptedWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acceptedWords;
    }
}
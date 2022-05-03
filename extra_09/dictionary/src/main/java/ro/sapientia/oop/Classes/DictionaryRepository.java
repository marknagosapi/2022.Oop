package ro.sapientia.oop.Classes;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@Repository
public class DictionaryRepository {

    private ArrayList<String> words = new ArrayList<>();

    public DictionaryRepository(){
        try{
            File file = ResourceUtils.getFile("src/main/resources/dic.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String w = scanner.next().trim();
                words.add(w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean findWord(String word){
        boolean result = false;
        String wod = word.toLowerCase(Locale.ROOT);
        for(int i=0;i<words.size();i++)
        {
            if(words.get(i).equals(word)){
                return true;
            }
        }

        return result;
    }
}

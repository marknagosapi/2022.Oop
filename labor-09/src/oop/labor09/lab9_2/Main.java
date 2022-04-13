package oop.labor09.lab9_2;

import oop.labor09.lab9_2.Classes.ArrayListDictionary;
import oop.labor09.lab9_2.Classes.DictionaryService;
import oop.labor09.lab9_2.Enum.DictionaryType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Word to find (Enter <end> for exit): ");
            String word = scanner.nextLine();
            if(word.equalsIgnoreCase("end")){
                break;
            }
            System.out.println(" Find("+ word + "): "+ service.findWord(word));
        }
        scanner.close();
    }
}

package oop.labor09.lab9_2.Classes;

import oop.labor09.lab9_2.Enum.DictionaryType;
import oop.labor09.lab9_2.Interface.IDictionary;

import java.util.ArrayList;

import static oop.labor09.lab9_2.Classes.DictionaryProvider.createDictionary;

public class DictionaryService {

    //Variables
    private IDictionary dictionary;

    //Constructor

    public DictionaryService(DictionaryType dtype){
        dictionary = createDictionary(dtype);
    }

    //Methods
    public boolean findWord(String a){
        return dictionary.find(a);
    }

    public ArrayList<String> findWordsFile(String a){
        return null;
    }
}

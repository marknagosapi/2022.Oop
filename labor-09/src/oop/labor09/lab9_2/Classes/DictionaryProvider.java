package oop.labor09.lab9_2.Classes;

import oop.labor09.lab9_2.Enum.DictionaryType;
import oop.labor09.lab9_2.Interface.IDictionary;

public class DictionaryProvider {

    //Methods

    public static IDictionary createDictionary(DictionaryType type){
            IDictionary dictionary = null;
            switch (type){
                case ARRAY_LIST -> {
                    dictionary = ArrayListDictionary.newInstance();
                    break;
                }
                    //case HASH_SET -> dictionary=HashSetDictionary.newInstance(); break;
                    //case TREE_SET -> dictionary=TreeSetDictionary.newInstance(); break;

            }
            return dictionary;
    }
}

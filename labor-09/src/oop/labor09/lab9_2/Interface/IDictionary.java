package oop.labor09.lab9_2.Interface;

public interface IDictionary {

    static final String DICTIONARY_FILE = "words.txt";

    boolean add(String string);
    boolean find(String string);
    int size();
}

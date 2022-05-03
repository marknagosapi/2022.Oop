package ro.sapientia.oop.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sapientia.oop.Interfaces.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository repository;

    @Override
    public boolean findWord(String word){
        return repository.findWord(word);
    }
}

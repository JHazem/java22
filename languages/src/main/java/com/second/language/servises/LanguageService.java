package com.second.language.servises;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.language.models.Language;
import com.second.language.repositories.LanguageRepository;

@Service
public class LanguageService {

	// p
	@Autowired
	private final LanguageRepository languageRepository;
	
	//4-1  p 
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
   //4-2   returns all the languages  p
	public List<Language> allLanguages() {

        return languageRepository.findAll();
	}

    //4-3 retrieves a language   p
    public Language findLanguage(Long id) {
    	
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } 
        else {
            return null;
        } 
    }
    
    //4-4    creates a language   p
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    
    //4-5  delete
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}

	//4-6
	public Language updateLanguage( Long    id,
									String  name,
									String  creator,
									String  version) {
		return null;
	}
	
	//4-7    update
	public void updateLanguage( Language language) {
		// TODO Auto-generated method stub
		languageRepository.save(language);
		
	}
	
}

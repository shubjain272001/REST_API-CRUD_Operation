package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.JournalClass;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repositories.journal_repositories;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalClassService {

    @Autowired
    public journal_repositories repo;

    @Autowired
    public UserEntryService user_entries;

    @Transactional
    public void saveEntry(JournalClass journalClass , String username){
        User user =user_entries.findByUsername(username);
        JournalClass saved =repo.save(journalClass);
        user.getJournal().add(saved);
        user_entries.saveEntry(user);
    }

    public void saveEntry_forput(JournalClass journalClass){JournalClass saved =repo.save(journalClass);}

    public List<JournalClass> get_entry(){
        return repo.findAll();
    }

    public Optional<JournalClass> getspecific_entry(ObjectId Id){
        return repo.findById(Id);
    }

    public void delete(ObjectId id , String username){
        User user =user_entries.findByUsername(username);
        user.getJournal().removeIf(x ->x.getId().equals(id));
        user_entries.saveEntry(user);
        repo.deleteById(id);
    }




}

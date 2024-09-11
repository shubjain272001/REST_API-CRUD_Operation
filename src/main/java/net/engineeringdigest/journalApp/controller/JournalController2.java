package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalClass;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.services.JournalClassService;
import net.engineeringdigest.journalApp.services.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Data")
public class JournalController2 {

@Autowired
public JournalClassService journal_entry;

@Autowired
public UserEntryService user_entries;

    @GetMapping("{username}")
    public ResponseEntity<List<JournalClass>> get(@PathVariable String username) {
        User user = user_entries.findByUsername(username);
        List<JournalClass> all_entries=user.getJournal();
        if(all_entries!=null&&!all_entries.isEmpty()){
            return new ResponseEntity<>(all_entries, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("{name}")
    public ResponseEntity<JournalClass> Post(@RequestBody JournalClass entry,@PathVariable String name){
         journal_entry.saveEntry(entry ,name);
         if(entry.getName()!=null){
             return new ResponseEntity<>(entry, HttpStatus.OK);
         }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/id/{MyId}")
    public ResponseEntity<?> specificID(@PathVariable ObjectId MyId){
        Optional<JournalClass> journalClass = journal_entry.getspecific_entry(MyId);
        if(journalClass. isPresent()){
            return new ResponseEntity<>(journalClass.get(),HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> putid(@PathVariable ObjectId id, @RequestBody JournalClass entry){
        JournalClass oldClass = journal_entry.getspecific_entry(id).orElse(null);
        if(oldClass!=null){
           oldClass.setName((entry.getName()!=null && entry.getName()!="") ? entry.getName() : oldClass.getName() );
           oldClass.setRollinfo((entry.getRollinfo()!=0)? entry.getRollinfo() : oldClass.getRollinfo());
            journal_entry.saveEntry_forput(oldClass);
            return new ResponseEntity<>(oldClass,HttpStatus.OK);
        }
       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("id/{username}/{id}")
    public ResponseEntity<?> deleteid(@PathVariable ObjectId id ,@PathVariable String username){

        journal_entry.delete(id, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}

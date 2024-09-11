
/*
package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.Entity.JournalClass;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// Without DB Just used Map as DB here and in journalontroller2 sed MongoDB


@RestController
@RequestMapping("/Data")
public class JournalController {
    Map<Long,JournalClass> entries =new HashMap<>();

    @GetMapping
    public ArrayList<JournalClass> get() {
        return new ArrayList<>(entries.values());

    }

    @PostMapping
    public boolean Post(@RequestBody JournalClass entry){
        entries.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{MyId}")
    public JournalClass specificID(@PathVariable long MyId){
        return entries.get(MyId);

    }

    @PutMapping("id/{id}")
    public JournalClass putid(@PathVariable long id, @RequestBody JournalClass entry){
        return entries.put(id,entry);
    }

    @DeleteMapping("id/{id}")
    public JournalClass deleteid(@PathVariable long id){
        return entries.remove(id);
    }


    }


*/
package net.engineeringdigest.journalApp.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document ( collection = "journalClass")
@Data //getter setter both in this @data of lombok .
@NoArgsConstructor //in data their is Required args constructor to accept both no_Args and required_args we added it
public class JournalClass {

    @Id
    private ObjectId id;
    private String name;
    private  int rollinfo;


}

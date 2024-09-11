package net.engineeringdigest.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

@Document (collection = "users")
@Data

public class User {

    @Id
    private ObjectId id;
    @Indexed(unique=true) //username is now unique and not null . (implementation of unique is done in application propertires)
    @NonNull
    private String username;
    @NonNull
    private int age;
    @NonNull
    private String password;
    @DBRef
    private List<JournalClass> journal =new ArrayList<>();
    private List<String>roles;
}

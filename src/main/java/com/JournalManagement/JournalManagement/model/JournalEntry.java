package com.JournalManagement.JournalManagement.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;
    private LocalDateTime date;
}

package com.duatson.studentapp.network;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDb {
    private static FirebaseDatabase database;

    public FirebaseDb() {
        database = FirebaseDatabase.getInstance();
    }

    public static DatabaseReference makeDbRef(String path) {
        return database.getReference(path);
    }

    public static DatabaseReference makeDbRef() {
        return database.getReference();
    }

}

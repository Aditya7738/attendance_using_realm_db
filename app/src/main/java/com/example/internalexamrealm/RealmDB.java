package com.example.internalexamrealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDB extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                        .allowQueriesOnUiThread(true)
                                .deleteRealmIfMigrationNeeded()
                                        .build();
        Realm.setDefaultConfiguration(configuration);

    }
}

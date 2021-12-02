package com.lymin.beentogetherpro.manager;

import com.lymin.beentogetherpro.model.LoveRealmObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoveManager {

    public void clearAll() {
        Realm realm = Realm.getInstance(config);
        realm.executeTransaction(realm1 -> realm1.deleteAll());
    }
    private final RealmConfiguration config;
    public LoveManager() {
        config = new RealmConfiguration.Builder().name("Love.realm").deleteRealmIfMigrationNeeded().schemaVersion(1).build();
        Realm.setDefaultConfiguration(config);
    }

    public void addData(LoveRealmObject item) {
        Realm realm = Realm.getInstance(config);
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(item));
        realm.close();
    }
}

package com.solvd.laba.hospital.dao.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbEventManager {

    private static DbEventManager instance;

    private static final Map<Type, List<DbEventListener>> LISTENERS = new HashMap<>();

    public enum Type {
        EMPLOYEE_SAVING, EMPLOYEE_GETTING, ROOM_SAVING
    }

    private DbEventManager() {
    }

    public void subscribe(Type type, DbEventListener listener) {
        List<DbEventListener> subscribers = LISTENERS.get(type);
        if (subscribers == null) {
            subscribers = new ArrayList<>();
            LISTENERS.put(type, subscribers);
        }
        subscribers.add(listener);
    }

    public void unsubscribe(Type type, DbEventListener listener) {
        List<DbEventListener> subscribers = LISTENERS.get(type);
        subscribers.remove(listener);
    }

    public void notify(Type type, String message) {
        List<DbEventListener> subscribers = LISTENERS.get(type);
        for (DbEventListener listener : subscribers) {
            listener.onEvent(message);
        }
    }

    public static DbEventManager createInstance(){
        if (instance == null) {
            instance = new DbEventManager();
        }
        return instance;
    }
}

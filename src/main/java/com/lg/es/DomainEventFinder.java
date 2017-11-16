package com.lg.es;

import com.lg.domain.events.NewGameRegistered;

public class DomainEventFinder implements FindDomainEvent {
    @Override
    public Class<? extends DomainEvent> findClass(String name) throws ClassNotFoundException {
        String eventClassName = String.format("%s.%s", NewGameRegistered.class.getPackage().getName(), name);
        return (Class<? extends DomainEvent>) Class.forName(eventClassName);
    }
}

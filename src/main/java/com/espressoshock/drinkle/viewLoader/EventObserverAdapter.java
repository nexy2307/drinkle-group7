package com.espressoshock.drinkle.viewLoader;

public class EventObserverAdapter implements IEventObserver {
    
    private IEventDispatcher eventDispatcher;

    public void setEventDispatcher(IEventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
        this.eventDispatcher.register(this);
    }

    @Override
    public void onViewChangeRequest(ViewMetadata view) {
    }
}

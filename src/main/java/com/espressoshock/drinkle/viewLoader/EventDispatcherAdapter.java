package com.espressoshock.drinkle.viewLoader;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcherAdapter implements IEventDispatcher{

    private List<IEventObserver> eventObservers;

    public EventDispatcherAdapter() {
        this.eventObservers = new ArrayList<>();
    }

    @Override
    public void register(IEventObserver eo) {
        this.eventObservers.add(eo);
    }

    @Override
    public void unregister(IEventObserver eo) {
        this.eventObservers.remove(eo);
    }

    @Override
    public void dispatchViewChangeRequest(ViewMetadata view) {
        for (IEventObserver eo : this.eventObservers)
            eo.onViewChangeRequest(view);
    }
}

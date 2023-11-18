package com.tranquyet.service;

import java.util.List;

public interface ActionService {
    boolean insertActions(List<Object> actions);

    List<Object> getActions();

    void truncate();
}

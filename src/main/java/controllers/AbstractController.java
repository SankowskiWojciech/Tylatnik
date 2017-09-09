package controllers;

import javafx.css.Styleable;

import java.util.List;

public abstract class AbstractController<T extends Styleable>{

    protected T getItem(List<T> list, String id) {
        for (T t : list)
            if (t.getId().equals(id))
                return t;
        return null;
    }
}

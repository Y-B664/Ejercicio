package co.edu.unilibre.operacionesBD;

import java.util.List;

public interface GenericDAO <T>{
    public boolean create(T objeto);
    public List<T> getTodos();
}

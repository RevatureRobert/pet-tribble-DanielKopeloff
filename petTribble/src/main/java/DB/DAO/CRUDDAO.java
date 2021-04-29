package DB.DAO;

import java.util.List;

public interface CRUDDAO <T> {

     T add(T t);

     T readbyID(int id);

     T readbyName(String name);

     List<T> readAll();

    int update(T t);
    int delete(T t);




}

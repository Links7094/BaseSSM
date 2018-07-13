package mapper;

public interface BaseMapper<T> {

    int insert(T t);

    void update(T t);

//    T get();
//
//    List<T> getList();
}

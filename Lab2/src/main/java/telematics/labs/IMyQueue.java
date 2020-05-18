package telematics.labs;

public interface IMyQueue<T> {

    int size();
    void insert(T obj);
    T remove();
}
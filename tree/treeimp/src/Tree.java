import java.util.Iterator;

/**
 * @author jgz
 * @Date 2019-12-25 19:56
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E>p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E>p) throws IllegalArgumentException;
    int numChilidren(Position<E>p)throws IllegalArgumentException;
    boolean isInternal(Position<E>p)throws IllegalArgumentException;
    boolean isExternal(Position<E>p)throws IllegalArgumentException;
    boolean isRoot(Position<E>p)throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}

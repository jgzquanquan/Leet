/**
 * @author jgz
 * @Date 2019-12-25 19:58
 */
public interface Position<E> {

    E getElement() throws IllegalStateException;
}

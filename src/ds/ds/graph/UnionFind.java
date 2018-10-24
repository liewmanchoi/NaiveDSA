package ds.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangsheng
 * @date 2018/10/24
 */
public final class UnionFind<T> {
    private static final class Link<T> {
        public T parent;
        public int rank = 0;

        Link(T parent) {
            this.parent = parent;
            rank++;
        }

        @Override
        public String toString() {
            return "{parent-> " + parent + " rank= " + rank + "}";
        }
    }

    private final Map<T, Link<T>> elems = new HashMap<>();

    public UnionFind() {

    }

    public UnionFind(Collection<? extends T> elems) {
        for (T elem : elems) {
            add(elem);
        }
    }

    public boolean add(T elem) {
        if (elem == null || elems.containsKey(elem)) {
            return false;
        }

        // 加入时，将自身作为父节点，秩增1
        elems.put(elem, new Link<>(elem));
        return true;
    }


    public T find(T elem) {
        if (!elems.containsKey(elem)) {
            return null;
        }
        // 返回元素对应的根节点
        return findAndCompress(elem);
    }

    private T findAndCompress(T elem) {
        T son = elem;
        for (T parent = elems.get(son).parent; !parent.equals(son); ) {
            son = parent;
            parent = elems.get(son).parent;
        }

        T root = son;
        for (T parent = elems.get(elem).parent; !parent.equals(elem); ) {
            elems.get(elem).parent = root;
            elem = parent;
            parent = elems.get(elem).parent;
        }

        return root;
    }

    public T union(T one, T two) {
        T root1 = find(one);
        T root2 = find(two);

        // 同一个对象，则不作改变
        if (Objects.equals(root1, root2)) {
            return root1;
        }

        Link<T> rootOneLink = elems.get(root1);
        Link<T> rootTwoLink = elems.get(root2);
        T root;

        // 将秩较少的并查集并入秩较大的并查集
        if (rootOneLink.rank >= rootTwoLink.rank) {
            rootTwoLink.parent = root1;
            rootOneLink.rank += rootTwoLink.rank;
            root = root1;
        } else {
            rootOneLink.parent = root2;
            rootTwoLink.rank += rootOneLink.rank;
            root = root2;
        }
        return root;
    }

    public boolean isConnected(T one, T two) {
        return Objects.equals(find(one),find(two));
    }

    @Override
    public String toString() {
        return elems.toString();
    }
}

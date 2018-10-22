package ds.graph;

import java.util.Objects;

/**
 * @author wangsheng
 * @date 2018/10/22
 */
public class Vertex<T> {
    /**
     * uniqueId: 顶点的标识符
     */
    private final T uniqueId;

    public Vertex(T uniqueId) {
        this.uniqueId = uniqueId;
    }

    public T getUniqueId() {
        return uniqueId;
    }

    @Override
    public String toString() {
        return "Vertex{" + uniqueId + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueId);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (!(otherObject instanceof Vertex)) {
            return false;
        }
        Vertex other = (Vertex)otherObject;
        return Objects.equals(uniqueId, other.uniqueId);
    }
}

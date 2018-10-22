package ds.graph;
import java.util.Objects;

/**
 * @author wangsheng
 * @date 2018/10/22
 */
public class Edge<T>  {
    private final Vertex<T> begin;
    private final Vertex<T> end;
    private double weight;

    /**
     * 创建带权重的边
     * @param begin: 边的起始结点
     * @param end：边的终止结点
     * @param weight：边的权重
     */
    public Edge(Vertex<T> begin, Vertex<T> end, double weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public Edge(T beginUniqueId, T endUniqueId, double weight) {
        this(new Vertex<>(beginUniqueId), new Vertex<>(endUniqueId), weight);
    }

    /**
     * 创建不带权重的边
     * @param begin: 边的起始结点
     * @param end：边的终止结点
     */
    public Edge(Vertex<T> begin, Vertex<T> end) {
        this(begin, end, 0);
    }

    public Edge(T beginUniqueId, T endUniqueId) {
        this(beginUniqueId, endUniqueId, 0);
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex<T> getBegin() {
        return begin;
    }
    public Vertex<T> getEnd() {
        return end;
    }

    public boolean containVertex(Vertex<T> vertex) {
        return begin.equals(vertex) || end.equals(vertex);
    }

    public boolean containVertex(T vertexUniqueId) {
        Vertex<T> vertex = new Vertex<>(vertexUniqueId);
        return begin.equals(vertex) || end.equals(vertex);
    }

    public Edge<T> reversed() {
        return new Edge<>(this.end, this.begin, weight);
    }

    @Override
    public String toString() {
        return "Edge<" + begin.getUniqueId() + "-" + end.getUniqueId() + ">";
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }

        if (!(otherObject instanceof Edge)) {
            return false;
        }

        Edge other = (Edge)otherObject;
        return Objects.equals(begin, other.begin) && Objects.equals(end, other.end);

    }
}

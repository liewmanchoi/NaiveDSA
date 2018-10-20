package ds.graph;

import java.util.Set;

/**
 * @author wangsheng
 */
public interface Graph <T>{
    /**
     * 向图添加顶点
     * @param vertex: 待添加的顶点
     * @return 是否添加成功
     */
    boolean addVertex(Vertex<T> vertex);

    /**
     * 删除图的某个顶点
     * @param vertex: 待删除的顶点
     * @return 是否删除成功
     */
    boolean removeVertex(Vertex<T> vertex);

    /**
     * 添加边
     * @param edge: 待添加的边
     * @return 是否添加成功
     */
    boolean addEdge(Edge<T> edge);

    /**
     * 删除边
     * @param edge: 待删除的边
     * @return 是否删除成功
     */
    boolean removeEdge(Edge<T> edge);

    /**
     * 返回所有顶点的HashSet
     * @return HashSet<Vertex<T>>
     */
    Set<Vertex<T>> vertexSet();

    /**
     * 返回所有边的HashSet
     * @return HashSet<Edge<T>>
     */
    Set<Edge<T>> edgeSet();

    /**
     * 返回图中顶点的个数
     * @return int
     */
    int size();

    /**
     * 判断图是否为空
     * @return boolean
     */
    default boolean isEmpty() {
        return size() == 0;
    }
}

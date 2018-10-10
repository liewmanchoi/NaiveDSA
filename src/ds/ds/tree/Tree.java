package ds.tree;

/**
 * @author wangsheng
 * @date 2018/10/9
 */
public interface Tree<E> {
    /**
     * 向树中插入节点
     * @param element 将要插入到树中的节点的值
     * @return 如果树结构发生了改变，返回{@code true}
     */
    boolean insert(E element);

    /**
     * 查询树中是否有节点值为element
     * @param element 待查询的值
     * @return 如果找到值为element的节点，返回{@code true}
     */
    boolean contains(E element);

    /**
     * 在树中删除节点
     * @param element 想要删除的节点
     * @return 如果树结构发生了改变，返回{@code true}
     */
    boolean remove(E element);
}

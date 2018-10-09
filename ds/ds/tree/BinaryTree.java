package ds.tree;

import java.util.Objects;

/**
 * @author wangsheng
 * @date 2018/10/9
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean insert(E nodeData) {
        Node<E> bestPosition = getFitNode(root, nodeData);
        // 如果树为空，则插入的节点为根节点
        if (Objects.isNull(bestPosition)) {
            root = new Node<>(nodeData);
            return true;
        }

        // 如果该节点已经存在于树中，则不作改变，返回false
        int result = bestPosition.data.compareTo(nodeData);
        if (result == 0) {
            return false;
        }

        // 否则，插入到最合适的位置
        Node<E> newNode = new Node<>(nodeData, null, null, bestPosition);
        if (result < 0) {
           bestPosition.right = newNode;
        } else {
            bestPosition.left = newNode;
        }
        return true;
    }

    @Override
    public boolean contains(E nodeData) {
        return !Objects.isNull(getNode(root, nodeData));
    }

    /**
     *
     * @param node 树或者子树的根节点
     * @param nodeData 需要查找的值
     * @return 与查找值相等的节点或者最佳插入位置
     */
    private Node<E> getFitNode(Node<E> node, E nodeData) {
        Node<E> preVisited = null;
        while(!Objects.isNull(node)) {
            preVisited = node;
            int result = node.data.compareTo(nodeData);
            if (result < 0) {
                node = node.right;
            } else if (result > 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return preVisited;
    }

    @Override
    public boolean remove(E nodeData) {
        return remove(root, nodeData);
    }

    private Node<E> getNode(Node<E> node, E nodeData) {
        Node<E> bestPosition = getFitNode(node, nodeData);
        if (!Objects.isNull(bestPosition) && bestPosition.data.compareTo(nodeData) == 0) {
            return bestPosition;
        }
        return null;
    }

    private boolean remove(Node<E> node, E nodeData) {
        Node<E> targetedNode = getNode(node, nodeData);
        // 如果树为空，或者未找到该节点
        if (Objects.isNull(targetedNode)) {
            return false;
        }

        Node<E> parent = targetedNode.parent;
        // 情形一：targetedNode没有孩子节点，直接删除
        if (Objects.isNull(targetedNode.left) && Objects.isNull(targetedNode.right)) {
            targetedNode.parent = null;
            targetedNode.data = null;
            if (parent.left == targetedNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (Objects.isNull(targetedNode.left)) {
        // 情形二：targetedNode只有一个右子节点
            targetedNode.parent = null;
            targetedNode.data = null;
            if (parent.left == targetedNode) {
                parent.left = targetedNode.right;
            } else {
                parent.right = targetedNode.right;
            }
        } else if (Objects.isNull(targetedNode.right)) {
            // 情形三： targetedNode只有一个左子节点
            targetedNode.parent = null;
            targetedNode.data = null;
            if (parent.left == targetedNode) {
                parent.left = targetedNode.left;
            } else {
                parent.right = targetedNode.left;
            }
        } else {
            // 情形四：targetedNode既有左子节点，又有右子节点。选择targetedNode的右子树中最小的元素来保持有序性

            Node<E> rightMinNode = findMin(targetedNode.right);
            // 两个节点交换值
            Objects.requireNonNull(rightMinNode);
            targetedNode.data = rightMinNode.data;
            // 递归删除已交换完值的节点
            remove(node, rightMinNode.data);
        }

        return true;
    }

    public E findMin() {
        Node<E> minNode = findMin(root);
        return minNode == null ? null : minNode.data;
    }

    private Node<E> findMin(Node<E> node) {
        if (Objects.isNull(node)) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public E findMax() {
        Node<E> maxNode = findMax(root);
        return maxNode == null ? null : maxNode.data;
    }

    private Node<E> findMax(Node<E> node) {
        if (Objects.isNull(node)) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public void inOrderTraversal() {
    }

    public void preOrderTraversal() {

    }

    public void postOrderTraversal() {

    }

    public void levelOrderTraversal() {

    }

    public int getHeight() {
        
    }

    private class Node<K> {
        Node(K data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        Node(K data, Node<K> left, Node<K> right, Node<K> parent) {
            this.data = data;
            this.left = left;
            this. right = right;
            this.parent = parent;
        }
        K data;
        Node<K> left;
        Node<K> right;
        Node<K> parent;
    }
}

package ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.function.Consumer;

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
            if (parent.left == targetedNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            targetedNode.parent = null;
            targetedNode.data = null;
        } else if (Objects.isNull(targetedNode.left)) {
        // 情形二：targetedNode只有一个右子节点
            if (parent.left == targetedNode) {
                parent.left = targetedNode.right;
            } else {
                parent.right = targetedNode.right;
            }
            targetedNode.parent = null;
            targetedNode.data = null;
        } else if (Objects.isNull(targetedNode.right)) {
            // 情形三： targetedNode只有一个左子节点
            if (parent.left == targetedNode) {
                parent.left = targetedNode.left;
            } else {
                parent.right = targetedNode.left;
            }
            targetedNode.parent = null;
            targetedNode.data = null;
        } else {
            // 情形四：targetedNode既有左子节点，又有右子节点。选择targetedNode的右子树中最小的元素来保持有序性

            Node<E> rightMinNode = findMin(targetedNode.right);
            // 两个节点交换值
            Objects.requireNonNull(rightMinNode);
            E tmp = targetedNode.data;
            targetedNode.data = rightMinNode.data;
            rightMinNode.data = tmp;
            // 递归删除已交换完值的节点
            remove(node.right, rightMinNode.data);
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

    public void preOrderTraversal(Consumer<E> action) {
        preOrderTraversal(root, action);

    }

    private void preOrderTraversal(Node<E> node, Consumer<E> action) {
        /* 前序遍历
        1. 访问当前节点
        2. 右子节点入栈，左子节点入栈
        3. 栈顶元素作为当前节点，弹出栈顶元素
        4. GOTO 1
        5. 循环终止条件：栈为空
         */
        if (Objects.isNull(node)) {
            return;
        }

        Deque<Node<E>> tube = new ArrayDeque<>();
        tube.push(node);

        while (!tube.isEmpty()) {
            node = tube.poll();
            action.accept(node.data);

            // 先让右子节点入栈
            if (!Objects.isNull(node.right)) {
                tube.push(node.right);
            }
            // 再让左子节点入栈
            if (!Objects.isNull(node.left)) {
                tube.push(node.left);
            }
        }
    }

    public void inOrderTraversal(Consumer<E> action) {
        inOrderTraversal(root, action);
    }

    private void inOrderTraversal(Node<E> node, Consumer<E> action) {
        if (Objects.isNull(node)) {
            return;
        }

        /* 中序遍历：
        1. 一路遍历到最左下端的节点，将它们全部压入栈中，直至全部遍历完毕
        2. 从栈中弹出节点，访问该节点。栈中弹出的节点的左子树已经遍历完毕，此时应该深入到右子树
        3. 深入右子树：将右子节点设置为当前节点，GOTO 1
        4. 循环终止条件：栈为空，且当前节点为null
        */
        Deque<Node<E>> tube = new ArrayDeque<>();
        Node<E> cur = node;
        while (!tube.isEmpty() || !Objects.isNull(cur)) {
            if (!Objects.isNull(cur)) {
                tube.push(cur);
                cur = cur.left;
            } else {
                cur = tube.poll();
                action.accept(cur.data);
                cur = cur.right;
            }
        }
    }

    public void postOrderTraversal(Consumer<E> action) {
        postOrderTraversal(root, action);
    }

    private void postOrderTraversal(Node<E> node, Consumer<E> action) {
        if (Objects.isNull(node)) {
            return;
        }

        /*
        后序遍历与中序遍历类似，但是情况略微复杂
        1. 一路遍历到最左下端的节点，将它们全部压入栈中，直至全部遍历完毕
        2. 将栈顶元素作为当前节点。显然，当前节点的左子树已经遍历完毕。此时条件允许，应当遍历右子树
        3. 如果当前节点满足下列条件之一，则访问该节点：
        (1) 当前节点没有右子节点（左子节点无需考虑，因为左子树已经遍历完毕）
        (2) 或者，当前节点的右子节点刚刚被访问
        3.1 访问满足条件的当前节点
        3.2 将lastVisited更新为当前节点
        3.3 从栈顶弹出元素
        3.4 当前节点设置为null，防止继续遍历左子树（此时无法确定下一个需要遍历的节点是谁）
        5. 如果当前节点不满足访问条件，则遍历右子树
        5.1 深入右子树，将当前节点更新为右子节点
        4. GOTO 1
        循环终止条件：栈为空且当前节点为null
         */
        Deque<Node<E>> tube = new ArrayDeque<>();
        Node<E> cur = node;
        Node<E> lastVisited = null;
        while (!tube.isEmpty() || !Objects.isNull(cur)) {
            if (!Objects.isNull(cur)) {
                tube.push(cur);
                cur = cur.left;
            } else {
                cur = tube.peek();
                if (Objects.isNull(cur.right) || lastVisited == cur.right) {
                    action.accept(cur.data);
                    lastVisited = cur;
                    tube.poll();
                    // 此处十分关键，否则会导致严重错误！
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }

        }
    }

    public void levelOrderTraversal(Consumer<E> action) {
        levelOrderTraversal(root, action);
    }

    private void levelOrderTraversal(Node<E> node, Consumer<E> action) {
        if (Objects.isNull(node)) {
            return;
        }
        /*
        层次遍历使用队列作为辅助结构
        1. 访问父节点
        2. 依次将左子节点和右子节点压入队列（如果有的话）
        3. 从队列中提取元素并访问
        4. GOTO 1
        循环终止条件：队列为空
         */
        Deque<Node<E>> tube = new ArrayDeque<>();
        tube.offer(node);
        while (!tube.isEmpty()) {
            Node<E> cur = tube.peek();
            if (!Objects.isNull(cur.left)) {
                tube.offer(cur.left);
            }
            if (!Objects.isNull(cur.right)) {
                tube.offer(cur.right);
            }
            action.accept(cur.data);
            tube.poll();
        }

    }

    public int getHeight() {
        return getHeight(root);

    }

    private int getHeight(Node<E> startNode) {
        if (Objects.isNull(startNode)) {
            return 0;
        }
        /*
        height = max(LeftHeight, RightHeight) + 1
        使用层次遍历的思路，层数即树高
        实现要点：确保队列的长度刚好等于该层的节点数量
         */

        Deque<Node<E>> tube = new ArrayDeque<>();
        tube.offer(startNode);
        int height = 0;

        while (!tube.isEmpty()) {
            ++height;
            int currentLevelSize = tube.size();
            for (int count = 1; count <= currentLevelSize; ++count) {
                Node<E> cur = tube.poll();
                if (!Objects.isNull(cur.left)) {
                    tube.offer(cur.left);
                }
                if (!Objects.isNull(cur.right)) {
                    tube.offer(cur.right);
                }
            }
        }
        return height;
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

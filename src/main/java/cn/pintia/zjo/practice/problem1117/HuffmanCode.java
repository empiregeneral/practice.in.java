package cn.pintia.zjo.practice.problem1117;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {

    private BinaryNode root;// root of huffman tree
    private int nodes;// number of total nodes in huffman tree

    /**
     *
     * @param nodes
     *            initial root of each tree
     * @return root of huffman tree
     */
    public BinaryNode buildHuffmanTree(List<BinaryNode> nodes) {
        if (nodes.size() == 1)// 只有一个结点
            return nodes.get(0);
        PriorityQueue<BinaryNode> pq = new PriorityQueue<BinaryNode>(nodes);//优先级队列保存所有叶子结点
        while (pq.size() != 1) {
            BinaryNode left = pq.remove();//频率最小的先出队列
            BinaryNode right = pq.remove();
            BinaryNode parent = new BinaryNode(
                    left.frequency + right.frequency, left, right, null);//构造父结点
            left.parent = parent;
            right.parent = parent;
            pq.add(parent);//新构造好的根结点插入到优先级队列中
        }
        return (root = pq.remove());
    }

    /**
     * 根据各个结点的权值构造 N 棵单根节点的树
     *
     * @param frequencies
     * @return
     */
    public List<BinaryNode> make_set(Integer[] frequencies) {
        List<BinaryNode> nodeList = new ArrayList<>(
                frequencies.length);
        for (Integer i : frequencies) {
            nodeList.add(new BinaryNode(i, null, null, null));
        }
        nodes = (frequencies.length << 1) - 1;// huffman 树中结点个数等于叶子结点个数乘以2减去1
        return nodeList;
    }

    /**
     *
     * @param root
     *            huffman树的根结点
     * @param nodeList
     *            huffman树中的所有叶子结点列表
     * @return
     */
    public int huffman_cost(List<BinaryNode> nodeList) {
        int cost = 0;
        int level;
        BinaryNode currentNode;
        if (nodes == 1) {
            return nodeList.get(0).frequency;
        }

        for (BinaryNode binaryNode : nodeList) {
            level = 0;
            currentNode = binaryNode;
            while (currentNode != root) {
                currentNode = currentNode.parent;
                level++;
            }
            cost += level * binaryNode.frequency;
        }
        return cost;
    }

    public String huffmanEncoding(List<BinaryNode> nodeList) {
        StringBuilder sb = new StringBuilder();
        BinaryNode currentNode;
        for (BinaryNode binaryNode : nodeList) {
            currentNode = binaryNode;
            while (currentNode != root) {
                if (currentNode.isLeftChild())
                    sb.append("0");// 左孩子编码为0
                else if (currentNode.isRightChild())
                    sb.append("1");// 右孩子编码为1
                currentNode = currentNode.parent;
            }
        }
        return sb.toString();
    }

    public Map<BinaryNode, String> huffmanDecoding(String encodeString) {
        BinaryNode currentNode = root;
        //存储每个叶子结点对应的二进制编码
        Map<BinaryNode, String> node_Code = new HashMap<BinaryNode, String>();
        StringBuilder sb = new StringBuilder();//临时保存每个结点的二进制编码
        for (int i = 0; i < encodeString.length(); i++) {

            char codeChar = encodeString.charAt(i);
            sb.append(codeChar);
            if (codeChar == '0')
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
            if (currentNode.left == null && currentNode.right == null)// 说明是叶子结点
            {
                node_Code.put(currentNode, sb.toString());
                sb.delete(0, sb.length());//清空当前结点,为存储下一个结点的二进制编码做准备
                currentNode = root;//下一个叶子结点的解码,又从根开始
            }
        }
        return node_Code;
    }

}


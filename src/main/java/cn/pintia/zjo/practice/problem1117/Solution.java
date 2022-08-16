package cn.pintia.zjo.practice.problem1117;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

public class Solution implements Readable {
    private int count = 1;

    private HuffmanCode huffmanCode = new HuffmanCode();
    private String inputText;

    private int originCodingCost;
    private int huffmanCodingCost;
    private double radio;

    public Solution(String inputText) {
        this.inputText = inputText;
        originCodingCost = unZipCodingCost(this.inputText);
        huffmanCodingCost = huffmanCodingCost(this.inputText);
        radio = Double.parseDouble("" + originCodingCost) / Double.parseDouble("" + huffmanCodingCost);

    }

    private int unZipCodingCost(String text) {
        return text.length() * 8;
    }

    private int huffmanCodingCost(String text) {
        Integer[] frequency = LetterFrequency.frequencyList(text);
        List<BinaryNode> nodeList = huffmanCode.make_set(frequency);
        huffmanCode.buildHuffmanTree(nodeList);
        int totalCost = huffmanCode.huffman_cost(nodeList);

        return totalCost;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("%d %d %.1f", new Object[]{originCodingCost, huffmanCodingCost, radio}));
        return 10;
    }
}

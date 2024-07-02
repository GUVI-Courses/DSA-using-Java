package guvidsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    // Comparator for the priority queue
    static class HuffmanComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.freq, node2.freq);
        }
    }

    // Generate Huffman codes from the Huffman tree
    private static void generateCodes(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        // If this is a leaf node, it contains a character
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, code);
        }

        generateCodes(root.left, code + '0', huffmanCode);
        generateCodes(root.right, code + '1', huffmanCode);
    }

    // Build the Huffman tree and generate Huffman codes
    public static Node buildHuffmanTree(String text, Map<Character, String> huffmanCode) {
        // Calculate frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Create a priority queue to store nodes of the Huffman tree
        PriorityQueue<Node> pq = new PriorityQueue<>(new HuffmanComparator());

        // Create a leaf node for each character and add it to the priority queue
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Iterate until the queue contains only one node
        while (pq.size() > 1) {
            // Remove the two nodes with the highest priority (lowest frequency)
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes' frequencies
            int sum = left.freq + right.freq;
            pq.add(new Node(sum, left, right));
        }

        // Root of the Huffman tree
        Node root = pq.poll();

        // Traverse the Huffman tree and store the Huffman codes in a map
        generateCodes(root, "", huffmanCode);

        return root;
    }

    // Encode the input text using the Huffman codes
    public static String encode(String text, Map<Character, String> huffmanCode) {
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCode.get(ch));
        }
        return encodedText.toString();
    }

    // Decode the encoded text using the Huffman tree
    public static String decode(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node current = root;
        for (int i = 0; i < encodedText.length(); i++) {
            current = (encodedText.charAt(i) == '0') ? current.left : current.right;

            // If this is a leaf node, append the character to the decoded text
            if (current.left == null && current.right == null) {
                decodedText.append(current.ch);
                current = root;
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        String text = "Huffman coding is a data compression algorithm.";

        // Build the Huffman tree and generate codes
        Map<Character, String> huffmanCode = new HashMap<>();
        Node root = buildHuffmanTree(text, huffmanCode);

        // Print the Huffman codes
        System.out.println("Huffman Codes: " + huffmanCode);

        // Encode the input text
        String encodedText = encode(text, huffmanCode);
        System.out.println("Encoded Text: " + encodedText);

        // Decode the encoded text
        String decodedText = decode(encodedText, root);
        System.out.println("Decoded Text: " + decodedText);
    }
}

class MyHashMap {
    static class Node{
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    final Node[] node = new Node[1000000];

    public void put(int key, int value) {
        int idx = key % node.length;
        if (node[idx] == null){
            node[idx] = new Node(key, value);
            return;
        }
        Node nodes = node[idx];
        while (nodes != null) {
            if (nodes.key == key) {
                nodes.val = value;
                return;
            }

            if (nodes.next == null)
                break;
            nodes = nodes.next;
        }
        nodes.next = new Node(key, value);
    }
    
    public int get(int key) {
        int idx = key % node.length;

        if (node[idx] == null)
            return -1;
        
        Node nodes = node[idx];
        while (nodes != null) {
            if (nodes.key == key)
                return nodes.val;
            if (nodes.next == null)
                break;
            nodes = nodes.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = key % node.length;

        if (node[idx] == null)
            return;
        Node nodes = node[idx];

        if (nodes.key == key) {
            if (nodes.next == null)
                node[idx] = null;
            else
                node[idx] = nodes.next;
        }

        Node prev = nodes;
        while (nodes != null) {
            if (nodes.key == key) {
                prev.next = nodes.next;
                return;
            }

            prev = nodes;
            nodes = nodes.next;

        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
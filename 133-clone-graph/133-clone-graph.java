/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> ref = new HashMap<>();
        travers(node, node1 -> 
            ref.computeIfAbsent(node1.val, Node::new));
        
        travers(node, node1 -> {
            Node clonedNode = ref.get(node1.val);
            for (Node neighbour : node1.neighbors) {
                clonedNode.neighbors.add(
                        ref.get(neighbour.val)
                );
            }
            
            return null;
        });
        
        return ref.get(node.val);
    }

    private void travers(Node start, Function<Node, ?> action) {
        Stack<Node> tracer = new Stack<>();
        tracer.push(start);

        Set<Node> visited = new HashSet<>();

        while (!tracer.empty()) {
            Node current = tracer.pop();
            if (visited.contains(current)) {
                continue;
            }
            action.apply(current);
            visited.add(current);

            for (Node neighbour : current.neighbors) {
                tracer.push(neighbour);
            }
        }
    }
    
}
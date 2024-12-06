package exampleasm;

import java.util.ArrayList;
import java.util.List;

// Node class for Tree
class TreeNode {
    int studentId;
    String studentName;
    double studentMarks;
    String studentRank;
    List<TreeNode> children;

    // Constructor to initialize the student node
    public TreeNode(int studentId, String studentName, double studentMarks, String studentRank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
        this.studentRank = studentRank;
        this.children = new ArrayList<>();
    }

    // Add a child node to the current node
    public void addChild(TreeNode child) {
        children.add(child);
    }

    // Display student information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Marks: " + studentMarks);
        System.out.println("Student Rank: " + studentRank);
    }
}

// Tree class to represent the Tree structure
class StudentTree {
    TreeNode root;

    // Insert a node into the tree
    public void insert(TreeNode parent, TreeNode child) {
        if (parent == null) {
            root = child;  // If the tree is empty, make the child the root
        } else {
            parent.addChild(child);  // Attach child to parent
        }
    }

    // Display all students (Level-order traversal)
    public void displayStudents(TreeNode node) {
        if (node != null) {
            node.displayStudent();
            for (TreeNode child : node.children) {
                displayStudents(child);  // Recursive traversal of children
            }
        }
    }

    // Search for a student by ID (Pre-order traversal)
    public TreeNode searchStudent(TreeNode node, int studentId) {
        if (node == null) return null;
        if (node.studentId == studentId) return node;
        for (TreeNode child : node.children) {
            TreeNode result = searchStudent(child, studentId);
            if (result != null) return result;
        }
        return null;
    }
}

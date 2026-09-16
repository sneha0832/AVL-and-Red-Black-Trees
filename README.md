# 🌳 AVL & Red-Black Trees — Java

A Java implementation of two self-balancing binary search trees: **AVL Trees** and **Red-Black Trees**.

This project explores how different balancing strategies maintain efficient search, insertion, and deletion operations in binary search trees. Both implementations build on a shared binary-tree/node structure and include tree rotations and rebalancing logic.

## ✨ Features

* Binary Search Tree foundation
* Complete **AVL Tree** implementation
* Complete **Red-Black Tree** implementation
* Insertion and deletion operations
* Automatic tree rebalancing
* Left and right rotations
* Height tracking for AVL trees
* Color-based balancing for Red-Black trees
* Test programs for validating tree operations
* Example datasets for testing

## 🧠 Data Structures

### AVL Tree

An AVL tree maintains a strict height-balance condition after insertions and deletions.

The implementation:

* Tracks the height of each node
* Calculates the balance factor
* Performs rotations when the tree becomes unbalanced
* Handles all four rotation cases:

  * Left-Left (LL)
  * Right-Right (RR)
  * Left-Right (LR)
  * Right-Left (RL)

The AVL implementation updates node heights after modifications and rebalances the tree recursively.

### Red-Black Tree

The Red-Black tree maintains balance using a color property assigned to each node.

The implementation handles:

* Node insertion
* Node deletion
* Recoloring
* Left rotations
* Right rotations
* Rebalancing after tree modifications

This allows the tree to maintain logarithmic height without requiring the strict height balancing used by AVL trees.

## 📊 Complexity

| Operation |   AVL Tree | Red-Black Tree |
| --------- | ---------: | -------------: |
| Search    | `O(log n)` |     `O(log n)` |
| Insertion | `O(log n)` |     `O(log n)` |
| Deletion  | `O(log n)` |     `O(log n)` |
| Space     |     `O(n)` |         `O(n)` |

Both structures maintain a balanced tree, providing efficient operations compared with an unbalanced binary search tree.

## 🔄 AVL Rotations

AVL trees use rotations to restore balance after insertions and deletions.

```text
        30                 20
       /  \               /  \
     20    40    →       10   30
    /
   10
```

**Right Rotation**

The implementation also supports the corresponding left, left-right, and right-left rotations depending on the imbalance.

## 🗂️ Project Structure

```text
AVL-and-Red-Black-Trees/
│
├── AVL.java
├── RedBlack.java
├── BinaryTree.java
├── BinNode.java
│
├── testing.java
├── binarytesting.java
│
├── SciFiLiBooks.txt
├── SciFiLiSorted.txt
│
└── .gitattributes
```

### Core Classes

**`BinaryTree.java`**
Provides the base binary-tree functionality used by the self-balancing tree implementations.

**`BinNode.java`**
Defines the node structure used by the trees.

**`AVL.java`**
Implements AVL insertion, deletion, height tracking, rotations, and rebalancing.

**`RedBlack.java`**
Implements Red-Black tree operations, including balancing through rotations and recoloring.

### Testing

`testing.java` and `binarytesting.java` are used to test the tree implementations.

The repository also includes sample text datasets containing book titles for testing the data structures.

## 🚀 Getting Started

### Prerequisites

* Java Development Kit (JDK 8+)
* Java compiler or an IDE such as IntelliJ IDEA, Eclipse, or VS Code

### 1. Clone the repository

```bash
git clone https://github.com/sneha0832/AVL-and-Red-Black-Trees.git
cd AVL-and-Red-Black-Trees
```

### 2. Compile the Java files

```bash
javac *.java
```

### 3. Run the tests

```bash
java testing
```

or:

```bash
java binarytesting
```

> The exact test entry point depends on which test class you want to run.

## 🎯 Learning Objectives

This project demonstrates practical understanding of:

* Binary Search Trees
* Self-balancing data structures
* AVL tree balancing
* Red-Black tree balancing
* Tree rotations
* Recursive algorithms
* Height and balance-factor calculations
* Object-oriented programming in Java
* Algorithmic time complexity

## ⚖️ AVL vs. Red-Black Trees

The two structures use different strategies to maintain balance.

**AVL Trees**

* More strictly balanced
* Track node heights
* Can provide faster lookups due to tighter balance
* May perform more rotations during updates

**Red-Black Trees**

* Use node colors and balancing rules
* Generally perform fewer rotations during updates
* Allow a looser balance compared with AVL trees
* Commonly used when frequent insertions and deletions are required

## 🛠️ Technologies

* **Java**
* Object-Oriented Programming
* Recursion
* Binary Search Trees
* AVL Trees
* Red-Black Trees
* Algorithm Analysis

## 👩‍💻 Author

**Sneha Patel**

[GitHub](https://github.com/sneha0832)

---

⭐ If you found this project useful, feel free to star the repository!

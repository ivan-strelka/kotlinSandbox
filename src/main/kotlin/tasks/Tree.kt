package tasks

import java.util.*

fun main(vararg args: String) {
    val root = Tree(
        20,
        Tree(7, Tree(4, right = Tree(6)), Tree(9)),
        Tree(35, Tree(31, left = Tree(28)), Tree(40, Tree(38), Tree(52)))
    )
}

class Tree(
    private val value: Int = 0,
    val left: Tree? = null,
    val right: Tree? = null,
    private val stack: Stack<Tree> = Stack<Tree>(),
    private val queue: LinkedList<Tree> = LinkedList<Tree>()
) {
    fun recursive(): Int {
        var summ = value
        if (left != null) summ += left.recursive()
        if (right != null) summ += right.recursive()
        return summ
    }

    fun deep(root: Tree): Int {
        stack.push(root)
        var total = 0

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            total += node.value

            println(node.value)

            if (node.right != null) stack.push(node.right)
            if (node.left != null) stack.push(node.left)
        }

        return total
    }

    fun wide(root: Tree) {

    }

}
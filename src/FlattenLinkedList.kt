
// https://www.geeksforgeeks.org/flattening-a-linked-list/
class FlattenLinkedList {
    
    fun flattenTheLinkedList() {
        
        val head: Node = getMockData()
        printList(head)

        var node = flatten(head)
        printList(node)
    }

    private fun flatten(node: Node?): Node? {
        var root = node
        if (root == null || root.right == null) {
            return root
        }

        root.right = flatten(root.right)
        root = mergeNodeList(root, root.right)

        return root
    }

    private fun mergeNodeList(first: FlattenLinkedList.Node?, second: FlattenLinkedList.Node?): FlattenLinkedList.Node? {
        if (first == null) {
            return second
        }
        if (second == null) {
            return first
        }

        var result:FlattenLinkedList.Node? = null

        if (first.data < second.data) {
            result = first
            result.down = mergeNodeList(first.down, second)
        }
        else {
            result = second
            result.down = mergeNodeList(second.down, first)
        }
        result.right = null
        return result
    }


    private fun getMockData(): Node {
        var head: Node? = null
        head = push(head, 30)
        head = push(head, 8)
        head = push(head, 7)
        head = push(head, 5)

        head.right = push(head.right, 20)
        head.right = push(head.right, 10)

        head.right?.right = push(head.right?.right, 50)
        head.right?.right = push(head.right?.right, 22)
        head.right?.right = push(head.right?.right, 19)


        head.right?.right?.right = push(head.right?.right?.right, 45)
        head.right?.right?.right = push(head.right?.right?.right, 40)
        head.right?.right?.right = push(head.right?.right?.right, 35)
        head.right?.right?.right = push(head.right?.right?.right, 28)

        return head
    }

     private fun push(headRef: Node?, data:Int): Node {
        var newNode: Node = Node(data, null, null)
        newNode.down = headRef
        return newNode

    }

    private fun printList(node: Node?) {
        var temp: Node? = node
        println("Printing:")
        while (temp != null) {
            print("${temp.data} -> ")
            temp = temp.down
        }
        println()
    }




    class Node(val data: Int, var right: Node?, var down: Node?)
    

}
import java.lang.Exception

fun main() {


    //deleteDuplicateValuesInLinkedList()

    //reverseDLL()
    
    //insertNode(21, 3)

    //deleteNode(3)
//    val flattenLinkedList = FlattenLinkedList()
//    flattenLinkedList.flattenTheLinkedList()
    val a = A()
    a.add()

    TestObject.add(2)

    TestCompanion.add(3)

}


class TestCompanion {


    companion object {
        fun add(num: Int) {
            println(num)
        }
    }
}

object TestObject {
    fun add(num: Int) {
        println(num)
    }
}



interface MYInterface {
    fun add()
}

open class B{
    open fun add() {
        println("CLass B")
    }

}

class A: B(), MYInterface {
//    override fun add() {
//        println("CLass A")
//    }
}


fun deleteNode(data: Int) {
    val head: DLLNode = getMockDLL()
    val printLinkedList = PrintLinkedList()
    println("Before Deletion: ")

    var current = head

    while (current.next != null) {

        if (current.next.data == data) {
             current.next.next
            val tempNode = current.next.next as DLLNode
            current.next = tempNode
            tempNode.previous = current
            break
        }
        current = current.next as DLLNode
    }

    println("After Deletion: ")
    printLinkedList.printList(head)

}

fun insertNode(data: Int, position: Int) {
    var head: DLLNode = getMockDLL()
    var current = head
    var count = 0

    val printLinkedList = PrintLinkedList()
    println("Before Insertion: ")
    printLinkedList.printList(head)


    while (current.next != null) {
        count++
        if (count == position) {
            val newNode = DLLNode(data)
            newNode.next = current.next
            current.next = newNode
            newNode.previous = current
            break
        }
        current = current.next as DLLNode
    }

    println("After Insertion: ")
    printLinkedList.printList(head)

}

fun reverseDLL() {
    //1 -> 2 -> 3 -> 4

    var head: DLLNode = getMockDLL()
    val printLinkedList = PrintLinkedList()
    printLinkedList.printList(head)


    var temp: DLLNode? = null
    var current: DLLNode? = head

    while (current != null) {
        temp = current.previous
        current.previous = current.next as DLLNode?
        current.next = temp as DLLNode?
        current = current.previous
    }

    if (temp != null) {
        head = temp.previous;
    }

    println("Reversed the DLL")
    printLinkedList.printList(head)
    



}



fun deleteDuplicateValuesInLinkedList() {

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(3)
    val node5 = Node(3)
    val node6 = Node(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val printLinkedList = PrintLinkedList()
    printLinkedList.printList(node1)

    var current = node1

    while (current.next != null) {
        if (current.data == current.next.data) {
            current.next = current.next.next
        }
        else {
            current = current.next
        }
    }
    println("Deleted Duplicate nodes:")
    printLinkedList.printList(node1)

}



private fun getMockDLL(): DLLNode {

    var node1 = DLLNode(1)
    var node2 = DLLNode(2)
    var node3 = DLLNode(3)
    var node4 = DLLNode(4)
    var node5 = DLLNode(5)

    node1.next = node2
    node2.next = node3
    node2.previous = node1
    node3.next = node4
    node3.previous = node2
    node4.next = node5
    node4.previous = node3
    node5.previous = node4
    return node1
}


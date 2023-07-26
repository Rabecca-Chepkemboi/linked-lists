import kotlin.math.ceil

fun main(){
    var head = createLinkedList()

    var cycle = detectCycleBeginning(head)
    println(cycle?.name)

    var cyc = floydsCycle(head)
    println(cyc.name)

//    var end = findKthElementFromEnd(2, head)
//    println(end.name)


//    var mid = findMiddle(head)
//    println(mid.name)


//    var middle = findMidleNode(head)
//    println(middle.name)

//    traversalList(head)


//    var insert = Node("Regina")
//    insertAtPosition(5, insert, head)
//    traversalList(head)


//    var insert = Node("Regina")
//    insertAfterNode("Cathy", insert, head)
//    traversalList(head)


//    var heading = createLinkedList()
//    var newNode = Node("Regina")
//    head = insertAtHead(newNode, head)
//
//
//    traversalList(head)
}

class Node(var name: String){
    var next: Node? = null
}

fun createLinkedList(): Node{
    var node1 = Node("Rabecca")
    var node2 = Node("Lekishon")
    var node3 = Node("Mercy")
    var node4 = Node("Victoria")
    var node5 = Node("Cathy")
    var node6 = Node("Marissa")
    var node7 = Node("Cynthia")
    var node8 = Node("Leila")
    var node9 = Node("Jemaimah")

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node3
    node8.next = node9

    return node1

}

fun traversalList(head: Node){
    var  current: Node? = head
    while (current != null){
        println(current.name)
        current = current.next
    }
}


fun insertAtPosition(pos: Int, nodeToInsert: Node, head:Node){
    var currpos = 1
    var current: Node? = head
    while (currpos<pos - 1){
        current = current?.next
        currpos ++
    }
    nodeToInsert?.next = current?.next
    current?.next = nodeToInsert
}


fun insertAfterNode(name: String, nodeToInsert: Node, head: Node){
    var curr:Node? = head
    while (curr?.name != name){
        curr = curr?.next
    }
    nodeToInsert.next = curr.next
    curr.next = nodeToInsert
}

fun insertAtHead(nodeToInsert: Node, head: Node): Node{
    nodeToInsert.next = head
    return nodeToInsert
}


fun findMidleNode(head: Node): Node{
    var counter = 1
    var curr: Node? = head

    while (curr != null){
        counter ++
        curr = curr.next
    }
    var mid = ceil(counter/2.0).toInt()
    counter = 1
    curr = head
    while (counter<mid){
        curr = curr?.next
        counter ++
    }
    return curr !!
}


fun findMiddle(head: Node): Node{
    var fast: Node? = head
    var slow: Node? = head

    while (fast?.next != null){
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow !!
}


fun findKthElementFromEnd(k : Int, head: Node): Node{
    var fast: Node? = head
    var slow: Node? = head

    var counter = 1
    while (counter<k){
        fast = fast?.next
        counter ++
    }
    while (fast?.next != null){
        fast = fast.next
        slow = slow?.next
    }
    return slow !!
}


fun detectCycleBeginning(head: Node): Node?{
    var visited = mutableSetOf<Node>()
    var curr: Node? = head
    while (curr?.next != null){
        if (visited.contains(curr)){
            return curr
        }
        else{
            visited.add(curr)
            curr = curr.next
        }
    }
    return null
}


fun floydsCycle(head: Node): Node{
    var fast: Node? = head
    var slow: Node? = head

    while (fast?.next != null){
        fast = fast?.next?.next
        slow = slow?.next
        if (fast ==  slow){
            break
        }
    }
    slow = head
    while (fast?.next != null) {
        fast = fast.next
        slow = slow?.next
        if (fast == slow) {
            break
        }
    }
    return slow !!
}









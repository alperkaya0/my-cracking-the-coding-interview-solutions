from random import randint

class LinkedListNode:

    def __init__(self, value, nextNode=None, prevNode=None):
        self.value = value
        self.next = nextNode
        self.prev = prevNode

    def __str__(self):
        return str(self.value)

class LinkedList:

    def __init__(self, values=None):
        self.head = None
        self.tail = None
        if values is not None:
            self.add_multiple(values)

    def __iter__(self):
        current = self.head
        while current:
            yield current
            current = current.next

    def __str__(self):
        values = [str(x) for x in self]
        return ' -> '.join(values)

    def __len__(self):
        result = 0
        node = self.head
        while node:
            result += 1
            node = node.next
        return result

    def add(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value)
        else:
            self.tail.next = LinkedListNode(value)
            self.tail = self.tail.next
        return self.tail

    def add_to_beginning(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value)
        else:
            self.head = LinkedListNode(value, self.head)
        return self.head

    def add_multiple(self, values):
        for v in values:
            self.add(v)

    def generate(self, n, min_value, max_value):
        self.head = self.tail = None
        for i in range(n):
            self.add(randint(min_value, max_value))
        return self

class DoublyLinkedList(LinkedList):

    def add(self, value):
        if self.head is None:
            self.tail = self.head = LinkedListNode(value, None, self.tail)
        else:
            self.tail.next = LinkedListNode(value)
            self.tail = self.tail.next
        return self

#with runner method
def return_kth_to_last(ll, k):
    if k == 0:
        print("Result: " + ll.tail.value)
        return ll.tail.value

    p = ll.head
    pp = ll.head#primer pointer
    for _ in range(k-1):
        p = p.next
    while(p is not None and p.next is not None):
        p = p.next
        pp = pp.next
    res = pp.value
    print("Result: " + str(res))
    return res
#recursive solution of the book
def printKthToLast(head, k):
    if (head is None):
        return 0
    index = printKthToLast(head.next, k) + 1
    if (index == k):
        print(str(k) + "th to last node is "+ head.value)
    return index


ll = LinkedList()
ll.add("1")
ll.add("2")
ll.add("3")
ll.add("4")
ll.add("5")
return_kth_to_last(ll, 2)
printKthToLast(ll.head, 2)
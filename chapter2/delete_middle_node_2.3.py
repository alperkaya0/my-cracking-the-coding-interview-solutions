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

def delete_middle_node(ll, n):
    next = n.next
    n.value = next.value
    n.next = next.next

    for i in ll:
        print(i, end=" > ")
    print("null", end="")
#end of the function

""""""""""""""""""""""""""""""""""""""""""""""""""

ll = LinkedList()
ll.add("1")
ll.add("2")
ll.add("3")
ll.add("4")
ll.add("5")
ll.add("6")
ll.add("7")
ll.add("8")
ll.add("9")
ll.add("10")
ll.add("11")
ll.add("12")
ll.add("13")
ll.add("14")
ll.add("15")
ll.add("16")
ll.add("17")
ll.add("18")
ll.add("19")
ll.add("20")
ll.add("21")
ll.add("22")
ll.add("23")
ll.add("24")
ll.add("25")
ll.add("26")
ll.add("27")
ll.add("28")
ll.add("29")
ll.add("30")
ll.add("31")

delete_middle_node(ll, ll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next)
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class LinkedList:
    def __init__(self):
        # LAST는 None값으로 항상 마지막이며 제거되지 않는다.
        self.LAST = Node(None)

        self.current = self.LAST
        self.last = self.LAST
        self.head = self.LAST
        self.size = 0

    def move_next(self):
        if self.current is None:
            print("리스트에 값이 없습니다")
            return
        self.current = self.current.next

    def move_prev(self):
        if self.current is None:
            print("리스트에 값이 없습니다.")
            return
        self.current = self.current.prev

    def get(self):
        if self.current is None:
            print("리스트에 값이 없습니다")
        return self.current.data

    def modify(self, value):
        if self.current is None:
            print("리스트에 값이 없습니다")
        self.current.data = value

    def add(self, value, which="f"):
        add_node = Node(value)
        current_node = self.current
        if which == "f":
            add_node.prev = current_node.prev
            add_node.next = current_node

            if current_node is not self.head:
                current_node.prev.next = add_node
            else:
                self.head = add_node

            current_node.prev = add_node
        elif which == "b":
            if current_node is self.LAST:
                return
            
            add_node.prev = current_node
            add_node.next = current_node.next
            if current_node.next is not None:
                current_node.next.prev = add_node
            else:
                add_node.next = self.LAST                
        
        self.current = add_node       
        self.size += 1     
        
    def delete(self):
        current_node = self.current
        if current_node is self.LAST:
            return
        
        if current_node is self.head:
            self.head = current_node.next
        else:
            current_node.prev.next = current_node.next
        current_node.next.prev = current_node.prev
        self.current = current_node.next       
        self.size -= 1

    def move_front(self):
        self.current = self.head

    def move_behind(self):
        self.current = self.LAST
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    ll = LinkedList()
    for i in range(n):
        how, idx = map(int, input().split())

        if how == 1:
            ll.move_front()
            ll.add(idx, 'f')
        if how == 2:
            ll.move_behind()
            ll.add(idx, 'f')

    ll.move_front()
    answer = ""
    for _ in range(ll.size):
        answer += f"{ll.get()} "
        ll.move_next()

    print(f"#{test_case} {answer.strip()}")
        
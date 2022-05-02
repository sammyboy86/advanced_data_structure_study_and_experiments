
class hashNode:

    #designed for strings

    def __init__(self, value):
        self.value = value
        self.hash = self.hashFunction(value)
        self.next = hashNode

    def hashFunction(value):

        #rolling hash function

        hash_value = 0
        p, m = 31, 10**9 + 7
        length = len(value)
        hash_so_far = 0
        p_pow = 1
        for i in range(value.length):
            hash_so_far = (hash_so_far + (1 + ord(value[i]) - ord('a')) * p_pow) % m
            p_pow = (p_pow * p) % m
        hash_value = hash_so_far

    def getHash(self):
        return self.hash

    def setNext(self, novo):
        self.next = novo

    def getNext(self):
        return self.next

    def getValue(self):
        return self.value


class hashTable:

    def __init__(self, size):
        self.table = [hashNode]*size

    def insert(self, string):

        node = hashNode(string)

        pos = node.getHash % self.size

        if(self.table!=None):
            self.table[pos] = node
        else:
            node.setNext(self.table[pos])
            self.table[pos] = node

    def search(self, string):


        node = hashNode(string)
        hash = node.getHash
        pos = hash % self.size

        
        elem = self.table[pos]

        if(elem == string):
            return True
        else:

            res = False
            elements = []
            elements[0] = elem
            
            cont = 1
            while(elem.getNext!=None):
                elements[cont] = elem.getNext
                elem = elem.getNext
                cont = cont +1
        

    











        



    

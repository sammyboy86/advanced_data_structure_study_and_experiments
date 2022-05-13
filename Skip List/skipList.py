


  
import random
import time
  
class Node(object):
    '''
    Clase de nodo
    '''
    def __init__(self, key, level):
        self.key = key
  
        # lista referencias distinto nivel
        self.forward = [None]*(level+1)
  
class SkipList(object):
    '''
    Clase skip 
    '''
    def __init__(self, max_lvl, P):
        # Maximo nivel de la skip
        self.MAXLVL = max_lvl
  
        # P fraccion nodos con
        # referencia a i e igualmente a i+1
        self.P = P
  
        # nodo inicial
        self.header = self.createNode(self.MAXLVL, -1)
  
        # nivel actual
        self.level = 0
      
    # nuevo nodo
    def createNode(self, lvl, key):
        n = Node(key, lvl)
        return n
      
    # nivel aleatorio
    def randomLevel(self):
        lvl = 0
        while random.random()<self.P and \
              lvl<self.MAXLVL:lvl += 1
        return lvl
  
    # insertar llave 
    def insertElement(self, key):
        # crear arreglo para actualizar
        update = [None]*(self.MAXLVL+1)
        current = self.header
  

        for i in range(self.level, -1, -1):
            while current.forward[i] and \
                  current.forward[i].key < key:
                current = current.forward[i]
            update[i] = current
  
  
        current = current.forward[0]

        if current == None or current.key != key:
            # generar nivel aleatorio
            rlevel = self.randomLevel()
  
        
            if rlevel > self.level:
                for i in range(self.level+1, rlevel+1):
                    update[i] = self.header
                self.level = rlevel
  
            # crear nuevo nodo con nivel aleatorio
            n = self.createNode(rlevel, key)
  
            # insertar nodo reorganizando referencias
            for i in range(rlevel+1):
                n.forward[i] = update[i].forward[i]
                update[i].forward[i] = n
  
            print("Successfully inserted key {}".format(key))
  
    # impresion de la skip
    def displayList(self):
        print("\n*****Skip List******")
        head = self.header
        for lvl in range(self.level+1):
            print("Level {}: ".format(lvl), end=" ")
            node = head.forward[lvl]
            while(node != None):
                print(node.key, end=" ")
                node = node.forward[lvl]
            print("")

    def deleteElement(self, search_key):
  
        # arreglo actualizar
        update = [None]*(self.MAXLVL+1)
        current = self.header
  
 
        for i in range(self.level, -1, -1):
            while(current.forward[i] and \
                  current.forward[i].key < search_key):
                current = current.forward[i]
            update[i] = current
  
  
        current = current.forward[0]
  
        # nodo actual = a nodo que buscamos?
        if current != None and current.key == search_key:
  
         
            for i in range(self.level+1):
  

                if update[i].forward[i] != current:
                    break
                update[i].forward[i] = current.forward[i]
  
            # eliminar niveles sin elementos
            while(self.level>0 and\
                  self.header.forward[self.level] == None):
                self.level -= 1
            print("Successfully deleted {}".format(search_key))
  
    def searchElement(self, key): 
        current = self.header
  

        for i in range(self.level, -1, -1):
            while(current.forward[i] and\
                  current.forward[i].key < key):
                current = current.forward[i]

        current = current.forward[0]

        if current and current.key == key:
            print("Found key ", key)
  
  
def main():
    lst = SkipList(3, 0.5)
    lst.insertElement(3)
    lst.insertElement(6)
    lst.insertElement(7)
    lst.insertElement(9)
    lst.insertElement(12)
    lst.insertElement(19)
    lst.insertElement(17)
    lst.insertElement(26)
    lst.insertElement(21)
    lst.insertElement(25)
    lst.displayList()

    # buscar 19
    lst.searchElement(19)
  
    # borrar 19
    lst.deleteElement(19)
    lst.displayList()

    # experimento
    skip1 = SkipList(10, 0.5)
    skip2 = SkipList(10, 0.5)
    skip3 = SkipList(10, 0.5)

    
    for i in range(100):
        skip1.insertElement(int(random.random()*1000))

    for i in range(1000):
        skip2.insertElement(int(random.random()*1000))

    for i in range(1000000):
        skip3.insertElement(int(random.random()*1000))

    

    tiempo1 = time.time()
    print(skip1.searchElement(0))
    t2 = time.time()
    print(t2 - tiempo1)

    print(skip2.searchElement(0))
    t3 = time.time()
    print(t3 - t2)

    print(skip3.searchElement(0))
    t4 = time.time()
    print(t4 - t3)




    

  
main()



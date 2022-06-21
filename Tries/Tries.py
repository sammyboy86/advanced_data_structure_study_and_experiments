
class NodeTrie:

    def __init__(self, key):
        self.nil = False
        self.key = key
        self.children = {}

    
    def setKey(self, key):
        self.key = key
    
    def getKey(self):
        return self.key

    def nilFalse(self):
        self.nil = False
    
    def nilTrue(self):
        self.nil = True

    def getChildren(self):
        return self.children
    
    def getNil(self):
        return self.nil
        
    def addChild(self, child):
        self.children[child.getKey()] = child

  


class Trie:

    def __init__(self, key):
        self.root = NodeTrie(key)
        self.root.nilFalse()
    
    def insert(self, key):
        current = self.root
        for x in key:
            if x in current.getChildren():
                current = current.getChildren()[x]
            
            else:
                node = NodeTrie(x)
                current.addChild(node)
                current = node

        current.nilTrue()

    
    def search(self, key):
        res = False
        flag = True
        current = self.root
        i = 0

        while(flag):
            if key[i] in current.getChildren():
                current = current.getChildren()[key[i]]  
                if i==len(key)-1:
                    
                    flag = False
                else:                    
                    i = i+1
            else:
                current = self.root
                flag = False

        if(current.getNil()):
            res = True        
        
        return res
    
    def delete(self, key):
        self.recursive_delete(self.root, key, 0)

    def recursive_delete(self, node, key, pos):
        element = key[pos]
        if(pos==len(key)-1):
            print(node.getChildren())
            print(node.getNil())
            temp = node.getChildren()[element]
            if(node.getNil()):
                node.nilFalse()

            
            
        elif(element in node.getChildren()):
            temp = node.getChildren()[element]
            pos = pos + 1
            self.recursive_delete(temp, key, pos)




def main():


    trie = Trie(None)
    trie.insert('ola')
    trie.insert('olas')
    trie.insert('olab')

    #pruebas
    #print('hijos de nodo a:')
    #print(root.getChildren()['o'].getChildren()['l'].getChildren()['a'].getChildren())
    print('buscar olas:')
    print(trie.search('olas'))
    print('buscar ola:')
    print(trie.search('ola'))
    print('buscar olan:')
    print(trie.search('olan'))

    #ajustar el delete falta!!
    trie.delete('ola')

    print(trie.search('ola'))
    print(trie.search('olas'))







main()


        



    
    


    

    


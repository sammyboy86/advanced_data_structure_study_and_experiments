from ctypes.wintypes import HDC
import numpy as np


class Grafo:
    def __init__(self):
        self.G={}
        self.visitados={}

    def insertaNodo(self,v1):
        if v1 not in self.G:
            self.G[v1]={}

    def insertaDirigido(self,v1,v2,peso=None):

        if v1 not in self.G:
            self.G[v1]={v2:peso}
        else:   
            self.G[v1][v2]=peso
        if v2 not in self.G:
            self.G[v2]={}

    def inserta(self,v1,v2,peso=None):
        self.insertaDirigido(v1,v2,peso)
        self.insertaDirigido(v2,v1,peso)


    def _recorreDFS(self,actual,lista):

        self.visitados[actual]=True
        lista.append(actual)
        for v in self.G[actual]:
            if not self.visitados[v]:
                self._recorreDFS(v,lista)

    def DFS(self): #Depth First Search, recorrido a profundidad
    # inicializar el visitados
        for v in self.G:
            self.visitados[v]=False
        lista=[]

        for v in self.G:
            if not self.visitados[v]:
                self._recorreDFS(v,lista)
        return lista
    
    
    def BFS(self):
        for v in self.G:
            self.visitados[v]=False
        lista=[]
        for v in self.G:
            if not self.visitados[v]:
                self._recorreBFS(v,lista)
        return lista

    def _recorreBFS(self,actual,lista):

        cola=[]

        self.visitados[actual]=True

        cola.append(actual)

        while len(cola)!=0:

            actual=cola.pop(0)

            lista.append(actual)

            for vecino in self.G[actual].keys():

                if not self.visitados[vecino]:
                    
                    self.visitados[vecino]=True
                    cola.append(vecino)

    def Prim(self, v_ini):
        key=HDC.heapdict()
        papa = {}
        for v in self.G:
            key[v] = np.inf
            papa[v] = None
        key[v_ini] = 0 

        while (len(key)>0):
            actual, costo = key.popitem()

            for vecino in self.G[actual]:
                if vecino in key and key[vecino]>self.G[actual][vecino]:
                    #key[vecino] = costo + self.G[actual][vecino] --> para hacerlo Djisdra
                    key[vecino] = self.G[actual][vecino]
                    papa[vecino] = actual

        return papa

        #camino Hamiltoniano


            

















    
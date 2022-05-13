import numpy as np
import hashlib as hl
import random as rnd
import matplotlib.pyplot as plt

class BloomFilter:
    
  def __init__(self,size,k):
    self.k=k
    self.bloom=np.array([False for i in range(size)], dtype=bool)
    self.size=size
    self.cont=0

  def regresaHash(self,dato):
    bits=int(np.ceil(np.log(self.size)/np.log(2)))
    hexa=int(np.ceil(bits/4))
    nMd5=int(np.ceil(self.k*hexa/32))
    hash=hl.md5(dato.encode('utf-8')).hexdigest()
    for i in range(nMd5-1):
      hash+=hl.md5(hash.encode('utf-8')).hexdigest()
    res=[]
    for i in range(0,hexa*self.k,hexa):
      res.append(int(hash[i:i+hexa],16)%self.size)
    return res

  def inserta(self,dato):
    posiciones=self.regresaHash(dato)
    for i in posiciones:
      self.bloom[i]=True
    self.cont+=1

  def busca(self,dato):
    posiciones=self.regresaHash(dato)
    i=0
    band=True
    while(band and i<len(posiciones)):
      if not self.bloom[posiciones[i]]:
        band=False
      i+=1
    return band

def optimizaBloom(numDatos, fracFalsosPositivos):

  



def main():
  bf=BloomFilter(1000,4)
  print(bf.regresaHash('fer'))
  bf.inserta('fer')
  print(bf.busca('laura'))
  print(bf.busca('fer'))

  #objetivo: minimizar tamanio para alcanzar cierto nivel de falsos positivos (jugar con k y tipo de funcion)



main()



    

    

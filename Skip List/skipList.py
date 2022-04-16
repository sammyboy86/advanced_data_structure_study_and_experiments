import random

class Node(object):

    def __init__(self, key, level):
        self.key = key
        self.forward = [None]*(level+1)

class SkipList(object):

    def __init__(self, max_lvl, P):

        self.MAXLVL = max_lvl

        self.P = P

        self.level = 0

    def createNode(self, lvl, key):
        n = Node(key, lvl)
        return n

    def randomLevel(self):
        lvl = 0
        while random.random()<self.P and lvl<self.MAXLVL:
                lvl += 1
        return lvl
        

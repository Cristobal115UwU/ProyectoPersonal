# -*- coding: utf-8 -*-
"""
Created on Mon Sep 16 12:29:17 2019

@author: Lenovo
"""
class Vertice:
    def __init__(self, n):
        self.nombre = n
        self.vecinos = list()
        self.distancia = 7777
        self.color = "verde"
        self.pred = -1
        
    def agregarVecino(self, v):
        if v not in self.vecinos:
            self.vecinos.append(v)
            self.vecinos.sort()
    
    def bfs(self, vert):
        vert.distancia = 0
        vert.color = "azul"
        vert.pred = -1
        q=list()
        
        q.append(vert.nombre)
        
        while len(q) > 0:
            u = q.pop()
            node_u = self.vertices[u]
            for v in node_u.vecinos:
                node_v = self.vertices[v]
                if node_v.color == "verde":
                    node_v.color = "azul"
                    node_v.distancia = node_u.distancia + 1
                    node_v.pred = node_u.nombre
                    q.append(v)
            self.vertices[u].color = "negro"

class Grafo:
    vertices = {}
    
    def agregarVertice(self, vertice):
        if isinstance(vertice, Vertice) and vertice.nombre not in self.vertices:
            self.vertices[vertice.nombre] = vertice
            return True
        else:
            return False
    def agregarArista(self, u, v):
        if u in self.vertices and v in self.vertices:
            for key, value in self.vertices.items():
                if key == u:
                    value.agregarVecino(v)
                    value.bfs(v)
                if key == v:
                    value.agregarVecino(u)
                    value.bfs(u)
            return True
        else:
            return False
    
    def imprimeGrafo(self):
        for key in sorted(list(self.vertices.keys())):
            print("Vertice "+key+" Sus vecinos son: "+str(self.vertices[key].vecinos))
            print("La distancia de A a " + key + " es: "+str(self.vertices[key].distancia)) 

class Controladora:
    def main(self):
        #Se crea un objeto 'g' de la clase Grafo, el grafo
        g = Grafo()
        #Se crea un objeto 'a' de la clase Vertice, un vertice
        a = Vertice("A")
        #Se agrega el vertice al grafo
        g.agregarVertice(a)
        
        #Esta estructura de repetición es para agregar
        #todos los vertices y  no hacerlo uno a uno
        for i in range(ord('A'), ord('K')):
            g.agregarVertice(Vertice(chr(i)))
        
        #Se declara una lista que contiene las aristas del grafo
        edges = ["AB", "AE", "BF", "CG", "DE", "DH", "EH", "FG","FI", "FJ", "GJ"]
        
        #Se agregan las aristas al grafo
        for edge in edges:
            g.agregarArista(edge[:1], edge[1:])
        #Se imprime el grafo, como lista de adyacencia
        g.imprimeGrafo()
        
c = Controladora()
c.main()
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 23 21:41:33 2019

@author: Lenovo
"""

class Vertice:
    def __init__(self, n):
        self.nombre = n
        self.vecinos = list()
        
        self.d = 0
        self.f = 0
        self.color = 'white'
        self.pred = -1
        
    def agregarVecino(self, v):
        if v not in self.vecinos:
            self.vecinos.append(v)
            self.vecinos.sort()
            
class Grafo:
    vertices = {}
    tiempo = 0
    
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
                    value.agregarVecino()
            return True
        else:
            return False
    
    def imprimeGrafo(self, vert):
        for key in sorted(list(self.vertices.keys())):
            print("Vertices: " + key)
            print("Descubierto/Termino: "+str(self.vertices[key].d) + "/" + str(self.vertices[key].f))
            
    def dfs(self, vert):
        global tiempo
        tiempo = 0
        for u in sorted(list(self.vertices.keys())):
            if self.vertices[u].color == 'white':
                self.dfsVisitar(self.vertices[u])
                
    def dfsVisitar(self, vert):
        global tiempo
        tiempo = tiempo + 1
        vert.d = tiempo
        vert.color = 'gris'
        
        for v in vert.vecinos:
            if self.vertices[v].color == 'white':
                self.vertices[v].pred = vert
                self.dfsVisitar(self.vertice[v])
            
        vert.color = 'black'
        tiempo = tiempo + 1
        vert.f = tiempo
        
        
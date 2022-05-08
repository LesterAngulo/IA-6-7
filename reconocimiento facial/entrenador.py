import os

import cv2
import numpy as np

# Aqui tenemos la ruta del dataset que acabamos de capturar
dataPath = 'C:/Users/leste/OneDrive/Escritorio/reconocimiento facial/data'
peopleList = os.listdir(dataPath)
# esto imprime una lista de las carpetas que acabamos de crear con el archivo de capturaRostros
print('Lista de personas: ', peopleList)

labels = []
facesData = []
# esta label es la que se utiliza para identificar a las imagenes de los datasets
label = 0

# Para que reconozca cual dataset es de quien se le agrega un label, a las imagenes, lo cual si es por ejemplo lester, tendra un 0 y si es otro tendra un 1,
# y asi sucesivamente hasta que acabe con los datasets
for nameDir in peopleList:
    personPath = dataPath + '/' + nameDir
    print('Leyendo las imágenes')

    for fileName in os.listdir(personPath):
        print('Rostros: ', nameDir + '/' + fileName)
        labels.append(label)
        # se hace una transformacion de las imagenes a escala de grises
        facesData.append(cv2.imread(personPath+'/'+fileName, 0))
        #image = cv2.imread(personPath+'/'+fileName,0)
        # cv2.imshow('image',image)
        # cv2.waitKey(10)
        # incrementamos el contador para que asigne el 0 en la primera carpeta que lea y 1 en la que sigue y asi sucesivamente
    label = label + 1

# Esto es una prueba la cual nos dice que indice es el que tiene cada carpeta, 0 o 1 ( y asi sucesivamente)
#print('labels= ',labels)
# Estos dos print son para hacer el contador de los indices, cuantos 0 y cuantos 1 hay en cada carpeta, dependiendo el num de imagenes
# en el dataset, son los indices que mostrara este print
#print('Número de etiquetas 0: ',np.count_nonzero(np.array(labels)==0))
#print('Número de etiquetas 1: ',np.count_nonzero(np.array(labels)==1))

# //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

# Métodos para entrenar el reconocedor

# Este metodo de entrenamiento dice que :
# todas las imagenes de entrenamiento como de prediccion deben de estar a escala de grises

face_recognizer = cv2.face.LBPHFaceRecognizer_create()


# //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
# Entrenando el reconocedor de rostros
print("Entrenando...")
# train()
# metodo el cual recibe 2 parametros
#  1.- imagenes de entrenamiento
#  2.- etiquetas correspondientes a las imagenes, estas deben de ser nunpy arrays, por eso se pone dentro de np.array
face_recognizer.train(facesData, np.array(labels))


# //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


# Almacenando el modelo obtenido

# El entrenamiento toma tiempo por lo tanto se hara un archivo y se leera en otro script

# metodo write()
# tiene 1 parametro el cual es:
#  1.- nombre del archivo para almacenar el reconocedor de rostros, el cual puede tener la extension: xlm o yaml

# yo lo nombre modeloEigenFace dado el nombre del metodo de entrenamiento que estoy utilizando
# face_recognizer.write('modeloEigenFace.xml')
# face_recognizer.write('modeloFisherFace.xml')
face_recognizer.write('modeloLBPHFace.xml')
print("Modelo almacenado...")

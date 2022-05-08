import os

import cv2
import imutils

# Aqui encontramos el nombre de la carpeta a la cual se agregaran los rostros para entrenar
# Se tiene que descomentar para ejecutar la carpeta a crear
# una vez creada, comentar de nuevo y repetir el paso anterior con la siguiente persona
personName = 'LilyColins'
# personName = 'AaronPaul'
# personName = 'DuaLipa'
# personName = 'ElizabethOlsen'
# personName = 'ChrisPratt'
# personName = 'Lester'

# ruta donde se guardara la carpeta de los rostros
dataPath = 'C:/Users/leste/OneDrive/Escritorio/reconocimiento facial/data'
personPath = dataPath + '/' + personName
# si no esxite esa carpeta se crea y se le agregan las imagenes sacadas del video o de la camara web
if not os.path.exists(personPath):
    print('Carpeta creada: ', personPath)
    os.makedirs(personPath)
# Esta opcion es para crear un dataset con su propia camara web
# cap = cv2.VideoCapture(0, cv2.CAP_DSHOW)

# Esta opcion es para crear el dataset a base de un video
# esta opcion es para capturar a traves de webcam
# cap = cv2.VideoCapture(0,cv2.CAP_DSHOW)

# Aqui empiezan los videos precargados para su captura de rostros
# descomentar el que desea capturar
cap = cv2.VideoCapture('lilycolins1.mp4')
# elegir la que quiere comporarar
# cap = cv2.VideoCapture('aaronpaul1.mp4')
# cap = cv2.VideoCapture('dualipa1.mp4')
# cap = cv2.VideoCapture('elizabeth1.mp4')
# cap = cv2.VideoCapture('chrispratt2.mp4')
# cap = cv2.VideoCapture('Lester1.mp4')


faceClassif = cv2.CascadeClassifier(
    cv2.data.haarcascades+'haarcascade_frontalface_default.xml')
# contador de rostros capturados
# incrementar dependiendo la cantidad de rostros capturados mas abajo
count = 0

# Aqui se hace la captura de los rostros
while True:

    ret, frame = cap.read()
    if ret == False:
        break
    frame = imutils.resize(frame, width=640)
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    auxFrame = frame.copy()
    faces = faceClassif.detectMultiScale(gray, 1.3, 5)

    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
        rostro = auxFrame[y:y+h, x:x+w]
        # en esta parte se toma el rostro y se seta la anchura y altura del cuadrado a tomar
        rostro = cv2.resize(rostro, (170, 170), interpolation=cv2.INTER_CUBIC)
        # aqui se escribira la captura del rostro y se guardara en el formato .jpg con el nombre, rostro y un contador
        cv2.imwrite(personPath + '/rostro_{}.jpg'.format(count), rostro)
        count = count + 1
        # muestra el video o frame donde se estaran capturando los rostros
    cv2.imshow('frame', frame)

    k = cv2.waitKey(1)
    # Aqui es la parte donde depende el contador de rostros capturados
    # si es >= 100 es que hasta 100 llegara, cambiar a 200 si se desea capturar 100 mas y el contador en vez de 0 ponerlo en 100
    if k == 27 or count >= 100:
        break

cap.release()
cv2.destroyAllWindows()

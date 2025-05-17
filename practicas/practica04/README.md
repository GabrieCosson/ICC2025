Trabajo del equipo de Gabriel Cosson Martinez 424111108 y Derek Maximo de la Serna Ortiz 320250363 <br/>
En este  documento se encuentra el código que implementa herencia en algunas figuras geométricas. <br/>
# Instrucciones para ejecutar: <br/>
1.- Clonar el repositorio con git clone y el enlace https del boton CODE. <br/>
2.- Situarse en la carpeta correcta desde la terminal. <br/>
3.- Ejecutar desde la terminal javac *.java para compilar todos los archivos en la carpeta. <br/>
4.- Ejecutar el comando java Main desde la terminal. <br/>
5.- Se puede acceder a la carpeta Main para cambiar los valores de las figuras, siempre asegurandose de compilar despues de cada cambio.<br/>
# Razon de la implementación del método toString(). <br/>
Se implementa el método toString() en la superclase con el dato del nombre de la figura, esto porque cada figura tiene diferentes caracteristicas y cada subclase podra sobreescribir el metodo para ser más especifico.
# Uso del polimorfismo. <br/>
En el Main del archivo declaramos a "cuadrado1" como FiguraGeometrica pero la instancia es la de Cuadrado realizando un polimorfismo, al implementar area() y perimetro() se comprueba el uso del polimorfismo.

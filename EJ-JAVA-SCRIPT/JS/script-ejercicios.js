//Ejercicio 1
var numero;
numero = 50;
document.getElementById("ejer1").innerHTML ="Es el número "+ numero;

//Ejercicio 2

var CMS = "WordPress";
document.getElementById("cms1").innerHTML = CMS;

//Ejercicio 3

var temperatura;
temperatura = "frio";
document.getElementById("temp").innerHTML ="la sensación térmica es "+ temperatura;

//Ejercicio 4

var x, y;
x = 2;
y = 3;
document.getElementById("sum").innerHTML = "El resultado de 2 + 3= " + (x + y);

//Ejericio 5

var x, y, z;
x = 5;
y = 10;
z = x + y;
document.getElementById("sum1").innerHTML = "El valor de z es la suma de x + y: " + (x + y);

//Ejercicio 6

var nombre, apellido, edad;
nombre = "Cristina" 
apellido = "García" 
edad = 39
document.getElementById("persona").innerHTML = nombre + " " + apellido + " tiene " + edad + " años";

//Ejercicio 7

var x, y, z;
x = 1;
y = 6;
z = x + y;
document.getElementById("donde").innerHTML = "El valor de z es la suma de x + y: " + (x + y);

//Ejercicio 8

var x;
x = 60;
document.getElementById("demo").innerHTML = " El resultado de la división 60/3 es: " + (x / 3);

//Ejercicio 9

var x, y;
x = 6;
y = 9;
z = "Cincuenta y cuatro" //resultado de la multiplicación en string.
document.getElementById("mult").innerHTML = " El resultado de la multiplicación  6*9 es: " + z;

//Ejercicio 10

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('evento').addEventListener('click', function() {
        this.innerHTML = '¡BUEN TRABAJO!';
    });
});




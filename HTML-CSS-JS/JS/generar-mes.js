var mes;
    switch (new Date().getMonth()) {
     case 0:
     mes = "Enero"; break;
     case 1:
     mes = "Febrero"; break;
     case 2:
     mes = "Marzo"; break;
     case 3:
     mes = "Abril"; break;
     case 4:
     mes = "Mayo"; break;
     case 5:
     mes = "Junio"; break;
     case 6:
     mes = "Julio";
    }
    document.write(new Date().getMonth());
    document.getElementById("Mes").innerHTML = "Estamos en el mes de" + mes;
    
CORBA-java-idl-simple-calc
==========================


Este es un proyecto de ejemplo que muestra cómo implementar una calculadora básica utilizando la arquitectura CORBA. La calculadora actualmente admite operaciones de suma, resta, multiplicación y división, pero se ha modificado para también admitir operaciones con números complejos.






Requisitos:

Para ejecutar este proyecto, necesitarás tener instalado lo siguiente:

Java Development Kit (JDK), 
IntelliJ IDEA o un IDE similar, 
Git, 
Corba

Instrucciones:
Abre el proyecto en tu IDE y ejecuta el comando idlj -fall Calc.idl para generar el código de esqueleto y proxy de Java a partir del archivo IDL.
Compila el proyecto ejecutando el comando javac *.java CalcApp/*.java.  
Inicia el servicio ORB ejecutando el comando orbd -ORBInitialPort 4000.  
Ejecuta el servidor de la calculadora utilizando el comando java CalcServer -ORBInitialPort 4000 -ORBInitialHost localhost.
Ejecuta el cliente de la calculadora utilizando el comando java CalcClient -ORBInitialPort 4000 -ORBInitialHost localhost.

Uso:
El cliente de la calculadora tiene una interfaz de usuario básica que te permite ingresar los números y operaciones que deseas realizar. Simplemente sigue las instrucciones en pantalla y verás el resultado de tus operaciones.


creditos: Este proyecto se basa en el trabajo original de qbart.


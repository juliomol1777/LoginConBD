
PROYECTO DE LOGIN EN JAVA CON CONEXION A BASE DE DATOS

Este es un proyecto de Login realizado en Java con coneccion a base de datos.
La base de datos es MySQL y la parte grafica realizada con Swing.
La base de datos sql se adjunta en el paquete DataBD.


Al ingresar al sistema de acuerdo al status del Usuario (Administrador, Empeado o Invitado),
se lo redirige a la ventana correspondiente. 
El login cuenta con un ProgressBar que funciona con un Timer simulamdo un tiempo de espera.
El administrador desde un panel de administración puede realizar los CRUD. 
Los Usuarios registrados en la base de datos se muetran en una JTable.
Desde la tabla se puede seleccionar cada usuario para modificar o eliminar sus datos.
Tambien se puede listar los datos presentes en la base de datos en un Texfield
Tambien el panel cuanta con un cuadro de busqueda que realiza la busqueda en la base de datos, segun el nombre de Usuario.
Los campos tienen validación y restricciones sobre campos nulos.
 
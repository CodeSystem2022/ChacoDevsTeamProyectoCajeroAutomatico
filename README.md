#                                                     Proyecto: SISTEMA DE CAJERO AUTOMATICO

#TEAM: CHACO DEV TEAM

Se decidió en grupo a desarrollar un sistema de cajero automático el cual se comenzo con 
un desarrollo en PSeint y se realizo su migracion a java, este cuenta con las siguientes operaciones básicas:
1.TRANSFERENCIAS
2.EXTRACCIONES/DEPOSITOS
3.PRESTAMOS
4.PAGOS/RECARGAS
5.CONSULTAS/MOVIMIENTOS
0.SALIR
El estado de saldo del cajero comienza en $0, tratando de simular lo máximo posible a la
realidad, en caso de que una entidad bancaria nos solicite el desarrollo de un sistema que
sea implementando en cajeros automáticos, el sistema cuenta con validaciones sobre el
saldo de la cuenta, así que se debe proceder a realizar un depósito en la cuenta para poder
operar con las opciones que impliquen débitos sobre esta.
TRANSFERENCIAS: Se solicitará que indique el tipo de transferencia que desea realizar, el
CBU y el monto, siempre y cuando posea saldo disponible para realizar la operación.
EXTRACCIONES/DEPOSITOS: Esta operación posee un submenú donde tenemos 3 opciones
Depósitos en la misma cuenta, Extracciones de dinero de la cuenta o volver al menú
principal.
PRESTAMOS: Permite al usuario realizar una solicitud de préstamo, donde se va
seleccionado diferentes opciones cuotas interés y el monto a solicitar, en caso de aceptar el
préstamo se acredita en la cuenta, en caso contrario se informa al usuario que se desistió
de la operación.
PAGOS/RECARGAS: Esta operación posee un submenú donde tenemos 3 opciones. PAGOS
el cual nos brinda 3 opciones de pagos (SAMEEP(AGUA)-SECHEEP(LUZ)-IMPUESTO
MUNICIPAL) y una opción de volver, una vez seleccionado un tipo de impuesto se debitará
del saldo de la cuenta. RECARGAS nos permite hacer una recarga de telefonía o tarjeta
sube. Estas operaciones siempre podrán ejecutarse siempre y cuando el usuario tenga
saldo en la cuenta, sino se informa al usuario que no posee saldo disponible.
CONSULTAS/MOVIMIENTOS: Esta operación cuenta con 5 operaciones Consultas de Saldos,
Tipo de Cambio, Consulta CBU, Últimos Movimientos, volver al menú principal.
2
Consulta de Saldos: muestra el saldo de la cuenta.
Tipo de cambio: muestra el cambio de USD a ARS.
Consulta de CBU: muestra el Nro. de cuenta y CBU.
Últimos Movimientos: muestra todos los movimientos hechos sobre la cuenta, depósitos,
extracciones, prestamos, pagos, recargas.
Listado de Integrantes
1. Balbuena, Fernando Nicolas DNI 38383822 correo: ferbalbu03@gmail.com
2. Balbuena, Facundo DNI 42263319 correo: facundo.balbuena31@gmail.com
3. Borda, Matías DNI: 43145033 correo: dediscoring@gmail.com
4. Espinola, Renzo Oscar DNI: 33074277 correo: renzo.espinola87@gmail.com
5. Giménez Ríos, Tatiana T. DNI: 33669320 correo: tatagimeri07@gmail.com
6. Gutiérrez, Juana Natalia DNI: 31630665 correo: naty.rcia33@gmail.com
7. Gutiérrez, Alejo Hernán DNI: 44331642 correo: alejohgutierrez@hotmail.com
8. Gutiérrez, Juan Carlos DNI: 28661402 correo: diosjuanvero2015@gmail.com
9. Gutiérrez, René Agustín DNI: 35686529 correo: yo_agustingutierrez@hotmail.com
10. Valdez, Carlos Federico DNI: 40605106 correo: cvaldes250@gmail.com

# JosephZanduetaMinimo1
Repositorio creado para la entrega del mínimo 1 

#1.0
Creada la estructura de carpetas Models, utils
Añadida Estructura de proyecto Maven y editado el pom.xml para incluir swagger y logger.
Añadido log.properties para deifinir el formato de logger.

#SortbyName
Como los Hasmap no se pueden ordenar, he copiado sus valores en un arrayList

#addUser()
Cambiado para que sea mas sencillo añadir un usuario, en vez de hacerlo en dos paso. Se comprueba que no está registrado ya

#updateUser()
Está hecho para modificar un valor de un usuario
Se tiene que crear un usuario antes con los valores modificados y si existe esa clave, lo actualiza y borra. Si no, saldrá excepción

#size()
Consulta el numero de usuarios

#SeeUser()
Lo he cambiado para que en vez de introducir un usuario, sea la clave del mapa y te devuelve un string con la informacion al respecto si está registrado.

#addItemToUser()
Añade un item ya un usuario dando la key del HashMap, si no existe salta la excepción

#getObjectUser()
Devuelve una lista con los objectos de un usuario en un metodo definido en Item. Si no existe el usario, excepcion

#sizeItemListUser()
Entra en un bucle guardando en un int auxiliar todas las cantidades de la lista de item de un usuario

#Fin
Pienso que tengo todo bien pero no hace mas que salirme un nullPointerExc... al hacer debug me sale como que la instancia p1 es null pero no lo entiendo porque, si al hacer logger se van añadiendo los objetos y no da error en eso.

He añadido varias funciones de la API pero tengo en cuenta que debería salir el test
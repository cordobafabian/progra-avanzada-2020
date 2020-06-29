# VisualizadorDeOrdenamientos

# RungeKutta - Autores

-Camila Noelí Abuin 
-Facundo Sebastián Bouza
-Lucas Natanael Bustos
-Rodrigo D'Ambrosio 
-Luana Daniela D'Amici 
-Matias Garín
-Leandro Santos 
-Julian Viescas

# Instrucciones de uso

-- Sección A --
Para ejecutar con interfaz gráfica por primera vez...
1) Ejecutar main.java como JavaApplication
2) Seleccionar:
- Tipo de ordenamiento
- Orden (Ordenado, invertido, etcétera)
- Delay
- Cantidad de elementos
3) Presionar Ordenar

-- Sección B --
Para volver a ordenar con la misma configuración pero nuevo array...
1) Presionar Mezclar
2) Presionar Ordenar

-- Sección C --
Para ejecutar un nuevo ordenamiento con algunos cambios...
1) Modifique los valores deseados
2) Si no cambió el caso ni el tamaño, seleccione Mezclar (Puede ordenar sin mezclar pero el array va a estar igual a como estaba después de la ejecución anterior)

-- Sección D --
Notas:
- Se puede cambiar el delay durante la ejecución
- Se puede detener la ejecución en caso de ser deseado con el botón Detener (La ejecución se almacenará en el .csv de igual manera)

-- Sección E --
Para ejecutar sin interfaz gráfica...
1) Cree un objeto Arreglos
2) Cree el array con generarArray(Orden caso, int cantElementos) que pertenece al objeto creado
3) Cree una estrategia del tipo de ordenamiento deseado
4) Establezca el delay a la estrategia
5) En caso de desearlo crear un objeto de tipo Salida y llamar al método escribirCSV(String algoritmoSeleccionado, String ordenSeleccionado, String tamanio, String tiempoTranscurrido)




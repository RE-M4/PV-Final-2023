INSERT INTO usuario (codigo,nombre,estatura) values("12345","elias",1.65)
INSERT INTO usuario (codigo,nombre,estatura) values("5414","laura",1.58)

INSERT INTO ingredientes (nombre) values("Arroz")
INSERT INTO ingredientes (nombre) values("Fideo integral")
INSERT INTO ingredientes (nombre) values("Tomate")
INSERT INTO ingredientes (nombre) values("Lechuga")
INSERT INTO ingredientes (nombre) values("Zanahoria")
INSERT INTO ingredientes (nombre) values("Cebolla")
INSERT INTO ingredientes (nombre) values("Huevo")
INSERT INTO ingredientes (nombre) values("Pollo")
INSERT INTO ingredientes (nombre) values("Carne")

INSERT INTO recetas (rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values("Carne","Imagen1","Carne con arroz","Preparacion1")
INSERT INTO recetas (rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values("Ensalada","Imagen2","Ensalada mixta","Preparacion2")

INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(1,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(2,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(3,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(4,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(5,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(6,2)

INSERT INTO testimonios (codigo, descripcion, usu_id) values("1", "Muy rico", "1")

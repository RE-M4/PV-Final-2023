INSERT INTO usuario (codigo,nombre,apellido,estatura,fecha_nacimiento) values("12345","Elias","Solis",165,"28-10-1993")
INSERT INTO usuario (codigo,nombre,apellido,estatura,fecha_nacimiento) values("5414","Laura","Flores",158,"08-01-1995")

INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Arroz")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Fideo integral")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Tomate")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Lechuga")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Zanahoria")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Cebolla")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Huevo")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Pollo")
INSERT INTO ingredientes (ing_estado,ing_nombre) values(1,"Carne")

INSERT INTO recetas (rec_estado,rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values(1,"Carne","Imagen1","Carne con arroz","Preparacion1")
INSERT INTO recetas (rec_estado,rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values(1,"Ensalada","Imagen2","Ensalada mixta","Preparacion2")

INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(1,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(2,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(3,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(4,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(5,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(6,2)

INSERT INTO testimonios (codigo, descripcion, usu_id) values("1", "Muy rico", "1")

INSERT INTO usuario (codigo,nombre,apellido,estatura,fecha_nacimiento) values("12345","Elias","Solis",165,"1993-10-28")
INSERT INTO usuario (codigo,nombre,apellido,estatura,fecha_nacimiento) values("5414","Laura","Flores",158,"1995-01-08")

INSERT INTO ingredientes (ing_nombre) values("Arroz")
INSERT INTO ingredientes (ing_nombre) values("Fideo integral")
INSERT INTO ingredientes (ing_nombre) values("Tomate")
INSERT INTO ingredientes (ing_nombre) values("Lechuga")
INSERT INTO ingredientes (ing_nombre) values("Zanahoria")
INSERT INTO ingredientes (ing_nombre) values("Cebolla")
INSERT INTO ingredientes (ing_nombre) values("Huevo")
INSERT INTO ingredientes (ing_nombre) values("Pollo")
INSERT INTO ingredientes (ing_nombre) values("Carne")

INSERT INTO recetas (rec_estado,rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values(1,"Carne","Imagen1","Carne con arroz","Preparacion1")
INSERT INTO recetas (rec_estado,rec_categoria,rec_imagen,rec_nombre,rec_preparacion) values(1,"Ensalada","Imagen2","Ensalada mixta","Preparacion2")

INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(1,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(2,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(3,1)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(4,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(5,2)
INSERT INTO recetas_lista_ingredientes(lista_ingredientes_ing_id,receta_rec_id) values(6,2)

INSERT INTO testimonios (codigo, descripcion, usu_id) values("1", "Muy rico", "1")

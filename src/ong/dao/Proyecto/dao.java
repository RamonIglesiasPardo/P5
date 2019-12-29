package ong.dao.Proyecto;
import ong.entreculturas.Proyecto;

public interface ProyectoDao {

void instertar (Proyecto p);

void modificar (Proyecto p);

void eliminar (Proyecto p);

List<Proyecto> obtenerTodos();

Proyecto obtener(IdProyecto);


}

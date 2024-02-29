package com.retogblhit.retogblhit.service;

import java.util.List;

public interface ICrud<T, V> {

	T registrar(T obj);
	T modificar();
	List<T> listar();
	T listarPorId(V id);
	void eliminar(V id);
	
}

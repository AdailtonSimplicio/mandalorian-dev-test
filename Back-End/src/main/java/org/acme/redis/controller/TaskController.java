package org.acme.controller;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.acme.service.TaskService;
import io.smallrye.mutiny.Uni;
//Definindo apenas uma instância
@Singleton
public class TaskController {
	//Injetando o TaskService
	@Inject
	TaskService service;

	public Uni<List<String>> getAllKeys() {
		return service.keys();
	}
	//Retorna a informação key para o cliente
	public String getKey(String key) {
		return service.get(key);
	}
	//Salva a key e o Value no redis
	public void insertTO(String key, String value) {
		service.set(key, value);
	}
	//Deleta uma key do redis
	public Uni<Void> deleteTO(String key) {
		return service.del(key);
	}

}

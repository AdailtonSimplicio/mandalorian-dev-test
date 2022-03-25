package org.acme.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.redis.client.Response;
//Definindo apenas uma instância
@Singleton
public class TaskService {
	//Injetando o RedisClient
	@Inject
	RedisClient redisClient;
	//Injetando o ReactiveRedisClient
	@Inject
	ReactiveRedisClient reactiveRedisClient;
	//Retorna uma lista keys
	public Uni<List<String>> keys() {
		return reactiveRedisClient
				.keys("*")
				.map(response -> {
				List<String> result = new ArrayList<>();
				for (Response r : response) {
					result.add(r.toString());
			}
			return result;
		});
	}
	//Retorna a informação key para o cliente
	public String get(String key) {
		return redisClient.get(key).toString();
	}
	//Salva a key e o Value no redis
	public void set(String key, String value) {
		redisClient.set(Arrays.asList(key, value));
	}
	//Deleta uma kay do redis
	public Uni<Void> del(String key) {
		return reactiveRedisClient.del(Arrays.asList(key))
				.map(response -> null);
	}
}

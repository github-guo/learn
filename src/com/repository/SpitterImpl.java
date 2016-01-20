package com.repository;

import org.springframework.stereotype.Repository;

import com.entity.Spitter;
@Repository
public class SpitterImpl implements SpitterRepository{

	@Override
	public void save(Spitter spitter) {
		System.out.println("saved success");
	}

}

package com.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Spittle;

public class SpittleRepositoryImpl implements SpittlRepository{

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<>();
		for(int i=0;i<20;i++){
			spittles.add(new Spittle("test"+1, new Date()));
		}
		return spittles;
	}
	
}

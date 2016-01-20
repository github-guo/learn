package com.repository;

import java.util.List;

import com.entity.Spittle;

public interface SpittlRepository {
	List<Spittle> findSpittles(long max,int count);
}

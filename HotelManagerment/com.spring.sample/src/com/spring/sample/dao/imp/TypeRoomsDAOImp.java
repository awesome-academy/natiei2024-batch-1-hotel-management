package com.spring.sample.dao.imp;

import org.springframework.stereotype.Repository;

import com.spring.sample.dao.TypeRoomsDAO;
import com.spring.sample.entity.TypeRooms;

@Repository
public class TypeRoomsDAOImp extends GenericDAOImp<TypeRooms, Integer> implements TypeRoomsDAO {

	public TypeRoomsDAOImp() {
		super(TypeRooms.class);
		// TODO Auto-generated constructor stub
	}

}

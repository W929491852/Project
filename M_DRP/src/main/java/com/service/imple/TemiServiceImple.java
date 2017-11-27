package com.service.imple;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Temi;
import com.mapper.TemiMapper;
import com.service.TemiService;

@Service
@Transactional
public class TemiServiceImple implements TemiService{

	@Autowired
	private TemiMapper temiMapper;
	@Override
	public boolean delete(String ids) {
		String[] strs=ids.split(",");
		System.out.println(Arrays.toString(strs));
		for(int i=0;i<strs.length;i++) {
			if(strs[i]!=null) {
				temiMapper.delete(Integer.parseInt(strs[i]));
			}
		}
		return true;
	}

	@Override
	public boolean insert(Temi record) {
		// TODO Auto-generated method stub
		return temiMapper.insert(record)>0?true:false;
	}

	@Override
	public Temi select(Integer temiid) {
		// TODO Auto-generated method stub
		return temiMapper.select(temiid);
	}

	@Override
	public boolean update(Temi record) {
		// TODO Auto-generated method stub
		return temiMapper.update(record)>0?true:false;
	}

	@Override
	public List<Temi> selectAll() {
		// TODO Auto-generated method stub
		return temiMapper.selectAll();
	}

}

package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.FlowCardDetail;
import com.mapper.FlowCardDetailMapper;
import com.service.FlowCardDetailService;
import com.service.FlowCardMatserService;

@Service
@Transactional
public class FlowCardDetailServiceImple implements FlowCardDetailService{

	@Autowired
	private FlowCardDetailMapper flowCardDetailMapper;
	@Override
	public List<FlowCardDetail> select(int id) {
		// TODO Auto-generated method stub
		return flowCardDetailMapper.select(id);
	}

}

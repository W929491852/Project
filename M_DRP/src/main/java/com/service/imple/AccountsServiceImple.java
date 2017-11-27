package com.service.imple;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Accounts;
import com.mapper.AccountsMapper;
import com.service.AccountsService;

@Service
@Transactional
public class AccountsServiceImple implements AccountsService{

	@Autowired
	private AccountsMapper accountsMapper;
	@Override
	public boolean delete(String ids) {
		// TODO Auto-generated method stub
		String[] strs=ids.split(",");
		System.out.println(Arrays.toString(strs));
		for(int i=0;i<strs.length;i++) {
			if(strs[i]!=null) {
				accountsMapper.delete(Integer.parseInt(strs[i]));
			}
		}
		return true;
	}

	@Override
	public boolean insert(Accounts record) {
		// TODO Auto-generated method stub
		return accountsMapper.insert(record)>0?true:false;
	}

	@Override
	public Accounts select(Integer id) {
		// TODO Auto-generated method stub
		return accountsMapper.select(id);
	}

	@Override
	public List<Accounts> selectAll() {
		// TODO Auto-generated method stub
		return accountsMapper.selectAll();
	}

	@Override
	public boolean update(String periodsts, int id) {
		// TODO Auto-generated method stub
		return accountsMapper.update(periodsts, id)>0?true:false;
	}

}

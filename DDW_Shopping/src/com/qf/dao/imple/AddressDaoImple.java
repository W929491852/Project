package com.qf.dao.imple;

import java.util.List;

import com.qf.dao.AddressDao;
import com.qf.domain.Address;
import com.qf.utils.DbHelp;

public class AddressDaoImple implements AddressDao{

	@Override
	public boolean save(Address address) {
		// TODO Auto-generated method stub
		return DbHelp.update("insert into tb_address(name,detail,level,phone,uid) values(?,?,?,?,?)",
				address.getName(),address.getDetail(),address.getLevel(),address.getPhone(),address.getUid());
	}

	@Override
	public boolean update(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Address> queryAll(int uid) {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select * from tb_address where uid=? order by level",Address.class, uid);
	}

}

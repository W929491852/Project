package com.service.imple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SignDao;
import com.domain.Sign;
import com.domain.User;
import com.service.SignService;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class SignServiceImple implements SignService{

	@Autowired
	private SignDao signDao;

	@Override
	public boolean addSign(String id) {
		// TODO Auto-generated method stub
		Date date=new Date();
		String str=new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			long startDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str+" 08:00:00").getTime();
			long endDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str+" 09:00:00").getTime();
			Sign sign=new Sign(date, 2, new User(Integer.parseInt(id)));
			if(date.getTime()>=startDate&&date.getTime()<=endDate) {
				sign.setFlag(1);
			}
			boolean addSign = signDao.addSign(sign);
			if(addSign) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public Sign selectSign(String id) {
		// TODO Auto-generated method stub
		String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String hql="select * from tb_sign  where createtime>='"+date+"' and uid="+id;
		return signDao.selectSingleSign(hql);
	}

	@Override
	public List<Sign> selectAllSign(String startDate, String endDate,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_sign where";
		if(StringCheckEmpty.checked(startDate)) {
			sql+=" createtime>='"+startDate+"'";
		}else {
			sql+=" createtime>='2000-01-01'";
		}
		if(StringCheckEmpty.checked(endDate)) {
			sql+=" and createtime<='"+endDate+"'";
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return signDao.selectAllSign(sql);
	}
}

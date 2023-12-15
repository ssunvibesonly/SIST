package boot.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ShopDto;
import boot.data.mapper.ShopMapper;

@Service
public class ShopService implements ShopServiceInter {

	@Autowired
	private ShopMapper shop_mapper;
	
	@Override
	public void insertShop(ShopDto dto) {
		// TODO Auto-generated method stub
		shop_mapper.insertShop(dto);
	}

	@Override
	public List<ShopDto> getShopDatas() {
		// TODO Auto-generated method stub
		return shop_mapper.getShopDatas();
	}

}

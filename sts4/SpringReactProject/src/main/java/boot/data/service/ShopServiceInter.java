package boot.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.data.dto.ShopDto;


public interface ShopServiceInter {
	public void insertShop(ShopDto dto);
	public List<ShopDto> getShopDatas();
}

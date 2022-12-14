package com.koreait.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.jpashop.domain.Item;
import com.koreait.jpashop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
	
	private final ItemRepository itemRepository;

	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item); 
	}

	public List<Item> findItems() {
		return itemRepository.findAll();
	}

	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
	
	@Transactional
	public void updateItem(Long itemid, String name, int price, int stockQuantity) {
		// 영속성 컨텍스트에 속해있으려면 해당 데이터를 select해준다.
		// select문을 통해서 영속성 컨텍스트에서 가져올건데, 영속성 컨텍스트에 데이터가 없으면 DB에서 가져온다.
		// select 요청을 함으로써, 영속성 컨텍스트영역으로 요청을 보내서 그 안에 내 정보가 담기게된다.
		// findItem 이라는 객체는 영속 상태에 놓이게 된다.
		Item findItem = itemRepository.findOne(itemid);
		findItem.setName(name);
		findItem.setPrice(price);
		findItem.setStockQuantity(stockQuantity);
	}
}

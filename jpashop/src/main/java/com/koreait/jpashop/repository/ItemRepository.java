package com.koreait.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.jpashop.domain.Item;
import com.koreait.jpashop.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
	
	@Autowired
	private final EntityManager em;
	
	public void save(Item item) {
		// 처움에 item의 id가 없으면 신규등록
//		if(item.getId() == null) {
			// 신규 
//			em.persist(item);
//		}else {
			// jpa를 통해서 db에 한번 들어간 값
//			em.merge(item);
//		}
		
		em.persist(item);
	}

	public List<Item> findAll() {
		return em.createQuery("select i from Item i", Item.class).getResultList();
	}

	public Item findOne(Long id) {
		return em.find(Item.class, id);
	}
	
}

package com.nhom8.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nhom8.dao.NewsRepository;
import com.nhom8.model.News;

@Service
@Transactional
public class NewsService {

	private final NewsRepository newsRepository;

	public NewsService(NewsRepository newsRepository) {
		super();
		this.newsRepository = newsRepository;
	}
	
	public List<News> findAll(){
		List<News> newss = new ArrayList<>();
		for(News news:newsRepository.findAll()) {
			newss.add(news);
		}
		Collections.reverse(newss);
		return newss;
	}
	
	public News findNewsById(int id) {
		return newsRepository.findById(id).get();
	}
	
	public News findNewsByTitle(String title) {
		News newss = new News();
		for(News news:newsRepository.findAll()) {
			if (news.getTitle().equals(title)) {
				newss = news;
			}
		}
		
		return newss;
	}
	
	public void save(News news) {
		newsRepository.save(news);
	}
	
	public void delete (int id) {
		newsRepository.deleteById(id);
	}
}
package com.somniuss.service.impl;

import com.somniuss.bean.News;
import com.somniuss.dao.DaoException;
import com.somniuss.dao.DaoProvider;
import com.somniuss.dao.NewsDao;
import com.somniuss.service.NewsService;
import com.somniuss.service.ServiceException;

import java.util.List;

public class NewsServiceImpl implements NewsService {

	private final NewsDao newsDao = DaoProvider.getInstance().getNewsDao();

	@Override
	public List<News> getAllNews() throws ServiceException {
	    try {
	        List<News> newsList = newsDao.getAllNews();
	        if (newsList == null) {
	            throw new ServiceException("Новостей пока нет");
	            
	        }
	        return newsList;
	    } catch (DaoException e) {
	        throw new ServiceException("Ошибка при получении списка новостей", e);
	    }
	}

}

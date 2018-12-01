package util;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import dao.BookDao;
import dao.DvdDao;
import dao.impl.BookDaoImpl;
import dao.impl.DvdDaoImpl;
import service.BookService;
import service.DvdService;
import service.impl.BookServiceImpl;
import service.impl.DvdServiceImpl;

public class OnStartupModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BookDao.class).annotatedWith(Names.named("bookDao")).to(BookDaoImpl.class);
        bind(DvdDao.class).annotatedWith(Names.named("dvdDao")).to(DvdDaoImpl.class);
        //bind Service
        bind(BookService.class).to(BookServiceImpl.class);
        bind(DvdService.class).to(DvdServiceImpl.class);
    }
}

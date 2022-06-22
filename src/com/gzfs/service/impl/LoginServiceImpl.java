package com.gzfs.service.impl;

import com.gzfs.entity.Admin;
import com.gzfs.entity.Reader;
import com.gzfs.repository.AdminRepository;
import com.gzfs.repository.ReaderRepository;
import com.gzfs.repository.impl.AdminRepositoryImpl;
import com.gzfs.repository.impl.ReaderRepositoryImpl;
import com.gzfs.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private AdminRepository adminRepository =  new AdminRepositoryImpl();
    @Override
    public Object Login(String username, String password,String type) {
        Object object =null;
        switch (type)
        {
            case "reader":
                object = readerRepository.login(username,password);
                break;
            case "admin":
                object = adminRepository.login(username,password);
                break;
        }
        return  object;
    }
}

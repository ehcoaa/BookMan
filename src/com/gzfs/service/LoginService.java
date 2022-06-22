package com.gzfs.service;

import com.gzfs.entity.Reader;

public interface LoginService {
    public Object Login(String username, String password,String type);
}

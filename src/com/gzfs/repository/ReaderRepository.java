package com.gzfs.repository;

import com.gzfs.entity.Admin;
import com.gzfs.entity.Reader;

public interface ReaderRepository {
    public Reader login(String username,String password);
}

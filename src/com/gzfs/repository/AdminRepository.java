package com.gzfs.repository;

import com.gzfs.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}

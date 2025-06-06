package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exception.CertException;
import com.example.demo.model.dto.UserCert;
@Service
public interface CertService {
	UserCert getCert(String username, String password) throws CertException;
}

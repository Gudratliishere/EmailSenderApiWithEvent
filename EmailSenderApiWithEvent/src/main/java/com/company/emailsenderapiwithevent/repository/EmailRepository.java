package com.company.emailsenderapiwithevent.repository;

import com.company.emailsenderapiwithevent.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer>
{
}

package com.company.emailsenderapiwithevent.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@Entity
@Table(name = "email")
@XmlRootElement
public class Email
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer Integer;

    @Column(name = "receiver")
    private String to;

    @Column(name = "subject")
    private String topic;

    @Column(name = "message")
    private String message;
}

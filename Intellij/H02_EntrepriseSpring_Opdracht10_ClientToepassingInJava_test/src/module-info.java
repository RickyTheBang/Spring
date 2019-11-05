open module house.com {
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires java.sql;

    //REST
    requires spring.web;
    //JEE annotations
    requires java.annotation;
    //XML binding
    requires java.xml.bind;
    requires com.sun.xml.bind;
    //JSON binding
    requires jackson.annotations;
   //Bean Validation API
    requires java.validation;






}

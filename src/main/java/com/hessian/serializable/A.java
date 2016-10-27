package com.hessian.serializable;

import java.io.Serializable;

class A implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5324153626203979248L;
	private String name;
    private String age;

    public A(String name, String age){
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
}
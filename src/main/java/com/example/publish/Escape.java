package com.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * Package:com.example.publish
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:12
 **/
@Slf4j
public class Escape {

	private int thisCanbeescape=0;
	public  Escape(){
		new InnerClass();
	}
	private class InnerClass{

		public InnerClass(){
			log.info("{}",Escape.this.thisCanbeescape );
		}

	}
	public static void main(String[] args) {
	    new Escape();
	}

}

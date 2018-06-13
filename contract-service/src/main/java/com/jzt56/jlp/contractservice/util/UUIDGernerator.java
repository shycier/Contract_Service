package com.jzt56.jlp.contractservice.util;

import java.util.UUID;

public class UUIDGernerator {
	
	public static void main(String[] args) {
		for(int i= 0;i<10;i++) {
			System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
		}
	}
	
}

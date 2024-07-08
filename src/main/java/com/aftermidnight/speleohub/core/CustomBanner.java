package com.aftermidnight.speleohub.core;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.env.Environment;

public class CustomBanner implements Banner {
	
	@Override
	public void printBanner(Environment env, Class<?> clazz, PrintStream ps) {
		
		String version = SpringBootVersion.getVersion();
		version = (version != null) ? " v" + version  : "";
		
		ps.println(" _____                _            _   _       _     		");
        ps.println("| ____|___ _ __   ___| | ___  ___ | | | |_   _| |__  		");
        ps.println("|  _| / __| '_ \\ / _ \\ |/ _ \\/ _ \\| |_| | | | | '_ \\ ");
        ps.println("| |___\\__ \\ |_) |  __/ |  __/ (_) |  _  | |_| | |_) |	");
        ps.println("|_____|___/ .__/ \\___|_|\\___|\\___/|_| |_|\\__,_|_.__/ 	");
        ps.println("          |_|                                        		");
    

		ps.println();
		ps.println(" > Spring Boot Version :"+version);
		ps.println();
	}
}

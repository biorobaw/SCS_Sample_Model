package com.github.biorobaw.scs_models.scs_sample_model.tasks;

import com.github.biorobaw.scs.simulation.scripts.Script;
import com.github.biorobaw.scs.utils.files.XML;

public class SampleTask implements Script {

	String param;
	int param2;
	
	public SampleTask(XML xml) {
		param = xml.getAttribute("sample_str_param");
		param2 = xml.getIntAttribute("sample_int_param");
	}
	
	
	// ALL the following functions are optional and do not have to be implemented
	// see class Script for more functions
	
	@Override
	public void run() {
		System.out.println("Sample Task: " + param + " " + param2);
	}
	
	
	
	
}

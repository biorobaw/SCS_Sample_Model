package com.github.biorobaw.scs_models.scs_sample_model.model;

import com.github.biorobaw.scs.experiment.Subject;
import com.github.biorobaw.scs.robot.commands.SetSpeedVW;
import com.github.biorobaw.scs.utils.files.XML;
import com.github.biorobaw.scs.utils.math.RandomSingleton;
import com.github.biorobaw.scs_models.scs_sample_model.gui.SampleGui;

public class SampleModel extends Subject {

	public String config_param_1;
	public String config_param_2;
	
	float v = 0.5f * 2*(float)Math.PI / 10;
	float w = v/0.5f;
	
	
	SampleGui gui;
	
	public SampleModel(XML xml) {
		super(xml);
		config_param_1 = xml.getAttribute("config_param_1");
		config_param_2 = xml.getAttribute("config_param_2");
		
		gui = new SampleGui(this);
	}

	@Override
	public long runModel() {
		// TODO Auto-generated method stub
		
		System.out.println("The model is running:");
		System.out.println("\t param1: " + config_param_1);
		System.out.println("\t param2: " + config_param_2);
		
		if(RandomSingleton.getInstance().nextInt(100)<5) {
			v*=-1;
			w*=-1;
		}
		robot.getRobotProxy().send_command(new SetSpeedVW(v, w));
		// the return value indicates the simulator's task scheduler in how many milliseconds
		// should this task be rescheduled.
		// A value of 0 indicates to use the default simulation cycle time
		return 0;
	}
	
	


}

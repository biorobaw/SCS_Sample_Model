package com.github.biorobaw.scs_models.scs_sample_model.tasks;

import com.github.biorobaw.scs.experiment.Experiment;
import com.github.biorobaw.scs.simulation.scripts.Script;
import com.github.biorobaw.scs.utils.files.XML;
import com.github.biorobaw.scs_models.scs_sample_model.model.SampleModel;

public class SampleLog implements Script {

	String subject_id = "";
	
	public SampleLog(XML xml) {
		subject_id =xml.getAttribute("subject_id");
	}
	
	
	// ALL the following functions are optional and do not have to be implemented
	// see class Script for more functions
	
	@Override
	public void run() {
		var e = Experiment.get();
		var model = (SampleModel)e.getSubject(subject_id);
		Long cycle = e.getGlobal("cycle");
		System.out.println("SampleLog: loggin cycle info: " + cycle + " " + model.config_param_1);
	}
	
	
	@Override
	public void newExperiment() {
		System.out.println("SampleLog: Optional function that runs before running the experiment");
	}
	
	@Override
	public void endExperiment() {
		System.out.println("SampleLog: Optional function that runs at the end of the experiment");
	}
	
	@Override
	public void newTrial() {
		System.out.println("SampleLog: Optional function that runs before each trial");
	}
	
	@Override
	public void endTrial() {
		System.out.println("SampleLog: Optional function that runs at the end of each trial");
	}
	
	@Override
	public void newEpisode() {
		System.out.println("SampleLog: Optional function that runs before each episode");
	}
	
	@Override
	public void endEpisode() {
		System.out.println("SampleLog: Optional function that runs at end of each episode");
		var e = Experiment.get();
		int episode = e.getGlobal("episode");
	}
	
	
	
}

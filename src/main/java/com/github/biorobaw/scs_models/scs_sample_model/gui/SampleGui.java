package com.github.biorobaw.scs_models.scs_sample_model.gui;

import java.awt.Color;

import com.github.biorobaw.scs.experiment.Experiment;
import com.github.biorobaw.scs.gui.Display;
import com.github.biorobaw.scs.gui.DrawPanel;
import com.github.biorobaw.scs.gui.drawer.CycleDataDrawer;
import com.github.biorobaw.scs.gui.drawer.FeederDrawer;
import com.github.biorobaw.scs.gui.drawer.PathDrawer;
import com.github.biorobaw.scs.gui.drawer.RobotDrawer;
import com.github.biorobaw.scs.gui.drawer.WallDrawer;
import com.github.biorobaw.scs.gui.utils.GuiUtils;
import com.github.biorobaw.scs_models.scs_sample_model.model.SampleModel;


public class SampleGui {

	Display d = Experiment.get().display;
	SampleModel model;
	
	
	// DRAWERS IMPLEMENTED BY SCS
	public WallDrawer wallDrawer;
	public PathDrawer pathDrawer;
	public RobotDrawer rDrawer;
	public FeederDrawer fDrawer;
	
	
	// =========== PARAMETERS =====================
	static final int   wall_thickness = 1;
	static final Color wall_color 	  = GuiUtils.getHSBAColor(0f, 0f, 0f, 1);
	static final Color path_color 	  = Color.RED;
	
	public SampleGui(SampleModel model) {
		
		// DEFINE THE PANELS IN THE GUI
		// the gui has a main panel and allows to add other panels with the following command
		// note: the main panel has id "universe"
		d.addPanel(new DrawPanel(300,300), "sample_panel_id", 0, 0, 1, 1);
		
		
		// CREATE A BUNCH OF DRAWERS TO ATTACH TO EACH PANEL
		var cycle_data_drawer = new CycleDataDrawer();
		
		wallDrawer = new WallDrawer( wall_thickness);
		wallDrawer.setColor(wall_color);
		
		
		pathDrawer = new PathDrawer(model.getRobot().getRobotProxy());
		pathDrawer.setColor(path_color);

		rDrawer = new RobotDrawer(model.getRobot().getRobotProxy());
		
		fDrawer = new FeederDrawer(0.1f);
		
		// ADD THE DRAWERS TO THE PANELS
		//UNIVERSE PANEL
		d.addDrawer("universe", "maze", wallDrawer );
		d.addDrawer("universe", "feeders", fDrawer);
		d.addDrawer("universe", "path", pathDrawer);
		d.addDrawer("universe", "robot", rDrawer);
		d.addDrawer("universe", "cycle info", cycle_data_drawer);
		
		// SAMPLE_PANEL
		d.addDrawer("sample_panel_id", "walls panel 2", wallDrawer);
		
		
	}
	
	
}

import javax.swing.SwingUtilities;

import algorithms.BackPropagation;
import algorithms.Propagation;
import geo.Grid;
import view.ResultView;

public class MainClass {
	
	
	public static void main(String[] args) {
		int nbNM = 100;
		int n = 300;
		double H = ((double)n/(double)nbNM)*60.;
		double wx = 0;
		double wy = 0;
		int x0 = n-1;
		int y0 = 3*n/4;
		Grid g = new Grid(n,H);
		
		long tBeginPropagation = System.currentTimeMillis();
		Propagation.propagate(g, wx, wy,  x0,  y0);
		long tEndPropagation = System.currentTimeMillis();
		
		System.out.println("PROPAGATION TIME : "+(tEndPropagation-tBeginPropagation));
		
		
		BackPropagation.backpropag(g, x0, y0);
		String filename = "Ortho_Vent_"+wx+"_"+wy+"_n_"+n+"_"+x0+"_"+y0+"_H_"+H+".png";
		String title = "Ortho_Vent_"+wx+"_"+wy+"_n_"+n+"_"+x0+"_"+y0+"_H_"+H;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ResultView(g,  title, filename).setVisible(true);
			}
		});
	}
	
	
}


/*	
 * Copyright 2011, Robin Roche
 * This file is part of jica.

    jica is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    jica is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with jica.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

/**
 * A simple test class for jica
 * @author Robin Roche
 */
public class TestICA 
{

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) 
	{


		// Set the fitness function and problem parameters
		FitnessFunction fitnessFunc = new FitnessFunction();

		// Create the algorithm object
		ICAlgorithm ica = new ICAlgorithm(fitnessFunc);
		ICAUtils utils = new ICAUtils();
		
		// Run the simulation
		int nbRuns = 20;
		int maxEvals = 200000;
		for(int i=0;i<nbRuns;i++)
		{
			// Run the algorithm and get the results
			double[] results = ica.runICA(maxEvals);
			FitnessFunction obj = new FitnessFunction();
			utils.printArray("result::",results);
			double bestFitness = obj.getFitnessValue(results);
			ica.reset();

			// Display the results
			System.out.println(bestFitness);
			//System.out.println("ICA run results:");
			//System.out.println("Best fitness:\t" + bestFitness);
			//System.out.println("Best solution:\t" + Arrays.toString(results));
		}
	}

}

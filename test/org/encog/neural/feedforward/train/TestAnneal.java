package org.encog.neural.feedforward.train;

import org.encog.neural.XOR;
import org.encog.neural.feedforward.FeedforwardNetwork;
import org.encog.neural.feedforward.train.anneal.NeuralSimulatedAnnealing;

import junit.framework.TestCase;

public class TestAnneal extends TestCase {

	public void testAnneal() throws Throwable
	{
		FeedforwardNetwork network = XOR.createThreeLayerNet();
		NeuralSimulatedAnnealing train = new NeuralSimulatedAnnealing(network,XOR.XOR_INPUT, XOR.XOR_IDEAL,10,2,100);	

		for (int i = 0; i < 100; i++) 
		{
			train.iteration();
			network = train.getNetwork();
		}
		
		TestCase.assertTrue("Error too high for simulated annealing",train.getError()<0.1);
		TestCase.assertTrue("XOR outputs not correct",XOR.verifyXOR(network, 0.1));

	}
	
}

package weka.classifiers.functions;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DL4JClassifierTest {
	
	public static void denseTest() throws Exception {
		
		DataSource ds = new DataSource("datasets/iris.arff");
		Instances data = ds.getDataSet();
		data.setClassIndex( data.numAttributes() - 1 );
		
		ChrisDL4JClassifier cls = new ChrisDL4JClassifier();
		cls.setLayers(new weka.dl4j.layers.Layer[] {
				new weka.dl4j.layers.DenseLayer(),
				new weka.dl4j.layers.DenseLayer(),
				new weka.dl4j.layers.OutputLayer() 
		});
		cls.setTrainBatchSize(1);
		cls.setDebugFile("/tmp/debug.txt");
		cls.buildClassifier(data);
		
		cls.distributionsForInstances(data);
		
	}
	
	public static void convTest() throws Exception {
		
		DataSource ds = new DataSource("datasets/iris.arff");
		Instances data = ds.getDataSet();
		data.setClassIndex( data.numAttributes() - 1 );
		
		ChrisDL4JClassifier cls = new ChrisDL4JClassifier();
		cls.setLayers(new weka.dl4j.layers.Layer[] {
				new weka.dl4j.layers.Conv1DLayer(),
				new weka.dl4j.layers.OutputLayer() 
		});
		cls.setTrainBatchSize(1);
		cls.setDebugFile("/tmp/debug.txt");
		cls.buildClassifier(data);
		
		cls.distributionsForInstances(data);				
		
	}
	
	public static void main(String[] args) throws Exception {
		
		//denseTest();
		
		convTest();
		
	}

}

package com.gnandoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testApp() throws FileNotFoundException {
		assertTrue(true);
		Kryo kryo = new Kryo();

		Output output = new Output(new FileOutputStream("file.bin"));

		Node node = new Node();
		Node c1 = new Node();
		node.set("c1", c1);
		c1.set("c2", new Leaf(42L));

		kryo.writeObject(output, node);
		output.close();

		Input input = new Input(new FileInputStream("file.bin"));
		Node result = kryo.readObject(input, Node.class);
		input.close();
	}
}

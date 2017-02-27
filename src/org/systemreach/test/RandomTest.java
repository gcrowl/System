package org.systemreach.test;

import org.hive2hive.core.api.H2HNode;
import org.hive2hive.core.api.configs.FileConfiguration;
import org.hive2hive.core.api.configs.NetworkConfiguration;
import org.hive2hive.core.api.interfaces.IFileConfiguration;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.INetworkConfiguration;

public class RandomTest {

	public static void main(String[] args) {
		setupNode();
	}

	private static void setupNode() {
		//Two ways to create node.
		//First step appears to be creating a file configuration.
		//Second step is to establish the network.
		//Lastly create the node.
		IFileConfiguration fileConfiguration = FileConfiguration.createDefault();
		//Create an uninitialized node.
		IH2HNode node = H2HNode.createNode(fileConfiguration);
		//Create a p2p network at first avaliable peer.
		node.connect(NetworkConfiguration.createInitial());

		//Configuring and setting up a new P2P network 
		INetworkConfiguration netConfig = NetworkConfiguration.createInitial();
		IFileConfiguration fileConfig = FileConfiguration.createDefault();

		IH2HNode peerNode = H2HNode.createNode(fileConfig);
		peerNode.connect(netConfig);
	}
}

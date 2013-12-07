DotA-2-API
==========

A interface for the WebAPI DotA in Java, currently under development.

Usage
-----

A simple example of how to retrieve a player's match history:

	public class TestClass {

		public static void main(String[] args) {
			APIConnector aSocket = new APIConnector("AAA1111A1111AAA1A111AA11111AAAA");
			ArrayList<Match> myMatchList = aSocket.retrieveFullMatchHistory(new Player("FruitLoops"));
		}
		
	}


Valve's WebAPI
--------------

You may find information about Valve's WebAPI here:

http://dev.dota2.com/showthread.php?t=47115

DotA-2-API
==========

A WebAPI interface for DotA written in Java.

Usage
-----

A simple example of how to retrieve a player's match history:

	public class TestClass {

		public static void main(String[] args) {
			APIConnector aSocket = new APIConnector("AAA1111A1111AAA1A111AA11111AAAA", Format.XML);
			Player testPlayer = new Player("FruitLoops");
			ArrayList<Match> myMatchList = aSocket.retrieveFullMatchHistory(testUser);
		}
		
	}


Valve's WebAPI
--------------

You may find information about Valve's WebAPI here:

http://dev.dota2.com/showthread.php?t=47115

DotA-2-API
==========

A interface for the WebAPI DotA in Java, currently under development.

Usage
-----

A simple example of how to retrieve a player's match history:

	public class TestClass {

		public static void main(String[] args) {
			APIConnector aConnector = new APIConnector("<Your Api Key>");
			ArrayList<Match> myMatchList = aConnector.retrieveFullMatchHistory(new Player("FruitLoops"));
		}
		
	}
	
The above code will populate the Player object with Match objects for every match in their entire history.
	
Libraries Used
--------------

Google's Gson: 

https://sites.google.com/site/gson/Home

Apache Commons IO:

http://commons.apache.org/proper/commons-io/


Valve's WebAPI
--------------

You may find the information about Valve's WebAPI here:

http://wiki.teamfortress.com/wiki/WebAPI

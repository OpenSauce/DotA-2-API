DotA-2-API
==========

A interface for the WebAPI DotA in Java, currently under development.

Usage
-----

A simple example of how to retrieve a player's match history:

	public class TestClass {

		public static void main(String[] args) {
			APIHandler aHandler = new APIHandler("<Your Api Key>");
			ArrayList<Match> playerMatchList = aHandler.retrieveFullMatchHistory(new Player("58542407"));
		}
		
	}
	
The above code will return an ArrayList of Match objects for every avaliable match in the player's history.
	
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

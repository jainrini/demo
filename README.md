# demo
Import the project as maven  and build the project.
Run the GameApplication.class
When the server is up you can use below APIs:

Note : If port 8080 is already in use, you can configure in src/main/resources/application.properties as below:
server.port={PORT_NUMBER}

1.start game: localhost:8080/game/start
This will start a game and provide Game details like gameId.

2.get best Task :http://localhost:8080/game/getBestTask/{gameId}
Using the previous response you can pass the gameId to get the bestTask for a game.

3.get Items :http://localhost:8080/game/getItems/{itemId}
Using the response from 1 , you can get the list of items available for a game.

4.solve task : http://localhost:8080/solve/{gameId}/{taskId}
Using the response from 1 ,2 get gameId and taskId and use this to get the result on solving task for a game.

5.play game :http://localhost:8080/game/play
This will start a new game , fetch the best task and chooses items for purchase .
It will continiue to choose the best task and purchase untill the player's lives run out.


Approach to the problem:

1. To get the best Task:
    Assign score to set of probabilities and calculate average score.
    For each task ,determined if it lies within the range of high probability of wining or low and then choose the tasks 
    which has expiry more than average and then finally retrieving the highest reward task.
2. To purchase item :
    Using the message response API, get the gold balance each time and determine the items that can be purchased.
    Collect items which are less or equal to goldbalance and then purchase the item which is nearest to the average cost.
   
   


# demo
Import and build the Maven Project
Run the GameApplication.class
When the server is up you can use below APIs:
1.start game: localhost:8080/game/start
This will start the game and provide Game details like gameId

2.get best Task :http://localhost:8080/game/getBestTask/{gameId}
Using the previous response you can pass the gameId to get the bestTask

3.get Items :http://localhost:8080/game/getItems/{itemId}
Using the response from 1 , you can get the list of items available 

4.solve task : http://localhost:8080/solve/{gameId}/{taskId}
Using the response from 1 ,2 we can use this to get the result on solving task for a game.

5.play game :http://localhost:8080/game/play
This will start a new game , fetch the best task and chooses items for purchase .
It will continiue to choose the best task and purchase untill the player's lives run out.


Approach to the problem:

1. To get the best Task
    Assign score to set of probabilities and calculate average score.
    For each task ,determined if it lies with highprobability of wining or less and then choose the task with highest reward.
2. To purchase item
   Using the message response API, calculated goldbalance each time and determine the items that can be purchased.
   Collected items which are less or equal to goldbalance and then determines the item which is nearest to the average cost.
   
   


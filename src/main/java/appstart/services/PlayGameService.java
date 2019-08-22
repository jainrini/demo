package appstart.services;


import appstart.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class PlayGameService {
    @Autowired
    private  TaskService taskService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private MessageResponseService messageResponseService;

    private static final String url = "https://dragonsofmugloar.com/api/v2/";
    private static RestTemplate restTemplate = new RestTemplate();
    List<String> result= new ArrayList<>();
    public List<String> playGame(Game game) {

        TasksOfGame bestTask = getBestTask(game.getGameId());
        List<Item> itemsToPurchase = getItemsToPurchase(game.getGameId());
        MessageResponse messageResponse = messageResponseService.solveTask(game.getGameId(), bestTask.getBestTask().getAdId());
        Integer goldBalance = messageResponse.getGold();
        System.out.println("Gold Balance is ="+goldBalance);
        System.out.println("Message Response "+ messageResponse.getMessage());
        System.out.println("Score after solving task " + messageResponse.getScore().toString());
        Integer lives = messageResponse.getLives();
        System.out.println("Life remaining" + lives);
        if(lives>0){
            if(goldBalance>50 && goldBalance <100){
                System.out.println("gold balance is greater than 50 less than 100");
                Item item = itemService.purchaseItemWith(goldBalance, itemsToPurchase);
                itemService.purchaseItem(game.getGameId(),item.getId());
                playGame(game);
            } else if (goldBalance>100 && goldBalance <150) {
                System.out.println("gold balance is greater than 100 less than 150");
                Item item = itemService.purchaseItemWith(goldBalance, itemsToPurchase);
                itemService.purchaseItem(game.getGameId(),item.getId());
                playGame(game);
            } else if (goldBalance>150&& goldBalance<300) {
                System.out.println("gold balance is greater than 100 less than 300");
                Item item = itemService.purchaseItemWith(goldBalance, itemsToPurchase);
                itemService.purchaseItem(game.getGameId(),item.getId());
                playGame(game);
            }
            else if (goldBalance>300 && goldBalance <350) {
                System.out.println("gold balance is greater than 350");
                Item item = itemService.purchaseItemWith(goldBalance, itemsToPurchase);
                itemService.purchaseItem(game.getGameId(),item.getId());
                playGame(game);
            } else {
                playGame(game);
            }
        }
        else{
            System.out.println("Game Over");
            result.add("GameOver");
            result.add("With Score  : "+messageResponse.getScore().toString());
        }
        return result;
    }

    public Game startGame(){
        ResponseEntity<Game> responseEntity = restTemplate.exchange(url + "game/start", HttpMethod.POST, null, Game.class, new HashMap<>());
        Game game = responseEntity.getBody();
        return  game;
    }

    public TasksOfGame getBestTask(String gameId) {
        List<Task> tasks = taskService.getTask(gameId);
        Task bestTask = taskService.getBestTask(tasks);
        TasksOfGame tasksOfGame= new TasksOfGame(gameId,bestTask,tasks);
        return tasksOfGame;
    }

    public List<Item> getItemsToPurchase(String gameId) {
        return itemService.getItems(gameId);
    }

}

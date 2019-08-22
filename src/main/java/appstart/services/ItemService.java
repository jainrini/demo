package appstart.services;

import appstart.models.Item;
import appstart.models.ShoppingResponse;
import appstart.models.Task;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private static final String url = "https://dragonsofmugloar.com/api/v2/";
    private static RestTemplate restTemplate = new RestTemplate();
    public List<Item> getItems(String gameId) {
        Map<String, String> params = new HashMap<>();
        params.put("gameId",gameId);
        ResponseEntity<Item[]> itemsFromShop= restTemplate.exchange(url + "{gameId}/shop", HttpMethod.GET, null, Item[].class, params);
        Item[] items = itemsFromShop.getBody();
        return Arrays.asList(items);
    }

    public Item purchaseItemWith(Integer goldBalance, List<Item> itemsToPurchase) {
        List<Item> collect = itemsToPurchase.stream().filter(c -> c.getCost() < goldBalance).collect(Collectors.toList());
        return collect.stream().min(Comparator.comparing(Item::getCost)).orElseThrow(NoSuchElementException::new);

    }

    public void purchaseItem(String gameId, String id) {
        Map<String, String> params = new HashMap<>();
        params.put("gameId", gameId);
        params.put("itemId", id);
        ResponseEntity<ShoppingResponse> itemsFromShop= restTemplate.exchange(url + "{gameId}/shop/buy/{itemId}", HttpMethod.POST, null, ShoppingResponse.class, params);
        ShoppingResponse items = itemsFromShop.getBody();
    }
}
